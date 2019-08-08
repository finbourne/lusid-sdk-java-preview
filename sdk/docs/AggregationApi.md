# AggregationApi

All URIs are relative to *http://http:/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAggregationByGroup**](AggregationApi.md#getAggregationByGroup) | **POST** /api/portfoliogroups/{scope}/{code}/$aggregate | [EXPERIMENTAL] Aggregate data in a portfolio group
[**getAggregationByPortfolio**](AggregationApi.md#getAggregationByPortfolio) | **POST** /api/portfolios/{scope}/{code}/$aggregate | [EXPERIMENTAL] Aggregate data in a portfolio
[**getAggregationByResultSet**](AggregationApi.md#getAggregationByResultSet) | **POST** /api/results/{scope}/{resultsKey}/$aggregate | [EXPERIMENTAL] Aggregate using result data
[**getNestedAggregationByGroup**](AggregationApi.md#getNestedAggregationByGroup) | **POST** /api/portfoliogroups/{scope}/{code}/$aggregatenested | [EXPERIMENTAL] Aggregate data in a portfolio group, as nested


<a name="getAggregationByGroup"></a>
# **getAggregationByGroup**
> ListAggregationResponse getAggregationByGroup(scope, code, sortBy, start, limit, request)

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
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio group
    String code = "code_example"; // String | The code of the portfolio group
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest request = new AggregationRequest(); // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregationByGroup(scope, code, sortBy, start, limit, request);
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
 **request** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

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

<a name="getAggregationByPortfolio"></a>
# **getAggregationByPortfolio**
> ListAggregationResponse getAggregationByPortfolio(scope, code, sortBy, start, limit, request)

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
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio
    String code = "code_example"; // String | The code of the portfolio
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest request = new AggregationRequest(); // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregationByPortfolio(scope, code, sortBy, start, limit, request);
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
 **request** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

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

<a name="getAggregationByResultSet"></a>
# **getAggregationByResultSet**
> ListAggregationResponse getAggregationByResultSet(scope, resultsKey, sortBy, start, limit, request)

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
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Result data set
    String resultsKey = "resultsKey_example"; // String | The key of the Result data set
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest request = new AggregationRequest(); // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregationByResultSet(scope, resultsKey, sortBy, start, limit, request);
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
 **request** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**ListAggregationResponse**](ListAggregationResponse.md)

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

<a name="getNestedAggregationByGroup"></a>
# **getNestedAggregationByGroup**
> NestedAggregationResponse getNestedAggregationByGroup(scope, code, request)

[EXPERIMENTAL] Aggregate data in a portfolio group, as nested

Obsolete - Aggregate data sourced from the specified portfolio group into a nested structure. Data is nested following the group-by specifications.

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
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio group
    String code = "code_example"; // String | The code of the portfolio group
    AggregationRequest request = new AggregationRequest(); // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      NestedAggregationResponse result = apiInstance.getNestedAggregationByGroup(scope, code, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getNestedAggregationByGroup");
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
 **request** | [**AggregationRequest**](AggregationRequest.md)| The request specifying the parameters of the aggregation | [optional]

### Return type

[**NestedAggregationResponse**](NestedAggregationResponse.md)

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

