package io.t04;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FilmsCollection A = new FilmsCollection("Classic");
//        A.print();

        FileInputStream fileInput = new FileInputStream("./resources/io/t04/old.dat");
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        Object object = objectInput.readObject();
        objectInput.close();

        FilmsCollection B = (FilmsCollection)object;
        B.print();

        Scanner in = new Scanner(System.in);
        while (true) {
            instructions();
            int choice = in.nextInt();

            if (choice == 0)
                B.print();
            else if (choice == 1)
                B.addFilm();
            else if (choice == 2)
                B.editFilm();
            else if (choice == 3) {
                safe(B);
                break;
            }
            else {
                System.out.println("Input error");
                break;
            }

        }

    }

    public static void safe(Object B) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream("./resources/io/t04/old.dat");
        ObjectOutputStream objectOutput =  new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(B);
        objectOutput.close();
    }

    public static void instructions() {
        System.out.println("----------------------------------");
        System.out.println("0 - Print collection");
        System.out.println("1 - Add film");
        System.out.println("2 - Edit film");
        System.out.println("3 - Safe");
        System.out.println("----------------------------------");
    }
}
