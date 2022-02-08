
package com.finbourne.lusid.tutorials.ibor;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.api.*;
import com.finbourne.lusid.model.*;
import com.finbourne.features.LusidFeature;
import com.finbourne.lusid.utilities.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;


import static com.finbourne.lusid.utilities.TestDataUtilities.TutorialScope;
import static org.junit.Assert.assertEquals;

public class Properties {

    private static TransactionPortfoliosApi transactionPortfoliosApi;
    private static PropertyDefinitionsApi propertyDefinitionsApi;
    private static PortfoliosApi portfoliosApi;

    @BeforeClass
    public static void setUp() throws Exception {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);

        transactionPortfoliosApi = new TransactionPortfoliosApi(apiClient);
        portfoliosApi = new PortfoliosApi(apiClient);
        propertyDefinitionsApi = new PropertyDefinitionsApi(apiClient);
    }

    @Test
    @LusidFeature("F1-5")
    public void create_portfolio_with_label_property() throws ApiException {

        String uuid = UUID.randomUUID().toString();
        String propertyName = String.format("fund-style-%s", uuid);
        OffsetDateTime effectiveDate = OffsetDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);

        CreatePropertyDefinitionRequest propertyDefinition = new CreatePropertyDefinitionRequest()

                //  The domain the property is to be applied to
                .domain(CreatePropertyDefinitionRequest.DomainEnum.PORTFOLIO)

                //  The scope the property will be created in
                .scope(TutorialScope)

                //  When the property value is set it will be valid forever and cannot be changed.
                //  Properties whose values can change over time should be created with LifeTimeEnum.TIMEVARIANT
                .lifeTime(CreatePropertyDefinitionRequest.LifeTimeEnum.PERPETUAL)

                .code(propertyName)
                .valueRequired(false)
                .displayName("Fund Style")
                .dataTypeId(new ResourceId().scope("system").code("string"));

        //  Creaate the property definition
        PropertyDefinition propertyDefinitionDto = propertyDefinitionsApi.createPropertyDefinition(propertyDefinition);

        //  Create the property value
        Property property = new Property()
                .key(propertyDefinitionDto.getKey())
                .value(new PropertyValue().labelValue("Active"));

        //  Details of the portfolio to be created
        CreateTransactionPortfolioRequest request = new CreateTransactionPortfolioRequest()
                .displayName(String.format("Portfolio-%s", uuid))
                .code(String.format("Id-%s", uuid))
                .baseCurrency("GBP")
                .created(effectiveDate)

                //  Set the property value when creating the portfolio
                .properties(new HashMap<String, Property>() {
                    {
                        put(propertyDefinitionDto.getKey(), property);
                    }
                });

        //  create portfolio
        Portfolio portfolio = transactionPortfoliosApi.createPortfolio(TutorialScope, request);

        assertEquals(request.getCode(), portfolio.getId().getCode());

        PortfolioProperties portfolioProperties = portfoliosApi.getPortfolioProperties(TutorialScope,
                portfolio.getId().getCode(), null, null);

        assertEquals(1, portfolioProperties.getProperties().size());
        assertEquals(property.getValue(),
                portfolioProperties.getProperties().get(propertyDefinitionDto.getKey()).getValue());


    }

    @Test
    @LusidFeature("F1-6")
    public void create_portfolio_with_metric_property() throws ApiException {

        String uuid = UUID.randomUUID().toString();
        String metricPropertyName = String.format("fund-nav-%s", uuid);
        OffsetDateTime effectiveDate = OffsetDateTime.of(2018, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);

        CreatePropertyDefinitionRequest metricPropertyDefinition = new CreatePropertyDefinitionRequest()

                //  The domain the property is to be applied to
                .domain(CreatePropertyDefinitionRequest.DomainEnum.PORTFOLIO)

                //  The scope the property will be created in
                .scope(TutorialScope)

                //  When the property value is set it will be valid forever and cannot be changed.
                //  Properties whose values can change over time should be created with LifeTimeEnum.TIMEVARIANT
                .lifeTime(CreatePropertyDefinitionRequest.LifeTimeEnum.PERPETUAL)

                .code(metricPropertyName)
                .valueRequired(false)
                .displayName("Fund NAV")
                .dataTypeId(new ResourceId().scope("system").code("currencyAndAmount"));

        //  Create the property definitions
        PropertyDefinition metricPropertyDefinitionDto =
                propertyDefinitionsApi.createPropertyDefinition(metricPropertyDefinition);

        MetricValue metricValue = new MetricValue().value(1100000.0).unit("GBP");
        PropertyValue propertyValue = new PropertyValue().metricValue(metricValue);

        //  Create the property values
        Property property = new Property()
                .key(metricPropertyDefinitionDto.getKey())
                .value(propertyValue);

        //  Details of the portfolio to be created
        CreateTransactionPortfolioRequest request = new CreateTransactionPortfolioRequest()
                .displayName(String.format("Portfolio-%s", uuid))
                .code(String.format("Id-%s", uuid))
                .baseCurrency("GBP")
                .created(effectiveDate)

                //  Set the property value when creating the portfolio
                .properties(new HashMap<String, Property>() {
                    {
                        put(metricPropertyDefinitionDto.getKey(), property);
                    }
                });

        //  create portfolio
        Portfolio portfolio = transactionPortfoliosApi.createPortfolio(TutorialScope, request);

        assertEquals(request.getCode(), portfolio.getId().getCode());

        PortfolioProperties portfolioProperties = portfoliosApi.getPortfolioProperties(TutorialScope,
                portfolio.getId().getCode(), null, null);

        assertEquals(1, portfolioProperties.getProperties().size());
        assertEquals(property.getValue(), portfolioProperties.getProperties().get(metricPropertyDefinitionDto.getKey()).getValue());


    }

}
