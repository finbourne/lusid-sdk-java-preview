package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiCallback;
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Pair;
import com.finbourne.lusid.utilities.auth.LusidToken;
import com.finbourne.lusid.utilities.auth.KeepAuthTokenProvider;
import okhttp3.Call;

import java.util.List;
import java.util.Map;

public class KeepLiveApiClient extends ApiClient {

    private final ApiClient apiClient;
    private final KeepAuthTokenProvider tokenProvider;

    public KeepLiveApiClient(ApiClient apiClient, KeepAuthTokenProvider tokenProvider) {
        this.apiClient = apiClient;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ApiCallback callback) throws ApiException {
        setAccessToken(tokenProvider.get());
        return apiClient.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, callback);
    }

    /**
     *  set api client to use latest token
     *
     * @param accessToken
     */
    private void setAccessToken(LusidToken accessToken) {
        apiClient.addDefaultHeader("Authorization", "Bearer " + accessToken.getAccessToken());
    }

}
