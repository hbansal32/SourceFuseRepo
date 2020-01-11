package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pageObjects.BasePage;

public class DatabaseConnector extends BasePage {
	private static String databaseURL = prop.getProperty("db_url");
	private static String dbusername = prop.getProperty("db_user");
	private static String dbpassword = prop.getProperty("db_password");

	public static String executeSQLQuery(String sqlQuery) {
		Connection connection;
		String resultValue = "";
		ResultSet rs;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(databaseURL, dbusername, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database...");
			} else {
				System.out.println("Database connection failed.");
			}
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQuery);

			try {
				while (rs.next()) {
					resultValue = rs.getString(1).toString();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException err) {
				System.out.println("No Records obtained for this specific query");
				err.printStackTrace();
			}
			connection.close();

		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;
	}

	public static ArrayList<String> executeSQLQuery_List(String sqlQuery) {
		Connection connection;
		ArrayList<String> resultValue = new ArrayList<String>();
		ResultSet resultSet;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(databaseURL, dbusername, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database");
			} else {
				System.out.println("Failed to connect to database");
			}
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);

			/*try {
				while (resultSet.next()) {
					int columnCount = resultSet.getMetaData().getColumnCount();
					StringBuilder stringBuilder = new StringBuilder();
					for (int iCounter = 1; iCounter <= columnCount; iCounter++) {
						stringBuilder.append(resultSet.getString(iCounter).trim());
					}
					String reqValue = stringBuilder.substring(0, stringBuilder.length() - 1);
					resultValue.add(reqValue);
				}
			}*/ 
			try {
				while (resultSet.next()) {
					int columnCount = resultSet.getMetaData().getColumnCount();
					for (int iCounter = 1; iCounter <= columnCount; iCounter++) {
						resultValue.add(resultSet.getString(iCounter));
					}
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException ex) {
				System.out.println("No Records found for this specific query" + ex.getStackTrace());
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException ex) {
						System.out.println("SQL Exception:" + ex.getStackTrace());
					}
				}
			}

		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;
	}
}
