package collections.t02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        Path path = Paths.get("resources\\collections\\t02\\demo.properties");

        Map<String, String> map = new HashMap<>();

        try {
            properties.load(Files.newBufferedReader(path));

            for (String key : properties.stringPropertyNames())
                map.put(key, properties.getProperty(key));

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : map.keySet())
            System.out.println(key + " : " + map.get(key));
    }
}
