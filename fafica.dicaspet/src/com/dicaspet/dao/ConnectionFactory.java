package com.dicaspet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(					

					"jdbc:mysql://$OPENSHIFT_MYSQL_DB_", "adminWXZ6qLn", "Fsm4XhmqUqnE");

		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}