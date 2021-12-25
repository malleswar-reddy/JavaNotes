package org.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.jdbc.utills.DbConnection;

public class ProcessStoredProcedureSQLStatement {
	private static final String SQL = "call retreive_users()";

	public static void main(String[] args) {
		try {
			Connection connection = DbConnection.getConnection();
			CallableStatement stmt = connection.prepareCall(SQL);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println("ID = " + rs.getInt(1) + ", NAME = " + rs.getString(2) + ", Email = "
						+ rs.getString(3) + ", Country = " + rs.getString(4) + ", Password = " + rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
