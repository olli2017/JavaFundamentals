package jdbc.t01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE Students (id IDENTITY, name VARCHAR NOT NULL, group_id INT)";

    public static Statement create() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        statement.executeUpdate(CREATE_TABLE_SQL);
        statement.executeUpdate("INSERT INTO Students(name, group_id) VALUES ('Ivanov Ivan', 101)");
        statement.executeUpdate("INSERT INTO Students(name, group_id) VALUES ('Petrov Petr', 201)");
        statement.executeUpdate("INSERT INTO Students(name, group_id) VALUES ('Borisov Boris', 304)");

        return statement;
    }
}
