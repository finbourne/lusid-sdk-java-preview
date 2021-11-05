# SequencesApi

All URIs are relative to *http://local-unit-test-server.lusid.com:34330*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSequence**](SequencesApi.md#createSequence) | **POST** /api/sequences/{scope} | [EXPERIMENTAL] CreateSequence: Create a new sequence
[**getSequence**](SequencesApi.md#getSequence) | **GET** /api/sequences/{scope}/{code} | [EXPERIMENTAL] GetSequence: Get a specified sequence
[**next**](SequencesApi.md#next) | **GET** /api/sequences/{scope}/{code}/next | [EXPERIMENTAL] Next: Get next values from sequence


<a name="createSequence"></a>
# **createSequence**
> SequenceDefinition createSequence(scope, createSequenceRequest)

[EXPERIMENTAL] CreateSequence: Create a new sequence

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:34330");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SequencesApi apiInstance = new SequencesApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the sequence.
    CreateSequenceRequest createSequenceRequest = new CreateSequenceRequest(); // CreateSequenceRequest | Request to create sequence
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
 **scope** | **String**| Scope of the sequence. |
 **createSequenceRequest** | [**CreateSequenceRequest**](CreateSequenceRequest.md)| Request to create sequence |

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
**201** | The newly created Sequence |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

<a name="getSequence"></a>
# **getSequence**
> SequenceDefinition getSequence(scope, code)

[EXPERIMENTAL] GetSequence: Get a specified sequence

Return the details of a specified sequence

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:34330");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SequencesApi apiInstance = new SequencesApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the sequence.
    String code = "code_example"; // String | Code of the sequence. This together with stated scope uniquely              identifies the sequence.
    try {
      SequenceDefinition result = apiInstance.getSequence(scope, code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SequencesApi#getSequence");
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
 **scope** | **String**| Scope of the sequence. |
 **code** | **String**| Code of the sequence. This together with stated scope uniquely              identifies the sequence. |

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

[EXPERIMENTAL] Next: Get next values from sequence

Get the next set of values from a specified sequence

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
    defaultClient.setBasePath("http://local-unit-test-server.lusid.com:34330");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    SequencesApi apiInstance = new SequencesApi(defaultClient);
    String scope = "scope_example"; // String | Scope of the sequence.
    String code = "code_example"; // String | Code of the sequence. This together with stated scope uniquely              identifies the sequence.
    Integer batch = 56; // Integer | Number of sequences items to return for the specified sequence. Default to 1 if not specified.
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
 **scope** | **String**| Scope of the sequence. |
 **code** | **String**| Code of the sequence. This together with stated scope uniquely              identifies the sequence. |
 **batch** | **Integer**| Number of sequences items to return for the specified sequence. Default to 1 if not specified. | [optional]

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
**200** | The response containing next available values in specified sequence. |  -  |
**400** | The details of the input related failure |  -  |
**0** | Error response |  -  |

