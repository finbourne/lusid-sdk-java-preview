# CustomEntityDefinitionsApi

All URIs are relative to *http://local-unit-test-server.lusid.com:54242*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomEntityDefinition**](CustomEntityDefinitionsApi.md#createCustomEntityDefinition) | **POST** /api/customentitydefinitions | [EXPERIMENTAL] Create a new CustomEntityDefinition
[**getDefinition**](CustomEntityDefinitionsApi.md#getDefinition) | **GET** /api/customentitydefinitions/{customEntityId} | [EXPERIMENTAL] Get CustomEntityDefinition


<a name="createCustomEntityDefinition"></a>
# **createCustomEntityDefinition**
> CustomEntityDefinition createCustomEntityDefinition(customEntityDefinitionRequest)

[EXPERIMENTAL] Create a new CustomEntityDefinition

Create a custom entity definition that does not already exist. Will return a Bad Request if the CustomEntityDefinition already exists

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CustomEntityDefinitionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54242");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntityDefinitionsApi apiInstance = new CustomEntityDefinitionsApi(defaultClient);
    CustomEntityDefinitionRequest customEntityDefinitionRequest = new CustomEntityDefinitionRequest(); // CustomEntityDefinitionRequest | The CustomEntityDefinitionRequest
    try {
      CustomEntityDefinition result = apiInstance.createCustomEntityDefinition(customEntityDefinitionRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomEntityDefinitionsApi#createCustomEntityDefinition");
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
 **customEntityDefinitionRequest** | [**CustomEntityDefinitionRequest**](CustomEntityDefinitionRequest.md)| The CustomEntityDefinitionRequest | [optional]

### Return type

[**CustomEntityDefinition**](CustomEntityDefinition.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created custom entity definition |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getDefinition"></a>
# **getDefinition**
> CustomEntityDefinition getDefinition(customEntityId, asAt)

[EXPERIMENTAL] Get CustomEntityDefinition

Retrieve a CustomEntityDefinition by a specific Id at a point in AsAt time

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CustomEntityDefinitionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54242");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntityDefinitionsApi apiInstance = new CustomEntityDefinitionsApi(defaultClient);
    String customEntityId = "customEntityId_example"; // String | Id of the CustomEntityDefinition
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The AsAt at which to retrieve the CustomEntityDefinition
    try {
      CustomEntityDefinition result = apiInstance.getDefinition(customEntityId, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomEntityDefinitionsApi#getDefinition");
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
 **customEntityId** | **String**| Id of the CustomEntityDefinition |
 **asAt** | **OffsetDateTime**| The AsAt at which to retrieve the CustomEntityDefinition | [optional]

### Return type

[**CustomEntityDefinition**](CustomEntityDefinition.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested custom entity definition |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

