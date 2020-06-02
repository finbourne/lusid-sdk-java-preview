package com.finbourne.lusid.utilities.auth;

import com.finbourne.lusid.utilities.ApiConfiguration;
import com.finbourne.lusid.utilities.ApiConfigurationBuilder;
import com.finbourne.lusid.utilities.CredentialsSource;
import com.finbourne.lusid.utilities.HttpClientBuilder;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class KeepAuthTokenProviderIT {

    private KeepAuthTokenProvider tokenProvider;
    private HttpLusidTokenProvider httpLusidTokenProvider;

    @Before
    public void setUp() throws IOException {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        OkHttpClient httpClient = new HttpClientBuilder().build(apiConfiguration);
        httpLusidTokenProvider = new HttpLusidTokenProvider(apiConfiguration, httpClient);
        KeepAuthTokenProvider instanceToSpy = new KeepAuthTokenProvider(httpLusidTokenProvider);
        tokenProvider = spy(instanceToSpy);
    }

    @Test
    public void get_OnNoCurrentToken_ShouldReturnNewToken(){
        LusidToken lusidToken = tokenProvider.get();
        assertThat(lusidToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getExpiresAt(), not(nullValue()));
    }

    @Test
    public void get_OnNonExpiredCurrentToken_ShouldReturnSameToken(){
        // first call should create a token
        LusidToken lusidToken = tokenProvider.get();

        // mock token not expired
        doReturn(false).when(tokenProvider).isTokenExpired(lusidToken);

        // second call should check for expiry
        LusidToken nextLusidToken = tokenProvider.get();

        assertThat(nextLusidToken, equalTo(lusidToken));
    }

    @Test
    public void get_OnExpiredCurrentToken_ShouldReturnNewToken(){
        // first call should create a token
        LusidToken lusidToken = tokenProvider.get();

        // mock token expired
        doReturn(true).when(tokenProvider).isTokenExpired(lusidToken);

        // second call should check for expiry
        LusidToken nextLusidToken = tokenProvider.get();

        assertThat(nextLusidToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(nextLusidToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(nextLusidToken.getExpiresAt(), not(nullValue()));
        assertThat(nextLusidToken, not(equalTo(lusidToken)));
    }



}
