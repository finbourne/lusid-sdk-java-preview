package com.finbourne.features;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class FeatureExtractorTest {

    @Test
    public void getAnnotationsAndWriteToFile() throws ClassNotFoundException, IOException, URISyntaxException {
        FeatureExtractor featureExtractor = new FeatureExtractor();
        List<String> annotations = featureExtractor.getAnnotations("com.finbourne.lusid.tutorials");

        String annotationsStr = String.join("\n", annotations);

        ParityFileWriter parityFileWriter = new ParityFileWriter();
        parityFileWriter.writeToFile(annotationsStr);
    }

}
