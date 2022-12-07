package persistencia;

import dominio.Filme;


import java.util.*;
import java.sql.*;

public class FilmeDAO {

	private Conexao c;
	private String mostrar = "SELECT * FROM Filme";
	private String inserir = "INSERT INTO Filme(categoria, título, valor_aluguel) VALUES (?, ?, ?)";
	private String alterar = "UPDATE Filme SET categoria = ?, título = ?, valor_aluguel = ? WHERE id_filme = ?";
	private String deletar = "DELETE FROM Filme WHERE Id_Filme = ?";
	private String deletarFK = "DELETE FROM aluguel WHERE fk_Filme = ?";
	
	public FilmeDAO() {
		c = new Conexao();
	}
	
	public ArrayList<Filme> mostrarFilmes() {
		Filme filmes;
		ArrayList<Filme> lista = new ArrayList<Filme>();
		try {
			c.conectar();
			Statement apresentar = c.getConnection().createStatement();
			ResultSet rs = apresentar.executeQuery(mostrar);
			
			while(rs.next()) {
				filmes = new Filme(rs.getInt("Id_Filme"), rs.getString("categoria"), rs.getString("título"), rs.getInt("valor_aluguel"));
				lista.add(filmes);
			}
			c.desconectar();
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO DOS FILMES ---" + e.getMessage());			
		}
		return lista;
	}
	
	public void inserirFilme(Filme dale) {
		try {
			c.conectar();
			PreparedStatement adicionar = c.getConnection().prepareStatement(inserir);
			adicionar.setString(1, dale.getCategoria());
			adicionar.setString(2, dale.getTitulo());
			adicionar.setInt(3, dale.getValor_aluguel());
			
			adicionar.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println("--- ERRO EM INSERIR FILME ---" + e.getMessage());
		}
	}
	
	public void deletarFilme(int id) {
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
			System.out.println("--- ERRO DELETAR FILME ---" + e.getMessage());
		}
	}
	
	public void alterarFilme(Filme dale) {
		try {
			c.conectar();
			PreparedStatement mudar = c.getConnection().prepareStatement(alterar);
			mudar.setString(1, dale.getCategoria());
			mudar.setString(2, dale.getTitulo());
			mudar.setInt(3, dale.getValor_aluguel());
			mudar.setInt(4, dale.getId_Filme());
			
			mudar.execute();
			c.desconectar();
		}catch(Exception e) {
			System.out.println("--- ERRO PARA ALTERAR FILME ---" +e.getMessage());
		}
	}
}
