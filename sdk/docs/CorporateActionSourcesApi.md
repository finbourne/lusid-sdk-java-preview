# CorporateActionSourcesApi

All URIs are relative to *http://local-unit-test-server.lusid.com:53397*

Method | HTTP request | Description
------------- | ------------- | -------------
[**batchUpsertCorporateActions**](CorporateActionSourcesApi.md#batchUpsertCorporateActions) | **POST** /api/corporateactionsources/{scope}/{code}/corporateactions | [BETA] Upsert corporate actions
[**createCorporateActionSource**](CorporateActionSourcesApi.md#createCorporateActionSource) | **POST** /api/corporateactionsources | [BETA] Create corporate action source
[**deleteCorporateActionSource**](CorporateActionSourcesApi.md#deleteCorporateActionSource) | **DELETE** /api/corporateactionsources/{scope}/{code} | [BETA] Delete a corporate action source
[**deleteCorporateActions**](CorporateActionSourcesApi.md#deleteCorporateActions) | **DELETE** /api/corporateactionsources/{scope}/{code}/corporateactions | [EXPERIMENTAL] Delete corporate actions
[**getCorporateActions**](CorporateActionSourcesApi.md#getCorporateActions) | **GET** /api/corporateactionsources/{scope}/{code}/corporateactions | [BETA] Get corporate actions
[**listCorporateActionSources**](CorporateActionSourcesApi.md#listCorporateActionSources) | **GET** /api/corporateactionsources | [BETA] List corporate action sources


<a name="batchUpsertCorporateActions"></a>
# **batchUpsertCorporateActions**
> UpsertCorporateActionsResponse batchUpsertCorporateActions(scope, code, upsertCorporateActionRequest)

[BETA] Upsert corporate actions

Create or update one or more corporate actions in a particular corporate action source. Failures are identified in the body of the response.                If a corporate action is upserted at exactly the same effective datetime as a transaction for the same instrument, the corporate action takes precedence. Depending on the nature of the corporate action, this may mean it affects the transaction.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:53397");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of corporate action source
    String code = "code_example"; // String | The code of the corporate action source
    List<UpsertCorporateActionRequest> upsertCorporateActionRequest = Arrays.asList(); // List<UpsertCorporateActionRequest> | The corporate action definitions
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

[BETA] Create corporate action source

Create a corporate action source.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:53397");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    CreateCorporateActionSourceRequest createCorporateActionSourceRequest = new CreateCorporateActionSourceRequest(); // CreateCorporateActionSourceRequest | The corporate action source definition
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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:53397");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the corporate action source to be deleted
    String code = "code_example"; // String | The code of the corporate action source to be deleted
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
 **scope** | **String**| The scope of the corporate action source to be deleted |
 **code** | **String**| The code of the corporate action source to be deleted |

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

[EXPERIMENTAL] Delete corporate actions

Delete one or more corporate actions from a particular corporate action source.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:53397");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the corporate action source
    String code = "code_example"; // String | The code of the corporate action source
    List<String> corporateActionIds = Arrays.asList(); // List<String> | The IDs of the corporate actions to delete
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
 **corporateActionIds** | [**List&lt;String&gt;**](String.md)| The IDs of the corporate actions to delete |

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

Get corporate actions from a particular corporate action source.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:53397");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the corporate action source.
    String code = "code_example"; // String | The code of the corporate action source.
    String fromEffectiveAt = "fromEffectiveAt_example"; // String | Optional. The start effective date of the data range.
    String toEffectiveAt = "toEffectiveAt_example"; // String | Optional. The end effective date of the data range.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | Optional. The AsAt date of the data.
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer limit = 56; // Integer | Optional. When paginating, limit the results to this number.
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
 **scope** | **String**| The scope of the corporate action source. |
 **code** | **String**| The code of the corporate action source. |
 **fromEffectiveAt** | **String**| Optional. The start effective date of the data range. | [optional]
 **toEffectiveAt** | **String**| Optional. The end effective date of the data range. | [optional]
 **asAt** | **OffsetDateTime**| Optional. The AsAt date of the data. | [optional]
 **sortBy** | [**List&lt;String&gt;**](String.md)| Optional. Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName | [optional]
 **limit** | **Integer**| Optional. When paginating, limit the results to this number. | [optional]
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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:53397");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CorporateActionSourcesApi apiInstance = new CorporateActionSourcesApi(defaultClient);
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | Optional. The AsAt date of the data
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

