# AnalyticsStoresApi

All URIs are relative to *http://http:/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAnalyticStore**](AnalyticsStoresApi.md#createAnalyticStore) | **POST** /api/analytics | [EXPERIMENTAL] Create analytic store
[**deleteAnalyticStore**](AnalyticsStoresApi.md#deleteAnalyticStore) | **DELETE** /api/analytics/{scope}/{year}/{month}/{day} | [EXPERIMENTAL] Delete analytic store
[**getAnalyticStore**](AnalyticsStoresApi.md#getAnalyticStore) | **GET** /api/analytics/{scope}/{year}/{month}/{day} | [EXPERIMENTAL] Get analytic store
[**listAnalyticStores**](AnalyticsStoresApi.md#listAnalyticStores) | **GET** /api/analytics | [EXPERIMENTAL] List analytic stores
[**setAnalytics**](AnalyticsStoresApi.md#setAnalytics) | **PUT** /api/analytics/{scope}/{year}/{month}/{day}/prices | [EXPERIMENTAL] Set analytic data


<a name="createAnalyticStore"></a>
# **createAnalyticStore**
> AnalyticStore createAnalyticStore(request)

[EXPERIMENTAL] Create analytic store

Create a new analytic store for the specified scope and date

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AnalyticsStoresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AnalyticsStoresApi apiInstance = new AnalyticsStoresApi(defaultClient);
    CreateAnalyticStoreRequest request = new CreateAnalyticStoreRequest(); // CreateAnalyticStoreRequest | A populated analytic store definition
    try {
      AnalyticStore result = apiInstance.createAnalyticStore(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsStoresApi#createAnalyticStore");
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
 **request** | [**CreateAnalyticStoreRequest**](CreateAnalyticStoreRequest.md)| A populated analytic store definition | [optional]

### Return type

[**AnalyticStore**](AnalyticStore.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | The meta data of the created analytic store |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deleteAnalyticStore"></a>
# **deleteAnalyticStore**
> DeletedEntityResponse deleteAnalyticStore(scope, year, month, day)

[EXPERIMENTAL] Delete analytic store

Delete stored analytic data in the specified scope for the specified date

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AnalyticsStoresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AnalyticsStoresApi apiInstance = new AnalyticsStoresApi(defaultClient);
    String scope = "scope_example"; // String | The analytics data scope
    Integer year = 56; // Integer | The year component of the date
    Integer month = 56; // Integer | The month component of the date
    Integer day = 56; // Integer | The day component of the date
    try {
      DeletedEntityResponse result = apiInstance.deleteAnalyticStore(scope, year, month, day);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsStoresApi#deleteAnalyticStore");
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
 **scope** | **String**| The analytics data scope |
 **year** | **Integer**| The year component of the date |
 **month** | **Integer**| The month component of the date |
 **day** | **Integer**| The day component of the date |

### Return type

[**DeletedEntityResponse**](DeletedEntityResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A confirmation of the deleted store |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getAnalyticStore"></a>
# **getAnalyticStore**
> AnalyticStore getAnalyticStore(scope, year, month, day, asAt)

[EXPERIMENTAL] Get analytic store

Get the meta data associated with a specified scope and date combination (analytic store)

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AnalyticsStoresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AnalyticsStoresApi apiInstance = new AnalyticsStoresApi(defaultClient);
    String scope = "scope_example"; // String | The analytics data scope
    Integer year = 56; // Integer | The year component of the date for the data in the scope
    Integer month = 56; // Integer | The month component of the date for the data in the scope
    Integer day = 56; // Integer | The day component of the date for the data in the scope
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | Optional. The AsAt date of the data
    try {
      AnalyticStore result = apiInstance.getAnalyticStore(scope, year, month, day, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsStoresApi#getAnalyticStore");
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
 **scope** | **String**| The analytics data scope |
 **year** | **Integer**| The year component of the date for the data in the scope |
 **month** | **Integer**| The month component of the date for the data in the scope |
 **day** | **Integer**| The day component of the date for the data in the scope |
 **asAt** | **OffsetDateTime**| Optional. The AsAt date of the data | [optional]

### Return type

[**AnalyticStore**](AnalyticStore.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The analytic store&#39;s meta data |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listAnalyticStores"></a>
# **listAnalyticStores**
> ResourceListOfAnalyticStoreKey listAnalyticStores(asAt, sortBy, start, limit, filter)

[EXPERIMENTAL] List analytic stores

List all defined analytic stores

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AnalyticsStoresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AnalyticsStoresApi apiInstance = new AnalyticsStoresApi(defaultClient);
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | Optional. The AsAt date of the data
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    String filter = "filter_example"; // String | Optional. Expression to filter the result set
    try {
      ResourceListOfAnalyticStoreKey result = apiInstance.listAnalyticStores(asAt, sortBy, start, limit, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsStoresApi#listAnalyticStores");
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
 **asAt** | **OffsetDateTime**| Optional. The AsAt date of the data | [optional]
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **start** | **Integer**| Optional. When paginating, skip this number of results | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many. | [optional]
 **filter** | **String**| Optional. Expression to filter the result set | [optional]

### Return type

[**ResourceListOfAnalyticStoreKey**](ResourceListOfAnalyticStoreKey.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A list of analytic store keys |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="setAnalytics"></a>
# **setAnalytics**
> AnalyticStore setAnalytics(scope, year, month, day, data)

[EXPERIMENTAL] Set analytic data

Store the complete set of analytics for an existing analytic store for the specified scope and date

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AnalyticsStoresApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AnalyticsStoresApi apiInstance = new AnalyticsStoresApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the data being stored
    Integer year = 56; // Integer | The year component of the date for the data
    Integer month = 56; // Integer | The month component of the date for the data
    Integer day = 56; // Integer | The day component of the date for the data
    List<InstrumentAnalytic> data = Arrays.asList(null); // List<InstrumentAnalytic> | The analytic data being inserted
    try {
      AnalyticStore result = apiInstance.setAnalytics(scope, year, month, day, data);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsStoresApi#setAnalytics");
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
 **scope** | **String**| The scope of the data being stored |
 **year** | **Integer**| The year component of the date for the data |
 **month** | **Integer**| The month component of the date for the data |
 **day** | **Integer**| The day component of the date for the data |
 **data** | [**List&lt;InstrumentAnalytic&gt;**](InstrumentAnalytic.md)| The analytic data being inserted | [optional]

### Return type

[**AnalyticStore**](AnalyticStore.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The meta data of the analytic store |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

