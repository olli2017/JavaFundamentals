package oop.t05;

public enum Discipline {
    Math("Double"),
    English("Integer"),
    Chem("Double");

    private String typeMark;

    Discipline(String typeMark){
        this.typeMark = typeMark;
    }

    public String getTypeMark() {
        return typeMark;
    }

}
