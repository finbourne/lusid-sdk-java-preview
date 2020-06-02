package com.finbourne.lusid.utilities;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Builds http client to communicate to LUSID API instances.
 *
 */
public class HttpClientBuilder {

    /**
     *  Builds a {@link OkHttpClient} from a {@link ApiConfiguration} to make
     *  calls to the LUSID API.
     *
     * @param apiConfiguration configuration to connect to LUSID API
     * @return an client for http calls to LUSID API
     */
    public OkHttpClient build(ApiConfiguration apiConfiguration){
        final OkHttpClient httpClient;

        //  use a proxy if given
        if (apiConfiguration.getProxyAddress() != null) {

            InetSocketAddress proxy = new InetSocketAddress(apiConfiguration.getProxyAddress(), apiConfiguration.getProxyPort());

            httpClient = new OkHttpClient.Builder()
                    .proxy(new Proxy(Proxy.Type.HTTP, proxy))
                    .proxyAuthenticator((route, response) -> {
                        String credential = Credentials.basic(apiConfiguration.getProxyUsername(), apiConfiguration.getProxyPassword());
                        return response.request().newBuilder()
                                .header("Proxy-Authorization", credential)
                                .build();
                    })
                    .build();
        }
        else {
            httpClient = new OkHttpClient();
        }
        return httpClient;
    }

}
