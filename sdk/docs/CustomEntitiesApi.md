# CustomEntitiesApi

All URIs are relative to *http://local-unit-test-server.lusid.com:40490*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCustomEntity**](CustomEntitiesApi.md#getCustomEntity) | **GET** /api/customentities/{entityType}/{identifierType}/{identifierValue} | [EXPERIMENTAL] Get CustomEntity
[**listCustomEntities**](CustomEntitiesApi.md#listCustomEntities) | **GET** /api/customentities/{entityType} | [EXPERIMENTAL] List Custom Entities
[**upsertCustomEntity**](CustomEntitiesApi.md#upsertCustomEntity) | **POST** /api/customentities/{entityType} | [EXPERIMENTAL] Upsert a new CustomEntity


<a name="getCustomEntity"></a>
# **getCustomEntity**
> CustomEntityResponse getCustomEntity(entityType, identifierType, identifierValue, identifierScope, asAt)

[EXPERIMENTAL] Get CustomEntity

Retrieve a CustomEntity by a specific Id at a point in AsAt time.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:40490");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of entity to retrieve. This is included in the response from M:Finbourne.WebApi.Controllers.CustomEntityDefinitionController.CreateCustomEntityDefinition(Finbourne.WebApi.Interface.Dto.CustomEntityDefinitions.CustomEntityDefinitionRequest).
    String identifierType = "identifierType_example"; // String | An identifier type attached to the CustomEntity.
    String identifierValue = "identifierValue_example"; // String | The identifier value.
    String identifierScope = "identifierScope_example"; // String | The identifier scope.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The AsAt at which to retrieve the CustomEntity.
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
 **entityType** | **String**| The type of entity to retrieve. This is included in the response from M:Finbourne.WebApi.Controllers.CustomEntityDefinitionController.CreateCustomEntityDefinition(Finbourne.WebApi.Interface.Dto.CustomEntityDefinitions.CustomEntityDefinitionRequest). |
 **identifierType** | **String**| An identifier type attached to the CustomEntity. |
 **identifierValue** | **String**| The identifier value. |
 **identifierScope** | **String**| The identifier scope. |
 **asAt** | **OffsetDateTime**| The AsAt at which to retrieve the CustomEntity. | [optional]

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

<a name="listCustomEntities"></a>
# **listCustomEntities**
> PagedResourceListOfCustomEntityResponse listCustomEntities(entityType, effectiveAt, asAt, limit, filter, page)

[EXPERIMENTAL] List Custom Entities

List all the Custom Entities matching particular criteria.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:40490");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of entity to list.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to list the entities. Defaults to the current LUSID              system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to list the entities. Defaults to returning the latest version              of each portfolio if not specified.
    Integer limit = 56; // Integer | When paginating, limit the results to this number. Defaults to 65,535 if not specified.
    String filter = "filter_example"; // String | Expression to filter the results. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914.
    String page = "page_example"; // String | The pagination token to use to continue listing entities; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request.
    try {
      PagedResourceListOfCustomEntityResponse result = apiInstance.listCustomEntities(entityType, effectiveAt, asAt, limit, filter, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomEntitiesApi#listCustomEntities");
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
 **entityType** | **String**| The type of entity to list. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to list the entities. Defaults to the current LUSID              system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to list the entities. Defaults to returning the latest version              of each portfolio if not specified. | [optional]
 **limit** | **Integer**| When paginating, limit the results to this number. Defaults to 65,535 if not specified. | [optional]
 **filter** | **String**| Expression to filter the results. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. | [optional]
 **page** | **String**| The pagination token to use to continue listing entities; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. | [optional]

### Return type

[**PagedResourceListOfCustomEntityResponse**](PagedResourceListOfCustomEntityResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested custom entities |  -  |
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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:40490");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of the CustomEntity to be created. An entityType can be created using the M:Finbourne.WebApi.Controllers.CustomEntityDefinitionController.GetDefinition(System.String,System.Nullable{System.DateTimeOffset}) endpoint.
    CustomEntityRequest customEntityRequest = new CustomEntityRequest(); // CustomEntityRequest | The CustomEntity to be created.
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
 **customEntityRequest** | [**CustomEntityRequest**](CustomEntityRequest.md)| The CustomEntity to be created. |

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

