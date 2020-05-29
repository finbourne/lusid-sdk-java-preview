package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.api.ScopesApi;
import com.finbourne.lusid.model.ResourceListOfScopeDefinition;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LusidApiFactoryBuilderIT {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void build_WithExistingConfigurationFile_ShouldReturnFactory() throws IOException, ApiException {
        LusidApiFactory lusidApiFactory = LusidApiFactoryBuilder.build(CredentialsSource.credentialsFile);
        assertThat(lusidApiFactory, is(notNullValue()));
        assertThatFactoryBuiltApiCanMakeLUSIDCalls(lusidApiFactory);
    }

    @Test
    public void build_WithNonExistingConfigurationFile_ShouldThrowException() throws IOException {
        thrown.expect(IOException.class);
        LusidApiFactoryBuilder.build("doesNotExist");
    }

    @Test
    public void build_WithUnsetEnvironmentVariablesConfig_ShouldThrowException() throws IOException {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Environment variables to configure LUSID API client have not been set. See " +
                " see https://support.lusid.com/getting-started-with-apis-sdks for details.");
        LusidApiFactoryBuilder.build();
    }

    private static void assertThatFactoryBuiltApiCanMakeLUSIDCalls(LusidApiFactory lusidApiFactory) throws ApiException {
        ScopesApi scopesApi = lusidApiFactory.build(ScopesApi.class);
        ResourceListOfScopeDefinition scopeDefinitions = scopesApi.listScopes("");
        assertThat("Scopes API created by factory should have produced scope definition"
                , scopeDefinitions, is(notNullValue()));
    }

}
