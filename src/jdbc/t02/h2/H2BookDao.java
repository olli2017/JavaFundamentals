package jdbc.t02.h2;

import jdbc.t02.dao.BookDao;
import jdbc.t02.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class H2BookDao implements BookDao {
    private static final String GET_BOOKS_SQL = "SELECT * FROM library;";
    private static final String GET_BOOK_BY_ID_SQL = "SELECT * FROM library WHERE id = ?;";
    private static final String DELETE_SQL = "DELETE FROM library WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE library SET name = ?, author = ?, cost = ? WHERE id = ?";

    private final Connection connection;

    public H2BookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Book book) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(
                "INSERT INTO library (name, author, cost) VALUES (?, ?, ?);");
        pstm.setString(1, book.getName());
        pstm.setString(2, book.getAuthor());
        pstm.setInt(3, book.getCost());

        pstm.execute();
    }

    @Override
    public Book read(int key) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(GET_BOOK_BY_ID_SQL);
        pstm.setInt(1, key);

        ResultSet rs = pstm.executeQuery();
        rs.next();

        return new Book(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("author"),
                rs.getInt("cost"));
    }

    @Override
    public void update(Book book) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(UPDATE_SQL);
        pstm.setString(1, book.getName());
        pstm.setString(2, book.getAuthor());
        pstm.setInt(3, book.getCost());
        pstm.setInt(4, book.getId());
        pstm.executeUpdate();
    }

    @Override
    public void delete(Book book) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(DELETE_SQL);
        pstm.setInt(1, book.getId());
        pstm.executeUpdate();
    }

    public void deleteById(int id) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(DELETE_SQL);
        pstm.setInt(1, id);
        pstm.executeUpdate();
    }

    @Override
    public List<Book> getAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(GET_BOOKS_SQL);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Book book = new Book(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("author"),
                    rs.getInt("cost"));
            books.add(book);
        }
        return books;
    }
}
