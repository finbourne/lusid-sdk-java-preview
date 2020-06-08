package com.finbourne.lusid.utilities.auth;

import java.time.LocalDateTime;
import java.util.Optional;

public class KeepAuthTokenProvider {

    private final HttpLusidTokenProvider httpLusidTokenProvider;
    private LusidToken currentToken;

    public KeepAuthTokenProvider(HttpLusidTokenProvider httpLusidTokenProvider) {
        this.httpLusidTokenProvider = httpLusidTokenProvider;
    }

    public synchronized LusidToken get(){
        if (currentToken == null) {
            currentToken = httpLusidTokenProvider.getToken(Optional.empty());
        } else if (isTokenExpired(currentToken)) {
            currentToken = httpLusidTokenProvider.getToken(Optional.of(currentToken.getRefreshToken()));
        }
        return currentToken;
    }

    public boolean isTokenExpired(LusidToken token){
        return LocalDateTime.now().isAfter(token.getExpiresAt());
    }

}
