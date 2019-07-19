package com.finbourne.lusid.tutorials.marketdata;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.api.QuotesApi;
import com.finbourne.lusid.model.*;
import com.finbourne.lusid.utilities.ApiClientBuilder;
import com.finbourne.lusid.utilities.CredentialsSource;
import com.finbourne.lusid.utilities.TestDataUtilities;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class Quotes {

    private static QuotesApi quotesApi;

    @BeforeClass
    public static void setUp() throws Exception {
        ApiClient apiClient = new ApiClientBuilder(CredentialsSource.credentialsFile).build();
        quotesApi = new QuotesApi(apiClient);
    }

    @Test
    public void add_quote() throws ApiException {
        UpsertQuoteRequest  request = new UpsertQuoteRequest()
            .quoteId(new QuoteId()
                    .quoteSeriesId(new QuoteSeriesId()
                        .provider("DataScope")
                        .priceSource("BankA")
                        .instrumentId("BBG000B9XRY4")
                        .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.FIGI)
                        .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                        .field("Mid")
                    )
                    .effectiveAt(OffsetDateTime.of(2019, 4, 15, 0, 0, 0, 0, ZoneOffset.UTC).toString())
            )
            .metricValue(new MetricValue()
                .value(199.23)
                .unit("USD")
            )
            .lineage("InternalSystem");

        UpsertQuotesResponse    result = quotesApi.upsertQuotes(TestDataUtilities.TutorialScope, Collections.singletonList(request));

        assertThat(result.getFailed().size(), equalTo(0));
        assertThat(result.getValues().size(), equalTo(1));
    }

    @Test
    public void get_quote_for_instrument_for_single_day() throws ApiException {

        QuoteSeriesId quoteSeriesId = new QuoteSeriesId()
                .provider("DataScope")
                .priceSource("BankA")
                .instrumentId("BBG000B9XRY4")
                .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.FIGI)
                .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                .field("Mid");

        OffsetDateTime effectiveDate = OffsetDateTime.of(2019, 4, 15, 0, 0, 0, 0, ZoneOffset.UTC);

        //  Get the close quote for AAPL on 15-Apr-19
        GetQuotesResponse   quotesResponse = quotesApi.getQuotes(
            TestDataUtilities.TutorialScope,
            effectiveDate.toString(),
            null, null,
            Collections.singletonList(quoteSeriesId)
        );

        assertThat(quotesResponse.getValues().values(), hasSize(equalTo(1)));

        Quote   quote = quotesResponse.getValues().values().stream().findFirst().get();

        assertThat(quote.getMetricValue().getValue(), equalTo(199.23));
    }

    @Test
    public void get_timeseries_quote() throws ApiException {

        OffsetDateTime startDate = OffsetDateTime.of(2019, 4, 15, 0, 0, 0, 0, ZoneOffset.UTC);
        List<OffsetDateTime> dates = IntStream.iterate(0, i -> i + 1)
            .limit(30)
            .mapToObj(startDate::plusDays)
            .collect(Collectors.toList());

        QuoteSeriesId quoteSeriesId = new QuoteSeriesId()
                        .provider("DataScope")
                        .instrumentId("BBG000B9XRY4")
                        .instrumentIdType(QuoteSeriesId.InstrumentIdTypeEnum.FIGI)
                        .quoteType(QuoteSeriesId.QuoteTypeEnum.PRICE)
                        .field("Mid");

        //  Get the quotes for each day in the date range
        List<GetQuotesResponse>   quoteResponses = dates
            .stream()
            .map(d -> {
                try {
                    return quotesApi.getQuotes(
                        TestDataUtilities.TutorialScope,
                        d.toString(),
                        null, null,
                        Collections.singletonList(quoteSeriesId));
                } catch (ApiException e) {
                    throw new RuntimeException(e);
                }
            })
            .collect(Collectors.toList());

        assertThat(quoteResponses, hasSize(30));

        for (GetQuotesResponse response : quoteResponses) {
            assertThat(response.getValues().size(), equalTo(1));
        }
    }
}
