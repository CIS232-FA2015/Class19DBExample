package carrollcc.cis232.dbexample;

import java.sql.*;

public class App {
	static final String DB_URL = "jdbc:derby:db/Students;create=true";

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection(DB_URL);
			System.out.println("Connection created to DB!");

			//CREATE A TABLE
			//1. Create a Statement from the database connection
			Statement stmt = conn.createStatement();
			
			//2. Make a SQL statement to create the table
			String sqlCreateTable = "create table Students("
					+ " name varchar(50),"
					+ " bonusPoints int"
					+ ")";
			
			//3. Execute the statement
			stmt.execute(sqlCreateTable);
			
			//TABLE IS CREATED!
			
			//INSERT DATA TO TABLE
			//1. Create the SQL command to insert the data
			String insertStudent = "insert into Students(name, bonusPoints)"
					+ " values ('Bill', 0)";
			//2. Execute the statement
			stmt.executeUpdate(insertStudent);
			
			
			conn.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
