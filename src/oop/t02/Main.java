package oop.t02;

import oop.t02.stationery.*;

public class Main {
    public static void main(String[] args) {
        Employe employe1 = new Employe();
        employe1.addStationeries(new Pen(30))
                .addStationeries(new Pencil(20))
                .addStationeries(new Eraser(10))
                .addStationeries(new Scissors(50))
                .addStationeries(new Ruler(20))
                .addStationeries(new Notepad(60))
                .addStationeries(new Corrector(40))
                .addStationeries(new Stickers(30));

        System.out.println(employe1.getTotalPrice());
    }
}
