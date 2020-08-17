package com.finbourne.lusid.tutorials.ibor.parity;

import com.finbourne.lusid.tutorials.ibor.Bitemporal;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class FeatureLookthroughTest {

    @BeforeClass
    public static void setUp(){
        System.out.println("Test set up BeforeClass");
    }

    @Test
    @LusidFeature("in test")
    public void checkFeatures() throws Exception {
        FeatureLookthrough featureLookthrough = new FeatureLookthrough();
        featureLookthrough.retrieveAnnotations();


        for( Method method: Bitemporal.class.getMethods()){
            if (method.isAnnotationPresent(LusidFeature.class)){
                System.out.println("In test, : " + method.getAnnotation(LusidFeature.class));
            }
        }
    }

    @Test
    public void customReflectionTest() throws ClassNotFoundException, IOException, URISyntaxException {
        CustomReflection customReflection = new CustomReflection();
        String annotations = customReflection.getAnnotations();
        System.out.println(annotations);
        ParityFileWriter parityFileWriter = new ParityFileWriter();
        parityFileWriter.writeToFile(annotations);
    }

}
