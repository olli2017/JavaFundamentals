package io.t02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class InitializeSetOfKeyWords {
    static HashSet<String> initialize() throws IOException {
        FileReader fr = new FileReader("./resources/io/t01/KeyWords");
        BufferedReader br = new BufferedReader(fr);

        HashSet<String> keyWords = new HashSet<>();

        while (br.ready()) {
            String s = br.readLine();
            keyWords.add(s.trim());
        }

        br.close();
        return keyWords;
    }
}
