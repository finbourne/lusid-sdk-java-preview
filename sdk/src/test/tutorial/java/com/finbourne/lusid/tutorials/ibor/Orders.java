package com.finbourne.lusid.tutorials.ibor;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.api.InstrumentsApi;
import com.finbourne.lusid.api.OrdersApi;
import com.finbourne.lusid.api.PropertyDefinitionsApi;
import com.finbourne.lusid.model.*;
import com.finbourne.features.LusidFeature;
import com.finbourne.lusid.utilities.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

// Orders represent an instruction from an investor to buy or sell a quantity of a specific
// security.
public class Orders
{
    private static OrdersApi ordersApi;
    private static List<String> instrumentIds;

    private static Map<String, String> TutorialScopes = new HashMap<String, String>(){{
        put("simple-upsert", "Orders-SimpleUpsert-TestScope");
        put("unknown-instrument", "Orders-UnknownInstrument-TestScope");
        put("filtering", "Orders-Filter-TestScope");
    }};

    private static Collection<String> TutorialPropertyCodes = Arrays.asList("TIF", "OrderBook", "PortfolioManager", "Account", "Strategy");

    @BeforeClass
    public static void setUp() throws Exception {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);

        InstrumentsApi instrumentsApi = new InstrumentsApi(apiClient);
        InstrumentLoader instrumentLoader = new InstrumentLoader(instrumentsApi);
        instrumentIds = instrumentLoader.loadInstruments();

