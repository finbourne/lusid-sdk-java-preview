package com.finbourne.lusid.tutorials.marketdata;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.api.QuotesApi;
import com.finbourne.lusid.model.*;
import com.finbourne.features.LusidFeature;
import com.finbourne.lusid.utilities.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

public class Quotes {

    private static QuotesApi quotesApi;

    @BeforeClass
    public static void setUp() throws Exception {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);
        quotesApi = new QuotesApi(apiClient);
    }

    @Test
    @LusidFeature("F14-1")  //F14-7
    public void add_quote() throws ApiException {

        QuoteSeriesId   quoteSeriesId = new QuoteSeriesId()
                .provider("DataScope")
                .priceSource("BankA")
                .instrumentId("BBG000B9XRY4")
                .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.FIGI)
                .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                .field("Mid");

        String effectiveDate = OffsetDateTime.of(2019, 4, 15, 0, 0, 0, 0, ZoneOffset.UTC).toString();
        BigDecimal  quoteValue = BigDecimal.valueOf(199.23);


        UpsertQuoteRequest  request = new UpsertQuoteRequest()
            .quoteId(new QuoteId()
                    .quoteSeriesId(quoteSeriesId)
                    .effectiveAt(effectiveDate)
            )
            .metricValue(new MetricValue()
                .value(quoteValue)
                .unit("USD")
            )
            .lineage("InternalSystem");

        UpsertQuotesResponse    result = quotesApi.upsertQuotes(TestDataUtilities.TutorialScope, Collections.singletonMap("correlationId", request));

        assertThat(result.getFailed().size(), equalTo(0));
        assertThat(result.getValues().size(), equalTo(1));

        GetQuotesResponse   quotesResponse = quotesApi.getQuotes(
                TestDataUtilities.TutorialScope,
                effectiveDate.toString(),
                null, null,
                Collections.singletonMap("correlationId1", quoteSeriesId)
        );

        Quote   quote = quotesResponse.getValues().values().stream().findFirst().get();

        assertThat(quote.getMetricValue().getValue(), comparesEqualTo(quoteValue));
    }

    @Test
    @LusidFeature("F14-4")
    public void get_timeseries_quote() throws ApiException {

        OffsetDateTime startDate = OffsetDateTime.of(2019, 4, 15, 0, 0, 0, 0, ZoneOffset.UTC);
        List<OffsetDateTime> dates = IntStream.iterate(0, i -> i + 1)
            .limit(30)
            .mapToObj(startDate::plusDays)
            .collect(Collectors.toList());

        QuoteSeriesId quoteSeriesId = new QuoteSeriesId()
                        .provider("Client")
                        .instrumentId("BBG000DMBXR2")
                        .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.FIGI)
                        .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                        .field("mid");

        //  Get the quotes for each day in the date range
        List<GetQuotesResponse>   quoteResponses = dates
            .stream()
            .map(d -> {
                try {
                    return quotesApi.getQuotes(
                        TestDataUtilities.MarketDataScope,
                        d.toString(),
                        null, null,
                        Collections.singletonMap("correlationId", quoteSeriesId));
                } catch (ApiException e) {
                    throw new RuntimeException(e);
                }
            })
            .collect(Collectors.toList());

        assertThat(quoteResponses, hasSize(30));

        for (GetQuotesResponse response : quoteResponses) {
            if (response.getNotFound().size() > 0) {
                fail(String.format("%s %s", quoteSeriesId, response.getNotFound().values().toArray()[0]));
            }
            assertThat(response.getValues().size(), equalTo(1));
        }
    }
}
