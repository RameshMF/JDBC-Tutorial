package net.javaguides.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Retrieve Image from MySQL Database Table using Java
 * @author Ramesh Fadatare
 *
 */
public class JdbcReadImage {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_demo?useSSL=false";
        String user = "root";
        String password = "root";

        String query = "SELECT Data FROM Images where id = 2";

        try (Connection con = DriverManager.getConnection(url, user, password); PreparedStatement pst = con.prepareStatement(query); ResultSet result = pst.executeQuery()) {

            if (result.next()) {

                String fileName = "image1.png";

                try (FileOutputStream fos = new FileOutputStream(fileName)) {

                    Blob blob = result.getBlob("Data");
                    int len = (int) blob.length();

                    byte[] buf = blob.getBytes(1, len);

                    fos.write(buf, 0, len);

                } catch (IOException ex) {

                    Logger lgr = Logger.getLogger(JdbcReadImage.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcReadImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}