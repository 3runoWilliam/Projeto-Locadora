package persistencia;

import java.sql.*;
import java.util.*;

import dominio.Dono;

public class DonoDAO {
	private Conexao c;
	private String pegar = "SELECT * FROM dono";
	
	public DonoDAO(){
		c = new Conexao();
	}
	
	public ArrayList<Dono> pegarDono(){
		ArrayList<Dono> listaDono = new ArrayList<>();		
		
		try {
			Dono dono;
			c.conectar();
			Statement apresentar = c.getConnection().createStatement();
			ResultSet rs = apresentar.executeQuery(pegar);
			
		    while(rs.next()) {
		    	dono = new Dono(rs.getInt("id_Dono"), rs.getString("senha_dono"), rs.getString("nome"));
		    	listaDono.add(dono);
		    }
			c.desconectar();
		}catch(Exception e) {
			System.out.println("--- ERRO EM PEGAR DONO ---" + e.getMessage());
		}
		return listaDono;	
	}
}