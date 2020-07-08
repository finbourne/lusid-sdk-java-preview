package com.finbourne.lusid.utilities;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.finbourne.lusid.utilities.TestContants.DUMMY_CREDENTIALS_FILE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class ApiConfigurationBuilderTests {

    ApiConfigurationBuilder apiConfigurationBuilder;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        apiConfigurationBuilder = spy(new ApiConfigurationBuilder());
    }

    @Test
    public void build_WithUnsetEnvironmentVariables_ShouldGetFromFile() throws ApiConfigurationException {
        doReturn(emptyConfigFromEnvVariables()).when(apiConfigurationBuilder)
                .getApiConfigurationFromEnvironmentVariables();

        ApiConfiguration apiConfiguration = apiConfigurationBuilder.build(DUMMY_CREDENTIALS_FILE);

        assertThat(apiConfiguration.getApiUrl(), equalTo("https://some-non-existing-test-instance.lusid.com/api"));
        assertThat(apiConfiguration.getTokenUrl(), equalTo("https://some-non-existing-test-instance.doesnotexist.com/oauth2/doesnotexist/v1/token"));
        assertThat(apiConfiguration.getClientId(), equalTo("client-id"));
        assertThat(apiConfiguration.getClientSecret(), equalTo("secret"));
        assertThat(apiConfiguration.getUsername(), equalTo("user"));
        assertThat(apiConfiguration.getPassword(), equalTo("pass"));
        assertThat(apiConfiguration.getApplicationName(), equalTo("non-existent"));
    }

    @Test
    public void build_WithSetEnvironmentVariables_ShouldGetFromEnvironmentVariables() throws ApiConfigurationException {
        doReturn(validConfigFromEnvVariables()).when(apiConfigurationBuilder)
                .getApiConfigurationFromEnvironmentVariables();

        ApiConfiguration apiConfiguration = apiConfigurationBuilder.build("does_not_matter");

        assertThat(apiConfiguration.getApiUrl(), equalTo("https://some-non-existing-test-instance.lusid.com/api"));
        assertThat(apiConfiguration.getTokenUrl(), equalTo("https://some-non-existing-test-instance.doesnotexist.com/oauth2/doesnotexist/v1/token"));
        assertThat(apiConfiguration.getClientId(), equalTo("client-id-from-env"));
        assertThat(apiConfiguration.getClientSecret(), equalTo("secret-from-env"));
        assertThat(apiConfiguration.getUsername(), equalTo("user"));
        assertThat(apiConfiguration.getPassword(), equalTo("pass"));
        assertThat(apiConfiguration.getApplicationName(), equalTo("non-existent"));
    }

    @Test
    public void build_OnNonExistingConfigurationFile_ShouldThrowException() throws ApiConfigurationException {
        doReturn(emptyConfigFromEnvVariables()).when(apiConfigurationBuilder)
                .getApiConfigurationFromEnvironmentVariables();

        thrown.expect(ApiConfigurationException.class);
        apiConfigurationBuilder.build("does not exist");
    }

    ApiConfiguration emptyConfigFromEnvVariables(){
        return new ApiConfiguration(null,null,null,null,null,null,null,null,null,null,null);
    }

    ApiConfiguration validConfigFromEnvVariables(){
        return new ApiConfiguration("https://some-non-existing-test-instance.doesnotexist.com/oauth2/doesnotexist/v1/token","user","pass","client-id-from-env","secret-from-env","https://some-non-existing-test-instance.lusid.com/api","non-existent",null,null,null,null);
    }


}
