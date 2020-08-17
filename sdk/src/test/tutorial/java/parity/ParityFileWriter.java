package parity;

import java.io.*;

public class ParityFileWriter {

    FileOutputStream fileOut;

    public void writeToFile(String data) throws IOException {
        fileOut = new FileOutputStream("features.txt");
        fileOut.write(data.getBytes());
        fileOut.close();
    }



}
