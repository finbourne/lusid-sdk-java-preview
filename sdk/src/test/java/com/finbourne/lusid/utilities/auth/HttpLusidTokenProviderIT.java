package com.finbourne.lusid.utilities.auth;

import com.finbourne.lusid.utilities.ApiConfiguration;
import com.finbourne.lusid.utilities.ApiConfigurationBuilder;
import com.finbourne.lusid.utilities.CredentialsSource;
import com.finbourne.lusid.utilities.HttpClientBuilder;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class HttpLusidTokenProviderIT {

    private HttpLusidTokenProvider httpLusidTokenProvider;

    @Before
    public void setUp() throws IOException {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        OkHttpClient httpClient = new HttpClientBuilder().build(apiConfiguration);
        httpLusidTokenProvider = new HttpLusidTokenProvider(apiConfiguration, httpClient);
    }

    @Test
    public void getToken_OnNoRefreshToken_ShouldReturnNewToken(){
        LusidToken lusidToken = httpLusidTokenProvider.getToken(Optional.empty());

        assertThat(lusidToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(lusidToken.getExpiresAt(), not(nullValue()));
    }

    @Test
    public void getToken_OnRefreshToken_ShouldReturnNewRefreshedToken(){
        LusidToken initialToken = httpLusidTokenProvider.getToken(Optional.empty());
        LusidToken refreshedToken = httpLusidTokenProvider.getToken(Optional.of(initialToken.getRefreshToken()));

        assertThat(refreshedToken.getAccessToken(), not(isEmptyOrNullString()));
        assertThat(refreshedToken.getRefreshToken(), not(isEmptyOrNullString()));
        assertThat(refreshedToken.getExpiresAt(), not(nullValue()));
        assertThat(refreshedToken, not(equalTo(initialToken)));
    }

    // Error cases
    @Test(expected = IllegalArgumentException.class)
    public void getToken_OnBadTokenUrl() throws IOException {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        OkHttpClient httpClient = new HttpClientBuilder().build(apiConfiguration);
        apiConfiguration.setTokenUrl("invalidTokenUrl");

        HttpLusidTokenProvider httpLusidTokenProvider = new HttpLusidTokenProvider(apiConfiguration, httpClient);
        LusidToken lusidToken = httpLusidTokenProvider.getToken(Optional.empty());
    }
}
