package com.finbourne.lusid.tutorials.ibor;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.api.*;
import com.finbourne.lusid.model.*;
import com.finbourne.lusid.utilities.ApiClientBuilder;
import com.finbourne.lusid.utilities.CredentialsSource;
import com.finbourne.lusid.utilities.InstrumentLoader;
import com.finbourne.lusid.utilities.TestDataUtilities;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.finbourne.lusid.utilities.TestDataUtilities.TutorialScope;
import static org.junit.Assert.assertEquals;

public class Valuation {

    private static final String AGGREGATION_KEY = "Holding/default/PV";
    private static final String AGGREGATION_RESULT_KEY = "Sum(Holding/default/PV)";
    private static final String GROUPBY_KEY = "Instrument/default/Name";

    private final OffsetDateTime EFFECTIVE_DATE = OffsetDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);

    private static TransactionPortfoliosApi transactionPortfoliosApi;
    private static QuotesApi quotesApi;
    private static AggregationApi  aggregationApi;
    private static List<String> instrumentIds;

    private static TestDataUtilities testDataUtilities;

    @BeforeClass
    public static void setUp() throws Exception
    {
        ApiClient apiClient = new ApiClientBuilder(CredentialsSource.credentialsFile).build();

        testDataUtilities = new TestDataUtilities(transactionPortfoliosApi);

        transactionPortfoliosApi = new TransactionPortfoliosApi(apiClient);
        quotesApi = new QuotesApi(apiClient);
        aggregationApi = new AggregationApi(apiClient);

        //  ensure instruments are created and exist in LUSID
        InstrumentsApi instrumentsApi = new InstrumentsApi(apiClient);
        InstrumentLoader instrumentLoader = new InstrumentLoader(instrumentsApi);
        instrumentIds = instrumentLoader.loadInstruments();
    }

    @Test
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
                                        .provider("DataScope")
                                        .instrumentId(x.getKey())
                                        .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.LUSIDINSTRUMENTID)
                                        .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                                        .field("mid")
                                )
                                .effectiveAt(EFFECTIVE_DATE.toString())
                        )
                        .metricValue(new MetricValue().value(x.getValue()).unit("GBP"))
                )
                .collect(Collectors.toMap(x -> UUID.randomUUID().toString(), Function.identity()));

        //  upload the quotes
        quotesApi.upsertQuotes(quotesScope, quotes);

        //  create the recipe to get the quotes
        ConfigurationRecipe configurationRecipe = new ConfigurationRecipe()
                .code("quotes_recipe")
                .market(new MarketContext()
                    .suppliers(new MarketContextSuppliers().equity(MarketContextSuppliers.EquityEnum.DATASCOPE))
                    .options(new MarketOptions()
                        .defaultSupplier(MarketOptions.DefaultSupplierEnum.DATASCOPE)
                        .defaultInstrumentCodeType(MarketOptions.DefaultInstrumentCodeTypeEnum.LUSIDINSTRUMENTID)
                        .defaultScope(quotesScope)
                    )
                );

        //    create the aggregation request, this example calculates the percentage of total portfolio value and value by instrument
        AggregationRequest  aggregationRequest = new AggregationRequest()
                .inlineRecipe(configurationRecipe)
                .metrics(Arrays.asList(
                        new AggregateSpec().key(GROUPBY_KEY).op(AggregateSpec.OpEnum.VALUE),
                        new AggregateSpec().key(AGGREGATION_KEY).op(AggregateSpec.OpEnum.PROPORTION),
                        new AggregateSpec().key(AGGREGATION_KEY).op(AggregateSpec.OpEnum.SUM)
                ))
                .groupBy(Collections.singletonList(GROUPBY_KEY))
                .effectiveAt(EFFECTIVE_DATE);

        //  do the aggregation
        ListAggregationResponse aggregationResponse = aggregationApi.getAggregationByPortfolio(TutorialScope, portfolioId,null, null, null, aggregationRequest);

        aggregationResponse.getData().sort((o1, o2) -> {
            String name1 = (String)o1.get(GROUPBY_KEY);
            String name2 = (String)o2.get(GROUPBY_KEY);

            return name1.compareTo(name2);
        });

        validateResults.accept(aggregationResponse.getData());

        /*
         * The aggregation response contains a schema property which describes the data returned.
         * This includes the aggregated values and description of the types.
         */
        ResultDataSchema    resultSchema = aggregationResponse.getDataSchema();

        for (Map<String, Object> aggregation : aggregationResponse.getData()) {
            System.out.println(aggregation.get(GROUPBY_KEY) + ":\t" + aggregation.get(AGGREGATION_RESULT_KEY) + "\t");
        }
    }

}
