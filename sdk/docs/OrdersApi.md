# OrdersApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getOrder**](OrdersApi.md#getOrder) | **GET** /api/orders/{scope}/{code} | [EXPERIMENTAL] Fetch a given order.
[**listOrders**](OrdersApi.md#listOrders) | **GET** /api/orders/{scope} | [EXPERIMENTAL] Fetch the last pre-AsAt date version of each order in scope (does not fetch the entire history).
[**upsertOrderProperties**](OrdersApi.md#upsertOrderProperties) | **POST** /api/orders/{scope}/properties | [EXPERIMENTAL] Upsert; update properties on existing Orders with given ids.
[**upsertOrders**](OrdersApi.md#upsertOrders) | **POST** /api/orders/{scope} | [EXPERIMENTAL] Upsert; update existing orders with given ids, or create new orders otherwise.


<a name="getOrder"></a>
# **getOrder**
> Order getOrder(scope, code, asAt, propertyKeys)

[EXPERIMENTAL] Fetch a given order.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    String scope = "scope_example"; // String | The scope to which the order belongs.
    String code = "code_example"; // String | The order's unique identifier.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the order. Defaults to return the latest version of the order if not specified.
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the \"Orders\" domain to decorate onto the order.              These take the format {domain}/{scope}/{code} e.g. \"Orders/system/Name\".
    try {
      Order result = apiInstance.getOrder(scope, code, asAt, propertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#getOrder");
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
 **scope** | **String**| The scope to which the order belongs. |
 **code** | **String**| The order&#39;s unique identifier. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the order. Defaults to return the latest version of the order if not specified. | [optional]
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the \&quot;Orders\&quot; domain to decorate onto the order.              These take the format {domain}/{scope}/{code} e.g. \&quot;Orders/system/Name\&quot;. | [optional]

### Return type

[**Order**](Order.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The order matching the given identifier. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listOrders"></a>
# **listOrders**
> PagedResourceListOfOrder listOrders(scope, asAt, page, sortBy, start, limit, filter, propertyKeys)

[EXPERIMENTAL] Fetch the last pre-AsAt date version of each order in scope (does not fetch the entire history).

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    String scope = "scope_example"; // String | The scope to which the orders belong.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the order. Defaults to return the latest version of the order if not specified.
    String page = "page_example"; // String | The pagination token to use to continue listing orders from a previous call to list orders.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, effectiveAt, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided.
    List<String> sortBy = Arrays.asList(); // List<String> | Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName.
    Integer start = 56; // Integer | When paginating, skip this number of results.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many.
    String filter = "\"Quantity gt 0\""; // String | Expression to filter the result set.  Currently Orders can be filtered by Code (e.g.              \"Id eq 'TestScope/ORD001'), Quantity (e.g. \"Quantity lt 100\"), Portfolio (e.g. \"Portfolio eq 'TestScope/UKEquities'\"),              LUSID Instrument Id (e.g. \"LusidInstrumentId eq 'LUID_12345678'\") or by Property (Read more about filtering results from LUSID here:              https://support.lusid.com/filtering-results-from-lusid).
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the \"Orders\" domain to decorate onto each order.                  These take the format {domain}/{scope}/{code} e.g. \"Orders/system/Name\".
    try {
      PagedResourceListOfOrder result = apiInstance.listOrders(scope, asAt, page, sortBy, start, limit, filter, propertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#listOrders");
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
 **scope** | **String**| The scope to which the orders belong. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the order. Defaults to return the latest version of the order if not specified. | [optional]
 **page** | **String**| The pagination token to use to continue listing orders from a previous call to list orders.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, effectiveAt, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided. | [optional]
 **sortBy** | [**List&lt;String&gt;**](String.md)| Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName. | [optional]
 **start** | **Integer**| When paginating, skip this number of results. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. | [optional]
 **filter** | **String**| Expression to filter the result set.  Currently Orders can be filtered by Code (e.g.              \&quot;Id eq &#39;TestScope/ORD001&#39;), Quantity (e.g. \&quot;Quantity lt 100\&quot;), Portfolio (e.g. \&quot;Portfolio eq &#39;TestScope/UKEquities&#39;\&quot;),              LUSID Instrument Id (e.g. \&quot;LusidInstrumentId eq &#39;LUID_12345678&#39;\&quot;) or by Property (Read more about filtering results from LUSID here:              https://support.lusid.com/filtering-results-from-lusid). | [optional] [default to &quot;Quantity gt 0&quot;]
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the \&quot;Orders\&quot; domain to decorate onto each order.                  These take the format {domain}/{scope}/{code} e.g. \&quot;Orders/system/Name\&quot;. | [optional]

### Return type

[**PagedResourceListOfOrder**](PagedResourceListOfOrder.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Orders in scope. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertOrderProperties"></a>
# **upsertOrderProperties**
> UpsertOrderPropertiesResponse upsertOrderProperties(scope, request)

[EXPERIMENTAL] Upsert; update properties on existing Orders with given ids.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    String scope = "scope_example"; // String | The scope to which the orders belong.
    List<UpsertOrderPropertiesRequest> request = Arrays.asList(null); // List<UpsertOrderPropertiesRequest> | A collection of order property upsert requests.
    try {
      UpsertOrderPropertiesResponse result = apiInstance.upsertOrderProperties(scope, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#upsertOrderProperties");
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
 **scope** | **String**| The scope to which the orders belong. |
 **request** | [**List&lt;UpsertOrderPropertiesRequest&gt;**](UpsertOrderPropertiesRequest.md)| A collection of order property upsert requests. | [optional]

### Return type

[**UpsertOrderPropertiesResponse**](UpsertOrderPropertiesResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | An upsert order properties response. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertOrders"></a>
# **upsertOrders**
> ResourceListOfOrder upsertOrders(scope, request)

[EXPERIMENTAL] Upsert; update existing orders with given ids, or create new orders otherwise.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    String scope = "scope_example"; // String | The scope to which the orders belong.
    OrderSetRequest request = new OrderSetRequest(); // OrderSetRequest | The collection of order requests.
    try {
      ResourceListOfOrder result = apiInstance.upsertOrders(scope, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#upsertOrders");
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
 **scope** | **String**| The scope to which the orders belong. |
 **request** | [**OrderSetRequest**](OrderSetRequest.md)| The collection of order requests. | [optional]

### Return type

[**ResourceListOfOrder**](ResourceListOfOrder.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | A collection of orders. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

