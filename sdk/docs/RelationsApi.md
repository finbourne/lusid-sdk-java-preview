# RelationsApi

All URIs are relative to *http://localhost:57275*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRelation**](RelationsApi.md#createRelation) | **POST** /api/relations/{scope}/{code} | [EXPERIMENTAL] Create Relation


<a name="createRelation"></a>
# **createRelation**
> CompleteRelation createRelation(scope, code, createRelationRequest, effectiveAt)

[EXPERIMENTAL] Create Relation

Create a relation between two entity objects by their identifiers

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.RelationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:57275");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    RelationsApi apiInstance = new RelationsApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the relation to create.
    String code = "code_example"; // String | Code of the relation to create.
    CreateRelationRequest createRelationRequest = {"sourceEntityId":{"idTypeScope":"HrSystem1","idTypeCode":"InternalId","code":"XY10001111"},"targetEntityId":{"idTypeScope":"HrSystem1","idTypeCode":"InternalId","code":"XY10001111"}}; // CreateRelationRequest | The details of the relation to create.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which the relation should be effective from. Defaults to the current LUSID system datetime if not specified.
    try {
      CompleteRelation result = apiInstance.createRelation(scope, code, createRelationRequest, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RelationsApi#createRelation");
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
 **scope** | **String**| Scope of the relation to create. |
 **code** | **String**| Code of the relation to create. |
 **createRelationRequest** | [**CreateRelationRequest**](CreateRelationRequest.md)| The details of the relation to create. |
 **effectiveAt** | **String**| The effective datetime or cut label at which the relation should be effective from. Defaults to the current LUSID system datetime if not specified. | [optional]

### Return type

[**CompleteRelation**](CompleteRelation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The newly created relation. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

