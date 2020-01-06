package com.internousdev.ecsite2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://database-2.cr8br8ioaq1x.ap-northeast-1.rds.amazonaws.com:3306/ecsite2?useSSL=false";
	private static String user = "root";
	//家用
	private static String password = "s145cmKai";
////	private static String password = "mysql";

	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driverName);
			con=(Connection)DriverManager.getConnection(url,user,password);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
}
