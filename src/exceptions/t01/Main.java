package exceptions.t01;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    private static final String PATH = "D:\\film\\FileFromJava.txt";

    private static void createFile(Path path) {
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.out.println("Файл уже существует");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFile(Path path) {
        try {
            Files.delete(path);
        } catch (NoSuchFileException e) {
            System.out.println("Файла не существует");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openFile(Path path) throws IOException {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }

        try {
            desktop.open(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInFile(Path path, String data) throws IOException {
        Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
    }

    private static void showCatalog(Path path) throws IOException {
        for (File file : path.toFile().listFiles()) {
            System.out.println(file.getName() +
                    (file.isDirectory() ? "\tcatalog" : "\tfile"));
        }
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(PATH);
//        createFile(path);
//        deleteFile(path);
//        writeInFile(path, "Hello world");
//        openFile(path);
//        showCatalog(Paths.get("D:\\"));
    }
}
