package dominio;

public class Dono {

	private int id_Dono;
	private String senha_dono;
	private String nome;
	
	public Dono() {
		
	}
	
	public Dono(int id_Dono, String senha_dono, String nome) {
		this.id_Dono = id_Dono;
		this.senha_dono = senha_dono;
		this.nome = nome;
	}
	
	public int getId_Dono() {
		return id_Dono;
	}
	
	public String getSenha() {
		return senha_dono;
	}
	
	public String getNome() {
		return nome;
	}
}