package persistencia;

import java.sql.*;

public class Conexao {
	private String user;
	private String passoword;
	private String path;
	private Connection connection;

	public Conexao() {
		path = "jdbc:postgresql://localhost:5432/locadora";
		user = "postgres";
		passoword = "postgres";
	}

	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(path, user, passoword);
			
		}catch(Exception e) {
			System.out.println("--- ERRO PARA CONECTAR --- " + e.getMessage());
		}
	}

	public void desconectar() {
		try {
			connection.close();
		}catch(Exception e) {
			System.out.println("--- ERRO PARA DESCONECTAR ---");
		}
	}

	public Connection getConnection() {
		return connection;
	}
}