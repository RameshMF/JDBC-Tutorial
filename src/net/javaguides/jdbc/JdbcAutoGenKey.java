package net.javaguides.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcAutoGenKey {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
        String user = "root";
        String password = "root";

        String studentName = "Ramesh Fadatare";
        String sql = "INSERT INTO Students(Name) VALUES(?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, studentName);
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

                if (resultSet.first()) {

                    System.out.printf("The ID of new student : %d", resultSet.getLong(1));
                }
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcAutoGenKey.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
