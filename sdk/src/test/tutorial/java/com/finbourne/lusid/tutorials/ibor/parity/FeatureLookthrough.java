package com.finbourne.lusid.tutorials.ibor.parity;

import com.finbourne.lusid.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

public class FeatureLookthrough {

    @LusidFeature(value = "Test")
    public void retrieveAnnotations() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder().setUrls(
                ClasspathHelper.forPackage("com.finbourne.lusid.tutorials")
        ).setScanners(new MethodAnnotationsScanner());

        Reflections reflections = new Reflections(configurationBuilder);

        Set<Method> methods = reflections.getMethodsAnnotatedWith(LusidFeature.class);
        System.out.println(ClasspathHelper.forPackage("com.finbourne.lusid.tutorials"));


        for (Method method : methods) {
//            if (method.isAnnotationPresent(LusidFeature.class))
//            {
            // do something
            System.out.println(method.getAnnotation(LusidFeature.class));
            System.out.println(method.isAnnotationPresent(LusidFeature.class));
//            }
        }

    }


}
