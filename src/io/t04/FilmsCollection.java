package io.t04;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import static java.lang.System.in;

public class FilmsCollection implements Serializable {
    private String name;
    private List<Film> films;

    public FilmsCollection(String name) {
        this.name = name;
        films = new ArrayList<>();

        Film hachiko = new Film("Hachiko");
        hachiko.addActor("Ashley",30).
                addActor("Bruce", 35).
                addActor("Conor", 40);

        Film war = new Film("War");
        war.addActor("Daniel", 20).
                addActor("Elisa", 25);

        Film peace = new Film("Peace");
        peace.addActor("Faruh", 23).
                addActor("Gomes", 26).
                addActor("Harry", 29);

        films.add(hachiko);
        films.add(war);
        films.add(peace);
    }

    public void addFilm() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of film");
        Film newFilm = new Film(input.next());
        films.add(newFilm);
    }

    public void editFilm() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of film");
        String filmName = input.next();

        System.out.println("0 - Add actor");
        System.out.println("1 - Remove actor");
        int choice = Integer.parseInt(input.next());
        if (choice == 0)
            addActor(filmName);
        else if (choice == 1)
            removeActor(filmName);
        else
            System.out.println("Input error");

    }

    private void removeActor(String filmName) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name");
        String actorName = input.next();

        for (Film f : films) {
            if (f.getName().equals(filmName)) {
                f.removeActor(actorName);
                break;
            }
        }
    }

    private void addActor(String filmName) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name");
        String actorName = input.next();
        System.out.println("Enter age");
        int actorAge = Integer.parseInt(input.next());

        for (Film f : films) {
            if (f.getName().equals(filmName)) {
                f.addActor(actorName, actorAge);
                break;
            }
        }
    }

    public void print() {
        System.out.println("FilmsCollection " + name + " :");
        for (Film f : films) {
            f.print();
        }
    }
}
