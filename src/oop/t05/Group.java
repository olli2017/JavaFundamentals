package oop.t05;

import java.util.List;
import java.util.stream.Collectors;

public class Group {
    private Discipline discipline;
    private List<Student> students;

    public Group(Discipline discipline, List<Student> st) {
        this.discipline = discipline;
        students = st.stream()
                .filter(student -> student.hasDiscipline(discipline))
                .collect(Collectors.toList());

        for (Student student : students) {
            student.addGroup(this);
        }

    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean containsStudent(Student st) {
        return students.contains(st);
    }

    public void printStudents() {
        System.out.println(discipline + ":");
        for (Student s : students)
            System.out.println(s.getName());
        System.out.println();
    }
}
