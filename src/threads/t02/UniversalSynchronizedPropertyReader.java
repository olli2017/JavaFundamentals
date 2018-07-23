package threads.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class UniversalSynchronizedPropertyReader extends Thread{
    private Map<String, String> mapProperties;
    private Properties properties;

    public UniversalSynchronizedPropertyReader(Path propPath) {
        mapProperties = new ConcurrentHashMap<>();
        properties = new Properties();

        try ( BufferedReader reader = Files.newBufferedReader(propPath)) {
            properties.load(reader);
            for (String property : properties.stringPropertyNames())
                mapProperties.put(property, properties.getProperty(property));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
        return mapProperties.get(key);
    }

}
