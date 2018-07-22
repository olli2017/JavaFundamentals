package collections.t03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Ссылочная переменная(ссылка) некоторого класса может ссылаться либо на объект этого класса, либо на объект этого подкласса.
        // Также ссылки Object могут ссылаться на любой объект. Поэтому:

        Doctor doctor1 = new Doctor(); // верно
//        Doctor doctor2 = new MedicalStaff(); неверно
        Doctor doctor3 = new HeadDoctor(); // верно
        Object object1 = new HeadDoctor(); // верно
//        HeadDoctor doctor5 = new Object(); неверно
//        Doctor doctor6 = new Nurse(); неверно
//        Nurse nurse = new Doctor(); неверно
        Object object2 = new Nurse(); // верно

        //Generic типы должны быть одинаковы(связи наследования здесь никак не учитываются)

        List <Doctor> list1 = new ArrayList<Doctor>(); // верно, т.к. ArrayList - реализация List
      //  List <MedicalStaff> list2 = new ArrayList <Doctor>(); неверно
//        List <Doctor> list3 = new ArrayList <MedicalStaff>(); неверно
//        List <Object> list4 = new ArrayList <Doctor>(); неверно
        List<Object> list5 = new ArrayList <Object>(); // верно


    }
}
