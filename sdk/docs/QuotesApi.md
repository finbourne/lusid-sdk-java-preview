# QuotesApi

All URIs are relative to *http://http:/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteQuotes**](QuotesApi.md#deleteQuotes) | **POST** /api/quotes/{scope}/$delete | [BETA] Delete quotes
[**getQuotes**](QuotesApi.md#getQuotes) | **POST** /api/quotes/{scope}/$get | [BETA] Get quotes
[**upsertQuotes**](QuotesApi.md#upsertQuotes) | **POST** /api/quotes/{scope} | [BETA] Upsert quotes


<a name="deleteQuotes"></a>
# **deleteQuotes**
> AnnulQuotesResponse deleteQuotes(scope, quotes)

[BETA] Delete quotes

Delete one or more specified quotes from a single scope. A quote is identified by its unique id which includes information about  the type of quote as well as the exact effective datetime (to the microsecond) from which it became valid.                In the request each quote must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each quote in the response.                The response will return both the collection of successfully deleted quotes, as well as those that failed.  For the failures a reason will be provided explaining why the quote could not be deleted.                It is important to always check the failed set for any unsuccessful results.

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
    String scope = "scope_example"; // String | The scope of the quotes to delete.
    Map<String, QuoteId> quotes = new HashMap(); // Map<String, QuoteId> | The quotes to delete keyed by a unique correlation id.
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
 **scope** | **String**| The scope of the quotes to delete. |
 **quotes** | [**Map&lt;String, QuoteId&gt;**](QuoteId.md)| The quotes to delete keyed by a unique correlation id. | [optional]

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
**200** | The successfully deleted quotes along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getQuotes"></a>
# **getQuotes**
> GetQuotesResponse getQuotes(scope, effectiveAt, asAt, maxAge, quoteIds)

[BETA] Get quotes

Get one or more quotes from a single scope.                Each quote can be identified by its time invariant quote series id.                For each quote series id LUSID will return the most recent quote with respect to the provided (or default) effective datetime.                 An optional maximum age range window can be specified which defines how far back to look back for a quote from the specified effective datetime.  LUSID will return the most recent quote within this window.                In the request each quote series id must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each quote in the response.                The response will return three collections. One, the successfully retrieved quotes. Two, those that had a  valid quote series id but could not be found. Three, those that failed because LUSID could not construct a valid quote series id from the request.    For the quotes that failed or could not be found a reason will be provided explaining why the quote could not be retrieved.                It is important to always check the failed and not found sets for any unsuccessful results.  The maximum number of quotes that this method can get per request is 2,000.

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
    String scope = "scope_example"; // String | The scope of the quotes to retrieve.
    String effectiveAt = "effectiveAt_example"; // String | The effective datetime or cut label at which to retrieve the quotes. Defaults to the current LUSID system datetime if not specified.
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The asAt datetime at which to retrieve the quotes. Defaults to return the latest version of each quote if not specified.
    String maxAge = "maxAge_example"; // String | The duration of the look back window in an ISO8601 time interval format e.g. P1Y2M3DT4H30M (1 year, 2 months, 3 days, 4 hours and 30 minutes).               This is subtracted from the provided effectiveAt datetime or cut label to generate a effective datetime window inside which a quote must exist to be retrieved.
    Map<String, QuoteSeriesId> quoteIds = new HashMap(); // Map<String, QuoteSeriesId> | The time invariant quote series ids of the quotes to retrieve. These need to be               keyed by a unique correlation id allowing the retrieved quote to be identified in the response.
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
 **scope** | **String**| The scope of the quotes to retrieve. |
 **effectiveAt** | **String**| The effective datetime or cut label at which to retrieve the quotes. Defaults to the current LUSID system datetime if not specified. | [optional]
 **asAt** | **OffsetDateTime**| The asAt datetime at which to retrieve the quotes. Defaults to return the latest version of each quote if not specified. | [optional]
 **maxAge** | **String**| The duration of the look back window in an ISO8601 time interval format e.g. P1Y2M3DT4H30M (1 year, 2 months, 3 days, 4 hours and 30 minutes).               This is subtracted from the provided effectiveAt datetime or cut label to generate a effective datetime window inside which a quote must exist to be retrieved. | [optional]
 **quoteIds** | [**Map&lt;String, QuoteSeriesId&gt;**](QuoteSeriesId.md)| The time invariant quote series ids of the quotes to retrieve. These need to be               keyed by a unique correlation id allowing the retrieved quote to be identified in the response. | [optional]

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
**200** | The successfully retrieved quotes along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="upsertQuotes"></a>
# **upsertQuotes**
> UpsertQuotesResponse upsertQuotes(scope, quotes)

[BETA] Upsert quotes

Update or insert one or more quotes in a single scope. A quote will be updated if it already exists  and inserted if it does not.                In the request each quote must be keyed by a unique correlation id. This id is ephemeral and is not stored by LUSID.  It serves only as a way to easily identify each quote in the response.                The response will return both the collection of successfully updated or inserted quotes, as well as those that failed.  For the failures a reason will be provided explaining why the quote could not be updated or inserted.                It is important to always check the failed set for any unsuccessful results.  The maximum number of quotes that this method can upsert per request is 2,000.

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
    String scope = "scope_example"; // String | The scope to use when updating or inserting the quotes.
    Map<String, UpsertQuoteRequest> quotes = new HashMap(); // Map<String, UpsertQuoteRequest> | The quotes to update or insert keyed by a unique correlation id.
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
 **scope** | **String**| The scope to use when updating or inserting the quotes. |
 **quotes** | [**Map&lt;String, UpsertQuoteRequest&gt;**](UpsertQuoteRequest.md)| The quotes to update or insert keyed by a unique correlation id. | [optional]

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
**200** | The successfully updated or inserted quotes along with any failures |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

