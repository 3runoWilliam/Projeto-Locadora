package persistencia;

import dominio.Cliente;

import java.util.*;
import java.sql.*;

public class ClienteDAO {

	private Conexao c;
	private String mostrar = "SELECT * FROM Cliente";
	private String alterar = "UPDATE Cliente SET name = ?, idade = ?, telefone = ?, endereco = ? WHERE id = ?";
	private String inserir = "INSERT INTO Cliente(name, idade, telefone, endereco) VALUES (?, ?, ?, ?, ?)";
	
	public ClienteDAO() {
		c = new Conexao("jdbc:postgresql://localhost:5432/locadora","postgres","postgres");
	}
	
	public ArrayList<Cliente> mostrarClientes() {
		Cliente pessoa;
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			c.conectar();
			Statement apresentar = c.getConnection().createStatement();
			ResultSet rs = apresentar.executeQuery(mostrar);
			
			while(rs.next()) {
				pessoa = new Cliente(rs.getInt("id"), rs.getString("name"), rs.getInt("idade"), rs.getString("telelefone"), rs.getString("endereco"));
				lista.add(pessoa);
			}
			c.desconectar();
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO ---");			
		}
		return lista;
	}
	
	public void alterarCliente() {
		Cliente alterarPeossoa;
		
		try {
			c.conectar();
			PreparedStatement mudar = c.getConnection().prepareStatement(alterar);
			
		}catch(Exception e) {
			System.out.println("--- ERRO PARA ALTERAR ---");
		}
	}
	
	public void inserirCliente() {
		Cliente inserirPeossoa;
		
		try {
			c.conectar();
			//PreparedStatement inserir = c.getConnection().prepareStatement(inserir);
			
		}catch(Exception e) {
			System.out.println("--- ERRO EM INSERIR ---");
		}
	}
	
}
