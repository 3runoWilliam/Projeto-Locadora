package persistencia;

import dominio.Aluguel;
import dominio.Cliente;

import java.util.*;
import java.sql.*;

public class ClienteDAO {

	private Conexao c;
	private String mostrar = "SELECT * FROM Cliente";
	private String alterar = "UPDATE Cliente SET name = ?, idade = ?, telefone = ?, endereco = ? WHERE id = ?";
	private String inserir = "INSERT INTO Cliente(name, idade, telefone, endereco) VALUES (?, ?, ?, ?)";
	private String deletar = "DELETE FROM Cliente WHERE id = ?";
	private String mostrarTudo = "SELECT data_aluguel, data_entrega, valor_aluguel, fk_filme, fk_cliente FROM cliente,aluguel WHERE id = fk_cliente AND id = ?";
	private String deletarFK = "DELETE FROM aluguel WHERE fk_cliente = ?";
	
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
			System.out.println("--- ERRO NO RELATORIO DO CLIENTE (MOSTRAR CLIENTES) ---" + e.getMessage());			
		}
		return lista;
	}
	
	public ArrayList<Aluguel> mostrarTudinho(int id) {
		Aluguel aluguel;
		ArrayList<Aluguel> lista = new ArrayList<>();
		try {
			c.conectar();
			PreparedStatement apresentar = c.getConnection().prepareStatement(mostrarTudo);
			apresentar.setInt(1, id);
			
			apresentar.execute();
			ResultSet rs = apresentar.executeQuery();
			while(rs.next()) {
				aluguel = new Aluguel(rs.getString("Data_aluguel"), rs.getString("Data_entrega"), rs.getInt("valor_aluguel"), rs.getInt("fk_filme"), rs.getInt("fk_cliente"));
				lista.add(aluguel);
			}
			c.desconectar();
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO DO CLIENTE ---" + e.getMessage());			
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
			System.out.println("--- ERRO PARA ALTERAR CLIENTE ---");
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
			System.out.println("--- ERRO EM INSERIR CLIENTE ---" + e.getMessage());
		}
	}
	
	public void deletarCliente(int id) {
		try {
			c.conectar();
			PreparedStatement excluirFk = c.getConnection().prepareStatement(deletarFK);
			PreparedStatement excluir = c.getConnection().prepareStatement(deletar);
			excluirFk.setInt(1, id);
			excluir.setInt(1, id);
			
			excluirFk.execute();
			excluir.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println("--- ERRO EM DELETAR CLIENTE ---" + e.getMessage());
		}
	}
}
