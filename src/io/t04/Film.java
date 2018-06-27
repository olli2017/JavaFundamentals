package io.t04;

import java.io.Serializable;
import java.util.*;

public class Film implements Serializable {
    private String name;
    private List<Actor> actors;

    public Film(String name) {
        this.name = name;
        actors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public Film addActor(String name, int age) {
        actors.add(new Actor(name, age));
        return this;
    }

    public void removeActor(String actorName) {
        int index = -1;
        for (Actor a : actors) {
            if (a.getName().equals(actorName)) {
                index = actors.indexOf(a);
                break;
            }
        }

        if (index >= 0)
            actors.remove(index);
    }

    public void print() {
        System.out.println("\t" + "Film " + name + " :");
        for (Actor actor : actors) {
            System.out.println("\t\t" + actor.getName() + ", " + actor.getAge());
        }
    }
}
