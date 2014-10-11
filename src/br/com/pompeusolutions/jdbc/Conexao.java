package br.com.pompeusolutions.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Conexao() {

	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/cjweb1", "postgres",
					"1234");
			// System.out.println("Conectado");
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		}
		return con;
	}

}
