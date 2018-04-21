package daoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql extends DaoFactory {

	private static String url = "jdbc:mysql://127.0.0.1:3306/";
	private static String database = "e_primelec";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "root";
	

	public Connection openConnection() {
		try {
			Class.forName(driver).newInstance();
			String databaseURL = url + database + "?useSSL=false";
			Connection connection = DriverManager.getConnection(databaseURL, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.err.println("Impossible de se connecter à la base de données");
			System.err.println(ex);
		}
		return null;
	}

}
