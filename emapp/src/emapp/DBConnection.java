package emapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection con;

	public static Connection createDBConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
			
			String url = "jdbc:mysql://localhost:3306/employeedB? useSSL=false";
			String user = "root";
			String pwd = "root";
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return con;

	}

}
