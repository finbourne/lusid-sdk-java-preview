package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.utilities.auth.LusidTokenException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

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
    public void build_BadTokenConfigurationFile_ShouldThrowException() throws LusidTokenException {
        thrown.expect(LusidTokenException.class);
        ApiConfiguration apiConfiguration = getBadTokenConfiguration();
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);
    }

    private ApiConfiguration getBadTokenConfiguration(){
        return new ApiConfiguration(
                "https://some-non-existing-test-instance.doesnotexist.com/oauth2/doesnotexist/v1/token",
                "test.testing@finbourne.com",
                "note",
                "invalid-client-id",
                "none",
                "https://some-non-existing-test-instance.lusid.com/api",
                "non-existent",
                // proxy strs
                "",8888,"",""
        );
    }


}
