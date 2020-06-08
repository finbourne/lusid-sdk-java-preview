package com.finbourne.lusid.utilities;

import com.finbourne.lusid.ApiCallback;
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Pair;
import com.finbourne.lusid.utilities.auth.LusidToken;
import com.finbourne.lusid.utilities.auth.KeepAuthTokenProvider;
import com.finbourne.lusid.utilities.auth.LusidTokenException;
import okhttp3.Call;

import java.util.List;
import java.util.Map;

/**
 * An extension of the {@link ApiClient} that always updates the clients authorisation
 * header to use a valid {@link LusidToken} before any calls to the LUSID API.
 *
 */
public class KeepAuthApiClient extends ApiClient {

    /** Default api client to delegate actual request execution*/
    private final ApiClient apiClient;

    /** Token provider to retrieve valid {@link LusidToken} */
    private final KeepAuthTokenProvider tokenProvider;

    public KeepAuthApiClient(ApiClient apiClient, KeepAuthTokenProvider tokenProvider) {
        this.apiClient = apiClient;
        this.tokenProvider = tokenProvider;
    }

    /**
     * Wraps around the default {@link ApiClient} implementation to ensure the client always uses
     * a valid {@link LusidToken}.
     *
     * Delegates actual call to the default {@link ApiClient} implementation once the authorisation
     * header has been set to use a valid token.
     *
     * @return
     * @throws ApiException
     */
    @Override
    public Call buildCall(String path, String method, List<Pair> queryParams, List<Pair> collectionQueryParams, Object body, Map<String, String> headerParams, Map<String, Object> formParams, String[] authNames, ApiCallback callback) throws ApiException {
        try {
            setAccessToken(tokenProvider.get());
        } catch (LusidTokenException e) {
            throw new ApiException(e);
        }
        return apiClient.buildCall(path, method, queryParams, collectionQueryParams, body, headerParams, formParams, authNames, callback);
    }

    private void setAccessToken(LusidToken accessToken) {
        apiClient.addDefaultHeader("Authorization", "Bearer " + accessToken.getAccessToken());
    }

}
