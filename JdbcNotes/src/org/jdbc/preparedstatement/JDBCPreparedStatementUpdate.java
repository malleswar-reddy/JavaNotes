package org.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.jdbc.utills.DbConnection;

public class JDBCPreparedStatementUpdate {
	private static final String UPDATE_USERS_SQL = "update users set name = ? where id = ?;";

	public static void main(String[] args) {
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
			preparedStatement.setString(1, "Ram Reddy");
			preparedStatement.setInt(2, 1);
			int result = preparedStatement.executeUpdate();
			System.out.println(" Result sucess "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
