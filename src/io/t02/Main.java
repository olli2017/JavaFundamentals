package io.t02;

import java.io.*;
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

        FileReader fr = new FileReader("./resources/io/t01/Notepad.java");
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();

        while (br.ready()) {
            int b = br.read();
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

        br.close();

        FileWriter fw = new FileWriter("./output/io/t02/result");

        for (String s : result.keySet()) {
            String out = s + " : " + result.get(s) + "\n";
            fw.write(out);
        }
        fw.close();
    }
}
