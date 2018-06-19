package oop.t04;

import oop.t03.stationery.Stationery;

import java.util.Comparator;

public class NameComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
    }
}