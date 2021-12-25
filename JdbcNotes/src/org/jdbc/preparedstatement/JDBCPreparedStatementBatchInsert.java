package org.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import org.jdbc.utills.DbConnection;

public class JDBCPreparedStatementBatchInsert {
	public static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (id, name, email, country, password) VALUES "
			+ " (?, ?, ?, ?, ?);";

	public static void main(String[] args) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
	            connection.setAutoCommit(false);

	            preparedStatement.setInt(1, 20);
	            preparedStatement.setString(2, "a");
	            preparedStatement.setString(3, "a@gmail.com");
	            preparedStatement.setString(4, "India");
	            preparedStatement.setString(5, "secret");
	            preparedStatement.addBatch();

	            preparedStatement.setInt(1, 21);
	            preparedStatement.setString(2, "b");
	            preparedStatement.setString(3, "b@gmail.com");
	            preparedStatement.setString(4, "India");
	            preparedStatement.setString(5, "secret");
	            preparedStatement.addBatch();

	            preparedStatement.setInt(1, 22);
	            preparedStatement.setString(2, "c");
	            preparedStatement.setString(3, "c@gmail.com");
	            preparedStatement.setString(4, "India");
	            preparedStatement.setString(5, "secret");
	            preparedStatement.addBatch();

	            preparedStatement.setInt(1, 23);
	            preparedStatement.setString(2, "d");
	            preparedStatement.setString(3, "d@gmail.com");
	            preparedStatement.setString(4, "India");
	            preparedStatement.setString(5, "secret");
	            preparedStatement.addBatch();

	            int[] updateCounts = preparedStatement.executeBatch();
	            System.out.println(Arrays.toString(updateCounts));
	            connection.commit();
	            connection.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
