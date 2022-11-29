package persistencia;

import dominio.Cliente;

import java.util.*;
import java.sql.*;

public class ClienteDAO {

	private Conexao c;
	private String mostrar = "SELECT * FROM Cliente";
	private String alterar = "UPDATE Cliente SET name = ?, idade = ?, telefone = ?, endereco = ? WHERE id = ?";
	private String inserir = "INSERT INTO Cliente(name, idade, telefone, endereco) VALUES (?, ?, ?, ?)";
	private String deletar = "DELETE FROM Cliente WHERE id = ?";
	
	public ClienteDAO() {
		c = new Conexao();
	}
	
	public ArrayList<Cliente> mostrarClientes() {
		Cliente pessoa;
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			c.conectar();
			Statement apresentar = c.getConnection().createStatement();
			ResultSet rs = apresentar.executeQuery(mostrar);
			
			while(rs.next()) {
				pessoa = new Cliente(rs.getInt("id"), rs.getString("name"), rs.getInt("idade"), rs.getString("telefone"), rs.getString("endereco"));
				lista.add(pessoa);
			}
			c.desconectar();
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO ---" + e.getMessage());			
		}
		return lista;
	}
	
	public void alterarCliente(Cliente dale) {
		try {
			c.conectar();
			PreparedStatement mudar = c.getConnection().prepareStatement(alterar);
			mudar.setString(1, dale.getName());
			mudar.setInt(2, dale.getIdade());
			mudar.setString(3, dale.getTelefone());
			mudar.setString(4, dale.getEndereco());
			mudar.setInt(5, dale.getId());
			
			mudar.execute();
			c.desconectar();
			
		}catch(Exception e) {
			System.out.println("--- ERRO PARA ALTERAR ---");
		}
	}
	
	public void inserirCliente(Cliente dale) {
		try {
			c.conectar();
			PreparedStatement adicionar = c.getConnection().prepareStatement(inserir);
			adicionar.setString(1, dale.getName());
			adicionar.setInt(2, dale.getIdade());
			adicionar.setString(3, dale.getTelefone());
			adicionar.setString(4, dale.getEndereco());
			
			adicionar.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println("--- ERRO EM INSERIR ---" + e.getMessage());
		}
	}
	
	public void deletarCliente(int id) {
		try {
			c.conectar();
			PreparedStatement excluir = c.getConnection().prepareStatement(deletar);
			excluir.setInt(1, id);
			
			excluir.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println("--- ERRO EM INSERIR ---" + e.getMessage());
		}
	}
}
