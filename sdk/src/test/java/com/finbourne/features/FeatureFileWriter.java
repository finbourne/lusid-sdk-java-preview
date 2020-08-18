package com.finbourne.features;

import java.io.*;

public class FeatureFileWriter {

    FileOutputStream fileOut;

    public void writeToFile(String data, String fileName) throws IOException {
        fileOut = new FileOutputStream(fileName);
        fileOut.write(data.getBytes());
        fileOut.close();
    }



}
