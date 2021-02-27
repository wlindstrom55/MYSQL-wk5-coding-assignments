package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSodas { 

	private final static String URL = "jdbc:mysql://localhost:3306/sodapops";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "raiz";
	private static Connection connection;
	private static DBConnectionSodas instance;
	
	private DBConnectionSodas(Connection connection) {
		this.connection = connection;
	}
	
	public static Connection getConnection() { 
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnectionSodas(connection);
				System.out.println("Connection Successful!");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnectionSodas.connection;
	}
	
	public static DBConnectionSodas getInstance() { 
		return instance;
	}
	
}
