package com.finbourne.lusid.utilities.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finbourne.lusid.utilities.ApiConfiguration;
import okhttp3.*;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

/**
 * Provides {@link LusidToken} used for API authentication by directly querying the authentication
 * token urls on the target LUSID instance. Always provides REFRESHable tokens (see
 * https://support.finbourne.com/using-a-refresh-token).
 *
 */
public class HttpLusidTokenProvider {

    /** Scope to ensure refresh token is enabled */
    private static final String SCOPE = "openid client groups offline_access";

    private static final MediaType FORM = MediaType.parse("application/x-www-form-urlencoded");

    /** configuration parameters to connect to LUSID */
    private final ApiConfiguration apiConfiguration;

    /** client to make http calls to LUSID */
    private final OkHttpClient httpClient;

    public HttpLusidTokenProvider(ApiConfiguration apiConfiguration, OkHttpClient httpClient) {
        this.apiConfiguration = apiConfiguration;
        this.httpClient = httpClient;
    }

    /**
     * Retrieves a {@link LusidToken} via an authentication call to LUSID.
     *
     * Will make a complete authentication call (with username and password) if no refresh token
     * is available. Otherwise will attempt to refresh the token.
     *
     * @param refreshToken - to attempt token refresh with it is available.
     * @return an authenticated LUSID token
     */
    public LusidToken get(Optional<String> refreshToken) {
        final Request request = createAccessTokenRequest(refreshToken);
        final LusidToken lusidToken = callAndMapResponseToToken(httpClient, request);
        return lusidToken;
    }

    private LusidToken callAndMapResponseToToken(OkHttpClient httpClient, Request request){
        //  map json response
        try {
            Response response = httpClient.newCall(request).execute();

            if (response.code() != 200) {
                throw new RuntimeException("Authentication call to LUSID failed. See response :" + response.toString());
            }

            final String content = response.body().string();
            final ObjectMapper mapper = new ObjectMapper();
            final Map bodyValues = mapper.readValue(content, Map.class);


            if (!bodyValues.containsKey("access_token")) {
                throw new IOException("missing access_token");
            }

            if (!bodyValues.containsKey("refresh_token")) {
                throw new IOException("missing refresh_token");
            }

            if (!bodyValues.containsKey("expires_in")) {
                throw new IOException("missing expires_in");
            }

            //  get access token, refresh token and token expiry
            final String apiToken = (String)bodyValues.get("access_token");
            final String refreshToken = (String)bodyValues.get("refresh_token");
            final int expires_in = (int)bodyValues.get("expires_in");

            LusidToken lusidToken = new LusidToken(apiToken, refreshToken, calculateExpiryAtTime(LocalDateTime.now(), expires_in));
            return lusidToken;
        } catch (IOException e){
            throw new RuntimeException("Authentication response does not appear to valid. See details:", e);
        }
    }

    private Request createAccessTokenRequest(Optional<String> refreshStringOpt){
        //  request body
        final String tokenRequestBody;
        try {
            if (!refreshStringOpt.isPresent()) {
                // if no refresh token is present then go through the entire authetication flow
                tokenRequestBody = String.format("grant_type=password&username=%s&password=%s&scope=%s&client_id=%s&client_secret=%s",
                        apiConfiguration.getUsername(),
                        URLEncoder.encode(apiConfiguration.getPassword(), StandardCharsets.UTF_8.toString()),
                        SCOPE,
                        apiConfiguration.getClientId(),
                        URLEncoder.encode(apiConfiguration.getClientSecret(), StandardCharsets.UTF_8.toString()));
            } else {
                // otherwise if a refresh token is present than request a refreshed access token only
                tokenRequestBody = String.format("grant_type=refresh_token&scope=%s&refresh_token=%s",
                        SCOPE,
                        refreshStringOpt.get());
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to encode parameters from the API Configuration. Ensure your secrets files is properly setup.", e);
        }

        final RequestBody body = RequestBody.create(FORM, tokenRequestBody);
        final Request.Builder requestBuilder = new Request.Builder()
                .url(apiConfiguration.getTokenUrl())
                .header("Accept", "application/json")
                .post(body);

        if (refreshStringOpt.isPresent()) {
            requestBuilder.addHeader("Authorization", "Basic " +
                    Base64.encodeBase64String((apiConfiguration.getClientId() + ":" + apiConfiguration.getClientSecret()).getBytes()));
        }

        return requestBuilder.build();
    }

    LocalDateTime calculateExpiryAtTime(LocalDateTime now, int expires_in){
        // expiration is shortened to overcome a race condition where the token is still valid when retrieved from cache but expired when
        // used in an api call
        return now.plusSeconds(expires_in - 30);
    }

}
