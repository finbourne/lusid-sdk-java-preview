# AllocationServiceApi

All URIs are relative to *https://www.lusid.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**runAllocationService**](AllocationServiceApi.md#runAllocationService) | **POST** /api/allocationservice/allocate | [EXPERIMENTAL] RunAllocationService: Runs the Allocation Service


<a name="runAllocationService"></a>
# **runAllocationService**
> AllocationServiceRunResult runAllocationService(resourceId, allocationAlgorithm)

[EXPERIMENTAL] RunAllocationService: Runs the Allocation Service

This will allocate executions for a given list of placements back to their originating orders.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AllocationServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AllocationServiceApi apiInstance = new AllocationServiceApi(defaultClient);
    List<ResourceId> resourceId = Arrays.asList(); // List<ResourceId> | The List of Placement IDs for which you wish to allocate executions.
    String allocationAlgorithm = "allocationAlgorithm_example"; // String | A string representation of the allocation algorithm you would like to use to allocate shares from executions e.g. \"PR-FIFO\".  This defaults to \"PR-FIFO\".
    try {
      AllocationServiceRunResult result = apiInstance.runAllocationService(resourceId, allocationAlgorithm);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllocationServiceApi#runAllocationService");
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
 **resourceId** | [**List&lt;ResourceId&gt;**](ResourceId.md)| The List of Placement IDs for which you wish to allocate executions. |
 **allocationAlgorithm** | **String**| A string representation of the allocation algorithm you would like to use to allocate shares from executions e.g. \&quot;PR-FIFO\&quot;.  This defaults to \&quot;PR-FIFO\&quot;. | [optional]

### Return type

[**AllocationServiceRunResult**](AllocationServiceRunResult.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The results from a run of the Allocation Service |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

