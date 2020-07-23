# CalendarsApi

All URIs are relative to *http://localhost:61175*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addDateToCalendar**](CalendarsApi.md#addDateToCalendar) | **PUT** /api/calendar/generic/{scope}/{code}/dates | [EXPERIMENTAL] Add a date to a calendar
[**createCalendar**](CalendarsApi.md#createCalendar) | **POST** /api/calendar/generic | [EXPERIMENTAL] Create a calendar in its generic form
[**deleteCalendar**](CalendarsApi.md#deleteCalendar) | **DELETE** /api/calendar/generic/{scope}/{code} | [EXPERIMENTAL] Delete a calendar
[**deleteDateFromCalendar**](CalendarsApi.md#deleteDateFromCalendar) | **DELETE** /api/calendar/generic/{scope}/{code}/dates/{dateId} | [EXPERIMENTAL] Remove a date from a calendar
[**getCalendar**](CalendarsApi.md#getCalendar) | **GET** /api/calendar/generic/{scope}/{code} | [EXPERIMENTAL] Get a calendar in its generic form
[**getDates**](CalendarsApi.md#getDates) | **GET** /api/calendar/generic/{scope}/{code}/dates | [EXPERIMENTAL] Get dates for a specific calendar
[**updateCalendar**](CalendarsApi.md#updateCalendar) | **PUT** /api/calendar/generic/{scope}/{code}/mask | [EXPERIMENTAL] Update a calendar


<a name="addDateToCalendar"></a>
# **addDateToCalendar**
> CalendarDate addDateToCalendar(scope, code, createDateRequest)

[EXPERIMENTAL] Add a date to a calendar

Add an event to the calendar. These Events can be a maximum of 24 hours and must be specified in UTC.  A local date will be calculated by the system and applied to the calendar before processing.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CalendarsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CalendarsApi apiInstance = new CalendarsApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the calendar
    String code = "code_example"; // String | Code of the calendar
    CreateDateRequest createDateRequest = {"dateId":"TestDate","fromUtc":"2020-02-12T12:00:00+00:00","toUtc":"2020-02-13T12:00:00+00:00","timeZone":"CET","description":"Chinese New year","type":"Holiday","sourceData":{}}; // CreateDateRequest | Add date to calendar request
    try {
      CalendarDate result = apiInstance.addDateToCalendar(scope, code, createDateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarsApi#addDateToCalendar");
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
 **scope** | **String**| Scope of the calendar |
 **code** | **String**| Code of the calendar |
 **createDateRequest** | [**CreateDateRequest**](CreateDateRequest.md)| Add date to calendar request |

### Return type

[**CalendarDate**](CalendarDate.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created date |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="createCalendar"></a>
# **createCalendar**
> Calendar createCalendar(createCalendarRequest)

[EXPERIMENTAL] Create a calendar in its generic form

Create a calendar in a generic form which can be used to store date events.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CalendarsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CalendarsApi apiInstance = new CalendarsApi(defaultClient);
    CreateCalendarRequest createCalendarRequest = {"calendarId":{"scope":"TestScope","code":"TestCode"},"calendarType":"Holiday","weekendMask":{"days":["Saturday","Sunday"],"timeZone":"UTC"},"sourceProvider":"Finbourne Calendar Service","properties":[{"key":"Calendar/default/Center","value":{"labelValue":"CBTR"}}]}; // CreateCalendarRequest | A request to create the calendar
    try {
      Calendar result = apiInstance.createCalendar(createCalendarRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarsApi#createCalendar");
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
 **createCalendarRequest** | [**CreateCalendarRequest**](CreateCalendarRequest.md)| A request to create the calendar |

### Return type

[**Calendar**](Calendar.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The created calendar |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deleteCalendar"></a>
# **deleteCalendar**
> Calendar deleteCalendar(scope, code)

[EXPERIMENTAL] Delete a calendar

Delete a calendar and all of its respective dates

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CalendarsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CalendarsApi apiInstance = new CalendarsApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the calendar
    String code = "code_example"; // String | Code of the calendar
    try {
      Calendar result = apiInstance.deleteCalendar(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarsApi#deleteCalendar");
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
 **scope** | **String**| Scope of the calendar |
 **code** | **String**| Code of the calendar |

### Return type

[**Calendar**](Calendar.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The deleted calendar |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="deleteDateFromCalendar"></a>
# **deleteDateFromCalendar**
> CalendarDate deleteDateFromCalendar(scope, code, dateId)

[EXPERIMENTAL] Remove a date from a calendar

Remove a date from a calendar.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CalendarsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CalendarsApi apiInstance = new CalendarsApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the calendar
    String code = "code_example"; // String | Code of the calendar
    String dateId = "dateId_example"; // String | Identifier of the date to be removed
    try {
      CalendarDate result = apiInstance.deleteDateFromCalendar(scope, code, dateId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarsApi#deleteDateFromCalendar");
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
 **scope** | **String**| Scope of the calendar |
 **code** | **String**| Code of the calendar |
 **dateId** | **String**| Identifier of the date to be removed |

### Return type

[**CalendarDate**](CalendarDate.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The deleted date |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getCalendar"></a>
# **getCalendar**
> Calendar getCalendar(scope, code, asAt)

[EXPERIMENTAL] Get a calendar in its generic form

Retrieve a generic calendar by a specific ID at a point in AsAt time

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CalendarsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CalendarsApi apiInstance = new CalendarsApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the calendar identifier
    String code = "code_example"; // String | Code of the calendar identifier
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | The AsAt datetime at which to retrieve the calendar
    try {
      Calendar result = apiInstance.getCalendar(scope, code, asAt);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarsApi#getCalendar");
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
 **scope** | **String**| Scope of the calendar identifier |
 **code** | **String**| Code of the calendar identifier |
 **asAt** | **OffsetDateTime**| The AsAt datetime at which to retrieve the calendar | [optional]

### Return type

[**Calendar**](Calendar.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested calendar |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getDates"></a>
# **getDates**
> ResourceListOfCalendarDate getDates(scope, code, fromEffectiveAt, toEffectiveAt, asAt, idFilter)

[EXPERIMENTAL] Get dates for a specific calendar

Get dates from a specific calendar within a specific window of effective time, at a point in AsAt time.  Providing an id filter can further refine the results.

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CalendarsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CalendarsApi apiInstance = new CalendarsApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the calendar
    String code = "code_example"; // String | Code of the calendar
    String fromEffectiveAt = "fromEffectiveAt_example"; // String | Where the effective window of dates should begin from
    String toEffectiveAt = "toEffectiveAt_example"; // String | Where the effective window of dates should end
    OffsetDateTime asAt = new OffsetDateTime(); // OffsetDateTime | AsAt the dates should be retrieved at
    List<String> idFilter = Arrays.asList(); // List<String> | An additional filter that will filter dates based on their identifer
    try {
      ResourceListOfCalendarDate result = apiInstance.getDates(scope, code, fromEffectiveAt, toEffectiveAt, asAt, idFilter);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarsApi#getDates");
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
 **scope** | **String**| Scope of the calendar |
 **code** | **String**| Code of the calendar |
 **fromEffectiveAt** | **String**| Where the effective window of dates should begin from | [optional]
 **toEffectiveAt** | **String**| Where the effective window of dates should end | [optional]
 **asAt** | **OffsetDateTime**| AsAt the dates should be retrieved at | [optional]
 **idFilter** | [**List&lt;String&gt;**](String.md)| An additional filter that will filter dates based on their identifer | [optional]

### Return type

[**ResourceListOfCalendarDate**](ResourceListOfCalendarDate.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested date |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="updateCalendar"></a>
# **updateCalendar**
> Calendar updateCalendar(scope, code, updateCalendarRequest)

[EXPERIMENTAL] Update a calendar

Update the calendars WeekendMask, SourceProvider or Properties

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.CalendarsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:61175");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    CalendarsApi apiInstance = new CalendarsApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the request
    String code = "code_example"; // String | Code of the request
    UpdateCalendarRequest updateCalendarRequest = {"weekendMask":{"days":["Saturday","Sunday"],"timeZone":"UTC"},"sourceProvider":"Finbourne Calendar Service","properties":[{"key":"Calendar/default/Center","value":{"labelValue":"CBTR"}}]}; // UpdateCalendarRequest | The new state of the calendar
    try {
      Calendar result = apiInstance.updateCalendar(scope, code, updateCalendarRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CalendarsApi#updateCalendar");
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
 **scope** | **String**| Scope of the request |
 **code** | **String**| Code of the request |
 **updateCalendarRequest** | [**UpdateCalendarRequest**](UpdateCalendarRequest.md)| The new state of the calendar |

### Return type

[**Calendar**](Calendar.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The updated calendar |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

