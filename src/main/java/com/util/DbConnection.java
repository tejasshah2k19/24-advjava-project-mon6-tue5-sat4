package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {

		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/portal24";
			String userName = "root";
			String password = "root";
			String driverClass = "com.mysql.cj.jdbc.Driver";

			Class.forName(driverClass);// load driver

			connection = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
