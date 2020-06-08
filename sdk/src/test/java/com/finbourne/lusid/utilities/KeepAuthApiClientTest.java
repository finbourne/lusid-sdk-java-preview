package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiCallback;
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Pair;
import com.finbourne.lusid.utilities.auth.KeepAuthTokenProvider;
import com.finbourne.lusid.utilities.auth.LusidToken;
import com.finbourne.lusid.utilities.auth.LusidTokenException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class KeepAuthApiClientTest {

    private KeepAuthApiClient keepAuthApiClient;

    // mock dependencies
    private ApiClient defaultApiClient;
    private KeepAuthTokenProvider tokenProvider;

    // mock tokens
    private LusidToken lusidToken = new LusidToken("access_01", "refresh_01", LocalDateTime.now());
    private LusidToken anotherLusidToken = new LusidToken("access_02", "refresh_01", LocalDateTime.now());

    // call params
    private String path = "/get_portfolios";
    private String method = "GET";
    private List<Pair> queryParams = new ArrayList<>();
    private List<Pair> collectionQueryParams = new ArrayList<>();
    private Object body = new Object();
    private Map<String,String> headerParams = new HashMap<>();
    private Map<String,Object> formParams = new HashMap<>();
    private String[] authNames = new String[]{};
    private ApiCallback apiCallback = mock(ApiCallback.class);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws LusidTokenException {
        defaultApiClient = mock(ApiClient.class);
        tokenProvider = mock(KeepAuthTokenProvider.class);

        doReturn(lusidToken).when(tokenProvider).get();

        keepAuthApiClient = new KeepAuthApiClient(defaultApiClient, tokenProvider);
    }

    @Test
    public void buildCall_ShouldUpdateAuthHeaderAndDelegateBuildCall() throws ApiException {
        keepAuthApiClient.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
        verify(defaultApiClient).addDefaultHeader("Authorization", "Bearer access_01");
        verify(defaultApiClient).buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
    }

    @Test
    public void buildCall_ShouldUpdateAuthHeaderOnEveryCall() throws ApiException, LusidTokenException {
        keepAuthApiClient.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
        verify(defaultApiClient).addDefaultHeader("Authorization", "Bearer access_01");
        verify(defaultApiClient).buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);

        doReturn(anotherLusidToken).when(tokenProvider).get();

        keepAuthApiClient.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
        verify(defaultApiClient).addDefaultHeader("Authorization", "Bearer access_02");
        verify(defaultApiClient, times(2)).buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
    }

    @Test
    public void buildCall_OnExceptionRetrievingToken_ShouldThrowApiException() throws LusidTokenException, ApiException {
        LusidTokenException lusidTokenException = new LusidTokenException("Failed to create token for some reason");
        doThrow(lusidTokenException).when(tokenProvider).get();
        thrown.expect(ApiException.class);
        thrown.expectCause(equalTo(lusidTokenException));

        keepAuthApiClient.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
    }

    @Test
    public void buidCall_OnUnderlyingApiClientException_ShouldRethrowExactException() throws ApiException {
        ApiException apiException = new ApiException("An API call failure");
        doThrow(apiException).when(defaultApiClient).buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
        try {
            keepAuthApiClient.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, apiCallback);
        } catch (ApiException e){
            assertThat(e, sameInstance(apiException));
        }
    }

}
