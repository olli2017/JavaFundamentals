package jdbc.t02;

import jdbc.t02.dao.BookDao;
import jdbc.t02.dao.DaoFactory;
import jdbc.t02.h2.H2DaoFactory;
import jdbc.t02.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class H2BookDaoTest {

    DaoFactory daoFactory = new H2DaoFactory();
    Connection con = daoFactory.getConnection();
    BookDao bookDao = daoFactory.getBookDao(con);

    Book unknownBook = new Book("Unknown", "Unknown", 1);

    public H2BookDaoTest() throws SQLException {
    }

    @Test
    public void read() throws SQLException {
        Assert.assertEquals(bookDao.read(2).getName(), "IT");
    }

    @Test
    public void getAll() throws SQLException {
        List<Book> list = bookDao.getAll();
        Assert.assertEquals(list.get(0).getName(), "1984");
    }

    @Test
    public void create() throws SQLException {
        bookDao.create(unknownBook);
        List<Book> list = bookDao.getAll();
        Assert.assertEquals(list.get(list.size() - 1).getName(), "Unknown");
    }

    @Test
    public void delete() throws SQLException {
        bookDao.delete(unknownBook);
        Assert.assertFalse(bookDao.getAll().contains(unknownBook));
    }
}