package io.t01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> result = new HashMap<>();

    static void addInHashmap(String s) {
        if (result.containsKey(s))
            result.put(s, result.get(s) + 1);
        else
            result.put(s, 1);
    }

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("./resources/io/t01/Notepad.java");

        StringBuilder sb = new StringBuilder();

        while (fileInputStream.available() > 0) {
            int b = fileInputStream.read();
            if (b >= 97 && b <= 122) {
                sb.append((char)b);
            }
            else if ((!sb.toString().equals("")) && InitializeSetOfKeyWords.initialize().contains(sb.toString())) {
                addInHashmap(sb.toString());
                sb = sb.delete(0, sb.length());
            }
            else
                sb = sb.delete(0, sb.length());
        }

        fileInputStream.close();

        FileOutputStream outputStream = new FileOutputStream("./output/io/t01/result");

        for (String s : result.keySet()) {
            String out = s + " : " + result.get(s) + "\n";
            outputStream.write(out.getBytes());
        }
        outputStream.close();
    }
}
