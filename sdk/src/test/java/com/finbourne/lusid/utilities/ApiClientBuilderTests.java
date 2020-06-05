package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.utilities.auth.LusidTokenException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ApiClientBuilderTests {

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
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(CredentialsSource.credentialsFile);
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);
        // running with no exceptions ensures client built correctly with no configuration or token creation exceptions
        assertThat("Unexpected extended implementation of ApiClient for default build." ,
                apiClient, instanceOf(RefreshingTokenApiClient.class));
    }

    @Test
    public void build_OnNonExistingConfigurationFile_ShouldThrowException() throws ApiConfigurationException, LusidTokenException {
        thrown.expect(ApiConfigurationException.class);
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build("doesNotExist");
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);
    }

    @Test
    public void build_BadTokenConfigurationFile_ShouldThrowException() throws ApiConfigurationException, LusidTokenException {
        thrown.expect(LusidTokenException.class);
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build("bad_token_credentials.json");
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);
    }


}
