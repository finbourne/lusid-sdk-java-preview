package com.finbourne.lusid.tutorials.ibor.parity;

import org.reflections.util.ClasspathHelper;

import java.io.*;
import java.net.URL;

public class ParityFileWriter {

    FileOutputStream fileOut;

    public void writeToFile(String data) throws IOException {
        // String path = this.getClass().getResource("parityOutput.txt").getPath();
        fileOut = new FileOutputStream("parityOutput.txt");
        // System.out.println(new File(path).getAbsolutePath());
        // System.out.println(path);
        fileOut.write(data.getBytes());
        fileOut.close();
    }



}