        ordersApi = new OrdersApi(apiClient);
        LoadProperties(new PropertyDefinitionsApi(apiClient), TutorialScopes.values(), TutorialPropertyCodes);
    }

    private static void LoadProperties(PropertyDefinitionsApi propertyDefinitionsApi, Collection<String> scopes, Collection<String> codes) throws ApiException {
        for(String scope : scopes) {
            for(String code: codes) {
                //    Create the property definitions
                try
                {
                    CreatePropertyDefinitionRequest propertyDefinition =  new CreatePropertyDefinitionRequest()
                            .domain(CreatePropertyDefinitionRequest.DomainEnum.ORDER)
                            .scope(scope)
                            .lifeTime(CreatePropertyDefinitionRequest.LifeTimeEnum.PERPETUAL)
                            .code(code)
                            .valueRequired(false)
                            .displayName(String.format("Order - %s", code))
                            .dataTypeId(new ResourceId().scope("system").code("string"));

                    propertyDefinitionsApi
                            .createPropertyDefinition(propertyDefinition);
                }
                catch (ApiException apiException)
                {
                    if(!apiException.getMessage().contains("PropertyAlreadyExists")){
                        throw apiException;
                    }
                    // Ignore if it already exists
                }
            }
        }
    }


    // We want to make a request for a single order. The LUID will be mapped on upsert
    // from the instrument identifiers passed.
    @Test
    @LusidFeature("F9-1")
    public void Upsert_Simple_Order() throws ApiException {
        String testScope = TutorialScopes.get("simple-upsert");
        String orderCode = "Order-" +  UUID.randomUUID().toString();
        ResourceId orderId = new ResourceId()
                .code(orderCode)
                .scope(testScope);
        
        // These instrument identifiers should all map to the same instrument. If the instance of
        // LUSID has the specified instruments registered these identifiers will get resolved to
        // an actual internal instrument on upsert; otherwise, they'll be resolved to instrument or
        // currency unknown.
        HashMap<String, String> instruments = new HashMap<>();
        instruments.put("Instrument/default/LusidInstrumentId", instrumentIds.get(0));

        // [Experimental] Currently this portfolio doesn't need to exist. As the domain model evolves
        // this reference might disappear, or might become a strict reference to an existing portfolio.
        ResourceId portfolio = new ResourceId()
                .code("OrdersTestPortfolio")
                .scope(testScope);

        ResourceId orderBook = new ResourceId()
                .code("OrdersTestBook")
                .scope(testScope);

        Map<String, PerpetualProperty> properties = new HashMap<String, PerpetualProperty>();
        properties.put("Order/" + testScope + "/TIF", new PerpetualProperty().key("Order/" + testScope + "/TIF").value(new PropertyValue().labelValue("GTC")));
        properties.put("Order/" + testScope + "/OrderBook", new PerpetualProperty().key("Order/" + testScope + "/OrderBook").value(new PropertyValue().labelValue("UK Test Orders")));
        properties.put("Order/" + testScope + "/PortfolioManager", new PerpetualProperty().key("Order/" + testScope + "/PortfolioManager").value(new PropertyValue().labelValue("F Bar")));
        properties.put("Order/" + testScope + "/Account", new PerpetualProperty().key("Order/" + testScope + "/Account").value(new PropertyValue().labelValue("J Wilson")));
        properties.put("Order/" + testScope + "/Strategy", new PerpetualProperty().key("Order/" + testScope + "/Strategy").value(new PropertyValue().labelValue("RiskArb")));

        OrderRequest request = new OrderRequest()
                .id(orderId)
                .quantity(100)
                .portfolioId(portfolio)
                .properties(properties)
                .instrumentIdentifiers(instruments)
                .side("Buy");

        OrderSetRequest requestSet = new OrderSetRequest()
                .addOrderRequestsItem(request);

        // We can ask the Orders API to upsert this order for us
        List<Order> upsertResult = ordersApi.upsertOrders(requestSet).getValues();

        // The return gives us a list of orders upserted. The LUID for each has been mapped from the
        // instrument identifiers passed
        assertEquals(1, upsertResult.stream().count());
        assertTrue(upsertResult.stream().allMatch(order -> order.getId().getCode().equals(orderCode)));
        assertTrue(upsertResult.stream().allMatch(order -> order.getLusidInstrumentId().equals(instrumentIds.get(0))));
    }

    // We want to make a request for a single order. The LUID will be mapped to an
    // "unknown" identifier on upsert as we're passing unregistered instrument identifiers.
    @Test
    @LusidFeature("F9-7")
    public void Upsert_Simple_Order_With_Unknown_Instrument() throws ApiException {
        String testScope = TutorialScopes.get("unknown-instrument");
        String orderCode = "Order-" +  UUID.randomUUID().toString();
        ResourceId orderId = new ResourceId()
                .code(orderCode)
                .scope(testScope);

        // These instrument identifiers should all map to the same instrument. If the instance of
        // LUSID has the specified instruments registered these identifiers will get resolved to
        // an actual internal instrument on upsert; otherwise, they'll be resolved to instrument or
        // currency unknown.
        HashMap<String, String> instruments = new HashMap<>();
        instruments.put("Instrument/default/LusidInstrumentId", "LUID_SomeNonexistentInstrument");

        // [Experimental] Currently this portfolio doesn't need to exist. As the domain model evolves
        // this reference might disappear, or might become a strict reference to an existing portfolio
        ResourceId portfolio = new ResourceId()
                .code("OrdersTestPortfolio")
                .scope(testScope);

        ResourceId orderBook = new ResourceId()
                .code("OrdersTestBook")
                .scope(testScope);

        Map<String, PerpetualProperty> properties = new HashMap<>();
        properties.put("Order/" + testScope + "/TIF", new PerpetualProperty().key("Order/" + testScope + "/TIF").value(new PropertyValue().labelValue("GTC")));
        properties.put("Order/" + testScope + "/OrderBook", new PerpetualProperty().key("Order/" + testScope + "/OrderBook").value(new PropertyValue().labelValue("UK Test Orders")));
        properties.put("Order/" + testScope + "/PortfolioManager", new PerpetualProperty().key("Order/" + testScope + "/PortfolioManager").value(new PropertyValue().labelValue("F Bar")));
        properties.put("Order/" + testScope + "/Account", new PerpetualProperty().key("Order/" + testScope + "/Account").value(new PropertyValue().labelValue("J Wilson")));
        properties.put("Order/" + testScope + "/Strategy", new PerpetualProperty().key("Order/" + testScope + "/Strategy").value(new PropertyValue().labelValue("RiskArb")));

        OrderRequest request = new OrderRequest()
                .id(orderId)
                .quantity(100)
                .portfolioId(portfolio)
                .properties(properties)
                .instrumentIdentifiers(instruments)
                .side("Buy");

        OrderSetRequest requestSet = new OrderSetRequest()
                .addOrderRequestsItem(request);

        // We can ask the Orders API to upsert this order for us
        List<Order> upsertResult = ordersApi.upsertOrders(requestSet).getValues();

        // The return gives us a list of orders upserted, and the LUID for each has been mapped from the
        // instrument identifiers passed
        assertEquals(1, upsertResult.stream().count());
        assertTrue(upsertResult.stream().allMatch(order -> order.getLusidInstrumentId().equals("LUID_ZZZZZZZZ")));
    }

    // We want to make a request for a single order. The internal security id will be mapped on upsert
    // from the instrument identifiers passed.
    @Test
    @LusidFeature("F9-8")
    public void Update_Simple_Order() throws ApiException {
        String testScope = TutorialScopes.get("simple-upsert");
        String orderCode = "Order-" +  UUID.randomUUID().toString();
        ResourceId orderId = new ResourceId()
                .code(orderCode)
                .scope(testScope);

        // These instrument identifiers should all map to the same instrument. If the instance of
        // LUSID has the specified instruments registered these identifiers will get resolved to
        // an actual internal instrument on upsert; otherwise, they'll be resolved to instrument or
        // currency unknown.
        HashMap<String, String> instruments = new HashMap<>();
        instruments.put("Instrument/default/LusidInstrumentId", instrumentIds.get(0));

        // [Experimental] Currently this portfolio doesn't need to exist. As the domain model evolves
        // this reference might disappear, or might become a strict reference to an existing portfolio
        ResourceId portfolio = new ResourceId()
                .code("OrdersTestPortfolio")
                .scope(testScope);

        ResourceId orderBook = new ResourceId()
                .code("OrdersTestBook")
                .scope(testScope);

        Map<String, PerpetualProperty> properties = new HashMap<>();
        properties.put("Order/" + testScope + "/TIF", new PerpetualProperty().key("Order/" + testScope + "/TIF").value(new PropertyValue().labelValue("GTC")));
        properties.put("Order/" + testScope + "/OrderBook", new PerpetualProperty().key("Order/" + testScope + "/OrderBook").value(new PropertyValue().labelValue("UK Test Orders")));
        properties.put("Order/" + testScope + "/PortfolioManager", new PerpetualProperty().key("Order/" + testScope + "/PortfolioManager").value(new PropertyValue().labelValue("F Bar")));
        properties.put("Order/" + testScope + "/Account", new PerpetualProperty().key("Order/" + testScope + "/Account").value(new PropertyValue().labelValue("J Wilson")));
        properties.put("Order/" + testScope + "/Strategy", new PerpetualProperty().key("Order/" + testScope + "/Strategy").value(new PropertyValue().labelValue("RiskArb")));

        OrderRequest request = new OrderRequest()
                .id(orderId)
                .quantity(100)
                .portfolioId(portfolio)
                .properties(properties)
                .instrumentIdentifiers(instruments)
                .side("Buy");

        OrderSetRequest requestSet = new OrderSetRequest()
                .addOrderRequestsItem(request);

        // We can ask the Orders API to upsert this order for us
        List<Order> upsertResult = ordersApi.upsertOrders(requestSet).getValues();

        // The return gives us a list of orders upserted, and the lusidinstrument for each has been mapped from the
        // instrument identifiers passed
        assertEquals(1, upsertResult.stream().count());
        assertTrue(upsertResult.stream().allMatch(order -> order.getId().getCode().equals(orderCode)));
        assertTrue(upsertResult.stream().allMatch(order -> order.getLusidInstrumentId().equals(instrumentIds.get(0))));
        assertTrue(upsertResult.stream().allMatch(order -> order.getQuantity().equals(BigDecimal.valueOf(100))));
        assertTrue(upsertResult.stream().allMatch(order -> order.getProperties().size() == 5));

        // We can update that Order with a new Quantity, and some extra parameters
        OrderRequest updateRequest = new OrderRequest()
                .id(orderId)
                .quantity(500)
                .portfolioId(portfolio)
                .properties(properties)
                .instrumentIdentifiers(instruments)
                .side("Buy");

        OrderSetRequest updateRequestSet = new OrderSetRequest()
                .addOrderRequestsItem(updateRequest);

        // We can ask the Orders API to upsert this order for us
        List<Order> updateResult = ordersApi.upsertOrders(updateRequestSet).getValues();

        // The return gives us a list of orders upserted, and the lusidinstrument for each has been mapped from the
        // instrument identifiers passed. We can see that the quantity has been udpated, and properties added
        assertEquals(1, updateResult.stream().count());
        assertTrue(updateResult.stream().allMatch(order -> order.getQuantity().equals(BigDecimal.valueOf(500))));
    }

    // We want to make a request for a single order. The internal security id will be mapped on upsert
    // from the instrument identifiers passed. We can filter on a number of parameters on query.
    @Ignore
    @Test
    @LusidFeature("F9-9")
    public void Upsert_And_Retrieve_Simple_Orders() throws ApiException {
        String testScope = TutorialScopes.get("filtering");
        String orderCode1 = "Order-" +  UUID.randomUUID().toString();
        String orderCode2 = "Order-" +  UUID.randomUUID().toString();
        String orderCode3 = "Order-" +  UUID.randomUUID().toString();
        ResourceId orderId1 = new ResourceId()
                .code(orderCode1)
                .scope(testScope);
        ResourceId orderId2 = new ResourceId()
                .code(orderCode2)
                .scope(testScope);
        ResourceId orderId3 = new ResourceId()
                .code(orderCode3)
                .scope(testScope);

        // These instrument identifiers should all map to the same instrument. If the instance of
        // LUSID has the specified instruments registered these identifiers will get resolved to
        // an actual internal instrument on upsert; otherwise, they'll be resolved to instrument or
        // currency unknown.
        HashMap<String, String> instruments = new HashMap<>();
        instruments.put("Instrument/default/LusidInstrumentId", instrumentIds.get(0));

        HashMap<String, String> altInstruments = new HashMap<>();
        altInstruments.put("Instrument/default/LusidInstrumentId", instrumentIds.get(1));

        // [EXPERIMENTAL] Currently required but not used, as the internal instrument
        // is resolved on upsert.  To remove shortly.
        ResourceId portfolio = new ResourceId()
                .code("OrdersTestPortfolio")
                .scope(testScope);

        ResourceId orderBook = new ResourceId()
                .code("OrdersTestBook")
                .scope(testScope);

        ResourceId anotherOrderBook = new ResourceId()
                .code("AnotherOrdersTestBook")
                .scope(testScope);

        Map<String, PerpetualProperty> properties = new HashMap<>();
        properties.put("Order/" + testScope + "/TIF", new PerpetualProperty().key("Order/" + testScope + "/TIF").value(new PropertyValue().labelValue("GTC")));
        properties.put("Order/" + testScope + "/OrderGroup", new PerpetualProperty().key("Order/" + testScope + "/OrderGroup").value(new PropertyValue().labelValue("UK Test Orders")));
        properties.put("Order/" + testScope + "/PortfolioManager", new PerpetualProperty().key("Order/" + testScope + "/PortfolioManager").value(new PropertyValue().labelValue("F Bar")));
        properties.put("Order/" + testScope + "/Account", new PerpetualProperty().key("Order/" + testScope + "/Account").value(new PropertyValue().labelValue("J Wilson")));
        properties.put("Order/" + testScope + "/Strategy", new PerpetualProperty().key("Order/" + testScope + "/Strategy").value(new PropertyValue().labelValue("RiskArb")));

        Map<String, PerpetualProperty> altProperties = new HashMap<>();
        altProperties.put("Order/" + testScope + "/OrderGroup", new PerpetualProperty().key("Order/" + testScope + "/OrderGroup").value(new PropertyValue().labelValue("UK Test Orders 2")));

        OrderRequest request1 = new OrderRequest()
                .id(orderId1)
                .quantity(100)
                .portfolioId(portfolio)
                .properties(properties)
                .instrumentIdentifiers(instruments)
                .side("Sell");

        OrderRequest request2 = new OrderRequest()
            .id(orderId2)
            .quantity(200)
            .portfolioId(portfolio)
            .properties(properties)
            .instrumentIdentifiers(instruments)
                .side("Buy");

        OrderRequest request3 = new OrderRequest()
                .id(orderId3)
                .quantity(300)
                .portfolioId(portfolio)
                .properties(altProperties)
                .instrumentIdentifiers(altInstruments)
                .side("Buy");

        OrderSetRequest request = new OrderSetRequest()
                .addOrderRequestsItem(request1)
                .addOrderRequestsItem(request2)
                .addOrderRequestsItem(request3);

        // We can ask the Orders API to upsert this order for us
        ResourceListOfOrder upsertResult = ordersApi.upsertOrders(request);

        // The return gives us a list of orders upserted, and the lusidinstrument for each has been mapped from the
        // instrument identifiers passed
        assertEquals(3, upsertResult.getValues().size());

        OffsetDateTime t = upsertResult.getValues().get(0).getVersion().getAsAtDate();

        String order1Filter = testScope + "/" + orderCode1;
        String order2Filter = testScope + "/" + orderCode2;
        String order3Filter = testScope + "/" + orderCode3;

        List<Order> quantityFilter = ordersApi.listOrders(t,
                null,
                null,
                null,
                null,
                "Quantity gt 100 and Scope eq '" + testScope + "' and Id in '" + order1Filter + "', '" + order2Filter + "', '" + order3Filter + "'",
                null)
                .getValues();
        assertEquals(2, quantityFilter.size());
        assertTrue(quantityFilter.stream().allMatch(order -> order.getQuantity().compareTo(BigDecimal.valueOf(100)) > 0));

        /*
        List<Order> orderGroupFilter = ordersApi.listOrders(t, null, null, null, null,"Properties[" + testScope + "/OrderGroup] eq 'UK Test Orders 2'", null).getValues();
        assertEquals(1, orderGroupFilter.size());
        assertTrue(orderGroupFilter.stream().allMatch(order -> order.getProperties().get("Order/" + testScope + "/OrderGroup").getValue().getLabelValue().equals("UK Test Orders 2")));

        List<Order> instrumentFilter = ordersApi.listOrders(t, null, null, null, null,"LusidInstrumentId eq '" + instrumentIds.get(0) + "' and Scope eq '" + testScope + "'", null).getValues();
        assertEquals(2, instrumentFilter.size());
        assertTrue(instrumentFilter.stream().allMatch(order -> order.getLusidInstrumentId().equals(instrumentIds.get(0))));

        List<Order> sideFilter = ordersApi.listOrders(t, null, null, null, null,"Side eq 'Sell' and Scope eq '" + testScope + "'", null).getValues();
        assertEquals(1, sideFilter.size());
        assertTrue(sideFilter.stream().allMatch(order -> order.getSide().equals("Sell")));
        */
    }
}