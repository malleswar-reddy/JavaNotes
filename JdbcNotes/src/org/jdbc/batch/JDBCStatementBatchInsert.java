package org.jdbc.batch;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import org.jdbc.utills.DbConnection;

public class JDBCStatementBatchInsert {

	public static void main(String[] args) {
		try {
			Connection connection = DbConnection.getConnection();
			Statement statement = connection.createStatement();

			connection.setAutoCommit(false);
			statement.addBatch("INSERT INTO Users VALUES (1, 'Z', 'z@gmail.com', 'India', '123');");
			statement.addBatch("INSERT INTO Users VALUES (2, 'Pramod', 'pramod@gmail.com', 'India', '123');");
			statement.addBatch("INSERT INTO Users VALUES (8, 'A', 'a@gmail.com', 'India', '123');");
			statement.addBatch("INSERT INTO Users VALUES (9, 'B', 'b@gmail.com', 'India', '123');");
			statement.addBatch("INSERT INTO Users VALUES (10, 'C', 'c@gmail.com', 'India', '123');");
			statement.addBatch("INSERT INTO Users VALUES (11, 'D', 'd@gmail.com', 'India', '123');");
			int[] updateCounts = statement.executeBatch();
			System.out.println(Arrays.toString(updateCounts));
			connection.commit();
			
			connection.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
