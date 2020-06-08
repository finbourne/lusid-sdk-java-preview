package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.utilities.auth.HttpLusidTokenProvider;
import com.finbourne.lusid.utilities.auth.KeepAuthTokenProvider;
import com.finbourne.lusid.utilities.auth.LusidToken;
import okhttp3.OkHttpClient;

import java.io.IOException;

/**
 * Utility class to build an ApiClient from a set of configuration
 */
public class ApiClientBuilder {

    public ApiClient build(String apiSecretsFilename){
        // setup configuration from secrets file
        ApiConfiguration apiConfiguration = createApiConfiguration(apiSecretsFilename);
        // http client to use for api and auth calls
        OkHttpClient httpClient = createHttpClient(apiConfiguration);

        // token provider to keep client authenticated with automated token refreshing
        KeepAuthTokenProvider keepAuthTokenProvider = new KeepAuthTokenProvider(new HttpLusidTokenProvider(apiConfiguration, httpClient));
        LusidToken lusidToken = keepAuthTokenProvider.get();

        // setup api client that managed submissions with latest token
        ApiClient defaultApiClient = createDefaultApiClient(apiConfiguration, httpClient, lusidToken);
        return new KeepLiveApiClient(defaultApiClient, keepAuthTokenProvider);
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

    private ApiConfiguration createApiConfiguration(String apiSecretsFilename){
        try {
            return new ApiConfigurationBuilder().build(apiSecretsFilename);
        } catch (IOException e) {
            throw new RuntimeException("Failed to build API Configuration. Ensure secrets files is properly setup.", e);
        }
    }

    private OkHttpClient createHttpClient(ApiConfiguration apiConfiguration){
        return new HttpClientBuilder().build(apiConfiguration);
    }
}
