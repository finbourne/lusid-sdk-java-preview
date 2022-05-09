# CustomEntitiesApi

All URIs are relative to *http://local-unit-test-server.lusid.com:42748*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCustomEntity**](CustomEntitiesApi.md#deleteCustomEntity) | **DELETE** /api/customentities/{entityType}/{identifierType}/{identifierValue} | [EXPERIMENTAL] DeleteCustomEntity: Delete a Custom Entity instance.
[**getCustomEntity**](CustomEntitiesApi.md#getCustomEntity) | **GET** /api/customentities/{entityType}/{identifierType}/{identifierValue} | [EXPERIMENTAL] GetCustomEntity: Get a Custom Entity instance.
[**getCustomEntityRelationships**](CustomEntitiesApi.md#getCustomEntityRelationships) | **GET** /api/customentities/{entityType}/{identifierType}/{identifierValue}/relationships | [EXPERIMENTAL] GetCustomEntityRelationships: Get Relationships for Custom Entity
[**listCustomEntities**](CustomEntitiesApi.md#listCustomEntities) | **GET** /api/customentities/{entityType} | [EXPERIMENTAL] ListCustomEntities: List Custom Entities of the specified entityType.
[**upsertCustomEntity**](CustomEntitiesApi.md#upsertCustomEntity) | **POST** /api/customentities/{entityType} | [EXPERIMENTAL] UpsertCustomEntity: Upsert a Custom Entity instance


<a name="deleteCustomEntity"></a>
# **deleteCustomEntity**
> DeletedEntityResponse deleteCustomEntity(entityType, identifierType, identifierValue, identifierScope)

[EXPERIMENTAL] DeleteCustomEntity: Delete a Custom Entity instance.

Delete a Custom Entity instance by a specific entity type.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of Custom Entity to remove.
    String identifierType = "identifierType_example"; // String | An identifier type attached to the Custom Entity instance.
    String identifierValue = "identifierValue_example"; // String | The identifier value.
    String identifierScope = "identifierScope_example"; // String | The identifier scope.
    try {
      DeletedEntityResponse result = apiInstance.deleteCustomEntity(entityType, identifierType, identifierValue, identifierScope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomEntitiesApi#deleteCustomEntity");
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
 **entityType** | **String**| The type of Custom Entity to remove. |
 **identifierType** | **String**| An identifier type attached to the Custom Entity instance. |
 **identifierValue** | **String**| The identifier value. |
 **identifierScope** | **String**| The identifier scope. |

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
**200** | Delete a Custom Entity instance. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getCustomEntity"></a>
# **getCustomEntity**
> CustomEntityResponse getCustomEntity(entityType, identifierType, identifierValue, identifierScope, asAt, effectiveAt)

[EXPERIMENTAL] GetCustomEntity: Get a Custom Entity instance.

Retrieve a Custom Entity instance by a specific entity type at a point in AsAt time.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of Custom Entity to retrieve. An entityType can be created using the \"CreateCustomEntityDefinition\" endpoint for CustomEntityDefinitions.
    String identifierType = "identifierType_example"; // String | An identifier type attached to the Custom Entity instance.
    String identifierValue = "identifierValue_example"; // String | The identifier value.
    String identifierScope = "identifierScope_example"; // String | The identifier scope.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The AsAt datetime at which to retrieve the Custom Entity instance.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to get the Custom Entity instance. Defaults to the current LUSID system datetime if not specified.
    try {
      CustomEntityResponse result = apiInstance.getCustomEntity(entityType, identifierType, identifierValue, identifierScope, asAt, effectiveAt);
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
 **entityType** | **String**| The type of Custom Entity to retrieve. An entityType can be created using the \&quot;CreateCustomEntityDefinition\&quot; endpoint for CustomEntityDefinitions. |
 **identifierType** | **String**| An identifier type attached to the Custom Entity instance. |
 **identifierValue** | **String**| The identifier value. |
 **identifierScope** | **String**| The identifier scope. |
 **asAt** | **OffsetDateTime**| The AsAt datetime at which to retrieve the Custom Entity instance. | [optional]
 **effectiveAt** | **String**| The effective datetime or cut label at which to get the Custom Entity instance. Defaults to the current LUSID system datetime if not specified. | [optional]

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
**200** | Get a custom entity instance. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getCustomEntityRelationships"></a>
# **getCustomEntityRelationships**
> ResourceListOfRelationship getCustomEntityRelationships(entityType, identifierScope, identifierType, identifierValue, effectiveAt, asAt, filter, identifierTypes)

[EXPERIMENTAL] GetCustomEntityRelationships: Get Relationships for Custom Entity

Get relationships for the specified Custom Entity.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of entity get relationships for.
    String identifierScope = "identifierScope_example"; // String | The identifier scope.
    String identifierType = "identifierType_example"; // String | An identifier type attached to the Custom Entity.
    String identifierValue = "identifierValue_example"; // String | The identifier value.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to get relationships. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified.
    String filter = "filter_example"; // String | Expression to filter relationships. Users should provide null or empty string for this field until further notice.
    List<String> identifierTypes = Arrays.asList(); // List<String> | Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \"Person/CompanyDetails/Role\". They must be from the \"Person\" or \"LegalEntity\" domain.              Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array.
    try {
      ResourceListOfRelationship result = apiInstance.getCustomEntityRelationships(entityType, identifierScope, identifierType, identifierValue, effectiveAt, asAt, filter, identifierTypes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomEntitiesApi#getCustomEntityRelationships");
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
 **entityType** | **String**| The type of entity get relationships for. |
 **identifierScope** | **String**| The identifier scope. |
 **identifierType** | **String**| An identifier type attached to the Custom Entity. |
 **identifierValue** | **String**| The identifier value. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to get relationships. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified. | [optional]
 **filter** | **String**| Expression to filter relationships. Users should provide null or empty string for this field until further notice. | [optional]
 **identifierTypes** | [**List&lt;String&gt;**](String.md)| Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array. | [optional]

### Return type

[**ResourceListOfRelationship**](ResourceListOfRelationship.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The relationships for the specified custom entity. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listCustomEntities"></a>
# **listCustomEntities**
> PagedResourceListOfCustomEntityResponse listCustomEntities(entityType, effectiveAt, asAt, limit, filter, page)

[EXPERIMENTAL] ListCustomEntities: List Custom Entities of the specified entityType.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of Custom Entity to list.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to list the entities. Defaults to the current LUSID              system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to list the entities. Defaults to returning the latest version              of each portfolio if not specified.
    Integer limit = 56; // Integer | When paginating, limit the results to this number. Defaults to 100 if not specified.
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
 **entityType** | **String**| The type of Custom Entity to list. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to list the entities. Defaults to the current LUSID              system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to list the entities. Defaults to returning the latest version              of each portfolio if not specified. | [optional]
 **limit** | **Integer**| When paginating, limit the results to this number. Defaults to 100 if not specified. | [optional]
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
**200** | List custom entities of the specified entityType. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertCustomEntity"></a>
# **upsertCustomEntity**
> CustomEntityResponse upsertCustomEntity(entityType, customEntityRequest)

[EXPERIMENTAL] UpsertCustomEntity: Upsert a Custom Entity instance

Insert the Custom Entity if it does not exist or update the Custom Entity with the supplied state if it does exist.

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:42748");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CustomEntitiesApi apiInstance = new CustomEntitiesApi(defaultClient);
    String entityType = "entityType_example"; // String | The type of the Custom Entity to be created. An entityType can be created using the \"CreateCustomEntityDefinition\" endpoint for CustomEntityDefinitions.
    CustomEntityRequest customEntityRequest = new CustomEntityRequest(); // CustomEntityRequest | The payload describing the Custom Entity instance.
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
 **entityType** | **String**| The type of the Custom Entity to be created. An entityType can be created using the \&quot;CreateCustomEntityDefinition\&quot; endpoint for CustomEntityDefinitions. |
 **customEntityRequest** | [**CustomEntityRequest**](CustomEntityRequest.md)| The payload describing the Custom Entity instance. |

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
**200** | The upserted custom entity instance |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

