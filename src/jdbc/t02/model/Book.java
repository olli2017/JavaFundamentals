package jdbc.t02.model;

import jdbc.t02.cp.Identifiable;

public class Book implements Identifiable<Book> {
    private int id;
    private String name;
    private String author;
    private int cost;

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Book( String name, String author, int cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }
    public Book(int id, String name, String author, int cost) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cost=" + cost +
                '}';
    }
}