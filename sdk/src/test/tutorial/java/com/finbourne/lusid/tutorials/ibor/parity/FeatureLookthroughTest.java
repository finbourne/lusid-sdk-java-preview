package com.finbourne.lusid.tutorials.ibor.parity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class FeatureLookthroughTest {

    @Test
    public void getAnnotationsAndWriteToFile() throws ClassNotFoundException, IOException, URISyntaxException {
        FeatureLookthrough featureLookthrough = new FeatureLookthrough();
        String annotations = featureLookthrough.getAnnotations();

        ParityFileWriter parityFileWriter = new ParityFileWriter();
        parityFileWriter.writeToFile(annotations);
    }

}
