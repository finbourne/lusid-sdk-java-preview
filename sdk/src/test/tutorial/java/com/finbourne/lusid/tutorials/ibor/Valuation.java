package com.finbourne.lusid.tutorials.ibor;

import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.api.*;
import com.finbourne.lusid.model.*;
import com.finbourne.features.LusidFeature;
import com.finbourne.lusid.utilities.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DecimalFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.finbourne.lusid.utilities.TestDataUtilities.TutorialScope;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.assertEquals;

public class Valuation {

    private static final String AGGREGATION_KEY = "Holding/default/PV";
    private static final String AGGREGATION_RESULT_KEY = "Sum(Holding/default/PV)";
    private static final String GROUPBY_INSTRUMENT_NAME_KEY = "Instrument/default/Name";
    private static final String GROUPBY_PORTFOLIO_NAME_KEY = "Portfolio/default/Name";

    private final OffsetDateTime EFFECTIVE_DATE = OffsetDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    private final DecimalFormat df3 = new DecimalFormat("#.###");

    private static TransactionPortfoliosApi transactionPortfoliosApi;
    private static QuotesApi quotesApi;
    private static AggregationApi  aggregationApi;
    private static ConfigurationRecipeApi recipeApi;
    private static List<String> instrumentIds;

    private static TestDataUtilities testDataUtilities;

    @BeforeClass
    public static void setUp() throws Exception
    {
        LusidApiFactory apiFactory = LusidApiFactoryBuilder.build(CredentialsSource.credentialsFile);

        // setup lusid apis
        transactionPortfoliosApi = apiFactory.build(TransactionPortfoliosApi.class);
        quotesApi = apiFactory.build(QuotesApi.class);
        aggregationApi = apiFactory.build(AggregationApi.class);
        recipeApi = apiFactory.build(ConfigurationRecipeApi.class);

        //  ensure instruments are created and exist in LUSID
        InstrumentsApi instrumentsApi = apiFactory.build(InstrumentsApi.class);
        InstrumentLoader instrumentLoader = new InstrumentLoader(instrumentsApi);
        instrumentIds = instrumentLoader.loadInstruments();

        testDataUtilities = new TestDataUtilities(transactionPortfoliosApi);
    }

    @Test
    @LusidFeature("F10-5")
    public void run_aggregation_with_buy() throws ApiException
    {
        run_aggregation(
                () -> {

                    final String    currency = "GBP";

                    List<TransactionRequest>    requests = new ArrayList<>();

                    //  add the starting cash
                    requests.add(testDataUtilities.buildCashFundsInTransactionRequest(30600.0, currency, EFFECTIVE_DATE));

                    // create the transaction requests
                    requests.add(testDataUtilities.buildTransactionRequest(instrumentIds.get(0), 100.0, 101.0, currency, EFFECTIVE_DATE, "Buy"));
                    requests.add(testDataUtilities.buildTransactionRequest(instrumentIds.get(1), 100.0, 102.0, currency, EFFECTIVE_DATE, "Buy"));
                    requests.add(testDataUtilities.buildTransactionRequest(instrumentIds.get(2), 100.0, 103.0, currency, EFFECTIVE_DATE, "Buy"));

                    return requests;
                },
                results -> {
                    assertEquals(3, results.size());
                    assertEquals(10000.0, results.get(0).get(AGGREGATION_RESULT_KEY));
                    assertEquals(20000.0, results.get(1).get(AGGREGATION_RESULT_KEY));
                    assertEquals(30000.0, results.get(2).get(AGGREGATION_RESULT_KEY));
                });
    }

