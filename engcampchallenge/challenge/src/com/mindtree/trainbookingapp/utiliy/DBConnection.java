package com.mindtree.trainbookingapp.utiliy;
import java.sql.*;
public class DBConnection {
	private static final String DRIVER_URL = "com.mysql.jdbc.Driver";
	private static final String DB_NAME = "testdb";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Welcome123";
	private static Connection connection = null;

	public static Connection getDbConnection() {
		try {
			if (connection == null) {
				Class.forName(DRIVER_URL);
				connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			System.out.println("connected to database sucessfully");
			}
		} catch (Exception e) {
			System.out.println("Error while connecting");
			System.out.println(e.getMessage());
		}

		return connection;
	}

	public static void closeConnection() {

		try
		{
			if(connection!=null)
			{
				connection.close();
			}
		}catch(Exception e)
		{
			System.out.println("error while disconnecting");
		}
		
		
	}
}
