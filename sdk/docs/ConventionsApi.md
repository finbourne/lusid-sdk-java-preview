# ConventionsApi

All URIs are relative to *http://localhost:61175*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteConventions**](ConventionsApi.md#deleteConventions) | **DELETE** /api/conventions/{scope}/{code} | [EXPERIMENTAL] Delete the conventions of given scope and code, assuming that it is present.
[**getFlowConventions**](ConventionsApi.md#getFlowConventions) | **GET** /api/conventions/{scope}/{code} | [EXPERIMENTAL] Get Flow Conventions
[**listConventions**](ConventionsApi.md#listConventions) | **GET** /api/conventions | [EXPERIMENTAL] List the set of conventions


<a name="deleteConventions"></a>
# **deleteConventions**
> AnnulSingleStructuredDataResponse deleteConventions(scope, code)

[EXPERIMENTAL] Delete the conventions of given scope and code, assuming that it is present.

Delete the specified conventions from a single scope.  The response will return either detail of the deleted item, or an explanation (failure) as to why this did not succeed.  It is important to always check for any unsuccessful response.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.ConventionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the conventions to delete.
    String code = "code_example"; // String | The conventions to delete.
    try {
      AnnulSingleStructuredDataResponse result = apiInstance.deleteConventions(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#deleteConventions");
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
 **scope** | **String**| The scope of the conventions to delete. |
 **code** | **String**| The conventions to delete. |

### Return type

[**AnnulSingleStructuredDataResponse**](AnnulSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The AsAt of deletion or failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getFlowConventions"></a>
# **getFlowConventions**
> GetConventionsResponse getFlowConventions(scope, code, asAt)

[EXPERIMENTAL] Get Flow Conventions

Get a Flow Conventions from a single scope.  The response will return either the conventions that has been stored, or a failure explaining why the request was unsuccessful.  It is important to always check for any unsuccessful requests (failures).

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.ConventionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Flow Conventions to retrieve.
    String code = "code_example"; // String | The name of the Flow Conventions to retrieve the data for.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the Flow Conventions. Defaults to return the latest version if not specified.
    try {
      GetConventionsResponse result = apiInstance.getFlowConventions(scope, code, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#getFlowConventions");
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
 **scope** | **String**| The scope of the Flow Conventions to retrieve. |
 **code** | **String**| The name of the Flow Conventions to retrieve the data for. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the Flow Conventions. Defaults to return the latest version if not specified. | [optional]

### Return type

[**GetConventionsResponse**](GetConventionsResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully retrieved Flow Conventions or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listConventions"></a>
# **listConventions**
> ResourceListOfGetConventionsResponse listConventions(asAt)

[EXPERIMENTAL] List the set of conventions

List the set of conventions at the specified date/time

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.ConventionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to list the conventions. Defaults to latest if not specified.
    try {
      ResourceListOfGetConventionsResponse result = apiInstance.listConventions(asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#listConventions");
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
 **asAt** | **OffsetDateTime**| The asAt datetime at which to list the conventions. Defaults to latest if not specified. | [optional]

### Return type

[**ResourceListOfGetConventionsResponse**](ResourceListOfGetConventionsResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested conventions |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

