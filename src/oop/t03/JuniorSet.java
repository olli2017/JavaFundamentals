package oop.t03;

import oop.t03.stationery.*;
import oop.t03.stationery.drawingProducts.*;
import oop.t03.stationery.officeProducts.*;
import oop.t03.stationery.writingProducts.*;

public class JuniorSet {
    private Stationery[] stationeries = {new Pen(20), new Pencil(20), new Paper(100),
            new Clip(1), new Brush(20), new Paint(20)};

    public Stationery[] getStationeries() {
        return stationeries.clone();
    }
}