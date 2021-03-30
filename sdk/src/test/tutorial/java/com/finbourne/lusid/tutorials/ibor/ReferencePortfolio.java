package com.finbourne.lusid.tutorials.ibor;

import com.finbourne.features.LusidFeature;
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Pair;
import com.finbourne.lusid.api.InstrumentsApi;
import com.finbourne.lusid.api.PortfoliosApi;
import com.finbourne.lusid.api.ReferencePortfolioApi;
import com.finbourne.lusid.model.*;
import com.finbourne.lusid.utilities.*;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.jvm.hotspot.compiler.ImmutableOopMapPair;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class ReferencePortfolio {
    private static List<String> instrumentIds;
    private static PortfoliosApi portfoliosApi;
    private static ReferencePortfolioApi referencePortfoliosApi;


    @BeforeClass
    public static void setUp() throws Exception {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);

        portfoliosApi = new PortfoliosApi(apiClient);
        referencePortfoliosApi = new ReferencePortfolioApi(apiClient);
        InstrumentsApi instrumentsApi = new InstrumentsApi(apiClient);

        InstrumentLoader instrumentLoader = new InstrumentLoader(instrumentsApi);
        instrumentIds = instrumentLoader.loadInstruments();
    }

    @Test
    @LusidFeature("F39")
    public void create_reference_portfolio() throws ApiException {

        // Declare name, code of the portfolio to create
        String F39PortfolioCode = "F39J_ReferencePortfolioCode";
        String F39PortfolioName = "F39J_Reference Portfolio name";

        // Generate request using CreateReferencePortfolioRequest model
        CreateReferencePortfolioRequest request = new CreateReferencePortfolioRequest()
                .code(F39PortfolioCode)
                .displayName(F39PortfolioName);

        // Make the request using the reference portfolio API
        Portfolio portfolio = referencePortfoliosApi.createReferencePortfolio(TestDataUtilities.TutorialScope, request);

        // Test that result portfolio code is the same as request code
        assertEquals(request.getCode(), portfolio.getId().getCode());

        // Delete portfolio once the test is completed
        DeletedEntityResponse deletedPortfolio = portfoliosApi.deletePortfolio(TestDataUtilities.TutorialScope, F39PortfolioCode);
    }

    @Test
    @LusidFeature("F40")
    public void upsert_reference_portfolio_constituents() throws ApiException {

        // Declare name, code, effective date of the portfolio to create
        String F40PortfolioCode = "F40J_ReferencePortfolioCode";
        String F40PortfolioName = "F40J_Reference Portfolio name";
        OffsetDateTime portfolioCreationDate = OffsetDateTime.of(2000, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        OffsetDateTime effectiveDate = OffsetDateTime.of(2010, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
//        List<Integer> weights = Arrays.asList(10, 20, 30, 15, 25); // TODO: implement multiple weights

        // Generate request using CreateReferencePortfolioRequest model
        CreateReferencePortfolioRequest createRequest = new CreateReferencePortfolioRequest()
                .code(F40PortfolioCode)
                .displayName(F40PortfolioName)
                .created(portfolioCreationDate);

        // Make the request using the reference portfolio API
        Portfolio portfolio = referencePortfoliosApi.createReferencePortfolio(TestDataUtilities.TutorialScope, createRequest);

        List<ReferencePortfolioConstituentRequest> constituentRequests = new ArrayList<>();

        // Prepare individual constituent requests
        for (String instrumentId : instrumentIds) {
            HashMap<String, String> instrumentIdentifier = new HashMap<>();
            instrumentIdentifier.put(TestDataUtilities.LUSID_INSTRUMENT_IDENTIFIER, instrumentId);

            constituentRequests.add(new ReferencePortfolioConstituentRequest()
                    .instrumentIdentifiers(instrumentIdentifier)
                    .weight(0.2)
                    .currency("GBP")
            );
        }

        // Prepare bulk constituent upsert request
        UpsertReferencePortfolioConstituentsRequest upsertRequest = new UpsertReferencePortfolioConstituentsRequest()
                .constituents(constituentRequests)
                .weightType(UpsertReferencePortfolioConstituentsRequest.WeightTypeEnum.STATIC)
                .effectiveFrom(effectiveDate.toString());

        // Make the request
        UpsertReferencePortfolioConstituentsResponse response = referencePortfoliosApi.upsertReferencePortfolioConstituents(TestDataUtilities.TutorialScope,
                F40PortfolioCode,
                upsertRequest);

        System.out.println(response);

        // Get constituents of portfolio
        List<ReferencePortfolioConstituent> constituents = referencePortfoliosApi.getReferencePortfolioConstituents(TestDataUtilities.TutorialScope,
                F40PortfolioCode,
                null,
                null,
                null).getConstituents(); // TODO: best way to leave propertyKeys blank?

        // Validate number of constituents matches what was inserted
        assertEquals(constituents.size(), instrumentIds.size());

        // Validate constituents match inserted instruments
        List<Pair> instrumentLuidPairs = IntStream
                .range(0, Math.min(constituents.size(), instrumentIds.size()))
                .mapToObj(i -> new Pair(constituents.get(i).getInstrumentUid(), instrumentIds.get(i)))
                .collect(Collectors.toList());

        for(Pair instrument : instrumentLuidPairs)
            assertEquals(instrument.getName(), instrument.getValue());


        // TODO: Validate weights of constituents match weights inserted

        // Delete portfolio once the test is completed
        DeletedEntityResponse deletedPortfolio = portfoliosApi.deletePortfolio(TestDataUtilities.TutorialScope, F40PortfolioCode);
    }
}