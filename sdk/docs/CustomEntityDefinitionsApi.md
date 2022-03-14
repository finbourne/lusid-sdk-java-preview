# CustomEntityDefinitionsApi

All URIs are relative to *http://local-unit-test-server.lusid.com:61362*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomEntityDefinition**](CustomEntityDefinitionsApi.md#createCustomEntityDefinition) | **POST** /api/customentities/entitytypes | [EXPERIMENTAL] CreateCustomEntityDefinition: Define a new custom entityType.
[**getDefinition**](CustomEntityDefinitionsApi.md#getDefinition) | **GET** /api/customentities/entitytypes/{entityType} | [EXPERIMENTAL] GetDefinition: Get a custom entityType definition.


<a name="createCustomEntityDefinition"></a>
# **createCustomEntityDefinition**
> CustomEntityDefinition createCustomEntityDefinition(customEntityDefinitionRequest)

[EXPERIMENTAL] CreateCustomEntityDefinition: Define a new custom entityType.

The API will return a Bad Request if the custom entityType already exists.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:61362");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntityDefinitionsApi apiInstance = new CustomEntityDefinitionsApi(defaultClient);
    CustomEntityDefinitionRequest customEntityDefinitionRequest = new CustomEntityDefinitionRequest(); // CustomEntityDefinitionRequest | The payload containing the description of the custom entityType.
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
 **customEntityDefinitionRequest** | [**CustomEntityDefinitionRequest**](CustomEntityDefinitionRequest.md)| The payload containing the description of the custom entityType. |

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
**200** | The created custom entityType. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getDefinition"></a>
# **getDefinition**
> CustomEntityDefinition getDefinition(entityType, asAt)

[EXPERIMENTAL] GetDefinition: Get a custom entityType definition.

Retrieve a CustomEntityDefinition by a specific EntityType at a point in AsAt time

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:61362");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntityDefinitionsApi apiInstance = new CustomEntityDefinitionsApi(defaultClient);
    String entityType = "entityType_example"; // String | The identifier for the custom entity type, derived from the \"entityTypeName\" provided on creation.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The AsAt datetime at which to retrieve the definition.
    try {
      CustomEntityDefinition result = apiInstance.getDefinition(entityType, asAt);
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
 **entityType** | **String**| The identifier for the custom entity type, derived from the \&quot;entityTypeName\&quot; provided on creation. |
 **asAt** | **OffsetDateTime**| The AsAt datetime at which to retrieve the definition. | [optional]

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
**200** | The requested custom entity definition. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

