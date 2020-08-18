package com.finbourne.features;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FeatureExtractor {



    /**
     * Scans all classes accessible from the context class loader which belong
     * to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException is thrown when no classes are found
     * @throws IOException            is thrown when the input is not acceptable
     */
    private Iterable<Class> getClasses(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', File.separatorChar);

        // Get directories for the package name as resources
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            URI uri = new URI(resource.toString());
            dirs.add(new File(uri.getPath()));
        }
        List<Class> classes = new ArrayList<>();

        // Get directories for the package name as files
        for (File directory : dirs) {
            // Get all classes, for all the files, in all directories
            classes.addAll(findClasses(directory, packageName));
        }

        return classes;
    }

    /**
     * Recursive method used to find all classes in a given directory and
     * subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException is thrown when no classes are found
     */
    private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }

        // List all the files within the directory passed as parameter
        File[] files = directory.listFiles();

        // If no files are found, continue to next directory
        if (files == null) {
            return classes;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                // Recursively find all classes within all files for nested directories
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                // Add class files to array list
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    /**
     * A method that validates annotations. Checks for duplicate values and empty values
     *
     * @param annotations  the annotation list retrieved from getClasses method
     * @throws DuplicateFeatureException throws when there are two LusidFeatures with the same values
     * @throws NullFeatureValueException throws when a LusidFeature annotation has not been assigned an acceptable value
     */

    private void checkIfAnnotationsValid(List<String> annotations) throws DuplicateFeatureException, NullFeatureValueException {
        long distinctAnnotationsCount = annotations.stream().distinct().count();
        if(distinctAnnotationsCount < annotations.size()){
            throw new DuplicateFeatureException("LusidFeature annotations with duplicate values have been found. " +
                    "Please make sure no LusidFeature annotations duplicates are present.");
        }

        if(annotations.contains("")) {
            throw new NullFeatureValueException("One of the LusidFeature annotations has not been assigned a value. " +
                    "Please assign it a value in the form \"LusidFeature(\"<code-value>\")\"");
        }

    }

    public List<String> getAnnotations(String packageName) throws URISyntaxException, IOException, ClassNotFoundException, NullFeatureValueException, DuplicateFeatureException {
        List<String> annotations = new ArrayList<>();

        this.getClasses(packageName).forEach(clazz -> {
                    for (Method method : clazz.getMethods()) {
                        if (method.isAnnotationPresent(LusidFeature.class)) {
                            String annotationValue = method.getAnnotation(LusidFeature.class).value();
                            annotations.add(annotationValue);
                        }
                    }
                }
        );
        this.checkIfAnnotationsValid(annotations);
        return annotations;
    }

}
