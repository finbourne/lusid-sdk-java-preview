package com.finbourne.lusid.utilities.auth;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class KeepAuthTokenProviderTest {

    private KeepAuthTokenProvider tokenProvider;
    // dependency mocks
    private HttpLusidTokenProvider httpLusidTokenProvider;

    @Before
    public void setUp(){
        httpLusidTokenProvider = mock(HttpLusidTokenProvider.class);
        tokenProvider = new KeepAuthTokenProvider(httpLusidTokenProvider);
    }

    @Test
    public void get_OnNoCurrentToken_ShouldCallLusidProviderForFullAuthentication(){
        tokenProvider.get();
        verify(httpLusidTokenProvider, times(1)).getToken(Optional.empty());
    }

    @Test
    public void get_OnExistingTokenThatIsNotExpired_ShouldDoNothing(){
        LusidToken nonExpiredToken = mock(LusidToken.class);
        doReturn(LocalDateTime.MAX).when(nonExpiredToken).getExpiresAt();
        doReturn(nonExpiredToken).when(httpLusidTokenProvider).getToken(Optional.empty());

        // setup first time
        LusidToken existingToken = tokenProvider.get();

        // fetch token again
        LusidToken nextToken = tokenProvider.get();

        assertThat(nextToken, equalTo(existingToken));
        verify(httpLusidTokenProvider, times(1)).getToken(Optional.empty());
        verify(httpLusidTokenProvider, times(0)).getToken(Optional.of(anyString()));
    }

    @Test
    public void get_OnExistingTokenThatIsExpired_ShouldCallLusidForNewRefreshedToken(){
        LusidToken expiredToken = mock(LusidToken.class);
        doReturn(LocalDateTime.MIN).when(expiredToken).getExpiresAt();
        doReturn("refreshToken1").when(expiredToken).getRefreshToken();
        doReturn(expiredToken).when(httpLusidTokenProvider).getToken(Optional.empty());

        LusidToken refreshedToken = mock(LusidToken.class);
        doReturn(refreshedToken).when(httpLusidTokenProvider).getToken(Optional.of("refreshToken1"));

        // setup first time
        LusidToken existingToken = tokenProvider.get();

        // fetch token again
        LusidToken nextToken = tokenProvider.get();

        assertThat(nextToken, not(equalTo(existingToken)));
        assertThat(nextToken, equalTo(refreshedToken));
        verify(httpLusidTokenProvider, times(1)).getToken(Optional.empty());
        verify(httpLusidTokenProvider, times(1)).getToken(Optional.of("refreshToken1"));
    }

    // Error Cases : //TODO Discuss exception cases Riz : Can refresh tokens expire

}
