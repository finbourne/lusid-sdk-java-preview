# FeesAndCommissionsApi

All URIs are relative to *http://local-unit-test-server.lusid.com:47445*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getApplicableFees**](FeesAndCommissionsApi.md#getApplicableFees) | **GET** /api/feesandcommissions | [EXPERIMENTAL] GetApplicableFees: Get the Fees and Commissions that may be applicable to a transaction.
[**getFeeRule**](FeesAndCommissionsApi.md#getFeeRule) | **GET** /api/feesandcommissions/rules-dev/{code} | [EXPERIMENTAL] GetFeeRule: Retrieve the definition of single fee rule.
[**listAllFees**](FeesAndCommissionsApi.md#listAllFees) | **GET** /api/feesandcommissions/rules | [EXPERIMENTAL] ListAllFees: List the rules available for fees and commissions.
[**listFeeRules**](FeesAndCommissionsApi.md#listFeeRules) | **GET** /api/feesandcommissions/rules-dev | [EXPERIMENTAL] ListFeeRules: List fee rules, with optional filtering.
[**upsertFeeRules**](FeesAndCommissionsApi.md#upsertFeeRules) | **POST** /api/feesandcommissions/rules-dev | [EXPERIMENTAL] UpsertFeeRules: Upsert fee rules.


<a name="getApplicableFees"></a>
# **getApplicableFees**
> ResourceListOfFeeCalculationDetails getApplicableFees(instrumentIdentifierType, instrumentIdentifier, portfolioScope, portfolioCode, additionalSearchKeys, fileName)

[EXPERIMENTAL] GetApplicableFees: Get the Fees and Commissions that may be applicable to a transaction.

Additionally, matching can be based on the instrument&#39;s properties, its portfolio properties, and any additional property keys present in the data file.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.FeesAndCommissionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:47445");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    FeesAndCommissionsApi apiInstance = new FeesAndCommissionsApi(defaultClient);
    String instrumentIdentifierType = "instrumentIdentifierType_example"; // String | Optional. The unique identifier type to use, eg 'Figi' or 'LusidInstrumentId'.
    String instrumentIdentifier = "instrumentIdentifier_example"; // String | Optional. The Instrument Identifier to get properties for.
    String portfolioScope = "portfolioScope_example"; // String | Optional. The scope of the portfolio to fetch additional properties from.
    String portfolioCode = "portfolioCode_example"; // String | Optional. The code of the portfolio to fetch additional properties from.
    List<String> additionalSearchKeys = Arrays.asList(); // List<String> | Any other property keys or fields and their corresponding values that should be matched for fees. Eg. \"Instrument/default/Name=exampleValue\" or \"AdditionalKey2=Value2\".              The list of fields available is as follows : \"RuleName\", \"Country\", \"FeeType\", \"FeeRate\", \"MinFee\", \"MaxFee\", \"PropertyKey\",               \"TransactionType\", \"Counterparty\", \"SettlementCurrency\", \"TransactionCurrency\", \"ExecutionBroker\",               \"Custodian\", \"Exchange\"
    String fileName = "fileName_example"; // String | Optionally provide the filename of an alternative to the default fees file ({fees.csv})              in your {fees-and-commissions} Drive folder, to support different fee structures.              For example, you might use one to understand the effect of different fees when considering a change in broker.
    try {
      ResourceListOfFeeCalculationDetails result = apiInstance.getApplicableFees(instrumentIdentifierType, instrumentIdentifier, portfolioScope, portfolioCode, additionalSearchKeys, fileName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeesAndCommissionsApi#getApplicableFees");
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
 **instrumentIdentifierType** | **String**| Optional. The unique identifier type to use, eg &#39;Figi&#39; or &#39;LusidInstrumentId&#39;. | [optional]
 **instrumentIdentifier** | **String**| Optional. The Instrument Identifier to get properties for. | [optional]
 **portfolioScope** | **String**| Optional. The scope of the portfolio to fetch additional properties from. | [optional]
 **portfolioCode** | **String**| Optional. The code of the portfolio to fetch additional properties from. | [optional]
 **additionalSearchKeys** | [**List&lt;String&gt;**](String.md)| Any other property keys or fields and their corresponding values that should be matched for fees. Eg. \&quot;Instrument/default/Name&#x3D;exampleValue\&quot; or \&quot;AdditionalKey2&#x3D;Value2\&quot;.              The list of fields available is as follows : \&quot;RuleName\&quot;, \&quot;Country\&quot;, \&quot;FeeType\&quot;, \&quot;FeeRate\&quot;, \&quot;MinFee\&quot;, \&quot;MaxFee\&quot;, \&quot;PropertyKey\&quot;,               \&quot;TransactionType\&quot;, \&quot;Counterparty\&quot;, \&quot;SettlementCurrency\&quot;, \&quot;TransactionCurrency\&quot;, \&quot;ExecutionBroker\&quot;,               \&quot;Custodian\&quot;, \&quot;Exchange\&quot; | [optional]
 **fileName** | **String**| Optionally provide the filename of an alternative to the default fees file ({fees.csv})              in your {fees-and-commissions} Drive folder, to support different fee structures.              For example, you might use one to understand the effect of different fees when considering a change in broker. | [optional]

### Return type

[**ResourceListOfFeeCalculationDetails**](ResourceListOfFeeCalculationDetails.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The List of applicable fee calculations details |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getFeeRule"></a>
# **getFeeRule**
> FeeRule getFeeRule(code, effectiveAt, asAt)

[EXPERIMENTAL] GetFeeRule: Retrieve the definition of single fee rule.

Retrieves the fee rule definition at the given effective and as at times.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.FeesAndCommissionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:47445");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    FeesAndCommissionsApi apiInstance = new FeesAndCommissionsApi(defaultClient);
    String code = "code_example"; // String | The fee rule code.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the rule definition. Defaults to the current LUSID  system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the rule definition. Defaults to returning the latest version if not  specified.
    try {
      FeeRule result = apiInstance.getFeeRule(code, effectiveAt, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeesAndCommissionsApi#getFeeRule");
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
 **code** | **String**| The fee rule code. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the rule definition. Defaults to the current LUSID  system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the rule definition. Defaults to returning the latest version if not  specified. | [optional]

### Return type

[**FeeRule**](FeeRule.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Details of one fee rule. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listAllFees"></a>
# **listAllFees**
> ResourceListOfFeeCalculationDetails listAllFees(additionalSearchKeys, fileName)

[EXPERIMENTAL] ListAllFees: List the rules available for fees and commissions.

By default, will list ALL rules available. Additional keys and be specified to list a smaller subset of rules.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.FeesAndCommissionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:47445");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    FeesAndCommissionsApi apiInstance = new FeesAndCommissionsApi(defaultClient);
    List<String> additionalSearchKeys = Arrays.asList(); // List<String> | Any other property keys or fields and their corresponding values that should be matched to reduce the list of rules returned. Eg. \"Instrument/default/Name=exampleValue\" or \"AdditionalKey2=Value2\".              The minimum list of fields available is as follows : \"RuleName\", \"Country\", \"FeeCalculationMethod\", \"FeeMultiplier\", \"MinFeeCalculationMethod\",              \"MinFeeMultiplier\", \"MaxFeeCalculationMethod\", \"MaxFeeMultiplier\", \"PropertyKey\",              \"TransactionType\", \"Counterparty\", \"SettlementCurrency\", \"TransactionCurrency\", \"ExecutionBroker\",              \"Custodian\", \"Exchange\"
    String fileName = "fileName_example"; // String | Optionally provide the filename of an alternative to the default fees file ({fees.csv})              in your Drive {fees-and-commissions} folder, to support different fee structures.              For example, you might use one to understand the effect of different fees when considering a change in broker.
    try {
      ResourceListOfFeeCalculationDetails result = apiInstance.listAllFees(additionalSearchKeys, fileName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeesAndCommissionsApi#listAllFees");
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
 **additionalSearchKeys** | [**List&lt;String&gt;**](String.md)| Any other property keys or fields and their corresponding values that should be matched to reduce the list of rules returned. Eg. \&quot;Instrument/default/Name&#x3D;exampleValue\&quot; or \&quot;AdditionalKey2&#x3D;Value2\&quot;.              The minimum list of fields available is as follows : \&quot;RuleName\&quot;, \&quot;Country\&quot;, \&quot;FeeCalculationMethod\&quot;, \&quot;FeeMultiplier\&quot;, \&quot;MinFeeCalculationMethod\&quot;,              \&quot;MinFeeMultiplier\&quot;, \&quot;MaxFeeCalculationMethod\&quot;, \&quot;MaxFeeMultiplier\&quot;, \&quot;PropertyKey\&quot;,              \&quot;TransactionType\&quot;, \&quot;Counterparty\&quot;, \&quot;SettlementCurrency\&quot;, \&quot;TransactionCurrency\&quot;, \&quot;ExecutionBroker\&quot;,              \&quot;Custodian\&quot;, \&quot;Exchange\&quot; | [optional]
 **fileName** | **String**| Optionally provide the filename of an alternative to the default fees file ({fees.csv})              in your Drive {fees-and-commissions} folder, to support different fee structures.              For example, you might use one to understand the effect of different fees when considering a change in broker. | [optional]

### Return type

[**ResourceListOfFeeCalculationDetails**](ResourceListOfFeeCalculationDetails.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The List of all fee and commission rules available |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="listFeeRules"></a>
# **listFeeRules**
> ResourceListOfFeeRule listFeeRules(effectiveAt, asAt, limit, filter, page)

[EXPERIMENTAL] ListFeeRules: List fee rules, with optional filtering.

For more information about filtering results,  see https://support.lusid.com/knowledgebase/article/KA-01914.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.FeesAndCommissionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:47445");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    FeesAndCommissionsApi apiInstance = new FeesAndCommissionsApi(defaultClient);
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the rule definitions. Defaults to the current LUSID  system datetime if not specified.
    OffsetDateTime asAt = OffsetDateTime.now(); // OffsetDateTime | The asAt datetime at which to retrieve the rule definitions. Defaults to returning the latest version if not  specified.
    Integer limit = 56; // Integer | When paginating, limit the results to this number. Defaults to 100 if not specified.
    String filter = "filter_example"; // String | Expression to filter the results.
    String page = "page_example"; // String | The pagination token to use to continue listing entities; this value is returned from the previous call. If  a pagination token is provided, the filter, effectiveAt and asAt fields must not have changed since the  original request.
    try {
      ResourceListOfFeeRule result = apiInstance.listFeeRules(effectiveAt, asAt, limit, filter, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeesAndCommissionsApi#listFeeRules");
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
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the rule definitions. Defaults to the current LUSID  system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the rule definitions. Defaults to returning the latest version if not  specified. | [optional]
 **limit** | **Integer**| When paginating, limit the results to this number. Defaults to 100 if not specified. | [optional]
 **filter** | **String**| Expression to filter the results. | [optional]
 **page** | **String**| The pagination token to use to continue listing entities; this value is returned from the previous call. If  a pagination token is provided, the filter, effectiveAt and asAt fields must not have changed since the  original request. | [optional]

### Return type

[**ResourceListOfFeeRule**](ResourceListOfFeeRule.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A filtered list of fee rules available. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertFeeRules"></a>
# **upsertFeeRules**
> FeeRuleUpsertResponse upsertFeeRules(requestBody, effectiveAt)

[EXPERIMENTAL] UpsertFeeRules: Upsert fee rules.

To upsert a new rule, the code field must be left empty, a code will then be assigned and returned as part  of the response. To update an existing rule, include the fee code. It is possible to both create and update  fee rules in the same request.                The upsert is transactional - either all create/update operations will succeed or none of them will.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.FeesAndCommissionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:47445");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    FeesAndCommissionsApi apiInstance = new FeesAndCommissionsApi(defaultClient);
    Map<String, FeeRuleUpsertRequest> requestBody = new HashMap(); // Map<String, FeeRuleUpsertRequest> | A dictionary of upsert request identifiers to rule upsert requests. The request               identifiers are valid for the request only and can be used to link the upserted fee rule to the code of a               created fee rule.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label for rule to begin to be effective from. Defaults to the current LUSID  system datetime if not specified. In the case of updates, the update rule will be valid from this time until  the next upserted effective from time. For example, if a rule is due to change from the first of the next  month, values upserted effective from the current time will only be valid until the end of the month, after  which the scheduled changes will take over, as they were due to before this latest upsert.
    try {
      FeeRuleUpsertResponse result = apiInstance.upsertFeeRules(requestBody, effectiveAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FeesAndCommissionsApi#upsertFeeRules");
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
 **requestBody** | [**Map&lt;String, FeeRuleUpsertRequest&gt;**](FeeRuleUpsertRequest.md)| A dictionary of upsert request identifiers to rule upsert requests. The request               identifiers are valid for the request only and can be used to link the upserted fee rule to the code of a               created fee rule. |
 **effectiveAt** | **String**| The effective datetime or cut label for rule to begin to be effective from. Defaults to the current LUSID  system datetime if not specified. In the case of updates, the update rule will be valid from this time until  the next upserted effective from time. For example, if a rule is due to change from the first of the next  month, values upserted effective from the current time will only be valid until the end of the month, after  which the scheduled changes will take over, as they were due to before this latest upsert. | [optional]

### Return type

[**FeeRuleUpsertResponse**](FeeRuleUpsertResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Upsert fee rules. New fee rules must have an empty code field. Where a code is given, this rule must already exist and will be updated. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

