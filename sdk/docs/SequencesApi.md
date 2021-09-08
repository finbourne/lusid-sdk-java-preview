# SequencesApi

All URIs are relative to *http://local-unit-test-server.lusid.com:62389*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSequence**](SequencesApi.md#createSequence) | **POST** /api/sequences/{scope} | [EXPERIMENTAL] Create a new sequence
[**getSequenceDefinition**](SequencesApi.md#getSequenceDefinition) | **GET** /api/sequences/{scope}/{code} | [EXPERIMENTAL] Return the definition of a sequence
[**next**](SequencesApi.md#next) | **GET** /api/sequences/{scope}/{code}/next | [EXPERIMENTAL] Get the next set of values from the sequence


<a name="createSequence"></a>
# **createSequence**
> SequenceDefinition createSequence(scope, createSequenceRequest)

[EXPERIMENTAL] Create a new sequence

Create a new sequence

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SequencesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:62389");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SequencesApi apiInstance = new SequencesApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the sequence definition.
    CreateSequenceRequest createSequenceRequest = new CreateSequenceRequest(); // CreateSequenceRequest | Request to create sequence definition.
    try {
      SequenceDefinition result = apiInstance.createSequence(scope, createSequenceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SequencesApi#createSequence");
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
 **scope** | **String**| Scope of the sequence definition. |
 **createSequenceRequest** | [**CreateSequenceRequest**](CreateSequenceRequest.md)| Request to create sequence definition. | [optional]

### Return type

[**SequenceDefinition**](SequenceDefinition.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json-patch+json, application/json, text/json, application/_*+json
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Successful creation of the sequence |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getSequenceDefinition"></a>
# **getSequenceDefinition**
> SequenceDefinition getSequenceDefinition(scope, code)

[EXPERIMENTAL] Return the definition of a sequence

Return the detailed definition of a sequence

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SequencesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:62389");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SequencesApi apiInstance = new SequencesApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the sequence definition.
    String code = "code_example"; // String | Code of the sequence definition. This together with stated scope uniquely              identifies the sequence definition.
    try {
      SequenceDefinition result = apiInstance.getSequenceDefinition(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SequencesApi#getSequenceDefinition");
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
 **scope** | **String**| Scope of the sequence definition. |
 **code** | **String**| Code of the sequence definition. This together with stated scope uniquely              identifies the sequence definition. |

### Return type

[**SequenceDefinition**](SequenceDefinition.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The requested sequence |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="next"></a>
# **next**
> NextValueInSequenceResponse next(scope, code, batch)

[EXPERIMENTAL] Get the next set of values from the sequence

Get the next set of values from the sequence

### Example
```java
// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.SequencesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:62389");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SequencesApi apiInstance = new SequencesApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the sequence definition.
    String code = "code_example"; // String | Code of the sequence definition. This together with stated scope uniquely              identifies the sequence definition.
    Integer batch = 1; // Integer | Number of sequences items to return for the specified sequence definition.
    try {
      NextValueInSequenceResponse result = apiInstance.next(scope, code, batch);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SequencesApi#next");
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
 **scope** | **String**| Scope of the sequence definition. |
 **code** | **String**| Code of the sequence definition. This together with stated scope uniquely              identifies the sequence definition. |
 **batch** | **Integer**| Number of sequences items to return for the specified sequence definition. | [optional] [default to 1]

### Return type

[**NextValueInSequenceResponse**](NextValueInSequenceResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json, text/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Gets the next set of values for the sequence |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

