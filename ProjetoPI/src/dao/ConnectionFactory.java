package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection conectar () throws SQLException{
		String str = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
		return DriverManager.getConnection(str, "root", "root");
	}
}