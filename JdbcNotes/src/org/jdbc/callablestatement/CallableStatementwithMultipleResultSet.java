package org.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.jdbc.utills.DbConnection;

public class CallableStatementwithMultipleResultSet {

	private static final String sql = "call retreive_different_results()";

	public static void main(String[] args) {
		try {
			Connection connection = DbConnection.getConnection();
			CallableStatement stmt = connection.prepareCall(sql);
			boolean hasRs = stmt.execute();

			System.out.println();
			// Get Product Names
			if (hasRs) {
				try (ResultSet rs = stmt.getResultSet()) {
					while (rs.next()) {
						System.out.println("NAME = " + rs.getString(1));
					}
				}
			}

			// Get Total Price
			if (stmt.getMoreResults()) {
				try (ResultSet rs = stmt.getResultSet()) {
					if (rs.next()) {
						System.out.println("Email = " + rs.getString(1));
					}
				}
			}

			// Get Max/Min Price
			if (stmt.getMoreResults()) {
				try (ResultSet rs = stmt.getResultSet()) {
					if (rs.next()) {
						System.out.println("Users count = " + rs.getInt(1));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
