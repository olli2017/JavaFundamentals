package jdbc.t02.dao;

import java.sql.Connection;
import java.sql.SQLException;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {

    /** Возвращает подключение к базе данных */
    Connection getConnection() throws SQLException;

    BookDao getBookDao(Connection connection) throws SQLException;
}
