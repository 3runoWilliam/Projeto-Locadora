package dominio;
import java.util.*;

public class Dono {

	private int Id_Dono;
	private String senha;
	
	public Dono() {
		
	}
	
	public Dono(int Id_Dono, String senha) {
		this.Id_Dono = Id_Dono;
		this.senha = senha;
		
	}
	
	public int getId_Dono() {
		return Id_Dono;
	}

	public void setId_Dono(int id_Dono) {
		Id_Dono = id_Dono;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Aluguel> mostrarAlugueis() {
		
		return null;
	}
}