    @Test
    @LusidFeature("F10-6")
    public void run_aggregation_on_multicurrency_portfolio_with_stock_in() throws ApiException {
        //  setup test environment scope
        String uuid = UUID.randomUUID().toString();
        String quotesScope = uuid;

        // begin test data preparation...

        //  prepare portfolio in baseline GBP currency
        String portfolioId = String.format("Id-%s", uuid);
        String portfolioDisplayName = String.format("Portfolio-%s", uuid);
        CreateTransactionPortfolioRequest transactionPortfolioRequest = createTransactionPortfolioRequest(portfolioId, portfolioDisplayName, "GBP");

        //  prepare transactions across GBP and USD, transactions are transfer in of cash and stock
        List<TransactionRequest> transactionRequests = new ArrayList<>();
        transactionRequests.add(testDataUtilities.buildCashFundsInTransactionRequest(10000.0, "GBP", EFFECTIVE_DATE));
        transactionRequests.add(testDataUtilities.buildTransactionRequest(instrumentIds.get(0), 100.0, 100.0, "USD", EFFECTIVE_DATE, "StockIn"));
        transactionRequests.add(testDataUtilities.buildTransactionRequest(instrumentIds.get(1), 100.0, 100.0, "GBP", EFFECTIVE_DATE, "StockIn"));
        transactionRequests.add(testDataUtilities.buildTransactionRequest(instrumentIds.get(2), 100.0, 100.0, "GBP", EFFECTIVE_DATE, "StockIn"));

        //  create and upload the instrument quotes in their respective currencies
        List<UpsertQuoteRequest> quotes = new ArrayList<>();
        // prepare market data quotes
        quotes.addAll(asList(
                createMarketDataUpsertQuoteRequest(instrumentIds.get(0), "USD", 200.00),
                createMarketDataUpsertQuoteRequest(instrumentIds.get(1), "GBP", 200.00),
                createMarketDataUpsertQuoteRequest(instrumentIds.get(2), "GBP", 80.00)
        ));
        // prepare fx data quotes
        quotes.addAll(asList(
                createFxUpsertQuoteRequest("GBP", "USD", 1.22),
                createFxUpsertQuoteRequest("USD", "GBP", 0.68)
        ));
        // package quotes by quote ids
        Map<String, UpsertQuoteRequest> quotesById = quotes.stream()
                .collect(toMap(q -> UUID.randomUUID().toString(), Function.identity()));

        // end test data preparation

        // begin executing LUSID calls...

        // create and validate portfolio creation
        Portfolio portfolio = transactionPortfoliosApi.createPortfolio(TutorialScope, transactionPortfolioRequest);
        assertEquals(portfolio.getId().getCode(), portfolioId);

        // upload the transactions
        transactionPortfoliosApi.upsertTransactions(TutorialScope, portfolioId, transactionRequests);

        // upload the latest market quotes
        quotesApi.upsertQuotes(quotesScope, quotesById);

        //  run aggregations at the instrument and portfolio levels
        List<Map<String, Object>> aggregationResultsByInstrument = runAggregation(portfolioId, quotesScope, GROUPBY_INSTRUMENT_NAME_KEY);
        List<Map<String, Object>> aggregationResultsByPortfolio = runAggregation(portfolioId, quotesScope, GROUPBY_PORTFOLIO_NAME_KEY);

        // end executing LUSID calls...


        // begin verification of aggregation results...

        // verify instruments aggregated in the base portfolio currency (GBP)
        assertEquals("ASTRAZENECA PLC should have increased in value and been converted to GBP for the aggregation",
                13600.0, aggregationResultsByInstrument.get(0).get(AGGREGATION_RESULT_KEY));
        assertEquals("CENTRICA PLC should have increased in value base on market quote movement",
                20000.0, aggregationResultsByInstrument.get(1).get(AGGREGATION_RESULT_KEY));
        assertEquals("DIAEGO PLC should have decreased in value base on market quote movement",
                8000.0, aggregationResultsByInstrument.get(2).get(AGGREGATION_RESULT_KEY));
        assertEquals("Cash position should remain unchanged",
                10000.0, aggregationResultsByInstrument.get(3).get(AGGREGATION_RESULT_KEY));

        // verify portfolio aggregated in the base portfolio currency (GBP)
        assertEquals(51600.0, aggregationResultsByPortfolio.get(0).get(AGGREGATION_RESULT_KEY));

        // verify instruments add up to the portfolio level aggregation in the base currency
        double totalInstrumentValueInBaseCcy = aggregationResultsByInstrument.stream()
                .mapToDouble(i -> (double) i.get(AGGREGATION_RESULT_KEY))
                .sum();
        assertEquals(totalInstrumentValueInBaseCcy, aggregationResultsByPortfolio.get(0).get(AGGREGATION_RESULT_KEY));
    }

    private void run_aggregation(
            Supplier<List<TransactionRequest>> createTransactionRequests,
            Consumer<List<Map<String, Object>>> validateResults
    ) throws ApiException
    {
        String uuid = UUID.randomUUID().toString();
        String quotesScope = uuid;

        //  build the create portfolio request
        String originalPortfolioId = String.format("Id-%s", uuid);
        CreateTransactionPortfolioRequest request = new CreateTransactionPortfolioRequest()
                .displayName(String.format("Portfolio-%s", uuid))
                .code(originalPortfolioId)
                .baseCurrency("GBP")
                .created(EFFECTIVE_DATE);

        //  create portfolio
        Portfolio portfolio = transactionPortfoliosApi.createPortfolio(TutorialScope, request);

        assertEquals(portfolio.getId().getCode(), originalPortfolioId);

        String portfolioId = portfolio.getId().getCode();

        //  build the transaction requests
        List<TransactionRequest> transactionRequests = createTransactionRequests.get();

        //  upload the transactions to LUSID
        transactionPortfoliosApi.upsertTransactions(TutorialScope, portfolioId, transactionRequests);

        //  create the quotes
        Map<String, UpsertQuoteRequest> quotes = Stream.of(
                        new AbstractMap.SimpleImmutableEntry<>(instrumentIds.get(0), 100.0),
                        new AbstractMap.SimpleImmutableEntry<>(instrumentIds.get(1), 200.0),
                        new AbstractMap.SimpleImmutableEntry<>(instrumentIds.get(2), 300.0)
                )
                .map(x -> new UpsertQuoteRequest()
                        .quoteId(new QuoteId()
                                .quoteSeriesId(new QuoteSeriesId()
                                        .provider("Lusid")
                                        .instrumentId(x.getKey())
                                        .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.LUSIDINSTRUMENTID)
                                        .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                                        .field("mid")
                                )
                                .effectiveAt(EFFECTIVE_DATE.toString())
                        )
                        .metricValue(new MetricValue().value(x.getValue()).unit("GBP"))
                )
                .collect(toMap(x -> UUID.randomUUID().toString(), Function.identity()));

