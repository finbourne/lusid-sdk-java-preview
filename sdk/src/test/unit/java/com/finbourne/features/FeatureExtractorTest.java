package com.finbourne.features;

import org.apache.commons.codec.Charsets;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FeatureExtractorTest {


    @Test
    @LusidFeature("Unit Test 1")
    public void checkIfWriterWritesCorrectly() throws ClassNotFoundException, IOException, URISyntaxException {
        FeatureExtractor featureExtractor = new FeatureExtractor();
        FeatureFileWriter featureFileWriter = new FeatureFileWriter();

        List<String> annotations = featureExtractor.getAnnotations("com.finbourne.lusid.tutorials");
        String annotationsFromMethod = String.join("\n", annotations);
        String fileName = "features.txt";
        featureFileWriter.writeToFile(annotationsFromMethod, fileName);
        List<String> lines = Files.readAllLines(Paths.get(fileName), Charsets.UTF_8);
        String annotationsFromFile = String.join("\n", lines);

        assertThat(annotationsFromMethod, equalTo(annotationsFromFile));
    }

    @Test
    @LusidFeature("Unit Test 2")
    public void getAnnotationsFromThisPackage() throws ClassNotFoundException, IOException, URISyntaxException {
        FeatureExtractor featureExtractor = new FeatureExtractor();

        List<String> annotations = featureExtractor.getAnnotations("com.finbourne.features");

        assertThat(annotations.size(), equalTo(2));
        assertThat(annotations, hasItems("Unit Test 1", "Unit Test 2"));
    }

}
