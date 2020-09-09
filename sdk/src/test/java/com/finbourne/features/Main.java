package com.finbourne.features;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.cli.*;


public class Main {
    public static void main(String args[]) throws ClassNotFoundException, IOException, NullFeatureValueException, DuplicateFeatureException, URISyntaxException {
        Options options = new Options();

        Option pkg = new Option("p", "package", true, "package name, eg. 'com.finbourne.lusid.tutorials' (which is also the default option) ");
        pkg.setRequired(false);
        options.addOption(pkg);

        Option fName = new Option("f", "filename", true, "Name of the features file to be created. By default 'features.txt', and will be created in the root sdk folder. Path from the sdk root folder can also be specified in this format <some-dir>/<another-dir>/filename.txt");
        fName.setRequired(false);
        options.addOption(fName);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;


        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        String packageName = cmd.getOptionValue("package");
        String fileName = cmd.getOptionValue("filename");

        if(packageName == null) {
            packageName = "com.finbourne.lusid.tutorials";
        }

        if(fileName == null) {
            fileName = "features.txt";
        }

        System.out.println(packageName);
        System.out.println(fileName);

        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path rootPath = currentDir.getParent().getParent().getParent().getParent().getParent().getParent().getParent();
        String filePath = Paths.get(rootPath.toString(), "sdk", fileName).toString();

        FeatureExtractor featureExtractor = new FeatureExtractor();
        FeatureFileWriter featureFileWriter = new FeatureFileWriter();

        List<String> annotations = featureExtractor.getAnnotations(packageName);
        String annotationsFromMethod = String.join("\n", annotations);
        featureFileWriter.writeToFile(annotationsFromMethod, filePath);
        System.out.println("Done writing to filepath: " + filePath);
    }
}
