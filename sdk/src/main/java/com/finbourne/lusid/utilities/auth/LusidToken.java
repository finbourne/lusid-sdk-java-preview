package com.finbourne.lusid.utilities.auth;

import java.time.LocalDateTime;

public class LusidToken {

    private final String accessToken;
    private final String refreshToken;
    private final LocalDateTime expiresAt;

    public LusidToken(String accessToken, String refreshToken, LocalDateTime expiresAt) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}
