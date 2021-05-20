# PortfoliosApi

All URIs are relative to *https://fbn-prd.lusid.com/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteKeyFromPortfolioAccessMetadata**](PortfoliosApi.md#deleteKeyFromPortfolioAccessMetadata) | **DELETE** /api/portfolios/{scope}/{code}/metadata/{metadataKey} | [EXPERIMENTAL] Delete a Portfolio Access Metadata Rule
[**deletePortfolio**](PortfoliosApi.md#deletePortfolio) | **DELETE** /api/portfolios/{scope}/{code} | Delete portfolio
[**deletePortfolioProperties**](PortfoliosApi.md#deletePortfolioProperties) | **DELETE** /api/portfolios/{scope}/{code}/properties | Delete portfolio properties
[**getPortfolio**](PortfoliosApi.md#getPortfolio) | **GET** /api/portfolios/{scope}/{code} | Get portfolio
[**getPortfolioAggregateReturns**](PortfoliosApi.md#getPortfolioAggregateReturns) | **GET** /api/portfolios/{scope}/{code}/returns/{returnScope}/{returnCode}/aggregated | [EXPERIMENTAL] Aggregate Returns
[**getPortfolioCommands**](PortfoliosApi.md#getPortfolioCommands) | **GET** /api/portfolios/{scope}/{code}/commands | [EARLY ACCESS] Get portfolio commands
[**getPortfolioMetadata**](PortfoliosApi.md#getPortfolioMetadata) | **GET** /api/portfolios/{scope}/{code}/metadata | [EXPERIMENTAL] Get access metadata rules for a portfolio
[**getPortfolioProperties**](PortfoliosApi.md#getPortfolioProperties) | **GET** /api/portfolios/{scope}/{code}/properties | Get portfolio properties
[**getPortfolioPropertyTimeSeries**](PortfoliosApi.md#getPortfolioPropertyTimeSeries) | **GET** /api/portfolios/{scope}/{code}/properties/time-series | [EXPERIMENTAL] Get portfolio property time series
[**getPortfolioRelations**](PortfoliosApi.md#getPortfolioRelations) | **GET** /api/portfolios/{scope}/{code}/relations | [EXPERIMENTAL] Get portfolio relations
[**getPortfolioRelationships**](PortfoliosApi.md#getPortfolioRelationships) | **GET** /api/portfolios/{scope}/{code}/relationships | [EXPERIMENTAL] Get portfolio relationships
[**getPortfolioReturns**](PortfoliosApi.md#getPortfolioReturns) | **GET** /api/portfolios/{scope}/{code}/returns/{returnScope}/{returnCode} | [EXPERIMENTAL] Get Returns
[**getPortfoliosAccessMetadataByKey**](PortfoliosApi.md#getPortfoliosAccessMetadataByKey) | **GET** /api/portfolios/{scope}/{code}/metadata/{metadataKey} | [EXPERIMENTAL] Get an entry identified by a metadataKey in the access metadata object
[**listPortfolios**](PortfoliosApi.md#listPortfolios) | **GET** /api/portfolios | List portfolios
[**listPortfoliosForScope**](PortfoliosApi.md#listPortfoliosForScope) | **GET** /api/portfolios/{scope} | List portfolios for scope
[**updatePortfolio**](PortfoliosApi.md#updatePortfolio) | **PUT** /api/portfolios/{scope}/{code} | Update portfolio
[**upsertPortfolioAccessMetadata**](PortfoliosApi.md#upsertPortfolioAccessMetadata) | **PUT** /api/portfolios/{scope}/{code}/metadata/{metadataKey} | [EXPERIMENTAL] Upsert a Portfolio Access Metadata Rule associated with specific metadataKey. This creates or updates the data in LUSID.
[**upsertPortfolioProperties**](PortfoliosApi.md#upsertPortfolioProperties) | **POST** /api/portfolios/{scope}/{code}/properties | Upsert portfolio properties
[**upsertPortfolioReturns**](PortfoliosApi.md#upsertPortfolioReturns) | **POST** /api/portfolios/{scope}/{code}/returns/{returnScope}/{returnCode} | [EXPERIMENTAL] Upsert Returns


<a name="deleteKeyFromPortfolioAccessMetadata"></a>
# **deleteKeyFromPortfolioAccessMetadata**
> DeletedEntityResponse deleteKeyFromPortfolioAccessMetadata(scope, code, metadataKey, effectiveAt)

[EXPERIMENTAL] Delete a Portfolio Access Metadata Rule

Delete the Portfolio Access Metadata Rule that exactly matches the provided identifier parts

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Quote Access Metadata Rule to retrieve.
    String code = "code_example"; // String | Portfolio code
    String metadataKey = "metadataKey_example"; // String | The metadataKey identifying the access metadata entry to delete
    String effectiveAt = "effectiveAt_example"; // String | The effective date to delete at, if this is not supplied, it will delete all data found
    try {
      DeletedEntityResponse result = apiInstance.deleteKeyFromPortfolioAccessMetadata(scope, code, metadataKey, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#deleteKeyFromPortfolioAccessMetadata");
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
 **scope** | **String**| The scope of the Quote Access Metadata Rule to retrieve. |
 **code** | **String**| Portfolio code |
 **metadataKey** | **String**| The metadataKey identifying the access metadata entry to delete |
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
**200** | The rule that has been deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deletePortfolio"></a>
# **deletePortfolio**
> DeletedEntityResponse deletePortfolio(scope, code)

Delete portfolio

Delete a portfolio.                The deletion will take effect from the portfolio&#39;s creation datetime. This means that the portfolio will no longer exist at any effective datetime, from the as-at datetime of deletion.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    try {
      DeletedEntityResponse result = apiInstance.deletePortfolio(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#deletePortfolio");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |

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
**200** | The datetime that the portfolio was deleted |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deletePortfolioProperties"></a>
# **deletePortfolioProperties**
> DeletedEntityResponse deletePortfolioProperties(scope, code, propertyKeys, effectiveAt)

Delete portfolio properties

Delete one or more properties from a single portfolio. If the properties are time variant then an effective date time from which the properties  will be deleted must be specified. If the properties are perpetual then it is invalid to specify an effective date time for deletion.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    List<String> propertyKeys = Arrays.asList(); // List<String> | The property keys of the properties to delete. These must take the format              {domain}/{scope}/{code}, for example 'Portfolio/Manager/Id'. Each property must be from the 'Portfolio' domain.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to delete the properties.
    try {
      DeletedEntityResponse result = apiInstance.deletePortfolioProperties(scope, code, propertyKeys, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#deletePortfolioProperties");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| The property keys of the properties to delete. These must take the format              {domain}/{scope}/{code}, for example &#39;Portfolio/Manager/Id&#39;. Each property must be from the &#39;Portfolio&#39; domain. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to delete the properties. | [optional]

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
**200** | The datetime that the properties were deleted from the specified portfolio |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolio"></a>
# **getPortfolio**
> Portfolio getPortfolio(scope, code, effectiveAt, asAt, propertyKeys)

Get portfolio

Retrieve the definition of a portfolio.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the portfolio definition. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the portfolio definition. Defaults to return the latest version of the portfolio definition if not specified.
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the 'Portfolio' domain to decorate onto the portfolio.              These must take the format {domain}/{scope}/{code}, for example 'Portfolio/Manager/Id'.
    try {
      Portfolio result = apiInstance.getPortfolio(scope, code, effectiveAt, asAt, propertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolio");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the portfolio definition. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the portfolio definition. Defaults to return the latest version of the portfolio definition if not specified. | [optional]
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the &#39;Portfolio&#39; domain to decorate onto the portfolio.              These must take the format {domain}/{scope}/{code}, for example &#39;Portfolio/Manager/Id&#39;. | [optional]

### Return type

[**Portfolio**](Portfolio.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested portfolio definition |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioAggregateReturns"></a>
# **getPortfolioAggregateReturns**
> ResourceListOfAggregatedReturn getPortfolioAggregateReturns(scope, code, returnScope, returnCode, fromEffectiveAt, toEffectiveAt, compositeMethod, period, outputFrequency, metrics, asAt)

[EXPERIMENTAL] Aggregate Returns

Aggregate Returns which are on the specified portfolio.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Portfolio.
    String code = "code_example"; // String | The code of the  Portfolio.
    String returnScope = "returnScope_example"; // String | The scope of the Returns.
    String returnCode = "returnCode_example"; // String | The code of the Returns.
    String fromEffectiveAt = "fromEffectiveAt_example"; // String | The start date from which to delete the Returns.
    String toEffectiveAt = "toEffectiveAt_example"; // String | The end date from which to delete the Returns
    String compositeMethod = "compositeMethod_example"; // String | The method used to calculate the Portfolio performance:              Equal/Asset.
    String period = "period_example"; // String | The type of the returns used to calculate the aggregation result: Daily/Monthly.
    String outputFrequency = "outputFrequency_example"; // String | The type of calculated output: Daily/Monthly/Yearly.
    List<String> metrics = Arrays.asList(); // List<String> | The period time to calculate the aggregate return.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the Returns. Defaults to the latest.
    try {
      ResourceListOfAggregatedReturn result = apiInstance.getPortfolioAggregateReturns(scope, code, returnScope, returnCode, fromEffectiveAt, toEffectiveAt, compositeMethod, period, outputFrequency, metrics, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioAggregateReturns");
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
 **scope** | **String**| The scope of the Portfolio. |
 **code** | **String**| The code of the  Portfolio. |
 **returnScope** | **String**| The scope of the Returns. |
 **returnCode** | **String**| The code of the Returns. |
 **fromEffectiveAt** | **String**| The start date from which to delete the Returns. | [optional]
 **toEffectiveAt** | **String**| The end date from which to delete the Returns | [optional]
 **compositeMethod** | **String**| The method used to calculate the Portfolio performance:              Equal/Asset. | [optional]
 **period** | **String**| The type of the returns used to calculate the aggregation result: Daily/Monthly. | [optional]
 **outputFrequency** | **String**| The type of calculated output: Daily/Monthly/Yearly. | [optional]
 **metrics** | [**List&lt;String&gt;**](String.md)| The period time to calculate the aggregate return. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the Returns. Defaults to the latest. | [optional]

### Return type

[**ResourceListOfAggregatedReturn**](ResourceListOfAggregatedReturn.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The aggregated returns. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioCommands"></a>
# **getPortfolioCommands**
> ResourceListOfProcessedCommand getPortfolioCommands(scope, code, fromAsAt, toAsAt, filter, page, limit)

[EARLY ACCESS] Get portfolio commands

Get all the commands that modified a portfolio, including any input transactions.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    OffsetDateTime fromAsAt = OffsetDateTime.now(); // OffsetDateTime | The lower bound as-at datetime (inclusive) from which to retrieve commands. There is no lower bound if this is not specified.
    OffsetDateTime toAsAt = OffsetDateTime.now(); // OffsetDateTime | The upper bound as-at datetime (inclusive) from which to retrieve commands. There is no upper bound if this is not specified.
    String filter = "filter_example"; // String | Expression to filter the result set.              For example, to filter on the User ID, use \"userId.id eq 'string'\"              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    String page = "page_example"; // String | The pagination token to use to continue listing commands from a previous call to GetPortfolioCommands.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many. Defaults to 500 if not specified.
    try {
      ResourceListOfProcessedCommand result = apiInstance.getPortfolioCommands(scope, code, fromAsAt, toAsAt, filter, page, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioCommands");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **fromAsAt** | **OffsetDateTime**| The lower bound as-at datetime (inclusive) from which to retrieve commands. There is no lower bound if this is not specified. | [optional]
 **toAsAt** | **OffsetDateTime**| The upper bound as-at datetime (inclusive) from which to retrieve commands. There is no upper bound if this is not specified. | [optional]
 **filter** | **String**| Expression to filter the result set.              For example, to filter on the User ID, use \&quot;userId.id eq &#39;string&#39;\&quot;              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]
 **page** | **String**| The pagination token to use to continue listing commands from a previous call to GetPortfolioCommands. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. Defaults to 500 if not specified. | [optional]

### Return type

[**ResourceListOfProcessedCommand**](ResourceListOfProcessedCommand.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The commands that modified the specified portfolio. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioMetadata"></a>
# **getPortfolioMetadata**
> Map&lt;String, List&lt;AccessMetadataValue&gt;&gt; getPortfolioMetadata(scope, code, effectiveAt, asAt)

[EXPERIMENTAL] Get access metadata rules for a portfolio

Pass the scope and portfolio code parameters to retrieve the AccessMetadata associated with a portfolio

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Portfolio Access Metadata Rule to retrieve.
    String code = "code_example"; // String | Portfolio code
    String effectiveAt = "effectiveAt_example"; // String | The effectiveAt datetime at which to retrieve the access metadata rule.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the portfolio access metadata.
    try {
      Map<String, List<AccessMetadataValue>> result = apiInstance.getPortfolioMetadata(scope, code, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioMetadata");
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
 **scope** | **String**| The scope of the Portfolio Access Metadata Rule to retrieve. |
 **code** | **String**| Portfolio code |
 **effectiveAt** | **String**| The effectiveAt datetime at which to retrieve the access metadata rule. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the portfolio access metadata. | [optional]

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
**200** | The filtered list of results |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioProperties"></a>
# **getPortfolioProperties**
> PortfolioProperties getPortfolioProperties(scope, code, effectiveAt, asAt)

Get portfolio properties

List all the properties of a portfolio.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to list the portfolio's properties. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The as-at datetime at which to list the portfolio's properties. Defaults to return the latest version of each property if not specified.
    try {
      PortfolioProperties result = apiInstance.getPortfolioProperties(scope, code, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioProperties");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to list the portfolio&#39;s properties. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The as-at datetime at which to list the portfolio&#39;s properties. Defaults to return the latest version of each property if not specified. | [optional]

### Return type

[**PortfolioProperties**](PortfolioProperties.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The properties of the specified portfolio |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioPropertyTimeSeries"></a>
# **getPortfolioPropertyTimeSeries**
> ResourceListOfPropertyInterval getPortfolioPropertyTimeSeries(scope, code, propertyKey, portfolioEffectiveAt, asAt, filter, page, limit)

[EXPERIMENTAL] Get portfolio property time series

List the complete time series of a portfolio property.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    String propertyKey = "propertyKey_example"; // String | The property key of the property that will have its history shown.              These must be from the 'Portfolio' domain and in the format {domain}/{scope}/{code}, for example 'Portfolio/Manager/Id'.
    String portfolioEffectiveAt = "portfolioEffectiveAt_example"; // String | The effective datetime used to resolve the portfolio. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The as-at datetime at which to list the portfolio's property history. Defaults to return the current datetime if not supplied.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    String page = "page_example"; // String | The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter, effectiveAt, and asAt fields              must not have changed since the original request.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many.
    try {
      ResourceListOfPropertyInterval result = apiInstance.getPortfolioPropertyTimeSeries(scope, code, propertyKey, portfolioEffectiveAt, asAt, filter, page, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioPropertyTimeSeries");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **propertyKey** | **String**| The property key of the property that will have its history shown.              These must be from the &#39;Portfolio&#39; domain and in the format {domain}/{scope}/{code}, for example &#39;Portfolio/Manager/Id&#39;. | [optional]
 **portfolioEffectiveAt** | **String**| The effective datetime used to resolve the portfolio. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The as-at datetime at which to list the portfolio&#39;s property history. Defaults to return the current datetime if not supplied. | [optional]
 **filter** | **String**| Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]
 **page** | **String**| The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter, effectiveAt, and asAt fields              must not have changed since the original request. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. | [optional]

### Return type

[**ResourceListOfPropertyInterval**](ResourceListOfPropertyInterval.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The time series of the property |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioRelations"></a>
# **getPortfolioRelations**
> ResourceListOfRelation getPortfolioRelations(scope, code, effectiveAt, asAt, filter, identifierTypes)

[EXPERIMENTAL] Get portfolio relations

Get relations for a portfolio .

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve relations. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The as-at datetime at which to retrieve relations. Defaults to return the latest LUSID AsAt time if not specified.
    String filter = "filter_example"; // String | Expression to filter the relations. Users should provide null or empty string for this field until further notice.
    List<String> identifierTypes = Arrays.asList(); // List<String> | Identifiers types (as property keys) used for referencing Persons or Legal Entities.              These must be from the 'Person' or 'LegalEntity' domains and take the format {domain}/{scope}/{code}, for example              'Person/CompanyDetails/Role'. Only identifier types stated will be used to look up relevant entities in relations. If not applicable, provide an empty array.
    try {
      ResourceListOfRelation result = apiInstance.getPortfolioRelations(scope, code, effectiveAt, asAt, filter, identifierTypes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioRelations");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve relations. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The as-at datetime at which to retrieve relations. Defaults to return the latest LUSID AsAt time if not specified. | [optional]
 **filter** | **String**| Expression to filter the relations. Users should provide null or empty string for this field until further notice. | [optional]
 **identifierTypes** | [**List&lt;String&gt;**](String.md)| Identifiers types (as property keys) used for referencing Persons or Legal Entities.              These must be from the &#39;Person&#39; or &#39;LegalEntity&#39; domains and take the format {domain}/{scope}/{code}, for example              &#39;Person/CompanyDetails/Role&#39;. Only identifier types stated will be used to look up relevant entities in relations. If not applicable, provide an empty array. | [optional]

### Return type

[**ResourceListOfRelation**](ResourceListOfRelation.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The relations for the specified portfolio. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioRelationships"></a>
# **getPortfolioRelationships**
> ResourceListOfRelationship getPortfolioRelationships(scope, code, effectiveAt, asAt, filter, identifierTypes)

[EXPERIMENTAL] Get portfolio relationships

Get relationships for a portfolio

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve relationships. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The as-at datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified.
    String filter = "filter_example"; // String | Expression to filter the relationships. Users should provide null or empty string for this field until further notice.
    List<String> identifierTypes = Arrays.asList(); // List<String> | Identifiers types (as property keys) used for referencing Persons or Legal Entities.              These must be from the 'Person' or 'LegalEntity' domains and take the format {domain}/{scope}/{code}, for example              'Person/CompanyDetails/Role'. Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array.
    try {
      ResourceListOfRelationship result = apiInstance.getPortfolioRelationships(scope, code, effectiveAt, asAt, filter, identifierTypes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioRelationships");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve relationships. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The as-at datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified. | [optional]
 **filter** | **String**| Expression to filter the relationships. Users should provide null or empty string for this field until further notice. | [optional]
 **identifierTypes** | [**List&lt;String&gt;**](String.md)| Identifiers types (as property keys) used for referencing Persons or Legal Entities.              These must be from the &#39;Person&#39; or &#39;LegalEntity&#39; domains and take the format {domain}/{scope}/{code}, for example              &#39;Person/CompanyDetails/Role&#39;. Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array. | [optional]

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
**200** | The relationships for the specified portfolio. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfolioReturns"></a>
# **getPortfolioReturns**
> ResourceListOfPerformanceReturn getPortfolioReturns(scope, code, returnScope, returnCode, fromEffectiveAt, toEffectiveAt, period, asAt)

[EXPERIMENTAL] Get Returns

Get Returns which are on the specified portfolio.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Portfolio.
    String code = "code_example"; // String | The code of the  Portfolio.
    String returnScope = "returnScope_example"; // String | The scope of the Returns.
    String returnCode = "returnCode_example"; // String | The code of the Returns.
    String fromEffectiveAt = "fromEffectiveAt_example"; // String | The start date from which to delete the Returns.
    String toEffectiveAt = "toEffectiveAt_example"; // String | The end date from which to delete the Returns
    String period = "period_example"; // String | Show the Returns on a Daily or Monthly period.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the Returns. Defaults to the latest.
    try {
      ResourceListOfPerformanceReturn result = apiInstance.getPortfolioReturns(scope, code, returnScope, returnCode, fromEffectiveAt, toEffectiveAt, period, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfolioReturns");
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
 **scope** | **String**| The scope of the Portfolio. |
 **code** | **String**| The code of the  Portfolio. |
 **returnScope** | **String**| The scope of the Returns. |
 **returnCode** | **String**| The code of the Returns. |
 **fromEffectiveAt** | **String**| The start date from which to delete the Returns. | [optional]
 **toEffectiveAt** | **String**| The end date from which to delete the Returns | [optional]
 **period** | **String**| Show the Returns on a Daily or Monthly period. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the Returns. Defaults to the latest. | [optional]

### Return type

[**ResourceListOfPerformanceReturn**](ResourceListOfPerformanceReturn.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The Returns on the given time period. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getPortfoliosAccessMetadataByKey"></a>
# **getPortfoliosAccessMetadataByKey**
> List&lt;AccessMetadataValue&gt; getPortfoliosAccessMetadataByKey(scope, code, metadataKey, effectiveAt, asAt)

[EXPERIMENTAL] Get an entry identified by a metadataKey in the access metadata object

Get a specific portfolio access metadata rule by specifying the corresponding identifier parts                No matching will be performed through this endpoint. To retrieve a rule, it is necessary to specify, exactly, the identifier of the rule

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Portfolio Access Metadata Rule to retrieve.
    String code = "code_example"; // String | The code of the portfolio
    String metadataKey = "metadataKey_example"; // String | Key of the metadata to retrieve
    String effectiveAt = "effectiveAt_example"; // String | The effective date of the rule
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the portfolio access metadata.
    try {
      List<AccessMetadataValue> result = apiInstance.getPortfoliosAccessMetadataByKey(scope, code, metadataKey, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#getPortfoliosAccessMetadataByKey");
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
 **scope** | **String**| The scope of the Portfolio Access Metadata Rule to retrieve. |
 **code** | **String**| The code of the portfolio |
 **metadataKey** | **String**| Key of the metadata to retrieve |
 **effectiveAt** | **String**| The effective date of the rule | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the portfolio access metadata. | [optional]

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
**200** | The successfully retrieved Portfolio Access Metadata Rule or any failure |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listPortfolios"></a>
# **listPortfolios**
> ResourceListOfPortfolio listPortfolios(effectiveAt, asAt, page, start, limit, filter, query, propertyKeys)

List portfolios

List all the portfolios matching particular criteria.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to list the portfolios. Defaults to the current LUSID              system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The as-at datetime at which to list the portfolios. Defaults to return the latest version              of each portfolio if not specified.
    String page = "page_example"; // String | The pagination token to use to continue listing portfolios from a previous call to list portfolios. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. Also, if set, a start value cannot be provided.
    Integer start = 56; // Integer | When paginating, skip this number of results.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified.
    String filter = "filter_example"; // String | Expression to filter the result set.              For example, to filter on the Type, use \"type eq 'Transaction'\"              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    String query = "query_example"; // String | Expression specifying the criteria that the returned portfolios must meet. For example, to see which              portfolios have holdings in the instruments with a Lusid Instrument Id (LUID) of 'LUID_PPA8HI6M' or a Figi of 'BBG000BLNNH6'              you would specify \"instrument.identifiers in (('LusidInstrumentId', 'LUID_PPA8HI6M'), ('Figi', 'BBG000BLNNH6'))\".
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the 'Portfolio' domain to decorate onto each portfolio.              These must take the format {domain}/{scope}/{code}, for example 'Portfolio/Manager/Id'.
    try {
      ResourceListOfPortfolio result = apiInstance.listPortfolios(effectiveAt, asAt, page, start, limit, filter, query, propertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#listPortfolios");
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
 **effectiveAt** | **String**| The effective datetime or cut label at which to list the portfolios. Defaults to the current LUSID              system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The as-at datetime at which to list the portfolios. Defaults to return the latest version              of each portfolio if not specified. | [optional]
 **page** | **String**| The pagination token to use to continue listing portfolios from a previous call to list portfolios. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. Also, if set, a start value cannot be provided. | [optional]
 **start** | **Integer**| When paginating, skip this number of results. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified. | [optional]
 **filter** | **String**| Expression to filter the result set.              For example, to filter on the Type, use \&quot;type eq &#39;Transaction&#39;\&quot;              Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]
 **query** | **String**| Expression specifying the criteria that the returned portfolios must meet. For example, to see which              portfolios have holdings in the instruments with a Lusid Instrument Id (LUID) of &#39;LUID_PPA8HI6M&#39; or a Figi of &#39;BBG000BLNNH6&#39;              you would specify \&quot;instrument.identifiers in ((&#39;LusidInstrumentId&#39;, &#39;LUID_PPA8HI6M&#39;), (&#39;Figi&#39;, &#39;BBG000BLNNH6&#39;))\&quot;. | [optional]
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the &#39;Portfolio&#39; domain to decorate onto each portfolio.              These must take the format {domain}/{scope}/{code}, for example &#39;Portfolio/Manager/Id&#39;. | [optional]

### Return type

[**ResourceListOfPortfolio**](ResourceListOfPortfolio.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested portfolios |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listPortfoliosForScope"></a>
# **listPortfoliosForScope**
> ResourceListOfPortfolio listPortfoliosForScope(scope, effectiveAt, asAt, page, start, limit, filter, propertyKeys)

List portfolios for scope

List all the portfolios in a scope.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolios.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to list the portfolios. Defaults to the current LUSID              system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The as-at datetime at which to list the portfolios. Defaults to return the latest version              of each portfolio if not specified.
    String page = "page_example"; // String | The pagination token to use to continue listing portfolios from a previous call to list portfolios. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. Also, if set, a start value cannot be provided.
    Integer start = 56; // Integer | When paginating, skip this number of results.
    Integer limit = 56; // Integer | When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified.
    String filter = "filter_example"; // String | Expression to filter the result set.              For example, to return only transactions with a transaction type of 'Buy', specify \"type eq 'Buy'\".              For more information about filtering LUSID results, see https://support.lusid.com/knowledgebase/article/KA-01914.
    List<String> propertyKeys = Arrays.asList(); // List<String> | A list of property keys from the 'Portfolio' domain to decorate onto each portfolio.              These must take the format {domain}/{scope}/{code}, for example 'Portfolio/Manager/Id'.
    try {
      ResourceListOfPortfolio result = apiInstance.listPortfoliosForScope(scope, effectiveAt, asAt, page, start, limit, filter, propertyKeys);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#listPortfoliosForScope");
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
 **scope** | **String**| The scope of the portfolios. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to list the portfolios. Defaults to the current LUSID              system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The as-at datetime at which to list the portfolios. Defaults to return the latest version              of each portfolio if not specified. | [optional]
 **page** | **String**| The pagination token to use to continue listing portfolios from a previous call to list portfolios. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. Also, if set, a start value cannot be provided. | [optional]
 **start** | **Integer**| When paginating, skip this number of results. | [optional]
 **limit** | **Integer**| When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified. | [optional]
 **filter** | **String**| Expression to filter the result set.              For example, to return only transactions with a transaction type of &#39;Buy&#39;, specify \&quot;type eq &#39;Buy&#39;\&quot;.              For more information about filtering LUSID results, see https://support.lusid.com/knowledgebase/article/KA-01914. | [optional]
 **propertyKeys** | [**List&lt;String&gt;**](String.md)| A list of property keys from the &#39;Portfolio&#39; domain to decorate onto each portfolio.              These must take the format {domain}/{scope}/{code}, for example &#39;Portfolio/Manager/Id&#39;. | [optional]

### Return type

[**ResourceListOfPortfolio**](ResourceListOfPortfolio.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The portfolios in the specified scope |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="updatePortfolio"></a>
# **updatePortfolio**
> Portfolio updatePortfolio(scope, code, updatePortfolioRequest, effectiveAt)

Update portfolio

Update the definition of a portfolio.                Note that not all elements of a portfolio definition are  modifiable due to the potential implications for data already stored against the portfolio.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    UpdatePortfolioRequest updatePortfolioRequest = new UpdatePortfolioRequest(); // UpdatePortfolioRequest | The updated portfolio definition.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to update the definition. Defaults to the current               LUSID system datetime if not specified.
    try {
      Portfolio result = apiInstance.updatePortfolio(scope, code, updatePortfolioRequest, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#updatePortfolio");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **updatePortfolioRequest** | [**UpdatePortfolioRequest**](UpdatePortfolioRequest.md)| The updated portfolio definition. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to update the definition. Defaults to the current               LUSID system datetime if not specified. | [optional]

### Return type

[**Portfolio**](Portfolio.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated definition of the portfolio |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertPortfolioAccessMetadata"></a>
# **upsertPortfolioAccessMetadata**
> ResourceListOfAccessMetadataValueOf upsertPortfolioAccessMetadata(scope, code, metadataKey, upsertPortfolioAccessMetadataRequest, effectiveAt)

[EXPERIMENTAL] Upsert a Portfolio Access Metadata Rule associated with specific metadataKey. This creates or updates the data in LUSID.

Update or insert one Portfolio Access Metadata Rule in a single scope. An item will be updated if it already exists  and inserted if it does not.    The response will return the successfully updated or inserted Portfolio Access Metadata Rule or failure message if unsuccessful    It is important to always check to verify success (or failure).                Multiple rules for a metadataKey can exists with different effective at dates, when resources are accessed the rule that is active for the current time will be fetched

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope to use when updating or inserting the Portfolio Access Metadata Rule.
    String code = "code_example"; // String | Portfolio code
    String metadataKey = "metadataKey_example"; // String | Key of the access metadata to upsert
    UpsertPortfolioAccessMetadataRequest upsertPortfolioAccessMetadataRequest = new UpsertPortfolioAccessMetadataRequest(); // UpsertPortfolioAccessMetadataRequest | The Portfolio Access Metadata Rule to update or insert
    String effectiveAt = "effectiveAt_example"; // String | The date this rule will effective from
    try {
      ResourceListOfAccessMetadataValueOf result = apiInstance.upsertPortfolioAccessMetadata(scope, code, metadataKey, upsertPortfolioAccessMetadataRequest, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#upsertPortfolioAccessMetadata");
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
 **scope** | **String**| The scope to use when updating or inserting the Portfolio Access Metadata Rule. |
 **code** | **String**| Portfolio code |
 **metadataKey** | **String**| Key of the access metadata to upsert |
 **upsertPortfolioAccessMetadataRequest** | [**UpsertPortfolioAccessMetadataRequest**](UpsertPortfolioAccessMetadataRequest.md)| The Portfolio Access Metadata Rule to update or insert |
 **effectiveAt** | **String**| The date this rule will effective from | [optional]

### Return type

[**ResourceListOfAccessMetadataValueOf**](ResourceListOfAccessMetadataValueOf.md)

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

<a name="upsertPortfolioProperties"></a>
# **upsertPortfolioProperties**
> PortfolioProperties upsertPortfolioProperties(scope, code, requestBody)

Upsert portfolio properties

Update or insert one or more properties onto a single portfolio. A property will be updated if it  already exists and inserted if it does not. All properties must be from the &#39;Portfolio&#39; domain.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio.
    String code = "code_example"; // String | The code of the portfolio. Together with the scope this uniquely identifies the portfolio.
    Map<String, Property> requestBody = new HashMap(); // Map<String, Property> | The properties to be updated or inserted onto the portfolio. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code}, for example               'Portfolio/Manager/Id'.
    try {
      PortfolioProperties result = apiInstance.upsertPortfolioProperties(scope, code, requestBody);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#upsertPortfolioProperties");
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
 **scope** | **String**| The scope of the portfolio. |
 **code** | **String**| The code of the portfolio. Together with the scope this uniquely identifies the portfolio. |
 **requestBody** | [**Map&lt;String, Property&gt;**](Property.md)| The properties to be updated or inserted onto the portfolio. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code}, for example               &#39;Portfolio/Manager/Id&#39;. |

### Return type

[**PortfolioProperties**](PortfolioProperties.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated or inserted properties |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertPortfolioReturns"></a>
# **upsertPortfolioReturns**
> UpsertReturnsResponse upsertPortfolioReturns(scope, code, returnScope, returnCode, performanceReturn)

[EXPERIMENTAL] Upsert Returns

Update or insert returns into the specified portfolio.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.PortfoliosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://fbn-prd.lusid.com/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    PortfoliosApi apiInstance = new PortfoliosApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the Portfolio.
    String code = "code_example"; // String | The code of the  Portfolio.
    String returnScope = "returnScope_example"; // String | The scope of the Returns.
    String returnCode = "returnCode_example"; // String | The code of the Returns.
    List<PerformanceReturn> performanceReturn = Arrays.asList(); // List<PerformanceReturn> | This contains the Returns which need to be upsert.
    try {
      UpsertReturnsResponse result = apiInstance.upsertPortfolioReturns(scope, code, returnScope, returnCode, performanceReturn);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PortfoliosApi#upsertPortfolioReturns");
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
 **scope** | **String**| The scope of the Portfolio. |
 **code** | **String**| The code of the  Portfolio. |
 **returnScope** | **String**| The scope of the Returns. |
 **returnCode** | **String**| The code of the Returns. |
 **performanceReturn** | [**List&lt;PerformanceReturn&gt;**](PerformanceReturn.md)| This contains the Returns which need to be upsert. |

### Return type

[**UpsertReturnsResponse**](UpsertReturnsResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The version of the portfolio that contains the newly updated or inserted Returns. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

