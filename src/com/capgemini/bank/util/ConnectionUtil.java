package com.capgemini.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
	private String url="jdbc:postgresql://localhost:5432/Bank";
	private String userName="postgres";
	private String password="anjali";
	private static Connection con=null;
	public Connection getConnection() {
		
		try {
			con=DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void closeConnection() {
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
