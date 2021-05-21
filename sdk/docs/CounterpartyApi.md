# CounterpartyApi

All URIs are relative to *http://local-unit-test-server.lusid.com:54149*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCounterparty**](CounterpartyApi.md#deleteCounterparty) | **DELETE** /api/counterparties/counterparties/counterparty/{scope}/{code} | [EXPERIMENTAL] Delete the Counterparty of given scope and code, assuming that it is present.
[**deleteCreditSupportAnnex**](CounterpartyApi.md#deleteCreditSupportAnnex) | **DELETE** /api/counterparties/counterparties/csa/{scope}/{code} | [EXPERIMENTAL] Delete the CSA of given scope and code, assuming that it is present.
[**getCounterparty**](CounterpartyApi.md#getCounterparty) | **GET** /api/counterparties/counterparties/counterparty/{scope}/{code} | [EXPERIMENTAL] Get Counterparty
[**getCreditSupportAnnex**](CounterpartyApi.md#getCreditSupportAnnex) | **GET** /api/counterparties/counterparties/csa/{scope}/{code} | [EXPERIMENTAL] Get CSA
[**listCounterparties**](CounterpartyApi.md#listCounterparties) | **GET** /api/counterparties/counterparties/counterparty | [EXPERIMENTAL] List the set of Counterparties
[**listCreditSupportAnnexes**](CounterpartyApi.md#listCreditSupportAnnexes) | **GET** /api/counterparties/counterparties/csa | [EXPERIMENTAL] List the set of CSAs
[**upsertCounterparty**](CounterpartyApi.md#upsertCounterparty) | **POST** /api/counterparties/counterparties/counterparty | [EXPERIMENTAL] Upsert Counterparty. This creates or updates the data in Lusid.
[**upsertCreditSupportAnnex**](CounterpartyApi.md#upsertCreditSupportAnnex) | **POST** /api/counterparties/counterparties/csa | [EXPERIMENTAL] Upsert CSA. This creates or updates the data in Lusid.


<a name="deleteCounterparty"></a>
# **deleteCounterparty**
> AnnulSingleStructuredDataResponse deleteCounterparty(scope, code)

[EXPERIMENTAL] Delete the Counterparty of given scope and code, assuming that it is present.

Delete the specified Counterparty from a single scope.  The response will return either detail of the deleted item, or an explanation (failure) as to why this did not succeed.                It is important to always check for any unsuccessful response.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Counterparty to delete.
    String code = "code_example"; // String | The Counterparty to delete.
    try {
      AnnulSingleStructuredDataResponse result = apiInstance.deleteCounterparty(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#deleteCounterparty");
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
 **scope** | **String**| The scope of the Counterparty to delete. |
 **code** | **String**| The Counterparty to delete. |

### Return type

[**AnnulSingleStructuredDataResponse**](AnnulSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The AsAt of deletion or failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deleteCreditSupportAnnex"></a>
# **deleteCreditSupportAnnex**
> AnnulSingleStructuredDataResponse deleteCreditSupportAnnex(scope, code)

[EXPERIMENTAL] Delete the CSA of given scope and code, assuming that it is present.

Delete the specified CSA from a single scope.  The response will return either detail of the deleted item, or an explanation (failure) as to why this did not succeed.                It is important to always check for any unsuccessful response.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the CSA to delete.
    String code = "code_example"; // String | The CSA to delete.
    try {
      AnnulSingleStructuredDataResponse result = apiInstance.deleteCreditSupportAnnex(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#deleteCreditSupportAnnex");
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
 **scope** | **String**| The scope of the CSA to delete. |
 **code** | **String**| The CSA to delete. |

### Return type

[**AnnulSingleStructuredDataResponse**](AnnulSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The AsAt of deletion or failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getCounterparty"></a>
# **getCounterparty**
> GetCounterpartyResponse getCounterparty(scope, code, asAt)

[EXPERIMENTAL] Get Counterparty

Get a Counterparty from a single scope.  The response will return either the counterparty that has been stored, or a failure explaining why the request was unsuccessful.  It is important to always check for any unsuccessful requests (failures).

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Counterparty to retrieve.
    String code = "code_example"; // String | The name of the Counterparty to retrieve the data for.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the counterparty. Defaults to return the latest version if not specified.
    try {
      GetCounterpartyResponse result = apiInstance.getCounterparty(scope, code, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#getCounterparty");
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
 **scope** | **String**| The scope of the Counterparty to retrieve. |
 **code** | **String**| The name of the Counterparty to retrieve the data for. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the counterparty. Defaults to return the latest version if not specified. | [optional]

### Return type

[**GetCounterpartyResponse**](GetCounterpartyResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully retrieved counterparty or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getCreditSupportAnnex"></a>
# **getCreditSupportAnnex**
> GetCreditSupportAnnexResponse getCreditSupportAnnex(scope, code, asAt)

[EXPERIMENTAL] Get CSA

Get a CSA from a single scope.  The response will return either the CSA that has been stored, or a failure explaining why the request was unsuccessful.  It is important to always check for any unsuccessful requests (failures).

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the CSA to retrieve.
    String code = "code_example"; // String | The name of the CSA to retrieve the data for.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the CSA. Defaults to return the latest version if not specified.
    try {
      GetCreditSupportAnnexResponse result = apiInstance.getCreditSupportAnnex(scope, code, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#getCreditSupportAnnex");
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
 **scope** | **String**| The scope of the CSA to retrieve. |
 **code** | **String**| The name of the CSA to retrieve the data for. |
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the CSA. Defaults to return the latest version if not specified. | [optional]

### Return type

[**GetCreditSupportAnnexResponse**](GetCreditSupportAnnexResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully retrieved credit support annexes or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listCounterparties"></a>
# **listCounterparties**
> ResourceListOfGetCounterpartyResponse listCounterparties(asAt)

[EXPERIMENTAL] List the set of Counterparties

List the set of Counterparties at the specified AsAt date/time

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to list the counterparty. Defaults to latest if not specified.
    try {
      ResourceListOfGetCounterpartyResponse result = apiInstance.listCounterparties(asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#listCounterparties");
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
 **asAt** | **OffsetDateTime**| The asAt datetime at which to list the counterparty. Defaults to latest if not specified. | [optional]

### Return type

[**ResourceListOfGetCounterpartyResponse**](ResourceListOfGetCounterpartyResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested counterparties |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listCreditSupportAnnexes"></a>
# **listCreditSupportAnnexes**
> ResourceListOfGetCreditSupportAnnexResponse listCreditSupportAnnexes(asAt)

[EXPERIMENTAL] List the set of CSAs

List the set of CSAs at the specified AsAt date/time

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to list the CSAs. Defaults to latest if not specified.
    try {
      ResourceListOfGetCreditSupportAnnexResponse result = apiInstance.listCreditSupportAnnexes(asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#listCreditSupportAnnexes");
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
 **asAt** | **OffsetDateTime**| The asAt datetime at which to list the CSAs. Defaults to latest if not specified. | [optional]

### Return type

[**ResourceListOfGetCreditSupportAnnexResponse**](ResourceListOfGetCreditSupportAnnexResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested CSAs |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertCounterparty"></a>
# **upsertCounterparty**
> UpsertSingleStructuredDataResponse upsertCounterparty(upsertCounterpartyRequest)

[EXPERIMENTAL] Upsert Counterparty. This creates or updates the data in Lusid.

Update or insert Counterparty in a single scope. An item will be updated if it already exists and inserted if it does not.                The response will return the successfully updated or inserted Counterparty or failure message if unsuccessful                It is important to always check to verify success (or failure).

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    UpsertCounterpartyRequest upsertCounterpartyRequest = {"counterparty":{"counterpartyId":"12345","counterpartyName":"some-bank-of-somewhere","countryOfRisk":"United States","issuerRatings":[{"ratingSource":"S&P","rating":"BB"}],"industryScheme":{"schemeName":"TRCS","schemeId":"5010201010","economicSector":"Energy","businessSector":"Energy - Fossil Fuels","industry":"Oil & Gas","industryActivity":"Integrated Oil & Gas"},"scope":"some-scope","code":"some-code"}}; // UpsertCounterpartyRequest | The Counterparty to update or insert
    try {
      UpsertSingleStructuredDataResponse result = apiInstance.upsertCounterparty(upsertCounterpartyRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#upsertCounterparty");
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
 **upsertCounterpartyRequest** | [**UpsertCounterpartyRequest**](UpsertCounterpartyRequest.md)| The Counterparty to update or insert |

### Return type

[**UpsertSingleStructuredDataResponse**](UpsertSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully updated or inserted item or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertCreditSupportAnnex"></a>
# **upsertCreditSupportAnnex**
> UpsertSingleStructuredDataResponse upsertCreditSupportAnnex(upsertCreditSupportAnnexRequest)

[EXPERIMENTAL] Upsert CSA. This creates or updates the data in Lusid.

Update or insert CSA in a single scope. An item will be updated if it already exists and inserted if it does not.                The response will return the successfully updated or inserted CSA or failure message if unsuccessful                It is important to always check to verify success (or failure).

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CounterpartyApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:54149");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CounterpartyApi apiInstance = new CounterpartyApi(defaultClient);
    UpsertCreditSupportAnnexRequest upsertCreditSupportAnnexRequest = {"creditSupportAnnex":{"referenceCurrency":"GBP","collateralCurrencies":["GBP"],"isdaAgreementVersion":"ISDA2002","marginCallFrequency":"1W","valuationAgent":"Institution","thresholdAmount":0,"roundingDecimalPlaces":2,"initialMarginAmount":100000,"minimumTransferAmount":10000,"scope":"some-scope","code":"some-code"}}; // UpsertCreditSupportAnnexRequest | The CSA to update or insert
    try {
      UpsertSingleStructuredDataResponse result = apiInstance.upsertCreditSupportAnnex(upsertCreditSupportAnnexRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CounterpartyApi#upsertCreditSupportAnnex");
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
 **upsertCreditSupportAnnexRequest** | [**UpsertCreditSupportAnnexRequest**](UpsertCreditSupportAnnexRequest.md)| The CSA to update or insert |

### Return type

[**UpsertSingleStructuredDataResponse**](UpsertSingleStructuredDataResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The successfully updated or inserted item or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

