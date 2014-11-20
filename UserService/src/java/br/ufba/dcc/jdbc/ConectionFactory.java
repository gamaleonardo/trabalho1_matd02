package br.ufba.dcc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	
	private static Connection con;
	
	public static Connection getPostgresConnection() {
		if(con==null){
			try {
				//Class.forName("org.postgresql.Driver");
				// Ou
				DriverManager.registerDriver(new org.postgresql.Driver());
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cjweb1", 
						"postgres", "postgres");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
}
