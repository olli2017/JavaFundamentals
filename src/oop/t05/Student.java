package oop.t05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private Map<Discipline, Number> disciplines;
    private List<Group> groups;

    public Student(String name) {
        this.name = name;
        disciplines = new HashMap<>();
        groups = new ArrayList<>();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group g) {
        groups.add(g);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Discipline, Number> getDisciplines() {
        return disciplines;
    }

    public boolean hasDiscipline(Discipline discipline) {
        return disciplines.containsKey(discipline);
    }

    public Student addDisciplines(Discipline d, Number mark) {
        if (mark.getClass().getSimpleName().equals(d.getTypeMark()))
            disciplines.put(d, mark);
        else
            throw new WrongTypeOfMarkException();
        return this;
    }

    public void printGroups() {
        System.out.println(name + ":");
        for (Group g : groups)
            System.out.println(g.getDiscipline() + "  " + disciplines.get(g.getDiscipline()));
        System.out.println();
    }
}
