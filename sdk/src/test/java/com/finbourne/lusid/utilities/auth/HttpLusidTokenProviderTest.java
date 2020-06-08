package com.finbourne.lusid.utilities.auth;

import com.finbourne.lusid.utilities.ApiConfiguration;
import com.finbourne.lusid.utilities.ApiConfigurationBuilder;
import com.finbourne.lusid.utilities.CredentialsSource;
import com.finbourne.lusid.utilities.HttpClientBuilder;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.mockito.Mockito.mock;

public class HttpLusidTokenProviderTest {

    private HttpLusidTokenProvider httpLusidTokenProvider;

    @Before
    public void setUp() throws IOException {
        ApiConfiguration apiConfiguration = mock(ApiConfiguration.class);
        OkHttpClient httpClient = mock(OkHttpClient.class);
        httpLusidTokenProvider = new HttpLusidTokenProvider(apiConfiguration, httpClient);
    }

    @Test
    public void calculateExpiryAtTime_ShouldApplyThirySecondCut(){
        LocalDateTime authTime = LocalDateTime.of(2020,01,01,00,00,00);
        int expiryIn = 3600;

        LocalDateTime expiryAt = httpLusidTokenProvider.calculateExpiryAtTime(authTime, expiryIn);

        assertThat("Expiry At time should be an hour ahead of the time of auth call minus a 30 second gap for " +
                        "race condition when token is very close to expiry time and valid on retrieval but not when used.",
                expiryAt,
                equalTo(LocalDateTime.of(2020,01,01,00,59,30)));
    }

}
