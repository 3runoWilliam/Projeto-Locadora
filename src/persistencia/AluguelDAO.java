package persistencia;

import dominio.Aluguel;

import java.util.*;
import java.sql.*;

public class AluguelDAO {
	
	private Conexao c;
	private String mostrar = "SELECT * FROM Aluguel";
	
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
				aluguel = new Aluguel(rs.getString("Data_aluguel"), rs.getString("Data_entrega"), rs.getInt("valor_aluguel"));
				lista.add(aluguel);
			}
			c.desconectar();
			
		}catch(Exception e){
			System.out.println("--- ERRO NO RELATORIO ---" + e.getMessage());			
		}
		return null;
	}
	
}
