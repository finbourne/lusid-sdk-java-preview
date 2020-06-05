package com.finbourne.lusid.utilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileConfigurationLoader {

    /**
     * Loads the API configuration from a resource in the classpath
     *
     * @param apiConfig name of the resource
     * @return API configuration file
     * @throws IOException
     */
    public File loadConfiguration(String apiConfig) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL configUrl = classLoader.getResource(apiConfig);
        // classLoader will return null on failing to locate a resource so wrap
        // in an IOException to avoid unchecked NPE.
        if (configUrl == null) {
            throw new IOException("cannot find " + apiConfig + "in classpath");
        }
        File configFile = new File(configUrl.getFile());
        if (configFile == null || !configFile.exists()) {
            throw new IOException("cannot find " + apiConfig + "in classpath");
        }

        return new File(configFile.toURI());
    }

}
