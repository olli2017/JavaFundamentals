package oop.t06;

public class AtomicBoat {
    private String name;

    public AtomicBoat(String name) {
        this.name = name;
    }

    public class EngineForAtomicBoat {
        public void swim() {
            System.out.println(name + " is running");
        }
    }
}

