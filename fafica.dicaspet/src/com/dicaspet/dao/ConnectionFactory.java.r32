package com.dicaspet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(					
					"jdbc:mysql://localhost/dicaspet", "root", "123456");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}