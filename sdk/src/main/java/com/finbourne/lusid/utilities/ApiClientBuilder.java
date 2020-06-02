package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.utilities.auth.HttpLusidTokenProvider;
import com.finbourne.lusid.utilities.auth.KeepAuthTokenProvider;
import com.finbourne.lusid.utilities.auth.LusidToken;
import com.finbourne.lusid.utilities.auth.LusidTokenException;
import okhttp3.OkHttpClient;

/**
 * Utility class to build an ApiClient from a set of configuration
 */
public class ApiClientBuilder {

    /**
     * Builds an ApiClient implementation configured against a secrets file. Typically used
     * for communicating with LUSID via the APIs (e.g. {@link com.finbourne.lusid.api.TransactionPortfoliosApi}, {@link com.finbourne.lusid.api.QuotesApi}.
     *
     * ApiClient implementation enables use of REFRESH tokens (see https://support.finbourne.com/using-a-refresh-token)
     * and automatically handles token refreshing on expiry.
     *
     * @param apiSecretsFilename
     * @return
     *
     * @throws ApiConfigurationException on failing to create a valid {@link ApiConfiguration} from the provided
     * secrets file or system environment variables
     * @throws LusidTokenException on failing to authenticate and retrieve an initial {@link LusidToken}
     */
    public ApiClient build(String apiSecretsFilename) throws ApiConfigurationException, LusidTokenException {
        // setup configuration from secrets file
        ApiConfiguration apiConfiguration = createApiConfiguration(apiSecretsFilename);
        // http client to use for api and auth calls
        OkHttpClient httpClient = createHttpClient(apiConfiguration);

        // token provider to keep client authenticated with automated token refreshing
        KeepAuthTokenProvider keepAuthTokenProvider = new KeepAuthTokenProvider(new HttpLusidTokenProvider(apiConfiguration, httpClient));
        LusidToken lusidToken = keepAuthTokenProvider.get();

        // setup api client that managed submissions with latest token
        ApiClient defaultApiClient = createDefaultApiClient(apiConfiguration, httpClient, lusidToken);
        return new KeepAuthApiClient(defaultApiClient, keepAuthTokenProvider);
    }

    private ApiClient createDefaultApiClient(ApiConfiguration apiConfiguration, OkHttpClient httpClient, LusidToken lusidToken){
        ApiClient apiClient = new ApiClient();

        if (apiConfiguration.getProxyAddress() != null) {
            apiClient.setHttpClient(httpClient);
        }

        apiClient.addDefaultHeader("Authorization", "Bearer " + lusidToken.getAccessToken());
        apiClient.addDefaultHeader("X-LUSID-Application", apiConfiguration.getApplicationName());
        apiClient.setBasePath(apiConfiguration.getApiUrl());

        return  apiClient;
    }

    private ApiConfiguration createApiConfiguration(String apiSecretsFilename) throws ApiConfigurationException {
        return new ApiConfigurationBuilder().build(apiSecretsFilename);
    }

    private OkHttpClient createHttpClient(ApiConfiguration apiConfiguration){
        return new HttpClientBuilder().build(apiConfiguration);
    }
}
