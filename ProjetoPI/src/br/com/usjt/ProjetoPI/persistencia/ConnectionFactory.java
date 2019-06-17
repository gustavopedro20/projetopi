package br.com.usjt.ProjetoPI.persistencia;

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
		String str = "jdbc:mysql://localhost/usjt_pi?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false";
		return DriverManager.getConnection(str, "root", "root");
	}
}