package com.finbourne.lusid.utilities.auth;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Provides {@link LusidToken} used for API authentication and manages
 * token expiry to ensure continued connectivity to LUSID API without the need
 * for explicit reauthentication by the caller.
 *
 */
public class KeepAuthTokenProvider {

    /** Underlying token provider that authenticates against LUSID*/
    private final HttpLusidTokenProvider httpLusidTokenProvider;

    /** Current token in use for API calls*/
    private LusidToken currentToken;

    /**
     * Creates a KeepAuthTokenProvider based on an underlying token provider
     * that manages direct authentication with LUSID.
     *
     * @param httpLusidTokenProvider underlying provider that manages explicit authentication calls to LUSID
     */
    public KeepAuthTokenProvider(HttpLusidTokenProvider httpLusidTokenProvider) {
        this.httpLusidTokenProvider = httpLusidTokenProvider;
    }

    /**
     * Stores an initial {@link LusidToken} on complete authentication (with username and password) and
     * will subsequently manage refreshing the token after expiry
     *
     * @return a live and valid {@link LusidToken}
     */
    public synchronized LusidToken get(){
        if (currentToken == null) {
            currentToken = httpLusidTokenProvider.get(Optional.empty());
        } else if (isTokenExpired(currentToken)) {
            currentToken = httpLusidTokenProvider.get(Optional.of(currentToken.getRefreshToken()));
        }
        return currentToken;
    }

    /**
     * Checks if a token has expired
     *
     * @param token to check expiry on
     * @return true if token expired false otherwise
     */
    public boolean isTokenExpired(LusidToken token){
        return LocalDateTime.now().isAfter(token.getExpiresAt());
    }

}
