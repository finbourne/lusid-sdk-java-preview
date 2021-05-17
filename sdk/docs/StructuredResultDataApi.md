# StructuredResultDataApi

All URIs are relative to *http://local-unit-test-server.lusid.com:52748*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDataMap**](StructuredResultDataApi.md#createDataMap) | **POST** /api/unitresults/datamap/{scope} | [EXPERIMENTAL] Upsert a set of structured result address definition maps. This creates or updates the data in Lusid.
[**deleteStructuredResultData**](StructuredResultDataApi.md#deleteStructuredResultData) | **POST** /api/unitresults/{scope}/$delete | [EXPERIMENTAL] Delete one or more items of structured result data, assuming they are present.
[**getDataMap**](StructuredResultDataApi.md#getDataMap) | **POST** /api/unitresults/datamap/{scope}/$get | [EXPERIMENTAL] Get the result address definition maps from the store
[**getStructuredResultData**](StructuredResultDataApi.md#getStructuredResultData) | **POST** /api/unitresults/{scope}/$get | [EXPERIMENTAL] Get structured result data
[**upsertStructuredResultData**](StructuredResultDataApi.md#upsertStructuredResultData) | **POST** /api/unitresults/{scope} | [EXPERIMENTAL] Upsert a set of structured result data items. This creates or updates the data in Lusid.


<a name="createDataMap"></a>
# **createDataMap**
> UpsertStructuredDataResponse createDataMap(scope, requestBody)

[EXPERIMENTAL] Upsert a set of structured result address definition maps. This creates or updates the data in Lusid.

Create one or more structured result address definition map items in a single scope. These are immutable and cannot be changed once inserted                In the request each data map item must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each structured result data in the response.                The response will return both the collection of successfully updated or inserted data maps, as well as those that failed.  For the failures a reason will be provided explaining why the item could not be updated or inserted.                It is important to always check the failed set for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredResultDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:52748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredResultDataApi apiInstance = new StructuredResultDataApi(defaultClient);
    String scope = "scope_example"; // String | Scope in which to upsert the result address definition maps
    Map<String, CreateDataMapRequest> requestBody = {}; // Map<String, CreateDataMapRequest> | Individual result address definition map creation requests
    try {
      UpsertStructuredDataResponse result = apiInstance.createDataMap(scope, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredResultDataApi#createDataMap");
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
 **scope** | **String**| Scope in which to upsert the result address definition maps |
 **requestBody** | [**Map&lt;String, CreateDataMapRequest&gt;**](CreateDataMapRequest.md)| Individual result address definition map creation requests |

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
**200** | The successfully created data maps along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deleteStructuredResultData"></a>
# **deleteStructuredResultData**
> AnnulStructuredDataResponse deleteStructuredResultData(scope, requestBody)

[EXPERIMENTAL] Delete one or more items of structured result data, assuming they are present.

Delete one or more specified structured result data items from a single scope. Each item is identified by a unique id which includes  information about its type as well as the exact effective datetime (to the microsecond) at which it entered the system (became valid).                In the request each market data item must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each quote in the response.                The response will return both the collection of successfully deleted market data items, as well as those that failed.  For the failures a reason will be provided explaining why the it could not be deleted.                It is important to always check the failed set for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredResultDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:52748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredResultDataApi apiInstance = new StructuredResultDataApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the structured result data to delete.
    Map<String, StructuredResultDataId> requestBody = {"someCorrelationId1":{"source":"MiddleOffice","code":"MyUploadedRiskResults","effectiveAt":"2018-03-05T00:00:00.0000000+00:00","resultType":"Risk"}}; // Map<String, StructuredResultDataId> | The structured result data Ids to delete, each keyed by a unique correlation id.
    try {
      AnnulStructuredDataResponse result = apiInstance.deleteStructuredResultData(scope, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredResultDataApi#deleteStructuredResultData");
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
 **scope** | **String**| The scope of the structured result data to delete. |
 **requestBody** | [**Map&lt;String, StructuredResultDataId&gt;**](StructuredResultDataId.md)| The structured result data Ids to delete, each keyed by a unique correlation id. |

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
**200** | The successfully deleted result data along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getDataMap"></a>
# **getDataMap**
> GetDataMapResponse getDataMap(scope, requestBody)

[EXPERIMENTAL] Get the result address definition maps from the store

Get one or more result address definition map from a single scope.                Each item can be identified by its invariant Data Map key, which can be thought of as a permanent URL.                For each id LUSID will return the most recent matched item.                In the request each structured result data id must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each item in the response.                The response will return three collections. One, the successfully retrieved structured result data. Two, those that had a  valid identifier but could not be found. Three, those that failed because LUSID could not construct a valid identifier from the request.                For the ids that failed to resolve or could not be found a reason will be provided explaining why that is the case.                It is important to always check the failed and not found sets for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredResultDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:52748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredResultDataApi apiInstance = new StructuredResultDataApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the result address definition map keys
    Map<String, DataMapKey> requestBody = {}; // Map<String, DataMapKey> | The result address definition map keys to lookup
    try {
      GetDataMapResponse result = apiInstance.getDataMap(scope, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredResultDataApi#getDataMap");
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
 **scope** | **String**| The scope of the result address definition map keys |
 **requestBody** | [**Map&lt;String, DataMapKey&gt;**](DataMapKey.md)| The result address definition map keys to lookup |

### Return type

[**GetDataMapResponse**](GetDataMapResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully retrieved data maps along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getStructuredResultData"></a>
# **getStructuredResultData**
> GetStructuredResultDataResponse getStructuredResultData(scope, requestBody, asAt, maxAge)

[EXPERIMENTAL] Get structured result data

Get one or more items of structured result data from a single scope.                Each item can be identified by its time invariant structured result data identifier.                For each id LUSID will return the most recent matched item with respect to the provided (or default) effective datetime.                 An optional maximum age range window can be specified which defines how far back to look back for data from the specified effective datetime.  LUSID will return the most recent item within this window.                In the request each structured result data id must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each item in the response.                The response will return three collections. One, the successfully retrieved structured result data. Two, those that had a  valid identifier but could not be found. Three, those that failed because LUSID could not construct a valid identifier from the request.    For the ids that failed to resolve or could not be found a reason will be provided explaining why that is the case.                It is important to always check the failed and not found sets for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredResultDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:52748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredResultDataApi apiInstance = new StructuredResultDataApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the structured result data to retrieve.
    Map<String, StructuredResultDataId> requestBody = {"someCorrelationId1":{"source":"MiddleOffice","code":"MyUploadedRiskResults","effectiveAt":"2018-03-05T00:00:00.0000000+00:00","resultType":"Risk"}}; // Map<String, StructuredResultDataId> | The time invariant set of structured data identifiers to retrieve the data for. These need to be               keyed by a unique correlation id allowing the retrieved item to be identified in the response.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the structured result data. Defaults to return the latest version if not specified.
    String maxAge = "maxAge_example"; // String | The duration of the look back window in an ISO8601 time interval format e.g. P1Y2M3DT4H30M (1 year, 2 months, 3 days, 4 hours and 30 minutes).               This is subtracted from the provided effectiveAt datetime to generate a effective datetime window inside which a structured result data item must exist to be retrieved.
    try {
      GetStructuredResultDataResponse result = apiInstance.getStructuredResultData(scope, requestBody, asAt, maxAge);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredResultDataApi#getStructuredResultData");
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
 **scope** | **String**| The scope of the structured result data to retrieve. |
 **requestBody** | [**Map&lt;String, StructuredResultDataId&gt;**](StructuredResultDataId.md)| The time invariant set of structured data identifiers to retrieve the data for. These need to be               keyed by a unique correlation id allowing the retrieved item to be identified in the response. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the structured result data. Defaults to return the latest version if not specified. | [optional]
 **maxAge** | **String**| The duration of the look back window in an ISO8601 time interval format e.g. P1Y2M3DT4H30M (1 year, 2 months, 3 days, 4 hours and 30 minutes).               This is subtracted from the provided effectiveAt datetime to generate a effective datetime window inside which a structured result data item must exist to be retrieved. | [optional]

### Return type

[**GetStructuredResultDataResponse**](GetStructuredResultDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully retrieved structured result data along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertStructuredResultData"></a>
# **upsertStructuredResultData**
> UpsertStructuredDataResponse upsertStructuredResultData(scope, requestBody)

[EXPERIMENTAL] Upsert a set of structured result data items. This creates or updates the data in Lusid.

Update or insert one or more structured result data items in a single scope. An item will be updated if it already exists  and inserted if it does not.                In the request each structured result data item must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each structured result data in the response.                The response will return both the collection of successfully updated or inserted structured result data, as well as those that failed.  For the failures a reason will be provided explaining why the item could not be updated or inserted.                It is important to always check the failed set for any unsuccessful results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.StructuredResultDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:52748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    StructuredResultDataApi apiInstance = new StructuredResultDataApi(defaultClient);
    String scope = "scope_example"; // String | The scope to use when updating or inserting the structured result data.
    Map<String, UpsertStructuredResultDataRequest> requestBody = {"first-item":{"id":{"source":"Client","code":"MyUploadedRiskResults-1","effectiveAt":"2018-03-05T00:00:00.0000000+00:00","resultType":"Risk"},"data":{"documentFormat":"Xml","version":"1.0.0","name":"free text identifier of document 1","document":"<xml>data</xml>"}},"second-item":{"id":{"source":"Client","code":"MyUploadedRiskResults-2","effectiveAt":"2018-03-05T00:00:00.0000000+00:00","resultType":"Risk"},"data":{"documentFormat":"Json","version":"1.0.0","name":"free text identifier of document 2","document":"{ \"some\":\"valid json\"}"}}}; // Map<String, UpsertStructuredResultDataRequest> | The set of structured result data items to update or insert keyed by a unique correlation id.
    try {
      UpsertStructuredDataResponse result = apiInstance.upsertStructuredResultData(scope, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StructuredResultDataApi#upsertStructuredResultData");
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
 **scope** | **String**| The scope to use when updating or inserting the structured result data. |
 **requestBody** | [**Map&lt;String, UpsertStructuredResultDataRequest&gt;**](UpsertStructuredResultDataRequest.md)| The set of structured result data items to update or insert keyed by a unique correlation id. |

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
**200** | The successfully updated or inserted result data along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

