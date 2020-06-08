package com.finbourne.lusid.utilities.auth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class KeepAuthTokenProviderTest {

    private KeepAuthTokenProvider tokenProvider;

    // dependency mocks
    private HttpLusidTokenProvider httpLusidTokenProvider;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        httpLusidTokenProvider = mock(HttpLusidTokenProvider.class);
        tokenProvider = new KeepAuthTokenProvider(httpLusidTokenProvider);
    }

    @Test
    public void get_OnNoCurrentToken_ShouldCallLusidProviderForFullAuthentication() throws LusidTokenException {
        LusidToken authenticatedToken = new LusidToken("access_01", "refresh_01", LocalDateTime.MAX);
        doReturn(authenticatedToken).when(httpLusidTokenProvider).get(Optional.empty());

        LusidToken currentToken = tokenProvider.get();

        assertThat(currentToken, equalTo(authenticatedToken));
        verify(httpLusidTokenProvider, times(1)).get(Optional.empty());
    }

    @Test
    public void get_OnNonExpiredCurrentToken_ShouldDoNothing() throws LusidTokenException {
        LusidToken nonExpiredToken = new LusidToken("access_01", "refresh_01", LocalDateTime.MAX);
        doReturn(nonExpiredToken).when(httpLusidTokenProvider).get(Optional.empty());

        // get the first token
        LusidToken currentToken = tokenProvider.get();

        // get the next token
        LusidToken nextToken = tokenProvider.get();

        assertThat(nextToken, sameInstance(currentToken));
        verify(httpLusidTokenProvider, times(1)).get(Optional.empty());
        verify(httpLusidTokenProvider, times(0)).get(Optional.of(anyString()));
    }

    @Test
    public void get_OnExpiredCurrentToken_ShouldCallLusidForNewRefreshedToken() throws LusidTokenException {
        LusidToken expiredToken = new LusidToken("access_01", "refresh_01", LocalDateTime.MIN);
        doReturn(expiredToken).when(httpLusidTokenProvider).get(Optional.empty());

        LusidToken refreshedToken = new LusidToken("access_02", "refresh_01", LocalDateTime.MAX);
        doReturn(refreshedToken).when(httpLusidTokenProvider).get(Optional.of("refresh_01"));

        // get the first token
        LusidToken currentToken = tokenProvider.get();

        // get the next token
        LusidToken nextToken = tokenProvider.get();

        assertThat(nextToken, not(equalTo(currentToken)));
        assertThat(nextToken, equalTo(refreshedToken));
        verify(httpLusidTokenProvider, times(1)).get(Optional.empty());
        verify(httpLusidTokenProvider, times(1)).get(Optional.of("refresh_01"));
    }

    @Test
    public void get_OnExpiredRefreshToken_ShouldCallLusidProviderForFullReauthentication() throws LusidTokenException {
        // the case where the REFRESH token itself has expired

        // setup initial expired access token
        LusidToken expiredToken = new LusidToken("access_01", "refresh_01", LocalDateTime.MIN);
        doReturn(expiredToken).when(httpLusidTokenProvider).get(Optional.empty());
        LusidToken currentToken = tokenProvider.get();

        // throw exception on attempting to refresh with an expired REFRESH token
        doThrow(new LusidTokenException("Refresh token has expired")).when(httpLusidTokenProvider).get(Optional.of("refresh_01"));
        // setup a new access token via full authentication route
        LusidToken newTokenWithNewRefresh = new LusidToken("access_02", "refresh_02", LocalDateTime.MAX);
        doReturn(newTokenWithNewRefresh).when(httpLusidTokenProvider).get(Optional.empty());

        // fetch token again. as both the access and refresh token have expired expect an exception and a full
        // reauthentication attempt
        LusidToken nextToken = tokenProvider.get();

        assertThat(nextToken, not(equalTo(currentToken)));
        assertThat(nextToken, equalTo(newTokenWithNewRefresh));
        verify(httpLusidTokenProvider, times(2)).get(Optional.empty());
        verify(httpLusidTokenProvider, times(1)).get(Optional.of("refresh_01"));
    }

    // Error Cases

    @Test
    public void get_OnFailedRemoteAuthentication_ShouldReThrowLusidTokenException() throws LusidTokenException {
        LusidTokenException lusidTokenException = new LusidTokenException("Failed to retrieve token");
        doThrow(lusidTokenException).when(httpLusidTokenProvider).get(Optional.empty());

        thrown.expect(LusidTokenException.class);
        tokenProvider.get();
    }

    @Test
    public void get_OnFailedRefreshAndFailedReAuthAttempt_ShouldReThrowLusidTokenException() throws LusidTokenException {
        LusidToken expiredToken = new LusidToken("access_01", "refresh_01", LocalDateTime.MIN);
        doReturn(expiredToken).when(httpLusidTokenProvider).get(Optional.empty());

        // get the first token
        LusidToken currentToken = tokenProvider.get();

        doThrow(new LusidTokenException("Refresh token has expired")).when(httpLusidTokenProvider).get(Optional.of("refresh_01"));
        doThrow(new LusidTokenException("Reauthentication attempt has failed")).when(httpLusidTokenProvider).get(Optional.empty());

        thrown.expect(LusidTokenException.class);
        tokenProvider.get();
    }

}
