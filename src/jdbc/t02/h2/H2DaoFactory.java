package jdbc.t02.h2;

import jdbc.t02.dao.BookDao;
import jdbc.t02.dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Реализация DaoFactory с базой H2
public class H2DaoFactory implements DaoFactory {
    private String url = "jdbc:h2:tcp://localhost/~/test/library";
    private String driver = "com.mysql.jdbc.Driver";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public BookDao getBookDao(Connection connection) throws SQLException {
        return new H2BookDao(connection);
    }

}
