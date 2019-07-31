# QuotesApi

All URIs are relative to *http://http:/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteQuotes**](QuotesApi.md#deleteQuotes) | **POST** /api/quotes/{scope}/$delete | [BETA] Delete a quote
[**getQuotes**](QuotesApi.md#getQuotes) | **POST** /api/quotes/{scope}/$get | [BETA] Get quotes
[**upsertQuotes**](QuotesApi.md#upsertQuotes) | **POST** /api/quotes/{scope} | [BETA] Upsert quotes


<a name="deleteQuotes"></a>
# **deleteQuotes**
> AnnulQuotesResponse deleteQuotes(scope, quotes)

[BETA] Delete a quote

Delete the specified quotes. In order for a quote to be deleted the id and effectiveFrom date must exactly match.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.QuotesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    QuotesApi apiInstance = new QuotesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the quote
    Map<String, QuoteId> quotes = new HashMap(); // Map<String, QuoteId> | The quotes to delete
    try {
      AnnulQuotesResponse result = apiInstance.deleteQuotes(scope, quotes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling QuotesApi#deleteQuotes");
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
 **scope** | **String**| The scope of the quote |
 **quotes** | [**Map&lt;String, QuoteId&gt;**](QuoteId.md)| The quotes to delete | [optional]

### Return type

[**AnnulQuotesResponse**](AnnulQuotesResponse.md)

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

<a name="getQuotes"></a>
# **getQuotes**
> GetQuotesResponse getQuotes(scope, effectiveAt, asAt, maxAge, quoteIds)

[BETA] Get quotes

Get quotes effective at the specified date/time (if any). An optional maximum age of quotes can be specified, and is infinite by default.  Quotes which are older than this at the time of the effective date/time will not be returned.  MaxAge is a duration of time represented in an ISO8601 format, eg. P1Y2M3DT4H30M (1 year, 2 months, 3 days, 4 hours and 30 minutes).  The maximum number of quotes that this method can get per request is 2,000.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.QuotesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    QuotesApi apiInstance = new QuotesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the quotes
    String effectiveAt = "effectiveAt_example"; // String | Optional. The date/time from which the quotes are effective
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | Optional. The 'AsAt' date/time
    String maxAge = "maxAge_example"; // String | Optional. The quote staleness tolerance
    Map<String, QuoteSeriesId> quoteIds = new HashMap(); // Map<String, QuoteSeriesId> | The ids of the quotes
    try {
      GetQuotesResponse result = apiInstance.getQuotes(scope, effectiveAt, asAt, maxAge, quoteIds);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling QuotesApi#getQuotes");
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
 **scope** | **String**| The scope of the quotes |
 **effectiveAt** | **String**| Optional. The date/time from which the quotes are effective | [optional]
 **asAt** | **OffsetDateTime**| Optional. The &#39;AsAt&#39; date/time | [optional]
 **maxAge** | **String**| Optional. The quote staleness tolerance | [optional]
 **quoteIds** | [**Map&lt;String, QuoteSeriesId&gt;**](QuoteSeriesId.md)| The ids of the quotes | [optional]

### Return type

[**GetQuotesResponse**](GetQuotesResponse.md)

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

<a name="upsertQuotes"></a>
# **upsertQuotes**
> UpsertQuotesResponse upsertQuotes(scope, quotes)

[BETA] Upsert quotes

Upsert quotes effective at the specified time. If a quote is added with the same id (and is effective at the same time) as an existing quote, then the more recently added quote will be returned when queried  The maximum number of quotes that this method can upsert per request is 2,000.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.QuotesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://http:/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    QuotesApi apiInstance = new QuotesApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the quotes
    Map<String, UpsertQuoteRequest> quotes = new HashMap(); // Map<String, UpsertQuoteRequest> | The quotes to upsert
    try {
      UpsertQuotesResponse result = apiInstance.upsertQuotes(scope, quotes);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling QuotesApi#upsertQuotes");
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
 **scope** | **String**| The scope of the quotes |
 **quotes** | [**Map&lt;String, UpsertQuoteRequest&gt;**](UpsertQuoteRequest.md)| The quotes to upsert | [optional]

### Return type

[**UpsertQuotesResponse**](UpsertQuotesResponse.md)

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

