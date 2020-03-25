# PersonsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletePerson**](PersonsApi.md#deletePerson) | **DELETE** /api/persons/{idTypeScope}/{idTypeCode}/{code} | [EXPERIMENTAL] Delete person
[**deletePersonAccessMetadata**](PersonsApi.md#deletePersonAccessMetadata) | **DELETE** /api/persons/{idTypeScope}/{idTypeCode}/{code}/metadata/{metadataKey} | [EXPERIMENTAL] Delete a Person Access Metadata entry
[**getAllPersonAccessMetadata**](PersonsApi.md#getAllPersonAccessMetadata) | **GET** /api/persons/{idTypeScope}/{idTypeCode}/{code}/metadata | [EXPERIMENTAL] Get Access Metadata rules for a Person
[**getPerson**](PersonsApi.md#getPerson) | **GET** /api/persons/{idTypeScope}/{idTypeCode}/{code} | [EXPERIMENTAL] Get Person
[**getPersonAccessMetadataByKey**](PersonsApi.md#getPersonAccessMetadataByKey) | **GET** /api/persons/{idTypeScope}/{idTypeCode}/{code}/metadata/{metadataKey} | [EXPERIMENTAL] Get an entry identified by a metadataKey in the Access Metadata of a Person
[**upsertPerson**](PersonsApi.md#upsertPerson) | **POST** /api/persons | [EXPERIMENTAL] Upsert Person
[**upsertPersonAccessMetadata**](PersonsApi.md#upsertPersonAccessMetadata) | **PUT** /api/persons/{idTypeScope}/{idTypeCode}/{code}/metadata/{metadataKey} | [EXPERIMENTAL] Upsert a Person Access Metadata entry associated with a specific metadataKey. This creates or updates the data in LUSID.


<a name="deletePerson"></a>
# **deletePerson**
> DeletedEntityResponse deletePerson(idTypeScope, idTypeCode, code)

[EXPERIMENTAL] Delete person

Delete a person. Deletion will be valid from the person&#39;s creation datetime.  This means that the person will no longer exist at any effective datetime from the asAt datetime of deletion.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PersonsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PersonsApi apiInstance = new PersonsApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | The scope of the person identifier type.
    String idTypeCode = "idTypeCode_example"; // String | The code of the person identifier type.
    String code = "code_example"; // String | Code of the person under specified identifier type scope and code. This together with defined              identifier type uniquely identifies the person to delete.
    try {
      DeletedEntityResponse result = apiInstance.deletePerson(idTypeScope, idTypeCode, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonsApi#deletePerson");
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
 **idTypeScope** | **String**| The scope of the person identifier type. |
 **idTypeCode** | **String**| The code of the person identifier type. |
 **code** | **String**| Code of the person under specified identifier type scope and code. This together with defined              identifier type uniquely identifies the person to delete. |

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
**200** | The response from deleting person. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deletePersonAccessMetadata"></a>
# **deletePersonAccessMetadata**
> DeletedEntityResponse deletePersonAccessMetadata(idTypeScope, idTypeCode, code, metadataKey, effectiveAt)

[EXPERIMENTAL] Delete a Person Access Metadata entry

Deletes the Person Access Metadata entry that exactly matches the provided identifier parts.    It is important to always check to verify success (or failure).

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PersonsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PersonsApi apiInstance = new PersonsApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | Scope of the person identifier.
    String idTypeCode = "idTypeCode_example"; // String | Code of the person identifier.
    String code = "code_example"; // String | Code of the person under specified identifier type's scope and code.
    String metadataKey = "metadataKey_example"; // String | Key of the metadata entry to retrieve
    String effectiveAt = "effectiveAt_example"; // String | The effective date to delete at, if this is not supplied, it will delete all data found
    try {
      DeletedEntityResponse result = apiInstance.deletePersonAccessMetadata(idTypeScope, idTypeCode, code, metadataKey, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonsApi#deletePersonAccessMetadata");
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
 **idTypeScope** | **String**| Scope of the person identifier. |
 **idTypeCode** | **String**| Code of the person identifier. |
 **code** | **String**| Code of the person under specified identifier type&#39;s scope and code. |
 **metadataKey** | **String**| Key of the metadata entry to retrieve |
 **effectiveAt** | **String**| The effective date to delete at, if this is not supplied, it will delete all data found | [optional]

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
**200** | The Access Metadata with the given metadataKey has been deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getAllPersonAccessMetadata"></a>
# **getAllPersonAccessMetadata**
> Map&lt;String, List&lt;AccessMetadataValue&gt;&gt; getAllPersonAccessMetadata(idTypeScope, idTypeCode, code, effectiveAt, asAt)

[EXPERIMENTAL] Get Access Metadata rules for a Person

Pass the Scope and Code of the Person identifier along with the person code parameter to retrieve the associated Access Metadata

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PersonsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PersonsApi apiInstance = new PersonsApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | Scope of the person identifier.
    String idTypeCode = "idTypeCode_example"; // String | Code of the person identifier.
    String code = "code_example"; // String | Code of the person under specified identifier type's scope and code.
    String effectiveAt = "effectiveAt_example"; // String | The effectiveAt datetime at which to retrieve the Access Metadata
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the Access Metadata
    try {
      Map<String, List<AccessMetadataValue>> result = apiInstance.getAllPersonAccessMetadata(idTypeScope, idTypeCode, code, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonsApi#getAllPersonAccessMetadata");
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
 **idTypeScope** | **String**| Scope of the person identifier. |
 **idTypeCode** | **String**| Code of the person identifier. |
 **code** | **String**| Code of the person under specified identifier type&#39;s scope and code. |
 **effectiveAt** | **String**| The effectiveAt datetime at which to retrieve the Access Metadata | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the Access Metadata | [optional]

### Return type

[**Map&lt;String, List&lt;AccessMetadataValue&gt;&gt;**](List.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The access metadata for the Person or any failure. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPerson"></a>
# **getPerson**
> Person getPerson(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt)

[EXPERIMENTAL] Get Person

Retrieve the definition of a person.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PersonsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PersonsApi apiInstance = new PersonsApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | Scope of the person identifier.
    String idTypeCode = "idTypeCode_example"; // String | Code of the person identifier.
    String code = "code_example"; // String | Code of the person under specified scope and code. This together with stated identifier type uniquely              identifies the person.
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the \"Person\" domain to decorate onto each person.              These take the format {domain}/{scope}/{code} e.g. \"Person/ContactDetails/Address\". Defaults to include all properties if not specified.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the person. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the person. Defaults to return the latest version of the person if not specified.
    try {
      Person result = apiInstance.getPerson(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonsApi#getPerson");
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
 **idTypeScope** | **String**| Scope of the person identifier. |
 **idTypeCode** | **String**| Code of the person identifier. |
 **code** | **String**| Code of the person under specified scope and code. This together with stated identifier type uniquely              identifies the person. |
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the \&quot;Person\&quot; domain to decorate onto each person.              These take the format {domain}/{scope}/{code} e.g. \&quot;Person/ContactDetails/Address\&quot;. Defaults to include all properties if not specified. | [optional]
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the person. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the person. Defaults to return the latest version of the person if not specified. | [optional]

### Return type

[**Person**](Person.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested person definition |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPersonAccessMetadataByKey"></a>
# **getPersonAccessMetadataByKey**
> List&lt;AccessMetadataValue&gt; getPersonAccessMetadataByKey(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, asAt)

[EXPERIMENTAL] Get an entry identified by a metadataKey in the Access Metadata of a Person

Get a specific Person Access Metadata by specifying the corresponding identifier parts and Person code                No matching will be performed through this endpoint. To retrieve an entry, it is necessary to specify, exactly, the identifier of the entry

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PersonsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PersonsApi apiInstance = new PersonsApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | Scope of the person identifier.
    String idTypeCode = "idTypeCode_example"; // String | Code of the person identifier.
    String code = "code_example"; // String | Code of the person under specified identifier type's scope and code.
    String metadataKey = "metadataKey_example"; // String | Key of the metadata entry to retrieve
    String effectiveAt = "effectiveAt_example"; // String | The effectiveAt datetime at which to retrieve the Access Metadata
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the Access Metadata
    try {
      List<AccessMetadataValue> result = apiInstance.getPersonAccessMetadataByKey(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonsApi#getPersonAccessMetadataByKey");
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
 **idTypeScope** | **String**| Scope of the person identifier. |
 **idTypeCode** | **String**| Code of the person identifier. |
 **code** | **String**| Code of the person under specified identifier type&#39;s scope and code. |
 **metadataKey** | **String**| Key of the metadata entry to retrieve |
 **effectiveAt** | **String**| The effectiveAt datetime at which to retrieve the Access Metadata | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the Access Metadata | [optional]

### Return type

[**List&lt;AccessMetadataValue&gt;**](AccessMetadataValue.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully retrieved Person access metadata filtered by metadataKey or any failure. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertPerson"></a>
# **upsertPerson**
> Person upsertPerson(request)

[EXPERIMENTAL] Upsert Person

Create or update new person under specified scope

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PersonsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PersonsApi apiInstance = new PersonsApi(defaultClient);
    UpsertPersonRequest request = new UpsertPersonRequest(); // UpsertPersonRequest | Request to create or update a person.
    try {
      Person result = apiInstance.upsertPerson(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonsApi#upsertPerson");
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
 **request** | [**UpsertPersonRequest**](UpsertPersonRequest.md)| Request to create or update a person. | [optional]

### Return type

[**Person**](Person.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | The newly created or updated person |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertPersonAccessMetadata"></a>
# **upsertPersonAccessMetadata**
> ResourceListOfAccessMetadataValueOf upsertPersonAccessMetadata(idTypeScope, idTypeCode, code, metadataKey, request, effectiveAt)

[EXPERIMENTAL] Upsert a Person Access Metadata entry associated with a specific metadataKey. This creates or updates the data in LUSID.

Update or insert one Person Access Metadata entry in a single scope. An item will be updated if it already exists  and inserted if it does not.                The response will return the successfully updated or inserted Person Access Metadata rule or failure message if unsuccessful.                It is important to always check to verify success (or failure).                Multiple rules for a metadataKey can exist with different effective at dates, when resources are accessed the rule that is active for the current time will be fetched.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PersonsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PersonsApi apiInstance = new PersonsApi(defaultClient);
    String idTypeScope = "idTypeScope_example"; // String | Scope of the person identifier.
    String idTypeCode = "idTypeCode_example"; // String | Code of the person identifier.
    String code = "code_example"; // String | Code of the person under specified identifier type's scope and code.
    String metadataKey = "metadataKey_example"; // String | Key of the metadata entry to retrieve
    UpsertPersonAccessMetadataRequest request = new UpsertPersonAccessMetadataRequest(); // UpsertPersonAccessMetadataRequest | The Person Access Metadata entry to upsert
    String effectiveAt = "effectiveAt_example"; // String | The effectiveAt datetime at which to upsert the Access Metadata
    try {
      ResourceListOfAccessMetadataValueOf result = apiInstance.upsertPersonAccessMetadata(idTypeScope, idTypeCode, code, metadataKey, request, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonsApi#upsertPersonAccessMetadata");
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
 **idTypeScope** | **String**| Scope of the person identifier. |
 **idTypeCode** | **String**| Code of the person identifier. |
 **code** | **String**| Code of the person under specified identifier type&#39;s scope and code. |
 **metadataKey** | **String**| Key of the metadata entry to retrieve |
 **request** | [**UpsertPersonAccessMetadataRequest**](UpsertPersonAccessMetadataRequest.md)| The Person Access Metadata entry to upsert |
 **effectiveAt** | **String**| The effectiveAt datetime at which to upsert the Access Metadata | [optional]

### Return type

[**ResourceListOfAccessMetadataValueOf**](ResourceListOfAccessMetadataValueOf.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully updated or inserted item or any failure. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

