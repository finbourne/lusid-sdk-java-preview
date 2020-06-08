package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiClient;

import java.io.IOException;

public class LusidApiFactoryBuilder {

    /**
     * Build a {@link LusidApiFactory} defining configuration using environment variables. For details on the environment arguments see https://support.lusid.com/getting-started-with-apis-sdks.
     *
     * @return
     */
    public static LusidApiFactory build() throws IOException {
        return createLusidApiFactory("");
    }

    /**
     * Build a {@link LusidApiFactory} using the specified configuration file. For details on the format of the configuration file see https://support.lusid.com/getting-started-with-apis-sdks.
     */
    public static LusidApiFactory build(String configurationFile) throws IOException {
        return createLusidApiFactory(configurationFile);
    }

    /**
     * Build a {@link LusidApiFactory} using constant personal access tokens is not currently supported in the lusid java sdk
     */
    public static LusidApiFactory build(Object accessToken){
        throw new UnsupportedOperationException("Connecting to LUSID via flat access tokens is not yet supported in the LUSID java sdk.");
    }

    private static LusidApiFactory createLusidApiFactory(String configurationFile) throws IOException {
        ApiClient apiClient = new ApiClientBuilder().build(configurationFile);
        return new LusidApiFactory(apiClient);
    }
}
