package net.javaguides.jdbc.hsqldb.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDBDeleteExample {
	private static final String deleteTableSQL = "delete from users where id = 1";

	    public static void main(String[] argv) throws SQLException {
	    	HSQLDBDeleteExample deleteExample = new HSQLDBDeleteExample();
	    	deleteExample.deleteRecord();
	    }

	    public void deleteRecord() throws SQLException {

	        System.out.println(deleteTableSQL);
	        // Step 1: Establishing a Connection
	        try (Connection connection = JDBCUtils.getConnection();
	            // Step 2:Create a statement using connection object
	            Statement statement = connection.createStatement();) {

	            // Step 3: Execute the query or update query
	            statement.execute(deleteTableSQL);
	            
	        } catch (SQLException e) {
	            // print SQL exception information
	        	JDBCUtils.printSQLException(e);
	        }
	    }
}
