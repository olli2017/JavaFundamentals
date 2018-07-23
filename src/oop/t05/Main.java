package oop.t05;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Student> students = initStudentList();

        Group chemStudents = new Group(Discipline.Chem, students);
        Group mathStudents = new Group(Discipline.Math, students);
        Group englishStudents = new Group(Discipline.English, students);

        chemStudents.printStudents();
        students.get(0).printGroups();

    }

    private static List<Student> initStudentList() {
        List<Student> students = new ArrayList<>();

        Student st1 = new Student("With all disciplines");
        st1.addDisciplines(Discipline.Chem, 4.5)
                .addDisciplines(Discipline.Math, 4.1)
                .addDisciplines(Discipline.English, 4);

        Student st2 = new Student("With Chem_Math");
        st2.addDisciplines(Discipline.Chem, 3.5)
                .addDisciplines(Discipline.Math, 3.1)
                .addDisciplines(Discipline.English, 3);

        Student st3 = new Student("With Chem_English");
        st3.addDisciplines(Discipline.Chem, 3.3)
                .addDisciplines(Discipline.English, 5);

        Student st4 = new Student("With Math_English");
        st4.addDisciplines(Discipline.Math, 3.3)
                .addDisciplines(Discipline.English, 4);

        Student st5 = new Student("With Math");
        st5.addDisciplines(Discipline.Math, 3.3);

        Student st6 = new Student("With English");
        st6.addDisciplines(Discipline.English, 3);

        Student st7 = new Student("With Chem");
        st7.addDisciplines(Discipline.Chem, 3.3);

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        students.add(st7);

        return students;
    }

}
