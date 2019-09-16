# SearchApi

All URIs are relative to *http://localhost/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**instrumentsSearch**](SearchApi.md#instrumentsSearch) | **POST** /api/search/instruments | [EXPERIMENTAL] Instruments search
[**portfolioGroupsSearch**](SearchApi.md#portfolioGroupsSearch) | **POST** /api/search/portfoliogroups | [EXPERIMENTAL] Portfolio groups search
[**portfoliosSearch**](SearchApi.md#portfoliosSearch) | **POST** /api/search/portfolios | [EXPERIMENTAL] [DEPRECATED] Portfolios search
[**propertiesSearch**](SearchApi.md#propertiesSearch) | **POST** /api/search/propertydefinitions | [EXPERIMENTAL] [DEPRECATED] Search property definitions
[**searchPortfolios**](SearchApi.md#searchPortfolios) | **GET** /api/search/portfolios | [EXPERIMENTAL] Search Portfolios
[**searchProperties**](SearchApi.md#searchProperties) | **GET** /api/search/propertydefinitions | [EXPERIMENTAL] Search Property Definitions


<a name="instrumentsSearch"></a>
# **instrumentsSearch**
> List&lt;InstrumentMatch&gt; instrumentsSearch(symbols, masteredEffectiveAt, masteredOnly)

[EXPERIMENTAL] Instruments search

Search across all instruments that have been mastered in LUSID. Optionally augment the results with instruments from an external symbology service,  currently OpenFIGI.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SearchApi apiInstance = new SearchApi(defaultClient);
    List<InstrumentSearchProperty> symbols = Arrays.asList(null); // List<InstrumentSearchProperty> | A collection of instrument properties to search for. LUSID will return instruments for any matched              properties.
    String masteredEffectiveAt = "masteredEffectiveAt_example"; // String | The effective datetime or cut label to use when searching mastered instruments. This parameter has no effect on instruments that  have not been mastered within LUSID. Defaults to the current LUSID system datetime if not specified.
    Boolean masteredOnly = false; // Boolean | If set to true, only search over instruments that have been mastered within LUSID. Defaults to false.
    try {
      List<InstrumentMatch> result = apiInstance.instrumentsSearch(symbols, masteredEffectiveAt, masteredOnly);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SearchApi#instrumentsSearch");
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
 **symbols** | [**List&lt;InstrumentSearchProperty&gt;**](InstrumentSearchProperty.md)| A collection of instrument properties to search for. LUSID will return instruments for any matched              properties. |
 **masteredEffectiveAt** | **String**| The effective datetime or cut label to use when searching mastered instruments. This parameter has no effect on instruments that  have not been mastered within LUSID. Defaults to the current LUSID system datetime if not specified. | [optional]
 **masteredOnly** | **Boolean**| If set to true, only search over instruments that have been mastered within LUSID. Defaults to false. | [optional] [default to false]

### Return type

[**List&lt;InstrumentMatch&gt;**](InstrumentMatch.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The instruments found by the search |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="portfolioGroupsSearch"></a>
# **portfolioGroupsSearch**
> ResourceListOfPortfolioGroup portfolioGroupsSearch(request, filter)

[EXPERIMENTAL] Portfolio groups search

Search across all portfolio groups across all scopes.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SearchApi apiInstance = new SearchApi(defaultClient);
    Object request = null; // Object | The search query to use. Read more about search queries in LUSID here https://support.lusid.com/constructing-a-search-request.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    try {
      ResourceListOfPortfolioGroup result = apiInstance.portfolioGroupsSearch(request, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SearchApi#portfolioGroupsSearch");
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
 **request** | **Object**| The search query to use. Read more about search queries in LUSID here https://support.lusid.com/constructing-a-search-request. |
 **filter** | **String**| Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]

### Return type

[**ResourceListOfPortfolioGroup**](ResourceListOfPortfolioGroup.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The portfolio groups found by the search |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="portfoliosSearch"></a>
# **portfoliosSearch**
> ResourceListOfPortfolioSearchResult portfoliosSearch(request, filter)

[EXPERIMENTAL] [DEPRECATED] Portfolios search

Search across all portfolios across all scopes.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SearchApi apiInstance = new SearchApi(defaultClient);
    Object request = null; // Object | The search query to use. Read more about search queries in LUSID here https://support.lusid.com/constructing-a-search-request.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    try {
      ResourceListOfPortfolioSearchResult result = apiInstance.portfoliosSearch(request, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SearchApi#portfoliosSearch");
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
 **request** | **Object**| The search query to use. Read more about search queries in LUSID here https://support.lusid.com/constructing-a-search-request. |
 **filter** | **String**| Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]

### Return type

[**ResourceListOfPortfolioSearchResult**](ResourceListOfPortfolioSearchResult.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The portfolios found by the search |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="propertiesSearch"></a>
# **propertiesSearch**
> ResourceListOfPropertyDefinition propertiesSearch(request, filter)

[EXPERIMENTAL] [DEPRECATED] Search property definitions

Search across all user defined property definitions across all scopes.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SearchApi apiInstance = new SearchApi(defaultClient);
    Object request = null; // Object | The search query to use. Read more about search queries in LUSID here https://support.lusid.com/constructing-a-search-request.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid.
    try {
      ResourceListOfPropertyDefinition result = apiInstance.propertiesSearch(request, filter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SearchApi#propertiesSearch");
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
 **request** | **Object**| The search query to use. Read more about search queries in LUSID here https://support.lusid.com/constructing-a-search-request. |
 **filter** | **String**| Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. | [optional]

### Return type

[**ResourceListOfPropertyDefinition**](ResourceListOfPropertyDefinition.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The property definitions found by the search |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="searchPortfolios"></a>
# **searchPortfolios**
> PagedResourceListOfPortfolioSearchResult searchPortfolios(search, filter, sortBy, limit, page)

[EXPERIMENTAL] Search Portfolios

Search through all portfolios

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SearchApi apiInstance = new SearchApi(defaultClient);
    String search = "search_example"; // String | A parameter used for searching any portfolio field. Wildcards(*) are supported at the end of words (e.g. 'Port*'). See <see href=\"https://support.lusid.com/filtering-results-from-lusid\"> filtering results from LUSID </see> for more details.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about <see href=\"https://support.lusid.com/filtering-results-from-lusid\"> filtering results from LUSID</see>.
    String sortBy = "sortBy_example"; // String | Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName. Multiple fields can be denoted by a comma e.g. -MyFieldName,AnotherFieldName,-AFurtherFieldName
    Integer limit = 56; // Integer | When paginating, only return this number of records
    String page = "page_example"; // String | Encoded page string returned from a previous search result that will retrieve the next page of data. When this field is supplied, filter, sortby and search fields should not be supplied.
    try {
      PagedResourceListOfPortfolioSearchResult result = apiInstance.searchPortfolios(search, filter, sortBy, limit, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SearchApi#searchPortfolios");
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
 **search** | **String**| A parameter used for searching any portfolio field. Wildcards(*) are supported at the end of words (e.g. &#39;Port*&#39;). See &lt;see href&#x3D;\&quot;https://support.lusid.com/filtering-results-from-lusid\&quot;&gt; filtering results from LUSID &lt;/see&gt; for more details. | [optional]
 **filter** | **String**| Expression to filter the result set. Read more about &lt;see href&#x3D;\&quot;https://support.lusid.com/filtering-results-from-lusid\&quot;&gt; filtering results from LUSID&lt;/see&gt;. | [optional]
 **sortBy** | **String**| Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName. Multiple fields can be denoted by a comma e.g. -MyFieldName,AnotherFieldName,-AFurtherFieldName | [optional]
 **limit** | **Integer**| When paginating, only return this number of records | [optional]
 **page** | **String**| Encoded page string returned from a previous search result that will retrieve the next page of data. When this field is supplied, filter, sortby and search fields should not be supplied. | [optional]

### Return type

[**PagedResourceListOfPortfolioSearchResult**](PagedResourceListOfPortfolioSearchResult.md)

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

<a name="searchProperties"></a>
# **searchProperties**
> PagedResourceListOfPropertyDefinition searchProperties(search, filter, sortBy, limit, page)

[EXPERIMENTAL] Search Property Definitions

Search through all Property Definitions

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SearchApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SearchApi apiInstance = new SearchApi(defaultClient);
    String search = "search_example"; // String | A parameter used for searching any field. Wildcards(*) are supported at the end of words (e.g. 'Port*'). See <see href=\"https://support.lusid.com/filtering-results-from-lusid\"> filtering results from LUSID </see> for more details.
    String filter = "filter_example"; // String | Expression to filter the result set. Read more about <see href=\"https://support.lusid.com/filtering-results-from-lusid\"> filtering results from LUSID</see>.
    String sortBy = "sortBy_example"; // String | Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName. Multiple fields can be denoted by a comma e.g. -MyFieldName,AnotherFieldName,-AFurtherFieldName
    Integer limit = 56; // Integer | When paginating, only return this number of records
    String page = "page_example"; // String | Encoded page string returned from a previous search result that will retrieve the next page of data. When this field is supplied, filter, sortby and search fields should not be supplied.
    try {
      PagedResourceListOfPropertyDefinition result = apiInstance.searchProperties(search, filter, sortBy, limit, page);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SearchApi#searchProperties");
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
 **search** | **String**| A parameter used for searching any field. Wildcards(*) are supported at the end of words (e.g. &#39;Port*&#39;). See &lt;see href&#x3D;\&quot;https://support.lusid.com/filtering-results-from-lusid\&quot;&gt; filtering results from LUSID &lt;/see&gt; for more details. | [optional]
 **filter** | **String**| Expression to filter the result set. Read more about &lt;see href&#x3D;\&quot;https://support.lusid.com/filtering-results-from-lusid\&quot;&gt; filtering results from LUSID&lt;/see&gt;. | [optional]
 **sortBy** | **String**| Order the results by these fields. Use use the &#39;-&#39; sign to denote descending order e.g. -MyFieldName. Multiple fields can be denoted by a comma e.g. -MyFieldName,AnotherFieldName,-AFurtherFieldName | [optional]
 **limit** | **Integer**| When paginating, only return this number of records | [optional]
 **page** | **String**| Encoded page string returned from a previous search result that will retrieve the next page of data. When this field is supplied, filter, sortby and search fields should not be supplied. | [optional]

### Return type

[**PagedResourceListOfPropertyDefinition**](PagedResourceListOfPropertyDefinition.md)

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

