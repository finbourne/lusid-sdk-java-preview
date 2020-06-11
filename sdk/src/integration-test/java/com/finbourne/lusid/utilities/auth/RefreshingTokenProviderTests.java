package com.finbourne.lusid.utilities.auth;

import com.finbourne.lusid.utilities.*;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class RefreshingTokenProviderTests {

    private RefreshingTokenProvider tokenProvider;
    private HttpLusidTokenProvider httpLusidTokenProvider;

    @Before
    public void setUp() throws ApiConfigurationException {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        OkHttpClient httpClient = new HttpClientFactory().build(apiConfiguration);
        httpLusidTokenProvider = new HttpLusidTokenProvider(apiConfiguration, httpClient);
        RefreshingTokenProvider instanceToSpy = new RefreshingTokenProvider(httpLusidTokenProvider);
        tokenProvider = spy(instanceToSpy);
    }

    @Test
    public void get_OnNoCurrentToken_ShouldReturnNewToken() throws LusidTokenException {
        LusidToken lusidToken = tokenProvider.get();
        assertThat(lusidToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getExpiresAt(), not(nullValue()));
    }

    @Test
    public void get_OnNonExpiredCurrentToken_ShouldReturnSameToken() throws LusidTokenException {
        // first call should create a token
        LusidToken lusidToken = tokenProvider.get();

        // mock token not expired
        doReturn(false).when(tokenProvider).isTokenExpired(lusidToken);

        // second call return same token as it has not expired
        LusidToken nextLusidToken = tokenProvider.get();

        assertThat(nextLusidToken, sameInstance(lusidToken));
    }

    @Test
    public void get_OnExpiredCurrentToken_ShouldReturnNewToken() throws LusidTokenException {
        // first call should create a token
        LusidToken lusidToken = tokenProvider.get();

        // mock token expired
        doReturn(true).when(tokenProvider).isTokenExpired(lusidToken);

        // second call should return a new token as the current one has expired
        LusidToken nextLusidToken = tokenProvider.get();

        assertThat(nextLusidToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(nextLusidToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(nextLusidToken.getExpiresAt(), not(nullValue()));

        assertThat(nextLusidToken, not(equalTo(lusidToken)));
        assertThat(nextLusidToken.getAccessToken(), not(equalTo(lusidToken.getAccessToken())));
        assertThat(nextLusidToken.getExpiresAt(), not(equalTo(lusidToken.getExpiresAt())));
        // although a new token the refresh token parameter should remain constant
        assertThat(nextLusidToken.getRefreshToken(), equalTo(lusidToken.getRefreshToken()));
    }



}
