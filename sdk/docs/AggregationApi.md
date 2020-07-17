# AggregationApi

All URIs are relative to *http://localhost:64988*

Method | HTTP request | Description
------------- | ------------- | -------------
[**generateConfigurationRecipe**](AggregationApi.md#generateConfigurationRecipe) | **POST** /api/aggregation/{scope}/{code}/$generateconfigurationrecipe | [EXPERIMENTAL] Generates a recipe sufficient to perform valuations for the given portfolio.
[**getAggregation**](AggregationApi.md#getAggregation) | **POST** /api/aggregation/{scope}/{code}/$aggregate | [EXPERIMENTAL] Aggregate data in a portfolio or portfolio group
[**getAggregationByGroup**](AggregationApi.md#getAggregationByGroup) | **POST** /api/portfoliogroups/{scope}/{code}/$aggregate | [EXPERIMENTAL] Aggregate data in a portfolio group
[**getAggregationByPortfolio**](AggregationApi.md#getAggregationByPortfolio) | **POST** /api/portfolios/{scope}/{code}/$aggregate | [EXPERIMENTAL] Aggregate data in a portfolio
[**getAggregationByResultSet**](AggregationApi.md#getAggregationByResultSet) | **POST** /api/results/{scope}/{resultsKey}/$aggregate | [EXPERIMENTAL] Aggregate using result data
[**getAggregationOfWeightedInstruments**](AggregationApi.md#getAggregationOfWeightedInstruments) | **POST** /api/portfolios/{scope}/$aggregateinlined | [EXPERIMENTAL] Aggregate data in an inlined portfolio
[**getNestedAggregation**](AggregationApi.md#getNestedAggregation) | **POST** /api/aggregation/{scope}/{code}/$aggregatenested | [EXPERIMENTAL] Aggregate data in a portfolio or portfolio group, as nested
[**getQueryableKeys**](AggregationApi.md#getQueryableKeys) | **GET** /api/results/queryable/keys | [EXPERIMENTAL] Query the set of supported \&quot;addresses\&quot; that can be queried from the aggregation endpoint.


<a name="generateConfigurationRecipe"></a>
# **generateConfigurationRecipe**
> ConfigurationRecipe generateConfigurationRecipe(scope, code, createRecipeRequest)

[EXPERIMENTAL] Generates a recipe sufficient to perform valuations for the given portfolio.

Given a set of scopes, a portfolio Id and a basic recipe, this endpoint generates a configuration recipe with relevant rules that can value the instruments in the portfolio.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio
    String code = "code_example"; // String | The code of the portfolio
    CreateRecipeRequest createRecipeRequest = {"recipeCreationMarketDataScopes":["MyScope"],"recipeId":{"scope":"MyScope","code":"default"},"asAt":"2018-03-05T00:00:00+00:00","effectiveAt":"2018-03-05T00:00:00+00:00"}; // CreateRecipeRequest | The request specifying the parameters to generating the recipe
    try {
      ConfigurationRecipe result = apiInstance.generateConfigurationRecipe(scope, code, createRecipeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#generateConfigurationRecipe");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| The scope of the portfolio |
 **code** | **String**| The code of the portfolio |
 **createRecipeRequest** | [**CreateRecipeRequest**](CreateRecipeRequest.md)| The request specifying the parameters to generating the recipe | [optional]

### Return type

[**ConfigurationRecipe**](ConfigurationRecipe.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getAggregation"></a>
# **getAggregation**
> ListAggregationResponse getAggregation(scope, code, sortBy, start, limit, aggregationRequest)

[EXPERIMENTAL] Aggregate data in a portfolio or portfolio group

Aggregate data sourced from the specified portfolio or portfolio group

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio or portfolio group
    String code = "code_example"; // String | The code of the portfolio or portfolio group
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest aggregationRequest = {"recipeId":{"scope":"MyScope","code":"default"},"asAt":"2018-03-05T00:00:00+00:00","effectiveAt":"2018-03-05T00:00:00+00:00","metrics":[{"key":"Holding/default/PV","op":"Proportion"},{"key":"Holding/default/PV","op":"Sum"}],"groupBy":["Instrument/default/Name"],"portfolioIdentifierCode":"SinglePortfolio"}; // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregation(scope, code, sortBy, start, limit, aggregationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getAggregation");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| The scope of the portfolio or portfolio group |
 **code** | **String**| The code of the portfolio or portfolio group |
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **start** | **Integer**| Optional. When paginating, skip this number of results | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many. | [optional]
 **aggregationRequest** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getAggregationByGroup"></a>
# **getAggregationByGroup**
> ListAggregationResponse getAggregationByGroup(scope, code, sortBy, start, limit, aggregationRequest)

[EXPERIMENTAL] Aggregate data in a portfolio group

Aggregate data sourced from the specified portfolio group

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio group
    String code = "code_example"; // String | The code of the portfolio group
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest aggregationRequest = {"recipeId":{"scope":"MyScope","code":"default"},"asAt":"2018-03-05T00:00:00+00:00","effectiveAt":"2018-03-05T00:00:00+00:00","metrics":[{"key":"Holding/default/PV","op":"Proportion"},{"key":"Holding/default/PV","op":"Sum"}],"groupBy":["Instrument/default/Name"],"portfolioIdentifierCode":"SinglePortfolio"}; // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregationByGroup(scope, code, sortBy, start, limit, aggregationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getAggregationByGroup");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| The scope of the portfolio group |
 **code** | **String**| The code of the portfolio group |
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **start** | **Integer**| Optional. When paginating, skip this number of results | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many. | [optional]
 **aggregationRequest** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getAggregationByPortfolio"></a>
# **getAggregationByPortfolio**
> ListAggregationResponse getAggregationByPortfolio(scope, code, sortBy, start, limit, aggregationRequest)

[EXPERIMENTAL] Aggregate data in a portfolio

Aggregate data sourced from the specified portfolio

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio
    String code = "code_example"; // String | The code of the portfolio
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest aggregationRequest = {"recipeId":{"scope":"MyScope","code":"default"},"asAt":"2018-03-05T00:00:00+00:00","effectiveAt":"2018-03-05T00:00:00+00:00","metrics":[{"key":"Holding/default/PV","op":"Proportion"},{"key":"Holding/default/PV","op":"Sum"}],"groupBy":["Instrument/default/Name"],"portfolioIdentifierCode":"SinglePortfolio"}; // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregationByPortfolio(scope, code, sortBy, start, limit, aggregationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getAggregationByPortfolio");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| The scope of the portfolio |
 **code** | **String**| The code of the portfolio |
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **start** | **Integer**| Optional. When paginating, skip this number of results | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many. | [optional]
 **aggregationRequest** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getAggregationByResultSet"></a>
# **getAggregationByResultSet**
> ListAggregationResponse getAggregationByResultSet(scope, resultsKey, sortBy, start, limit, aggregationRequest)

[EXPERIMENTAL] Aggregate using result data

Aggregate data from a previously-run Result data set into a flat row of results

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Result data set
    String resultsKey = "resultsKey_example"; // String | The key of the Result data set
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest aggregationRequest = {"recipeId":{"scope":"MyScope","code":"default"},"asAt":"2018-03-05T00:00:00+00:00","effectiveAt":"2018-03-05T00:00:00+00:00","metrics":[{"key":"Holding/default/PV","op":"Proportion"},{"key":"Holding/default/PV","op":"Sum"}],"groupBy":["Instrument/default/Name"],"portfolioIdentifierCode":"SinglePortfolio"}; // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregationByResultSet(scope, resultsKey, sortBy, start, limit, aggregationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getAggregationByResultSet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| The scope of the Result data set |
 **resultsKey** | **String**| The key of the Result data set |
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **start** | **Integer**| Optional. When paginating, skip this number of results | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many. | [optional]
 **aggregationRequest** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getAggregationOfWeightedInstruments"></a>
# **getAggregationOfWeightedInstruments**
> ListAggregationResponse getAggregationOfWeightedInstruments(scope, sortBy, start, limit, inlineAggregationRequest)

[EXPERIMENTAL] Aggregate data in an inlined portfolio

Aggregate data sourced from the portfolio that is defined by the weighted set of instruments passed to the request.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the instruments should that be required
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    InlineAggregationRequest inlineAggregationRequest = {"request":{"recipeId":{"scope":"MyScope","code":"default"},"asAt":"2018-03-05T00:00:00+00:00","effectiveAt":"2018-03-05T00:00:00+00:00","metrics":[{"key":"Holding/default/PV","op":"Proportion"},{"key":"Holding/default/PV","op":"Sum"}],"groupBy":["Instrument/default/Name"],"portfolioIdentifierCode":"SinglePortfolio"},"instruments":[{"quantity":10000,"holdingIdentifier":"my-holding-on-some-date","instrument":{"domAmount":100,"fgnAmount":-150,"isNdf":false,"fixingDate":"0001-01-01T00:00:00+00:00","fgnCcy":"GBP","refSpotRate":1.5,"startDate":"2018-03-05T00:00:00+00:00","maturityDate":"2018-04-04T00:00:00+00:00","domCcy":"USD","instrumentType":"FxForward"}}]}; // InlineAggregationRequest | The request specifying the parameters of the aggregation and the inlined set of instruments to aggregate over.
    try {
      ListAggregationResponse result = apiInstance.getAggregationOfWeightedInstruments(scope, sortBy, start, limit, inlineAggregationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getAggregationOfWeightedInstruments");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| The scope of the instruments should that be required |
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **start** | **Integer**| Optional. When paginating, skip this number of results | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many. | [optional]
 **inlineAggregationRequest** | [**InlineAggregationRequest**](InlineAggregationRequest.md)| The request specifying the parameters of the aggregation and the inlined set of instruments to aggregate over. | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getNestedAggregation"></a>
# **getNestedAggregation**
> NestedAggregationResponse getNestedAggregation(scope, code, aggregationRequest)

[EXPERIMENTAL] Aggregate data in a portfolio or portfolio group, as nested

Aggregate data sourced from the specified portfolio or portfolio group into a nested structure. Data is nested following the group-by specifications.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio or portfolio group
    String code = "code_example"; // String | The code of the portfolio or portfolio group
    AggregationRequest aggregationRequest = {"recipeId":{"scope":"MyScope","code":"default"},"asAt":"2018-03-05T00:00:00+00:00","effectiveAt":"2018-03-05T00:00:00+00:00","metrics":[{"key":"Holding/default/PV","op":"Proportion"},{"key":"Holding/default/PV","op":"Sum"}],"groupBy":["Instrument/default/Name"],"portfolioIdentifierCode":"SinglePortfolio"}; // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      NestedAggregationResponse result = apiInstance.getNestedAggregation(scope, code, aggregationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getNestedAggregation");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scope** | **String**| The scope of the portfolio or portfolio group |
 **code** | **String**| The code of the portfolio or portfolio group |
 **aggregationRequest** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**NestedAggregationResponse**](NestedAggregationResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getQueryableKeys"></a>
# **getQueryableKeys**
> ResourceListOfAggregationQuery getQueryableKeys(page, start, limit, filter)

[EXPERIMENTAL] Query the set of supported \&quot;addresses\&quot; that can be queried from the aggregation endpoint.

When a request is made for aggregation, the user needs to know what keys can be passed to it for queryable data. This endpoint allows to queries to provide the set of keys,  what they are and what they return.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:64988");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String page = "page_example"; // String | The pagination token to use to continue listing queryable keys from a previous call to list queryable keys.              This value is returned from the previous call.
    Integer start = 56; // Integer | When paginating, skip this number of results.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many.
    String filter = "filter_example"; // String | Expression to filter the result set.              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    try {
      ResourceListOfAggregationQuery result = apiInstance.getQueryableKeys(page, start, limit, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getQueryableKeys");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **String**| The pagination token to use to continue listing queryable keys from a previous call to list queryable keys.              This value is returned from the previous call. | [optional]
 **start** | **Integer**| When paginating, skip this number of results. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. | [optional]
 **filter** | **String**| Expression to filter the result set.              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]

### Return type

[**ResourceListOfAggregationQuery**](ResourceListOfAggregationQuery.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

