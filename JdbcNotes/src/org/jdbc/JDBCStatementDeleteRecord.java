package org.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import org.jdbc.utills.DbConnection;

public class JDBCStatementDeleteRecord {
	private static final String DELETE_USERS_SQL = "delete from users where id = 3;";

	public static void main(String[] args) {

		try {
			Connection connection = DbConnection.getConnection();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(DELETE_USERS_SQL);
			System.out.println("Number of records affected :: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
