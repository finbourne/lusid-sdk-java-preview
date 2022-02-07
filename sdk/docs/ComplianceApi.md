# ComplianceApi

All URIs are relative to *http://local-unit-test-server.lusid.com:42875*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getComplianceRun**](ComplianceApi.md#getComplianceRun) | **GET** /api/compliance/{runId} | [EXPERIMENTAL] GetComplianceRun: Get the details of a single compliance run.
[**listComplianceRuns**](ComplianceApi.md#listComplianceRuns) | **GET** /api/compliance | [EXPERIMENTAL] ListComplianceRuns: List historical compliance runs.
[**runComplianceCheck**](ComplianceApi.md#runComplianceCheck) | **POST** /api/compliance/run | [EXPERIMENTAL] RunComplianceCheck: Kick off the compliance check process


<a name="getComplianceRun"></a>
# **getComplianceRun**
> PagedResourceListOfComplianceRuleResult getComplianceRun(runId, page, limit, filter)

[EXPERIMENTAL] GetComplianceRun: Get the details of a single compliance run.

Use this endpoint to fetch the detail associated with a specific compliance run, including a breakdown  of the passing state of each rule, portfolio combination.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.ComplianceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42875");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ComplianceApi apiInstance = new ComplianceApi(defaultClient);
    String runId = "runId_example"; // String | The unique identifier of the compliance run requested.
    String page = "page_example"; // String | The pagination token to use to continue listing compliance rule results from a previous call to list compliance rule result.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    try {
      PagedResourceListOfComplianceRuleResult result = apiInstance.getComplianceRun(runId, page, limit, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ComplianceApi#getComplianceRun");
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
 **runId** | **String**| The unique identifier of the compliance run requested. |
 **page** | **String**| The pagination token to use to continue listing compliance rule results from a previous call to list compliance rule result.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. | [optional]
 **filter** | **String**| Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]

### Return type

[**PagedResourceListOfComplianceRuleResult**](PagedResourceListOfComplianceRuleResult.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The details of a specific compliance run |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listComplianceRuns"></a>
# **listComplianceRuns**
> PagedResourceListOfComplianceRun listComplianceRuns(page, limit, filter)

[EXPERIMENTAL] ListComplianceRuns: List historical compliance runs.

Use this endpoint to fetch a list of all historical compliance runs.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.ComplianceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42875");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ComplianceApi apiInstance = new ComplianceApi(defaultClient);
    String page = "page_example"; // String | The pagination token to use to continue listing compliance runs from a previous call to list compliance runs.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    try {
      PagedResourceListOfComplianceRun result = apiInstance.listComplianceRuns(page, limit, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ComplianceApi#listComplianceRuns");
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
 **page** | **String**| The pagination token to use to continue listing compliance runs from a previous call to list compliance runs.              This value is returned from the previous call. If a pagination token is provided the sortBy, filter, and asAt fields              must not have changed since the original request. Also, if set, a start value cannot be provided. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. | [optional]
 **filter** | **String**| Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]

### Return type

[**PagedResourceListOfComplianceRun**](PagedResourceListOfComplianceRun.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The List of all compliance runs completed |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="runComplianceCheck"></a>
# **runComplianceCheck**
> ComplianceRun runComplianceCheck(fileName)

[EXPERIMENTAL] RunComplianceCheck: Kick off the compliance check process

Use this endpoint to fetch the start a compliance run, based on a pre-set mapping file.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.ComplianceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42875");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    ComplianceApi apiInstance = new ComplianceApi(defaultClient);
    String fileName = "fileName_example"; // String | The name of compliance mappings file to use. Has to exist in drive ComplianceRules folder
    try {
      ComplianceRun result = apiInstance.runComplianceCheck(fileName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ComplianceApi#runComplianceCheck");
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
 **fileName** | **String**| The name of compliance mappings file to use. Has to exist in drive ComplianceRules folder |

### Return type

[**ComplianceRun**](ComplianceRun.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The identifying information of a compliance run |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