        //  upload the quotes
        quotesApi.upsertQuotes(quotesScope, quotes);

        String recipeScope = "tutorials";
        String recipeCode = "quotes";

        //  create the recipe to get the quotes
        ConfigurationRecipe configurationRecipe = new ConfigurationRecipe()
				.scope(recipeScope)
                .code(recipeCode)
                .market(new MarketContext()
                    .suppliers(new MarketContextSuppliers().equity("Lusid"))
                    .options(new MarketOptions()
                        .defaultSupplier("Lusid")
                        .defaultInstrumentCodeType("LusidInstrumentId")
                        .defaultScope(quotesScope)
                    )
                );

        saveRecipe(configurationRecipe);

        //    create the aggregation request, this example calculates the percentage of total portfolio value and value by instrument
        ValuationRequest  valuationRequest = new ValuationRequest()
                .recipeId(new ResourceId().scope(recipeScope).code(recipeCode))
                .metrics(asList(
                        new AggregateSpec().key(GROUPBY_INSTRUMENT_NAME_KEY).op(AggregateSpec.OpEnum.VALUE),
                        new AggregateSpec().key(AGGREGATION_KEY).op(AggregateSpec.OpEnum.PROPORTION),
                        new AggregateSpec().key(AGGREGATION_KEY).op(AggregateSpec.OpEnum.SUM)
                ))
                .valuationSchedule(new ValuationSchedule().effectiveAt(EFFECTIVE_DATE.toString()))
                .portfolioEntityIds(asList(
                        new PortfolioEntityId().scope(TutorialScope).code(portfolioId)
                ))
                .groupBy(Collections.singletonList(GROUPBY_INSTRUMENT_NAME_KEY));

        //  do the aggregation
        ListAggregationResponse aggregationResponse = aggregationApi.getValuation(valuationRequest);

        aggregationResponse.getData().sort((o1, o2) -> {
            String name1 = (String)o1.get(GROUPBY_INSTRUMENT_NAME_KEY);
            String name2 = (String)o2.get(GROUPBY_INSTRUMENT_NAME_KEY);

            return name1.compareTo(name2);
        });

        validateResults.accept(aggregationResponse.getData());

        /*
         * The aggregation response contains a schema property which describes the data returned.
         * This includes the aggregated values and description of the types.
         */
        ResultDataSchema    resultSchema = aggregationResponse.getDataSchema();

