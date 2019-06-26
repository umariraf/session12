package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	public static String getUsername() throws ClassNotFoundException, SQLException {
		String username = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techfios", "root", "abc123");
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from users");
		while (rs.next()) {
			username = rs.getString("username");
		}
		return username;
	}

	public static String getPassword() throws ClassNotFoundException, SQLException {
		String password = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techfios", "root", "abc123");
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from users");
		while (rs.next()) {
			password = rs.getString("password");
		}
		return password;
	}
}