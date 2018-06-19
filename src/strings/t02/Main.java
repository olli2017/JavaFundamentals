package strings.t02;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String country;
        String language;
        Scanner in = new Scanner(System.in);

        System.out.println("1 – English");
        System.out.println("2 – Русский");

        char choice = (char)System.in.read();

        switch (choice) {
            case '1':
                country = "US";
                language = "en";
                break;
            case '2':
                country = "RU";
                language = "ru";
                break;
            default:
                System.out.println("Input error");
                return;
        }

        File file = new File("./resources/strings/t02");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        Locale currentLocale = new Locale(language, country);
        ResourceBundle rbQuestions = ResourceBundle.getBundle("questions", currentLocale, loader);
        ResourceBundle rbAnswers = ResourceBundle.getBundle("answers", currentLocale, loader);

        Enumeration<String> questionsKeys = rbQuestions.getKeys();
        while (questionsKeys.hasMoreElements()) {
            String s = questionsKeys.nextElement();
            System.out.println(s + ") " + rbQuestions.getString(s));
        }

        String userInput = in.next().trim();
        System.out.println(rbAnswers.getString(userInput));

        in.close();
    }
}

