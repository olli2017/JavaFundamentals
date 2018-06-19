package oop.t04;

import oop.t03.JuniorSet;
import oop.t03.stationery.Stationery;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        JuniorSet juniorSet = new JuniorSet();
        Stationery[] stationeries = juniorSet.getStationeries();

        System.out.println("Initial JuniorSet");
        printArray(stationeries);

        System.out.println("Sorted by price");
        Arrays.sort(stationeries, new PriceComparator());
        printArray(stationeries);

        System.out.println("Sorted by name");
        Arrays.sort(stationeries, new NameComparator());
        printArray(stationeries);

        System.out.println("Sorted by price and name");
        Arrays.sort(stationeries, new PriceComparator().thenComparing(new NameComparator()));
        printArray(stationeries);

    }

    public static void printArray(Stationery[] a) {
        for (Stationery s : a)
            System.out.println(s.getClass().getSimpleName() + " : " + s.getPrice());

        System.out.println();
    }
}

