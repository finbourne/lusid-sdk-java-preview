package com.finbourne.features;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class FeatureExtractorTest {

    @Test
    public void getAnnotationsAndWriteToFile() throws ClassNotFoundException, IOException, URISyntaxException {
        FeatureExtractor featureExtractor = new FeatureExtractor();
        String annotations = featureExtractor.getAnnotations();

        ParityFileWriter parityFileWriter = new ParityFileWriter();
        parityFileWriter.writeToFile(annotations);
    }

}
