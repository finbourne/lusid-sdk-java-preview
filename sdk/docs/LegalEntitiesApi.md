# LegalEntitiesApi

All URIs are relative to *http://localhost:50501*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteLegalEntity**](LegalEntitiesApi.md#deleteLegalEntity) | **DELETE** /api/legalentities/{idTypeScope}/{idTypeCode}/{code} | [EXPERIMENTAL] Delete legal entity
[**getLegalEntity**](LegalEntitiesApi.md#getLegalEntity) | **GET** /api/legalentities/{idTypeScope}/{idTypeCode}/{code} | [EXPERIMENTAL] Get Legal Entity
[**upsertLegalEntity**](LegalEntitiesApi.md#upsertLegalEntity) | **POST** /api/legalentities | [EXPERIMENTAL] Upsert Legal Entity


<a name="deleteLegalEntity"></a>
# **deleteLegalEntity**
> DeletedEntityResponse deleteLegalEntity(idTypeScope, idTypeCode, code)

[EXPERIMENTAL] Delete legal entity

Delete a legal entity. Deletion will be valid from the legal entity&#39;s creation datetime.  This means that the legal entity will no longer exist at any effective datetime from the asAt datetime of deletion.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.LegalEntitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:50501");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    LegalEntitiesApi apiInstance = new LegalEntitiesApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | The scope of the legal entity identifier type.
    String idTypeCode = "idTypeCode_example"; // String | The code of the legal entity identifier type.
    String code = "code_example"; // String | Code of the legal entity under specified identifier type scope and code. This together with defined              identifier type uniquely identifies the legal entity to delete.
    try {
      DeletedEntityResponse result = apiInstance.deleteLegalEntity(idTypeScope, idTypeCode, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalEntitiesApi#deleteLegalEntity");
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
 **idTypeScope** | **String**| The scope of the legal entity identifier type. |
 **idTypeCode** | **String**| The code of the legal entity identifier type. |
 **code** | **String**| Code of the legal entity under specified identifier type scope and code. This together with defined              identifier type uniquely identifies the legal entity to delete. |

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
**200** | The response from deleting legal entity. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getLegalEntity"></a>
# **getLegalEntity**
> LegalEntity getLegalEntity(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt)

[EXPERIMENTAL] Get Legal Entity

Retrieve the definition of a legal entity.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.LegalEntitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:50501");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    LegalEntitiesApi apiInstance = new LegalEntitiesApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | Scope of the legal entity identifier type.
    String idTypeCode = "idTypeCode_example"; // String | Code of the legal entity identifier type.
    String code = "code_example"; // String | Code of the legal entity under specified scope and code. This together with stated identifier type uniquely              identifies the legal entity.
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the \"LegalEntity\" domain to decorate onto each legal entity.              These take the format {domain}/{scope}/{code} e.g. \"LegalEntity/ContactDetails/Address\". Defaults to include all properties if not specified.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the legal entity. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the legal entity. Defaults to return the latest version of the legal entity if not specified.
    try {
      LegalEntity result = apiInstance.getLegalEntity(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalEntitiesApi#getLegalEntity");
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
 **idTypeScope** | **String**| Scope of the legal entity identifier type. |
 **idTypeCode** | **String**| Code of the legal entity identifier type. |
 **code** | **String**| Code of the legal entity under specified scope and code. This together with stated identifier type uniquely              identifies the legal entity. |
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the \&quot;LegalEntity\&quot; domain to decorate onto each legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. Defaults to include all properties if not specified. | [optional]
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the legal entity. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the legal entity. Defaults to return the latest version of the legal entity if not specified. | [optional]

### Return type

[**LegalEntity**](LegalEntity.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested legal entity definition |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertLegalEntity"></a>
# **upsertLegalEntity**
> LegalEntity upsertLegalEntity(upsertLegalEntityRequest)

[EXPERIMENTAL] Upsert Legal Entity

Create or update new legal entity under specified scope

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.LegalEntitiesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:50501");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    LegalEntitiesApi apiInstance = new LegalEntitiesApi(defaultClient);
    UpsertLegalEntityRequest upsertLegalEntityRequest = {"identifiers":{"legalEntity/ExternalIdentifier/LEI":{"key":"LegalEntity/ExternalIdentifier/LEI","value":{"labelValue":"LEI_12345678"}},"legalEntity/InternalIdentifier/InternalLeiId":{"key":"LegalEntity/InternalIdentifier/InternalLeiId","value":{"labelValue":"Internal_XHSP2038"}}},"properties":{"legalEntity/Details/Name":{"key":"LegalEntity/Details/Name","value":{"labelValue":"Legal Entity Inc."}},"legalEntity/Details/Country":{"key":"LegalEntity/Details/Country","value":{"labelValue":"United Kingdom"},"effectiveFrom":"2016-01-01T00:00:00+00:00"},"legalEntity/Status/Active":{"key":"LegalEntity/Status/Active","value":{"labelValue":"Active"},"effectiveFrom":"2016-07-01T00:00:00+00:00"}}}; // UpsertLegalEntityRequest | Request to create or update a legal entity.
    try {
      LegalEntity result = apiInstance.upsertLegalEntity(upsertLegalEntityRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LegalEntitiesApi#upsertLegalEntity");
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
 **upsertLegalEntityRequest** | [**UpsertLegalEntityRequest**](UpsertLegalEntityRequest.md)| Request to create or update a legal entity. |

### Return type

[**LegalEntity**](LegalEntity.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | The newly created or updated legal entity |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

