package com.finbourne.features;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FeatureFileWriter {

    private FileOutputStream fileOut;
    private String filePath;
    private String fileName;

    public String getFilePath(){
        return this.filePath;
    }

    public String getFileName() {
        return this.fileName;
    }

    private void setFilePath(String fileName) {
        Path currentDir = Paths.get(System.getProperty("user.dir"));
        System.out.println(currentDir);
        Path rootPath = currentDir.getParent().getParent().getParent().getParent().getParent().getParent().getParent();
        Path filePath = Paths.get(rootPath.toString(), "sdk", fileName);
        this.filePath = filePath.toString();
    }

    public void writeToFile(String data, String filePath) throws IOException {
        fileOut = new FileOutputStream(filePath);
        fileOut.write(data.getBytes());
        fileOut.close();
    }



}
