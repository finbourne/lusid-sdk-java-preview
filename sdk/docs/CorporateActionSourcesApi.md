# CorporateActionSourcesApi

All URIs are relative to *http://local-unit-test-server.lusid.com:30592*

Method | HTTP request | Description
------------- | ------------- | -------------
[**batchUpsertCorporateActions**](CorporateActionSourcesApi.md#batchUpsertCorporateActions) | **POST** /api/corporateactionsources/{scope}/{code}/corporateactions | [BETA] Upsert corporate actions
[**createCorporateActionSource**](CorporateActionSourcesApi.md#createCorporateActionSource) | **POST** /api/corporateactionsources | [BETA] Create Corporate Action Source
[**deleteCorporateActionSource**](CorporateActionSourcesApi.md#deleteCorporateActionSource) | **DELETE** /api/corporateactionsources/{scope}/{code} | [BETA] Delete a corporate action source
[**deleteCorporateActions**](CorporateActionSourcesApi.md#deleteCorporateActions) | **DELETE** /api/corporateactionsources/{scope}/{code}/corporateactions | [EXPERIMENTAL] Delete one or more corporate actions
[**getCorporateActions**](CorporateActionSourcesApi.md#getCorporateActions) | **GET** /api/corporateactionsources/{scope}/{code}/corporateactions | [BETA] Get corporate actions
[**listCorporateActionSources**](CorporateActionSourcesApi.md#listCorporateActionSources) | **GET** /api/corporateactionsources | [BETA] List corporate action sources


<a name="batchUpsertCorporateActions"></a>
# **batchUpsertCorporateActions**
> UpsertCorporateActionsResponse batchUpsertCorporateActions(scope, code, upsertCorporateActionRequest)

[BETA] Upsert corporate actions

Attempt to create/update one or more corporate action in a specified corporate action source. Failed actions will be identified in the body of the response.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CorporateActionSourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:30592");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of corporate action source
    String code = "code_example"; // String | The code of the corporate action source
    List<UpsertCorporateActionRequest> upsertCorporateActionRequest = [{"corporateActionCode":"MyStockSplitId","description":"2-for-1 stock split of instrument BBG001S6PJ31","announcementDate":"2018-03-01T00:00:00.0000000+00:00","exDate":"2018-06-01T00:00:00.0000000+00:00","recordDate":"2018-06-02T00:00:00.0000000+00:00","paymentDate":"2018-08-02T00:00:00.0000000+00:00","transitions":[{"inputTransition":{"instrumentIdentifiers":{"instrument/default/Figi":"BBG001S6PJ31"},"unitsFactor":1,"costFactor":1},"outputTransitions":[{"instrumentIdentifiers":{"instrument/default/Figi":"BBG001S6PJ31"},"unitsFactor":2,"costFactor":1}]}]}]; // List<UpsertCorporateActionRequest> | The corporate action definitions
    try {
      UpsertCorporateActionsResponse result = apiInstance.batchUpsertCorporateActions(scope, code, upsertCorporateActionRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CorporateActionSourcesApi#batchUpsertCorporateActions");
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
 **scope** | **String**| The scope of corporate action source |
 **code** | **String**| The code of the corporate action source |
 **upsertCorporateActionRequest** | [**List&lt;UpsertCorporateActionRequest&gt;**](UpsertCorporateActionRequest.md)| The corporate action definitions | [optional]

### Return type

[**UpsertCorporateActionsResponse**](UpsertCorporateActionsResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | The created corporate actions |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="createCorporateActionSource"></a>
# **createCorporateActionSource**
> CorporateActionSource createCorporateActionSource(createCorporateActionSourceRequest)

[BETA] Create Corporate Action Source

Attempt to create a corporate action source.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CorporateActionSourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:30592");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    CreateCorporateActionSourceRequest createCorporateActionSourceRequest = {"scope":"ExampleScope","code":"ExampleCode","displayName":"ExampleDisplayName","description":"Example Description"}; // CreateCorporateActionSourceRequest | The corporate action source definition
    try {
      CorporateActionSource result = apiInstance.createCorporateActionSource(createCorporateActionSourceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CorporateActionSourcesApi#createCorporateActionSource");
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
 **createCorporateActionSourceRequest** | [**CreateCorporateActionSourceRequest**](CreateCorporateActionSourceRequest.md)| The corporate action source definition |

### Return type

[**CorporateActionSource**](CorporateActionSource.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | The created corporate action source |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deleteCorporateActionSource"></a>
# **deleteCorporateActionSource**
> DeletedEntityResponse deleteCorporateActionSource(scope, code)

[BETA] Delete a corporate action source

Deletes a single corporate action source

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CorporateActionSourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:30592");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The Scope of the Corporate Action Source to be deleted
    String code = "code_example"; // String | The Code of the Corporate Action Source to be deleted
    try {
      DeletedEntityResponse result = apiInstance.deleteCorporateActionSource(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CorporateActionSourcesApi#deleteCorporateActionSource");
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
 **scope** | **String**| The Scope of the Corporate Action Source to be deleted |
 **code** | **String**| The Code of the Corporate Action Source to be deleted |

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
**200** | Corporate Action Source Deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deleteCorporateActions"></a>
# **deleteCorporateActions**
> DeletedEntityResponse deleteCorporateActions(scope, code, corporateActionIds)

[EXPERIMENTAL] Delete one or more corporate actions

Deletes one or more corporate actions from the specified corporate action source

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CorporateActionSourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:30592");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the corporate action source
    String code = "code_example"; // String | The code of the corporate action source
    List<String> corporateActionIds = Arrays.asList(); // List<String> | The ids of the corporate actions to delete
    try {
      DeletedEntityResponse result = apiInstance.deleteCorporateActions(scope, code, corporateActionIds);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CorporateActionSourcesApi#deleteCorporateActions");
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
 **scope** | **String**| The scope of the corporate action source |
 **code** | **String**| The code of the corporate action source |
 **corporateActionIds** | [**List&lt;String&gt;**](String.md)| The ids of the corporate actions to delete |

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
**200** | Corporate Actions Deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getCorporateActions"></a>
# **getCorporateActions**
> ResourceListOfCorporateAction getCorporateActions(scope, code, fromEffectiveAt, toEffectiveAt, asAt, sortBy, limit, filter)

[BETA] Get corporate actions

Gets corporate actions from a specific corporate action source

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CorporateActionSourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:30592");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the corporate action source
    String code = "code_example"; // String | The code of the corporate action source
    String fromEffectiveAt = "fromEffectiveAt_example"; // String | Optional. The start effective date of the data range
    String toEffectiveAt = "toEffectiveAt_example"; // String | Optional. The end effective date of the data range
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | Optional. The AsAt date of the data
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many
    String filter = "filter_example"; // String | Optional. Expression to filter the result set.              For example, to filter on the Announcement Date, use \"announcementDate eq '2020-03-06'\"              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    try {
      ResourceListOfCorporateAction result = apiInstance.getCorporateActions(scope, code, fromEffectiveAt, toEffectiveAt, asAt, sortBy, limit, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CorporateActionSourcesApi#getCorporateActions");
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
 **scope** | **String**| The scope of the corporate action source |
 **code** | **String**| The code of the corporate action source |
 **fromEffectiveAt** | **String**| Optional. The start effective date of the data range | [optional]
 **toEffectiveAt** | **String**| Optional. The end effective date of the data range | [optional]
 **asAt** | **OffsetDateTime**| Optional. The AsAt date of the data | [optional]
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many | [optional]
 **filter** | **String**| Optional. Expression to filter the result set.              For example, to filter on the Announcement Date, use \&quot;announcementDate eq &#39;2020-03-06&#39;\&quot;              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]

### Return type

[**ResourceListOfCorporateAction**](ResourceListOfCorporateAction.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Corporate Actions |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listCorporateActionSources"></a>
# **listCorporateActionSources**
> PagedResourceListOfCorporateActionSource listCorporateActionSources(asAt, sortBy, limit, filter, page)

[BETA] List corporate action sources

Gets a list of all corporate action sources

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CorporateActionSourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:30592");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | Optional. The AsAt date of the data
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer limit = 100; // Integer | Optional. When paginating, limit the number of returned results to this many. If not specified, a default  of 100 is used.
    String filter = "filter_example"; // String | Optional. Expression to filter the result set. For example, to  filter on the Display Name, use \"displayName eq 'string'\"  Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    String page = "page_example"; // String | Optional. The pagination token to use to continue listing items from a previous call. Page values are  return from list calls, and must be supplied exactly as returned. Additionally, when specifying this  value, the filter, asAt, and limit must not  be modified.
    try {
      PagedResourceListOfCorporateActionSource result = apiInstance.listCorporateActionSources(asAt, sortBy, limit, filter, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CorporateActionSourcesApi#listCorporateActionSources");
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
 **limit** | **Integer**| Optional. When paginating, limit the number of returned results to this many. If not specified, a default  of 100 is used. | [optional] [default to 100]
 **filter** | **String**| Optional. Expression to filter the result set. For example, to  filter on the Display Name, use \&quot;displayName eq &#39;string&#39;\&quot;  Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]
 **page** | **String**| Optional. The pagination token to use to continue listing items from a previous call. Page values are  return from list calls, and must be supplied exactly as returned. Additionally, when specifying this  value, the filter, asAt, and limit must not  be modified. | [optional]

### Return type

[**PagedResourceListOfCorporateActionSource**](PagedResourceListOfCorporateActionSource.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | All Existing Corporate Action Sources |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

