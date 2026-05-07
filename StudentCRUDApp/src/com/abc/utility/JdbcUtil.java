package com.abc.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static Connection connection;
	static {
		Properties properties = new Properties();
		String filePath="D:\\JDBC\\StudentCRUDApp\\src\\com\\abc\\properties\\application.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			properties.load(fis);
			String url = properties.getProperty("jdbc.url");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password"); 
			 connection = DriverManager.getConnection(url, username, password);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static Connection getDbConnection(){
		
		return connection;
	}
	

	public static void close(ResultSet resultSet,Statement statement,Connection connection) {
	//Closing the resources 
	
	try {
		 if (resultSet!=null) {
			 resultSet.close();
		}
		
	} catch (SQLException se) {
		se.printStackTrace();
	}

	try {
		 if (statement!=null) {
			 statement.close();
		}
		
	} catch (SQLException se) {
		se.printStackTrace();
	}

	try {
	 if (connection!=null) {
		 connection.close();
	}
	
	} catch (SQLException se) {
	se.printStackTrace();
}
}

}