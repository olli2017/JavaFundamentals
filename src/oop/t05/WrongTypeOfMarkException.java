package oop.t05;

public class WrongTypeOfMarkException extends RuntimeException {
    public WrongTypeOfMarkException() {
        System.out.println("Incorrect mark for this discipline");
    }
}
