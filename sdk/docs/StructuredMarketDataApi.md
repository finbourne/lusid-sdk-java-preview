# StructuredMarketDataApi

All URIs are relative to *http://local-unit-test-server.lusid.com:38291*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteStructuredMarketData**](StructuredMarketDataApi.md#deleteStructuredMarketData) | **POST** /api/structured/{scope}/$delete | [EXPERIMENTAL] Delete one or more items of structured market data, assuming they are present.
[**getStructuredMarketData**](StructuredMarketDataApi.md#getStructuredMarketData) | **POST** /api/structured/{scope}/$get | [EXPERIMENTAL] Get structured market data
[**upsertStructuredMarketData**](StructuredMarketDataApi.md#upsertStructuredMarketData) | **POST** /api/structured/{scope} | [EXPERIMENTAL] Upsert a set of structured market data items. This creates or updates the data in Lusid.


<a name="deleteStructuredMarketData"></a>
# **deleteStructuredMarketData**
> AnnulStructuredDataResponse deleteStructuredMarketData(scope, requestBody)

[EXPERIMENTAL] Delete one or more items of structured market data, assuming they are present.

Delete one or more specified structured market data items from a single scope. Each item is identified by a unique id which includes  information about its type as well as the exact effective datetime (to the microsecond) at which it entered the system (became valid).                In the request each market data item must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each quote in the response.                The response will return both the collection of successfully deleted market data items, as well as those that failed.  For the failures a reason will be provided explaining why the it could not be deleted.                It is important to always check the failed set for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredMarketDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:38291");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredMarketDataApi apiInstance = new StructuredMarketDataApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the structured market data to delete.
    Map<String, StructuredMarketDataId> requestBody = new HashMap(); // Map<String, StructuredMarketDataId> | The structured market data Ids to delete, each keyed by a unique correlation id.
    try {
      AnnulStructuredDataResponse result = apiInstance.deleteStructuredMarketData(scope, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredMarketDataApi#deleteStructuredMarketData");
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
 **scope** | **String**| The scope of the structured market data to delete. |
 **requestBody** | [**Map&lt;String, StructuredMarketDataId&gt;**](StructuredMarketDataId.md)| The structured market data Ids to delete, each keyed by a unique correlation id. |

### Return type

[**AnnulStructuredDataResponse**](AnnulStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully deleted StructuredMarketData along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getStructuredMarketData"></a>
# **getStructuredMarketData**
> GetStructuredMarketDataResponse getStructuredMarketData(scope, requestBody, effectiveAt, asAt, maxAge)

[EXPERIMENTAL] Get structured market data

Get one or more items of structured market data from a single scope.                Each item can be identified by its time invariant structured market data identifier.                For each id LUSID will return the most recent matched item with respect to the provided (or default) effective datetime.                 An optional maximum age range window can be specified which defines how far back to look back for data from the specified effective datetime.  LUSID will return the most recent item within this window.                In the request each structured market data id must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each item in the response.                The response will return three collections. One, the successfully retrieved structured market data. Two, those that had a  valid identifier but could not be found. Three, those that failed because LUSID could not construct a valid identifier from the request.    For the ids that failed to resolve or could not be found a reason will be provided explaining why that is the case.                It is important to always check the failed and not found sets for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredMarketDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:38291");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredMarketDataApi apiInstance = new StructuredMarketDataApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the structured market data to retrieve.
    Map<String, StructuredMarketDataId> requestBody = new HashMap(); // Map<String, StructuredMarketDataId> | The time invariant set of structured data identifiers to retrieve the data for. These need to be               keyed by a unique correlation id allowing the retrieved item to be identified in the response.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime at which to retrieve the structured market data. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the structured market data. Defaults to return the latest version if not specified.
    String maxAge = "maxAge_example"; // String | The duration of the look back window in an ISO8601 time interval format e.g. P1Y2M3DT4H30M (1 year, 2 months, 3 days, 4 hours and 30 minutes).               This is subtracted from the provided effectiveAt datetime to generate a effective datetime window inside which a structured market data item must exist to be retrieved.
    try {
      GetStructuredMarketDataResponse result = apiInstance.getStructuredMarketData(scope, requestBody, effectiveAt, asAt, maxAge);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredMarketDataApi#getStructuredMarketData");
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
 **scope** | **String**| The scope of the structured market data to retrieve. |
 **requestBody** | [**Map&lt;String, StructuredMarketDataId&gt;**](StructuredMarketDataId.md)| The time invariant set of structured data identifiers to retrieve the data for. These need to be               keyed by a unique correlation id allowing the retrieved item to be identified in the response. |
 **effectiveAt** | **String**| The effective datetime at which to retrieve the structured market data. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the structured market data. Defaults to return the latest version if not specified. | [optional]
 **maxAge** | **String**| The duration of the look back window in an ISO8601 time interval format e.g. P1Y2M3DT4H30M (1 year, 2 months, 3 days, 4 hours and 30 minutes).               This is subtracted from the provided effectiveAt datetime to generate a effective datetime window inside which a structured market data item must exist to be retrieved. | [optional]

### Return type

[**GetStructuredMarketDataResponse**](GetStructuredMarketDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully retrieved structured market data along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertStructuredMarketData"></a>
# **upsertStructuredMarketData**
> UpsertStructuredDataResponse upsertStructuredMarketData(scope, requestBody)

[EXPERIMENTAL] Upsert a set of structured market data items. This creates or updates the data in Lusid.

Update or insert one or more structured market data items in a single scope. An item will be updated if it already exists  and inserted if it does not.                In the request each structured market data item must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each structured market data in the response.                The response will return both the collection of successfully updated or inserted structured market data, as well as those that failed.  For the failures a reason will be provided explaining why the item could not be updated or inserted.                It is important to always check the failed set for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredMarketDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:38291");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredMarketDataApi apiInstance = new StructuredMarketDataApi(defaultClient);
    String scope = "scope_example"; // String | The scope to use when updating or inserting the structured market data.
    Map<String, UpsertStructuredMarketDataRequest> requestBody = new HashMap(); // Map<String, UpsertStructuredMarketDataRequest> | The set of structured market data items to update or insert keyed by a unique correlation id.
    try {
      UpsertStructuredDataResponse result = apiInstance.upsertStructuredMarketData(scope, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredMarketDataApi#upsertStructuredMarketData");
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
 **scope** | **String**| The scope to use when updating or inserting the structured market data. |
 **requestBody** | [**Map&lt;String, UpsertStructuredMarketDataRequest&gt;**](UpsertStructuredMarketDataRequest.md)| The set of structured market data items to update or insert keyed by a unique correlation id. |

### Return type

[**UpsertStructuredDataResponse**](UpsertStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully updated or inserted StructuredMarketData along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

