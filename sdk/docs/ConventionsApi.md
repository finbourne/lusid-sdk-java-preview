# ConventionsApi

All URIs are relative to *http://localhost:59118*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCdsFlowConventions**](ConventionsApi.md#deleteCdsFlowConventions) | **DELETE** /api/conventions/credit/conventions/{scope}/{code} | [EXPERIMENTAL] Delete the CDS Flow Conventions of given scope and code, assuming that it is present.
[**deleteFlowConventions**](ConventionsApi.md#deleteFlowConventions) | **DELETE** /api/conventions/rates/flowconventions/{scope}/{code} | [EXPERIMENTAL] Delete the Flow Conventions of given scope and code, assuming that it is present.
[**deleteIndexConvention**](ConventionsApi.md#deleteIndexConvention) | **DELETE** /api/conventions/rates/indexconventions/{scope}/{code} | [EXPERIMENTAL] Delete the Index Convention of given scope and code, assuming that it is present.
[**getCdsFlowConventions**](ConventionsApi.md#getCdsFlowConventions) | **GET** /api/conventions/credit/conventions/{scope}/{code} | [EXPERIMENTAL] Get CDS Flow Conventions
[**getFlowConventions**](ConventionsApi.md#getFlowConventions) | **GET** /api/conventions/rates/flowconventions/{scope}/{code} | [EXPERIMENTAL] Get Flow Conventions
[**getIndexConvention**](ConventionsApi.md#getIndexConvention) | **GET** /api/conventions/rates/indexconventions/{scope}/{code} | [EXPERIMENTAL] Get Index Convention
[**listConventions**](ConventionsApi.md#listConventions) | **GET** /api/conventions | [EXPERIMENTAL] List the set of conventions
[**upsertCdsFlowConventions**](ConventionsApi.md#upsertCdsFlowConventions) | **POST** /api/conventions/credit/conventions | [EXPERIMENTAL] Upsert a set of CDS Flow Conventions. This creates or updates the data in Lusid.
[**upsertFlowConventions**](ConventionsApi.md#upsertFlowConventions) | **POST** /api/conventions/rates/flowconventions | [EXPERIMENTAL] Upsert a set of Flow Conventions. This creates or updates the data in Lusid.
[**upsertIndexConvention**](ConventionsApi.md#upsertIndexConvention) | **POST** /api/conventions/rates/indexconventions | [EXPERIMENTAL] Upsert a set of Index Convention. This creates or updates the data in Lusid.


<a name="deleteCdsFlowConventions"></a>
# **deleteCdsFlowConventions**
> AnnulSingleStructuredDataResponse deleteCdsFlowConventions(scope, code)

[EXPERIMENTAL] Delete the CDS Flow Conventions of given scope and code, assuming that it is present.

Delete the specified CDS Flow Conventions from a single scope.  The response will return either detail of the deleted item, or an explanation (failure) as to why this did not succeed.  It is important to always check for any unsuccessful response.

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the CDS Flow Conventions to delete.
    String code = "code_example"; // String | The CDS Flow Conventions to delete.
    try {
      AnnulSingleStructuredDataResponse result = apiInstance.deleteCdsFlowConventions(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#deleteCdsFlowConventions");
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
 **scope** | **String**| The scope of the CDS Flow Conventions to delete. |
 **code** | **String**| The CDS Flow Conventions to delete. |

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

<a name="deleteFlowConventions"></a>
# **deleteFlowConventions**
> AnnulSingleStructuredDataResponse deleteFlowConventions(scope, code)

[EXPERIMENTAL] Delete the Flow Conventions of given scope and code, assuming that it is present.

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Flow Conventions to delete.
    String code = "code_example"; // String | The Flow Conventions to delete.
    try {
      AnnulSingleStructuredDataResponse result = apiInstance.deleteFlowConventions(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#deleteFlowConventions");
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
 **scope** | **String**| The scope of the Flow Conventions to delete. |
 **code** | **String**| The Flow Conventions to delete. |

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

<a name="deleteIndexConvention"></a>
# **deleteIndexConvention**
> AnnulSingleStructuredDataResponse deleteIndexConvention(scope, code)

[EXPERIMENTAL] Delete the Index Convention of given scope and code, assuming that it is present.

Delete the specified Index Convention from a single scope.  The response will return either detail of the deleted item, or an explanation (failure) as to why this did not succeed.  It is important to always check for any unsuccessful response.

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Index Convention to delete.
    String code = "code_example"; // String | The Index Convention to delete.
    try {
      AnnulSingleStructuredDataResponse result = apiInstance.deleteIndexConvention(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#deleteIndexConvention");
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
 **scope** | **String**| The scope of the Index Convention to delete. |
 **code** | **String**| The Index Convention to delete. |

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

<a name="getCdsFlowConventions"></a>
# **getCdsFlowConventions**
> GetConventionsResponse getCdsFlowConventions(scope, code, asAt)

[EXPERIMENTAL] Get CDS Flow Conventions

Get a CDS Flow Conventions from a single scope.  The response will return either the conventions that has been stored, or a failure explaining why the request was unsuccessful.  It is important to always check for any unsuccessful requests (failures).

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the CDS Flow Conventions to retrieve.
    String code = "code_example"; // String | The name of the CDS Flow Conventions to retrieve the data for.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the CDS Flow Conventions. Defaults to return the latest version if not specified.
    try {
      GetConventionsResponse result = apiInstance.getCdsFlowConventions(scope, code, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#getCdsFlowConventions");
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
 **scope** | **String**| The scope of the CDS Flow Conventions to retrieve. |
 **code** | **String**| The name of the CDS Flow Conventions to retrieve the data for. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the CDS Flow Conventions. Defaults to return the latest version if not specified. | [optional]

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
**200** | The successfully retrieved CDS Flow Conventions or any failure |  -  |
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
    defaultClient.setBasePath("http://localhost:59118");
    
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

<a name="getIndexConvention"></a>
# **getIndexConvention**
> GetConventionsResponse getIndexConvention(scope, code, asAt)

[EXPERIMENTAL] Get Index Convention

Get a Index Convention from a single scope.  The response will return either the conventions that has been stored, or a failure explaining why the request was unsuccessful.  It is important to always check for any unsuccessful requests (failures).

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Index Convention to retrieve.
    String code = "code_example"; // String | The name of the Index Convention to retrieve the data for.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the Index Convention. Defaults to return the latest version if not specified.
    try {
      GetConventionsResponse result = apiInstance.getIndexConvention(scope, code, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#getIndexConvention");
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
 **scope** | **String**| The scope of the Index Convention to retrieve. |
 **code** | **String**| The name of the Index Convention to retrieve the data for. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the Index Convention. Defaults to return the latest version if not specified. | [optional]

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
**200** | The successfully retrieved Index Convention or any failure |  -  |
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
    defaultClient.setBasePath("http://localhost:59118");
    
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

<a name="upsertCdsFlowConventions"></a>
# **upsertCdsFlowConventions**
> UpsertSingleStructuredDataResponse upsertCdsFlowConventions(upsertConventionsRequest)

[EXPERIMENTAL] Upsert a set of CDS Flow Conventions. This creates or updates the data in Lusid.

Update or insert CDS Flow Conventions in a single scope. An item will be updated if it already exists  and inserted if it does not.                The response will return the successfully updated or inserted CDS Flow Conventions or failure message if unsuccessful                It is important to always check to verify success (or failure).

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    UpsertConventionsRequest upsertConventionsRequest = {"conventions":{"rollFrequency":"6M","currency":"GBP","paymentFrequency":"1Y","dayCountConvention":"Act360","rollConvention":"F","holidayCalendars":["LON"],"settleDays":2,"resetDays":2,"scope":"someScope","code":"exampleCdsFlowConventionsName"}}; // UpsertConventionsRequest | The CDS Flow Conventions to update or insert
    try {
      UpsertSingleStructuredDataResponse result = apiInstance.upsertCdsFlowConventions(upsertConventionsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#upsertCdsFlowConventions");
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
 **upsertConventionsRequest** | [**UpsertConventionsRequest**](UpsertConventionsRequest.md)| The CDS Flow Conventions to update or insert |

### Return type

[**UpsertSingleStructuredDataResponse**](UpsertSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully updated or inserted item or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertFlowConventions"></a>
# **upsertFlowConventions**
> UpsertSingleStructuredDataResponse upsertFlowConventions(upsertConventionsRequest)

[EXPERIMENTAL] Upsert a set of Flow Conventions. This creates or updates the data in Lusid.

Update or insert Flow Conventions in a single scope. An item will be updated if it already exists  and inserted if it does not.                The response will return the successfully updated or inserted Flow Conventions or failure message if unsuccessful                It is important to always check to verify success (or failure).

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    UpsertConventionsRequest upsertConventionsRequest = {"conventions":{"currency":"GBP","paymentFrequency":"1Y","dayCountConvention":"Act360","rollConvention":"F","holidayCalendars":["LON"],"settleDays":2,"resetDays":2,"scope":"someScope","code":"exampleFlowConventionsName"}}; // UpsertConventionsRequest | The Flow Conventions to update or insert
    try {
      UpsertSingleStructuredDataResponse result = apiInstance.upsertFlowConventions(upsertConventionsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#upsertFlowConventions");
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
 **upsertConventionsRequest** | [**UpsertConventionsRequest**](UpsertConventionsRequest.md)| The Flow Conventions to update or insert |

### Return type

[**UpsertSingleStructuredDataResponse**](UpsertSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully updated or inserted item or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertIndexConvention"></a>
# **upsertIndexConvention**
> UpsertSingleStructuredDataResponse upsertIndexConvention(upsertConventionsRequest)

[EXPERIMENTAL] Upsert a set of Index Convention. This creates or updates the data in Lusid.

Update or insert Index Convention in a single scope. An item will be updated if it already exists  and inserted if it does not.                The response will return the successfully updated or inserted Index Convention or failure message if unsuccessful                It is important to always check to verify success (or failure).

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
    defaultClient.setBasePath("http://localhost:59118");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ConventionsApi apiInstance = new ConventionsApi(defaultClient);
    UpsertConventionsRequest upsertConventionsRequest = {"conventions":{"fixingReference":"Unknown","publicationDayLag":2,"paymentTenor":"1Y","dayCountConvention":"Act360","currency":"GBP","scope":"someScope","code":"exampleIndexonventionsName"}}; // UpsertConventionsRequest | The Index Conventions to update or insert
    try {
      UpsertSingleStructuredDataResponse result = apiInstance.upsertIndexConvention(upsertConventionsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ConventionsApi#upsertIndexConvention");
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
 **upsertConventionsRequest** | [**UpsertConventionsRequest**](UpsertConventionsRequest.md)| The Index Conventions to update or insert |

### Return type

[**UpsertSingleStructuredDataResponse**](UpsertSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully updated or inserted item or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

