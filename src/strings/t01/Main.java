package strings.t01;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        CrazyLogger crazyLogger = new CrazyLogger();
        crazyLogger.log("Hye");
        crazyLogger.log("Begin");
        crazyLogger.log("Error");
        crazyLogger.log("Norm");
        crazyLogger.log("Good");
        crazyLogger.log("End");
        crazyLogger.log("Bye");

        crazyLogger.print();

        System.out.println(crazyLogger.searchByString("B"));

        //crazyLogger.searchByPeriod("20-06-2018 : 12-50", "20-06-2018 : 12-59");
    }
}
