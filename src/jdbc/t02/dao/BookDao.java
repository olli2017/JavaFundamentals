package jdbc.t02.dao;

import jdbc.t02.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    void create(Book book) throws SQLException;

    Book read(int key) throws SQLException;

    void update(Book book) throws SQLException;

    void delete(Book book) throws SQLException;

    List<Book> getAll() throws SQLException;
}
