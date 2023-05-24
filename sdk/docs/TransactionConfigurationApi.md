# TransactionConfigurationApi

All URIs are relative to *https://www.lusid.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteTransactionType**](TransactionConfigurationApi.md#deleteTransactionType) | **DELETE** /api/transactionconfiguration/types/{source}/{type} | [EXPERIMENTAL] DeleteTransactionType: Delete a transaction type
[**getTransactionType**](TransactionConfigurationApi.md#getTransactionType) | **GET** /api/transactionconfiguration/types/{source}/{type} | [EXPERIMENTAL] GetTransactionType: Get a single transaction configuration type
[**listTransactionTypes**](TransactionConfigurationApi.md#listTransactionTypes) | **GET** /api/transactionconfiguration/types | [EXPERIMENTAL] ListTransactionTypes: List transaction types
[**setSideDefinition**](TransactionConfigurationApi.md#setSideDefinition) | **PUT** /api/transactionconfiguration/sides/{side} | [EXPERIMENTAL] SetSideDefinition: Set a side definition
[**setTransactionType**](TransactionConfigurationApi.md#setTransactionType) | **PUT** /api/transactionconfiguration/types/{source}/{type} | [EXPERIMENTAL] SetTransactionType: Set a specific transaction type


<a name="deleteTransactionType"></a>
# **deleteTransactionType**
> DeletedEntityResponse deleteTransactionType(source, type, scope)

[EXPERIMENTAL] DeleteTransactionType: Delete a transaction type

/// WARNING! Changing existing transaction types has a material impact on how data, new and old,  is processed and aggregated by LUSID, and will affect your whole organisation. Only call this API if you are fully aware of the implications of the change.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.TransactionConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    TransactionConfigurationApi apiInstance = new TransactionConfigurationApi(defaultClient);
    String source = "source_example"; // String | The source that the type is in
    String type = "type_example"; // String | One of the type's aliases
    String scope = "default"; // String | The scope in which the transaction types exists. When not supplied the scope is 'default'.
    try {
      DeletedEntityResponse result = apiInstance.deleteTransactionType(source, type, scope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionConfigurationApi#deleteTransactionType");
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
 **source** | **String**| The source that the type is in |
 **type** | **String**| One of the type&#39;s aliases |
 **scope** | **String**| The scope in which the transaction types exists. When not supplied the scope is &#39;default&#39;. | [optional] [default to default]

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
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getTransactionType"></a>
# **getTransactionType**
> TransactionType getTransactionType(source, type, asAt, scope)

[EXPERIMENTAL] GetTransactionType: Get a single transaction configuration type

Get a single transaction type. Returns failure if not found

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.TransactionConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    TransactionConfigurationApi apiInstance = new TransactionConfigurationApi(defaultClient);
    String source = "source_example"; // String | The source that the type is in
    String type = "type_example"; // String | One of the type's aliases
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the transaction configuration.              Defaults to returning the latest version of the transaction configuration type if not specified
    String scope = "default"; // String | The scope in which the transaction types exists. When not supplied the scope is 'default'.
    try {
      TransactionType result = apiInstance.getTransactionType(source, type, asAt, scope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionConfigurationApi#getTransactionType");
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
 **source** | **String**| The source that the type is in |
 **type** | **String**| One of the type&#39;s aliases |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the transaction configuration.              Defaults to returning the latest version of the transaction configuration type if not specified | [optional]
 **scope** | **String**| The scope in which the transaction types exists. When not supplied the scope is &#39;default&#39;. | [optional] [default to default]

### Return type

[**TransactionType**](TransactionType.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listTransactionTypes"></a>
# **listTransactionTypes**
> Map&lt;String, List&lt;TransactionType&gt;&gt; listTransactionTypes(asAt, scope)

[EXPERIMENTAL] ListTransactionTypes: List transaction types

Get the list of current transaction types. For information on the default transaction types provided with  LUSID, see https://support.lusid.com/knowledgebase/article/KA-01873/.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.TransactionConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    TransactionConfigurationApi apiInstance = new TransactionConfigurationApi(defaultClient);
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the transaction types. Defaults              to returning the latest versions if not specified.
    String scope = "default"; // String | The scope in which the side exists. When not supplied the scope is 'default'.
    try {
      Map<String, List<TransactionType>> result = apiInstance.listTransactionTypes(asAt, scope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionConfigurationApi#listTransactionTypes");
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
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the transaction types. Defaults              to returning the latest versions if not specified. | [optional]
 **scope** | **String**| The scope in which the side exists. When not supplied the scope is &#39;default&#39;. | [optional] [default to default]

### Return type

[**Map&lt;String, List&lt;TransactionType&gt;&gt;**](List.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="setSideDefinition"></a>
# **setSideDefinition**
> SideDefinition setSideDefinition(side, sideDefinitionRequest, scope)

[EXPERIMENTAL] SetSideDefinition: Set a side definition

Set a new side definition for use in a transaction type. For more information, see https://support.lusid.com/knowledgebase/article/KA-01875.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.TransactionConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    TransactionConfigurationApi apiInstance = new TransactionConfigurationApi(defaultClient);
    String side = "side_example"; // String | The label to uniquely identify the side.
    SideDefinitionRequest sideDefinitionRequest = new SideDefinitionRequest(); // SideDefinitionRequest | The side definition to create or replace.
    String scope = "default"; // String | The scope in which the side exists. When not supplied the scope is 'default'.
    try {
      SideDefinition result = apiInstance.setSideDefinition(side, sideDefinitionRequest, scope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionConfigurationApi#setSideDefinition");
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
 **side** | **String**| The label to uniquely identify the side. |
 **sideDefinitionRequest** | [**SideDefinitionRequest**](SideDefinitionRequest.md)| The side definition to create or replace. |
 **scope** | **String**| The scope in which the side exists. When not supplied the scope is &#39;default&#39;. | [optional] [default to default]

### Return type

[**SideDefinition**](SideDefinition.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="setTransactionType"></a>
# **setTransactionType**
> TransactionType setTransactionType(source, type, transactionTypeRequest, scope)

[EXPERIMENTAL] SetTransactionType: Set a specific transaction type

Set a transaction type for the given source and type. If the requested transaction type does not exist, it will be created    WARNING! Changing existing transaction types has a material impact on how data, new and old, is processed and aggregated by LUSID, and will affect your whole organisation. Only call this API if you are fully aware of the implications of the change.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.TransactionConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    TransactionConfigurationApi apiInstance = new TransactionConfigurationApi(defaultClient);
    String source = "source_example"; // String | The source to set the transaction configuration for
    String type = "type_example"; // String | One of the transaction configuration alias types to uniquely identify the configuration
    TransactionTypeRequest transactionTypeRequest = new TransactionTypeRequest(); // TransactionTypeRequest | The transaction configuration to set
    String scope = "default"; // String | The scope in which the transaction types exists. When not supplied the scope is 'default'.
    try {
      TransactionType result = apiInstance.setTransactionType(source, type, transactionTypeRequest, scope);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TransactionConfigurationApi#setTransactionType");
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
 **source** | **String**| The source to set the transaction configuration for |
 **type** | **String**| One of the transaction configuration alias types to uniquely identify the configuration |
 **transactionTypeRequest** | [**TransactionTypeRequest**](TransactionTypeRequest.md)| The transaction configuration to set |
 **scope** | **String**| The scope in which the transaction types exists. When not supplied the scope is &#39;default&#39;. | [optional] [default to default]

### Return type

[**TransactionType**](TransactionType.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

