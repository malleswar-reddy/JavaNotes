package org.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import org.jdbc.utills.DbConnection;

public class JDBCStatementInsertMultiple {

	private static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO Users "
			+ "VALUES (3, 'Pramod', 'pramod@gmail.com', 'India', '123'),"
			+ "(4, 'Deepa', 'deepa@gmail.com', 'India', '123')," + "(5, 'Tom', 'top@gmail.com', 'India', '123');";

	public static void main(String[] args) {

		try {

			// Step 1: getconnection
			Connection connection = DbConnection.getConnection();
			// Step 2
			Statement statement = connection.createStatement();
			// Step 2: Execute the query or update query
			int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
			System.out.println("No. of records affected : " + result);
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
