package persistencia;

import dominio.Cliente;
import dominio.Filme;
import dominio.Aluguel;

import java.util.*;
import java.sql.*;

public class AluguelDAO {
	
	private Conexao c;
	private String mostrar = "SELECT * FROM aluguel";
	private String mostrarCertinho = "SELECT * FROM cliente,aluguel WHERE id = fk_cliente AND id = ?";
	private String mostrarFilme = "SELECT id_filme, categoria, título, filme.valor_aluguel FROM cliente,aluguel, filme WHERE cliente.id = fk_cliente AND id_filme = fk_filme AND cliente.id = ?";
	private String adicionarFilmeAoCliente = "INSERT INTO Aluguel(fk_cliente, fk_filme, data_aluguel, data_entrega, valor_aluguel) VALUES (?, ?, ?, ?, ?)";
		
	public AluguelDAO() {
		c = new Conexao();
	}
	
	public ArrayList<Aluguel> mostrarAlugueis() {
		Aluguel aluguel;
		ArrayList<Aluguel> lista = new ArrayList<Aluguel>();
		try {
			c.conectar();
			Statement apresentar = c.getConnection().createStatement();
			ResultSet rs = apresentar.executeQuery(mostrar);
			
			while(rs.next()) {
				aluguel = new Aluguel(rs.getString("Data_aluguel"), rs.getString("Data_entrega"), rs.getInt("valor_aluguel"), rs.getInt("fk_filme"), rs.getInt("fk_cliente"));
				lista.add(aluguel);
			}
			c.desconectar();
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO MOSTRAR ALUGUEIS ---" + e.getMessage());			
		}
		return lista;
	}
	
	public ArrayList<Aluguel> mostrarAlugueisCertinho(Cliente id) {
		Aluguel aluguel;
		
		ArrayList<Aluguel> lista = new ArrayList<Aluguel>();
		try {
			c.conectar();
			PreparedStatement apresentar = c.getConnection().prepareStatement(mostrarCertinho);
			ResultSet rs = apresentar.executeQuery();
			
			apresentar.setInt(1, id.getId());
			
			while(rs.next()) {				
				aluguel = new Aluguel(rs.getString("Data_aluguel"), rs.getString("Data_entrega"), rs.getInt("valor_aluguel"), rs.getInt("fk_filme"), rs.getInt("fk_cliente"));
				lista.add(aluguel);
			}
			c.desconectar();
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO MOSTRAR ALUGUEIS CERTINHO ---" + e.getMessage());			
		}
		return lista;
	}
	
	public void adicionarAluguel(Aluguel dale) {
		try {
			c.conectar();
			PreparedStatement adicionar = c.getConnection().prepareStatement(adicionarFilmeAoCliente);
			adicionar.setInt(1, dale.getFk_cliente());
			adicionar.setInt(2, dale.getFk_filme());
			adicionar.setString(3, dale.getData_aluguel());
			adicionar.setString(4, dale.getData_entrega());
			adicionar.setInt(5, dale.getValor_aluguel());
			
			adicionar.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println("--- ERRO AO ADICIONAR O FILME PARA O CLIENTE ---" + e.getMessage());
		}
	}
	
	public ArrayList<Filme> mostrarFilmes(int id) {
		Filme Filme;
		ArrayList<Filme> listaFilme = new ArrayList<>();
		try {
			c.conectar();
			PreparedStatement apresentar = c.getConnection().prepareStatement(mostrarFilme);
			apresentar.setInt(1, id);
			
			ResultSet rs = apresentar.executeQuery();
			
			while(rs.next()) {
				Filme = new Filme(rs.getInt("id_Filme"), rs.getString("categoria"), rs.getString("título"), rs.getInt("valor_aluguel"));
				listaFilme.add(Filme);
			}
			c.desconectar();
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO MOSTRAR ALUGUEIS ---" + e.getMessage());			
		}
		return listaFilme;
	}
}
