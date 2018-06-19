package io.t03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("./resources/io/t03/data.txt");
        FileOutputStream outputStream = new FileOutputStream("./output/io/t03/result.txt");

        Charset utf_8 = Charset.forName("UTF-8");
        Charset utf_16 = Charset.forName("UTF-16");

        byte[] buffer = new byte[1000];

        while (inputStream.available() > 0) {
            int count = inputStream.read(buffer);
            String s = new String(buffer, utf_8);
            buffer = s.getBytes(utf_16);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}
