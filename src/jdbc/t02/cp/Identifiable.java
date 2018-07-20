package jdbc.t02.cp;

public interface Identifiable<T> {
    int getId();
    T setId(int id);
}
