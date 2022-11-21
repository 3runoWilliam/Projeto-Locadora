package persistencia;

import java.sql.*;

public class Conexao {
	private String user;
	private String passoword;
	private String path;
	private Connection connection;

	public Conexao(String u, String s, String c) {
		path = "jdbc:postgresql://local:5432/locadora";
		user = "postgres";
		passoword = "postgres";
	}

	public void conectar() {
		try {
			
			Class.forName("org.postgresql.Driver");
			System.out.println("passou forname");
			connection = DriverManager.getConnection(path, user, passoword);
			System.out.println("passou connection");
			
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