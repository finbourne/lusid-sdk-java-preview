package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.utilities.auth.LusidTokenException;

public class LusidApiFactoryBuilder {

    /**
     * Build a {@link LusidApiFactory} defining configuration using environment variables. For details on the environment arguments see https://support.lusid.com/getting-started-with-apis-sdks.
     *
     * @return
     */
    public static LusidApiFactory build() throws ApiConfigurationException, LusidTokenException {
        if (!areRequiredEnvironmentVariablesSet()) {
            throw new ApiConfigurationException("Environment variables to configure LUSID API client have not been set. See " +
                    " see https://support.lusid.com/getting-started-with-apis-sdks for details.");
        }
        return createLusidApiFactory("");
    }

    /**
     * Build a {@link LusidApiFactory} using the specified configuration file. For details on the format of the configuration file see https://support.lusid.com/getting-started-with-apis-sdks.
     */
    public static LusidApiFactory build(String configurationFile) throws ApiConfigurationException, LusidTokenException {
        return createLusidApiFactory(configurationFile);
    }

    private static LusidApiFactory createLusidApiFactory(String configurationFile) throws ApiConfigurationException, LusidTokenException {
        ApiConfiguration apiConfiguration = new ApiConfigurationBuilder().build(configurationFile);
        ApiClient apiClient = new ApiClientBuilder().build(apiConfiguration);
        return new LusidApiFactory(apiClient);
    }

    private static boolean areRequiredEnvironmentVariablesSet(){
        return (System.getenv("FBN_TOKEN_URL") != null &&
                System.getenv("FBN_USERNAME") != null &&
                System.getenv("FBN_PASSWORD") != null &&
                System.getenv("FBN_CLIENT_ID") != null &&
                System.getenv("FBN_CLIENT_SECRET") != null &&
                System.getenv("FBN_LUSID_API_URL") != null);
    }
}
