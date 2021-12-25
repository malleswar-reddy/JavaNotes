package org.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import org.jdbc.utills.DbConnection;

public class JDBCStatementUpdateRecord {
	private static final String UPDATE_USERS_SQL = "update users set name = \"Ram\" where id = 3;";

	public static void main(String[] args) {

		try {

			// Step 1: getconnection
			Connection connection = DbConnection.getConnection();
			// Step 2
			Statement statement = connection.createStatement();
			// Step 2: Execute the query or update query

			int result = statement.executeUpdate(UPDATE_USERS_SQL);
			System.out.println("Number of records affected :: " + result);

			connection.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
