# SystemConfigurationApi

All URIs are relative to *http://local-unit-test-server.lusid.com:51792*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createConfigurationTransactionType**](SystemConfigurationApi.md#createConfigurationTransactionType) | **POST** /api/systemconfiguration/transactions/type | [EARLY ACCESS] Create transaction type
[**createSideDefinition**](SystemConfigurationApi.md#createSideDefinition) | **POST** /api/systemconfiguration/transactions/side | [EXPERIMENTAL] Create side definition
[**listConfigurationTransactionTypes**](SystemConfigurationApi.md#listConfigurationTransactionTypes) | **GET** /api/systemconfiguration/transactions | [EARLY ACCESS] List transaction types
[**setConfigurationTransactionTypes**](SystemConfigurationApi.md#setConfigurationTransactionTypes) | **PUT** /api/systemconfiguration/transactions | [EXPERIMENTAL] Set transaction types


<a name="createConfigurationTransactionType"></a>
# **createConfigurationTransactionType**
> TransactionSetConfigurationData createConfigurationTransactionType(transactionConfigurationDataRequest)

[EARLY ACCESS] Create transaction type

Create a new transaction type by specifying a definition and mappings to movements.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SystemConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:51792");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SystemConfigurationApi apiInstance = new SystemConfigurationApi(defaultClient);
    TransactionConfigurationDataRequest transactionConfigurationDataRequest = new TransactionConfigurationDataRequest(); // TransactionConfigurationDataRequest | A transaction type definition.
    try {
      TransactionSetConfigurationData result = apiInstance.createConfigurationTransactionType(transactionConfigurationDataRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SystemConfigurationApi#createConfigurationTransactionType");
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
 **transactionConfigurationDataRequest** | [**TransactionConfigurationDataRequest**](TransactionConfigurationDataRequest.md)| A transaction type definition. | [optional]

### Return type

[**TransactionSetConfigurationData**](TransactionSetConfigurationData.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="createSideDefinition"></a>
# **createSideDefinition**
> TransactionSetConfigurationData createSideDefinition(sideConfigurationDataRequest)

[EXPERIMENTAL] Create side definition

Create a new side definition for use in a transaction type. For more information, see https://support.lusid.com/knowledgebase/article/KA-01875.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SystemConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:51792");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SystemConfigurationApi apiInstance = new SystemConfigurationApi(defaultClient);
    SideConfigurationDataRequest sideConfigurationDataRequest = new SideConfigurationDataRequest(); // SideConfigurationDataRequest | The definition of the side.
    try {
      TransactionSetConfigurationData result = apiInstance.createSideDefinition(sideConfigurationDataRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SystemConfigurationApi#createSideDefinition");
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
 **sideConfigurationDataRequest** | [**SideConfigurationDataRequest**](SideConfigurationDataRequest.md)| The definition of the side. | [optional]

### Return type

[**TransactionSetConfigurationData**](TransactionSetConfigurationData.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Success |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listConfigurationTransactionTypes"></a>
# **listConfigurationTransactionTypes**
> TransactionSetConfigurationData listConfigurationTransactionTypes(asAt)

[EARLY ACCESS] List transaction types

Get the list of current transaction types. For information on the default transaction types provided with  LUSID, see https://support.lusid.com/knowledgebase/article/KA-01873/.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SystemConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:51792");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SystemConfigurationApi apiInstance = new SystemConfigurationApi(defaultClient);
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the transaction types. Defaults              to returning the latest versions if not specified.
    try {
      TransactionSetConfigurationData result = apiInstance.listConfigurationTransactionTypes(asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SystemConfigurationApi#listConfigurationTransactionTypes");
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

### Return type

[**TransactionSetConfigurationData**](TransactionSetConfigurationData.md)

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

<a name="setConfigurationTransactionTypes"></a>
# **setConfigurationTransactionTypes**
> TransactionSetConfigurationData setConfigurationTransactionTypes(transactionSetConfigurationDataRequest)

[EXPERIMENTAL] Set transaction types

Configure all existing transaction types. Note it is not possible to configure a single existing transaction type on its own.                WARNING! Changing existing transaction types has a material impact on how data, new and old, is processed and aggregated by LUSID, and will affect your whole organisation. Only call this API if you are fully aware of the implications of the change.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SystemConfigurationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:51792");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SystemConfigurationApi apiInstance = new SystemConfigurationApi(defaultClient);
    TransactionSetConfigurationDataRequest transactionSetConfigurationDataRequest = new TransactionSetConfigurationDataRequest(); // TransactionSetConfigurationDataRequest | The complete set of transaction type definitions.
    try {
      TransactionSetConfigurationData result = apiInstance.setConfigurationTransactionTypes(transactionSetConfigurationDataRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SystemConfigurationApi#setConfigurationTransactionTypes");
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
 **transactionSetConfigurationDataRequest** | [**TransactionSetConfigurationDataRequest**](TransactionSetConfigurationDataRequest.md)| The complete set of transaction type definitions. | [optional]

### Return type

[**TransactionSetConfigurationData**](TransactionSetConfigurationData.md)

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

