package org.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jdbc.utills.DbConnection;

public class JDBCStatementSelectRecords {

	private static final String SELECT_QUERY = "select id,name,email,country,password from Users";

	public static void main(String[] args) {
		try {
			// Step 1: getconnection
			Connection connection = DbConnection.getConnection();
			// Step 2
			Statement statement = connection.createStatement();
			// Step 2: Execute the query or update query

			ResultSet rs = statement.executeQuery(SELECT_QUERY);

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
			
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
