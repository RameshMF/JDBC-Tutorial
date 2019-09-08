package net.javaguides.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class demonstrate Inserting Image into MySQL Database using Java
 * @author Ramesh Fadatare
 *
 */
public class JdbcWriteImage {

    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/java_demo?useSSL=false";
        String user = "root";
        String password = "root";

        String sql = "INSERT INTO Images(Data) VALUES(?)";

        try (Connection con = DriverManager.getConnection(url, user, password); 
        		PreparedStatement pst = con.prepareStatement(sql)) {

            File myFile = new File("image.png");
            try (FileInputStream fin = new FileInputStream(myFile)) {

                pst.setBinaryStream(1, fin, (int) myFile.length());
                pst.executeUpdate();

            } catch (IOException ex) {

                Logger lgr = Logger.getLogger(JdbcWriteImage.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JdbcWriteImage.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        System.out.println("Image inserted successfully....");
    }
}