        for (Map<String, Object> aggregation : aggregationResponse.getData()) {
            System.out.println(aggregation.get(GROUPBY_INSTRUMENT_NAME_KEY) + ":\t" + aggregation.get(AGGREGATION_RESULT_KEY) + "\t");
        }
    }

    /**
     * Run an aggregation on LUSID for a given portfolio and scope to produce values in the portfolio
     * base currency. The aggregation level is defined by the grouping key.
     *
     * @param portfolioId - the portfolio to execute the aggregation on
     * @param quotesScope - scope the aggregation retrieves quotes from
     * @param groupingKey - grouping level of the aggregation
     * @return
     * @throws ApiException
     */
    private List<Map<String, Object>> runAggregation(String portfolioId, String quotesScope, String groupingKey) throws ApiException {

        String recipeScope = "tutorials";
        String recipeCode = "multi-currency";

        //  create the recipe that will instruct the aggregation on the market data provider and scope.
        ConfigurationRecipe configurationRecipe = new ConfigurationRecipe()
				.scope(recipeScope)
                .code(recipeCode)
                .market(new MarketContext()
                        // equity and fx data both sourced from Lusid provider, reference the createUpsertQuote... methods
                        // to view how the quote requests are mapped to providers.
                        .suppliers(new MarketContextSuppliers()
                                .equity("Lusid")
                                .fx("Lusid")
                        )
                        .options(new MarketOptions()
                                .defaultSupplier("Lusid")
                                .defaultInstrumentCodeType("LusidInstrumentId")
                                .defaultScope(quotesScope)
                        )
                );

        saveRecipe(configurationRecipe);

        //  create the aggregation request, this example calculates the percentage of total portfolio value and value by instrument
        ValuationRequest  valuationRequest = new ValuationRequest()
                .recipeId(new ResourceId().scope(recipeScope).code(recipeCode))
                .metrics(asList(
                        new AggregateSpec().key(groupingKey).op(AggregateSpec.OpEnum.VALUE),
                        new AggregateSpec().key(AGGREGATION_KEY).op(AggregateSpec.OpEnum.PROPORTION),
                        new AggregateSpec().key(AGGREGATION_KEY).op(AggregateSpec.OpEnum.SUM)
                ))
                .valuationSchedule(new ValuationSchedule().effectiveAt(EFFECTIVE_DATE.toString()))
                .portfolioEntityIds(asList(
                        new PortfolioEntityId().scope(TutorialScope).code(portfolioId)
                ))
                .groupBy(Collections.singletonList(groupingKey));

        //  do the aggregation
        ListAggregationResponse aggregationResponse = aggregationApi.getValuation(valuationRequest);

        aggregationResponse.getData().sort((o1, o2) -> {
            String name1 = (String)o1.get(groupingKey);
            String name2 = (String)o2.get(groupingKey);

            return name1.compareTo(name2);
        });

        List<Map<String, Object>> aggregationResults = aggregationResponse.getData();
        logResults(groupingKey, aggregationResults);
        return  aggregationResults;
    }

    private UpsertSingleStructuredDataResponse saveRecipe(ConfigurationRecipe recipe) throws ApiException{
        return recipeApi.upsertConfigurationRecipe(new UpsertRecipeRequest().configurationRecipe(recipe));
    }

    /**
     * Create a request to submit to LUSID to generate a transaction portfolio.
     *
     * @param portfolioId - unique portfolio id
     * @param displayName - display name of the portfolio
     * @param currency - base currency of the portfolio
     * @return
     * @throws ApiException
     */
    private CreateTransactionPortfolioRequest createTransactionPortfolioRequest(String portfolioId, String displayName, String currency) throws ApiException {
        //  build the create portfolio request
        CreateTransactionPortfolioRequest request = new CreateTransactionPortfolioRequest()
                .displayName(displayName)
                .code(portfolioId)
                .baseCurrency(currency)
                .created(EFFECTIVE_DATE);

        return request;
    }

    /**
     * Creates a market data entry quote request.
     *
     * @param instrument - market data instrument
     * @param currency - base currency of the instrument
     * @param value - value of the quote
     * @return
     */
    private UpsertQuoteRequest createMarketDataUpsertQuoteRequest(String instrument, String currency, double value){
        return new UpsertQuoteRequest()
                .quoteId(new QuoteId()
                        .quoteSeriesId(new QuoteSeriesId()
                                .provider("Lusid")
                                .instrumentId(instrument)
                                .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.LUSIDINSTRUMENTID)
                                .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                                .field("mid")
                        )
                        .effectiveAt(EFFECTIVE_DATE.toString())
                )
                .metricValue(new MetricValue().value(value).unit(currency));
    }

    /**
     * Creates an fx entry quote request.
     *
     * @param baseCcy - base currency of the quote
     * @param foreignCcy - foreign currency of the quote
     * @param rate - the exchange rate
     * @return
     */
    private UpsertQuoteRequest createFxUpsertQuoteRequest(String baseCcy, String foreignCcy, double rate){
        return new UpsertQuoteRequest()
                .quoteId(new QuoteId()
                        .quoteSeriesId(new QuoteSeriesId()
                                .provider("Lusid")
                                // base and foreign currencies must be split by "/" (e.g. USD/GBP).
                                .instrumentId(baseCcy + "/" + foreignCcy)
                                .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.CURRENCYPAIR)
                                .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                                .field("mid")
                        )
                        .effectiveAt(EFFECTIVE_DATE.toString())
                )
                .metricValue(new MetricValue().value(rate).unit(baseCcy));
    }

    /**
     *  Output aggregation results to console.
     */
    private void logResults(String resultSetName, List<Map<String, Object>> results){
        System.out.println("---- Aggregation Results On Grouping By " + resultSetName + " ----");
        for (Map<String, Object> aggregation : results) {
            System.out.println(aggregation.get(resultSetName) + ":\t" + aggregation.get(AGGREGATION_RESULT_KEY) + "\t" +
                    "(" + df3.format(aggregation.get("Proportion(Holding/default/PV)")) +")");
        }
        System.out.println("...");
    }

}
