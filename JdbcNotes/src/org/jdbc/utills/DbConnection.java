package org.jdbc.utills;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static final String DIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTURL = "jdbc:mysql://localhost:3306/test";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DIVERCLASS);
			con = DriverManager.getConnection(CONNECTURL, "user", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
