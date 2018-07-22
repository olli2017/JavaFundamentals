package exceptions.t02;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        Path path1 = Paths.get("resources\\exceptions\\t02\\demo.properties");
        Path path2 = Paths.get("resources\\exceptions\\t02\\empty.properties");
        Path path3 = Paths.get("resources\\exceptions\\t02\\incorrect.properties");
        try {
            properties.load(Files.newInputStream(path1, StandardOpenOption.READ));
            if (properties.isEmpty())
                throw new EmptyPropertiesFileException();
            if (properties.keySet().contains("")) {
                throw new IncorrectPropertiesFileException();
            }

            HashMap<Object, Object > result = new HashMap<>((Map)properties);

            for (Object key : result.keySet())
                System.out.println(key.toString() + ":" + result.get(key).toString());

        } catch (NoSuchFileException e) {
            System.out.println("Нет файла");
        } catch (EmptyPropertiesFileException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectPropertiesFileException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
