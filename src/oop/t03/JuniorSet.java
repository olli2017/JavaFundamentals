package oop.t03;

import oop.t03.stationery.*;
import oop.t03.stationery.drawingProducts.*;
import oop.t03.stationery.officeProducts.*;
import oop.t03.stationery.writingProducts.*;

public class JuniorSet {
    private Stationery[] stationeries = {new Pen(30), new Pencil(20), new Paper(100),
            new Clip(1), new Brush(15), new Paint(25)};

    public Stationery[] getStationeries() {
        return stationeries.clone();
    }
}