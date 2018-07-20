package jdbc.t01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String GET_STUDENTS_SQL = "SELECT id, name, group_id FROM Students";
    private static final String GET_CONCRETE_STUDENT_SQL = "SELECT id, name, group_id FROM Students WHERE id = 2";
    private static final String DELETE_STUDENTS_SQL = "DELETE FROM Students";

    public static void main(String[] args) throws SQLException {
        Statement statement = CreateTable.create();
        print(statement, GET_STUDENTS_SQL);

        statement.executeUpdate("UPDATE Students SET name = 'Vasya Pupkin', group_id = '444' WHERE id = 1");
        statement.executeUpdate("UPDATE Students SET name = 'Unknown Unknown' WHERE id = 3");
        print(statement, GET_STUDENTS_SQL);

        print(statement, GET_CONCRETE_STUDENT_SQL);

        statement.executeUpdate("INSERT INTO Students(name, group_id) VALUES ('New New', 333)");
        print(statement, GET_STUDENTS_SQL);

        statement.executeUpdate(DELETE_STUDENTS_SQL);

        statement.close();
    }

    private static void print(Statement st, String query) throws SQLException {
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.printf("%d %s %d%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("group_id"));
        }
        System.out.println();
    }

}

