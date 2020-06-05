package com.finbourne.lusid.utilities;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class FileConfigurationLoaderTest {

    private FileConfigurationLoader fileConfigurationLoader;

    // mock dependencies
    private ClassLoader classLoader;
    private File file;
    private URL configURL;

    // param
    private String configFilePath = "/home/dir/secrets.json";
    private String configFileUrl = "file:/home/dir/secrets.json";

    @Before
    public void setUp() throws MalformedURLException {
        classLoader = mock(ClassLoader.class);
        file = mock(File.class);
        configURL = new URL(configFileUrl);
        fileConfigurationLoader = spy(new FileConfigurationLoader());

        doReturn(classLoader).when(fileConfigurationLoader).getClassLoader();
        doReturn(file).when(fileConfigurationLoader).getFile(configFilePath);
    }

    @Test
    public void loadConfiguration_NotInResources_ShouldLoadAbsolutePath() throws IOException {
        // mock class loader not finding URL in resources
        doReturn(null).when(classLoader).getResource(configFilePath);
        // mock file existing in absolute path
        doReturn(true).when(file).exists();

        // verify returned the file from the absolute path
        File result = fileConfigurationLoader.loadConfiguration(configFilePath);
        assertThat(result, equalTo(file));
    }

    @Test
    public void loadConfiguration_InResources_ShouldLoadFromResource() throws IOException {
        // mock class loader finding URL in resources
        doReturn(configURL).when(classLoader).getResource(configFilePath);
        // ensure not returning file from absolute path
        doReturn(false).when(file).exists();

        // verify returned the file from resources
        File result = fileConfigurationLoader.loadConfiguration(configFilePath);
        // check name not absolute path to keep this test platform agnostic
        assertThat(result.getName(), equalTo("secrets.json"));
    }

    @Test(expected = IOException.class)
    public void loadConfiguration_NotInResourcesAndPathDoesNotExist_ShouldThrowException() throws IOException {
        // mock class loader not finding URL in resources
        doReturn(null).when(classLoader).getResource(configFilePath);
        // mock file does not exist in absolute path
        doReturn(false).when(file).exists();

        // should throw an exception if nothing has been found
        fileConfigurationLoader.loadConfiguration(configFilePath);
    }

}
