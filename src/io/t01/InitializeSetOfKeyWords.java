package io.t01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

public class InitializeSetOfKeyWords {

    static HashSet<String> initialize() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./resources/io/t01/KeyWords");

        HashSet<String> keyWords = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while (fileInputStream.available() > 0) {
            int b = fileInputStream.read();
            if (b >= 97 && b <= 122) {
                sb.append((char) b);
            } else if (!sb.toString().equals("")) {
                keyWords.add(sb.toString());
                sb = sb.delete(0, sb.length());
            }
        }
        fileInputStream.close();
        return keyWords;
    }
}
