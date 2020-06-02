package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.utilities.auth.HttpLusidTokenProvider;
import com.finbourne.lusid.utilities.auth.KeepAuthTokenProvider;
import com.finbourne.lusid.utilities.auth.LusidTokenException;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ApiClientBuilderIT {

    private ApiClientBuilder apiClientBuilder;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        apiClientBuilder = new ApiClientBuilder();
    }

    @Test
    public void build_OnValidConfigurationFile_ShouldBuildKeepLiveApiClient() throws ApiConfigurationException, LusidTokenException {
        // This test assumes default secrets file is valid. Same assertion as all other integration tests.
        ApiClient apiClient = apiClientBuilder.build(CredentialsSource.credentialsFile);
        // running with no exceptions ensures client built correctly with no configuration or token creation exceptions
        assertThat("Unexpected extended implementation of ApiClient for default build." ,
                apiClient, instanceOf(KeepLiveApiClient.class));
    }

    @Test
    public void build_OnNonExistingConfigurationFile_ShouldThrowException() throws ApiConfigurationException, LusidTokenException {
        thrown.expect(ApiConfigurationException.class);
        ApiClient apiClient = apiClientBuilder.build("doesNotExist");
    }

    @Test
    public void build_BadTokenConfigurationFile_ShouldThrowException() throws ApiConfigurationException, LusidTokenException {
        thrown.expect(LusidTokenException.class);
        ApiClient apiClient = apiClientBuilder.build("bad_token_credentials.json");
    }


}
