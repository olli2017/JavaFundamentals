package oop.t06;

public class Main {
    public static void main(String[] args) {
        AtomicBoat atomicBoat = new AtomicBoat("Admiral");
        AtomicBoat.EngineForAtomicBoat engineForAtomicBoat = atomicBoat.new EngineForAtomicBoat();
        engineForAtomicBoat.swim();
    }
}

