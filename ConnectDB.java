package com.revature.bankApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectDB {
	public static Connection setup() throws SQLException, IOException {
			Properties prop = new Properties();
			//InputStream in = new FileInputStream("connection.properties");
			//prop.load(in);
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "waldo";
			String password = "polka";
			
			//url = prop.getProperty("url");
			//user = prop.getProperty("user");
			//password = prop.getProperty("password");
			
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			return DriverManager.getConnection(url, user, password);
		}
	

	public static void close() {
		// TODO Auto-generated method stub
		ConnectDB.close();
	}


	public static CallableStatement prepareCall(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
