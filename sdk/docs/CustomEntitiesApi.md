# CustomEntitiesApi

All URIs are relative to *https://fbn-prd.lusid.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCustomEntity**](CustomEntitiesApi.md#getCustomEntity) | **GET** /api/customentities/{entityType}/{identifierType}/{identifierValue} | [EXPERIMENTAL] Get CustomEntity
[**upsertCustomEntity**](CustomEntitiesApi.md#upsertCustomEntity) | **POST** /api/customentities/{entityType} | [EXPERIMENTAL] Upsert a new CustomEntity


<a name="getCustomEntity"></a>
# **getCustomEntity**
> CustomEntityResponse getCustomEntity(entityType, identifierType, identifierValue, identifierScope, asAt)

[EXPERIMENTAL] Get CustomEntity

Retrieve a CustomEntity by a specific Id at a point in AsAt time

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CustomEntitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of entity to retrieve
    String identifierType = "identifierType_example"; // String | An identifier type attached to the CustomEntity
    String identifierValue = "identifierValue_example"; // String | The identifier value
    String identifierScope = "identifierScope_example"; // String | The identifier scope
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The AsAt at which to retrieve the CustomEntity
    try {
      CustomEntityResponse result = apiInstance.getCustomEntity(entityType, identifierType, identifierValue, identifierScope, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomEntitiesApi#getCustomEntity");
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
 **entityType** | **String**| The type of entity to retrieve |
 **identifierType** | **String**| An identifier type attached to the CustomEntity |
 **identifierValue** | **String**| The identifier value |
 **identifierScope** | **String**| The identifier scope |
 **asAt** | **OffsetDateTime**| The AsAt at which to retrieve the CustomEntity | [optional]

### Return type

[**CustomEntityResponse**](CustomEntityResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested Custom Entity |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertCustomEntity"></a>
# **upsertCustomEntity**
> CustomEntityResponse upsertCustomEntity(entityType, customEntityRequest)

[EXPERIMENTAL] Upsert a new CustomEntity

Insert the custom entity if it does not exist or update the custom entity with the supplied state if it does exist.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CustomEntitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of the CustomEntity to be created. An entityType can be created using the M:Finbourne.WebApi.Controllers.CustomEntityDefinitionController.GetDefinition(System.String,System.Nullable{System.DateTimeOffset}) endpoint.
    CustomEntityRequest customEntityRequest = new CustomEntityRequest(); // CustomEntityRequest | The CustomEntity to be created
    try {
      CustomEntityResponse result = apiInstance.upsertCustomEntity(entityType, customEntityRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomEntitiesApi#upsertCustomEntity");
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
 **entityType** | **String**| The type of the CustomEntity to be created. An entityType can be created using the M:Finbourne.WebApi.Controllers.CustomEntityDefinitionController.GetDefinition(System.String,System.Nullable{System.DateTimeOffset}) endpoint. |
 **customEntityRequest** | [**CustomEntityRequest**](CustomEntityRequest.md)| The CustomEntity to be created |

### Return type

[**CustomEntityResponse**](CustomEntityResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The upserted Custom Entity |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

