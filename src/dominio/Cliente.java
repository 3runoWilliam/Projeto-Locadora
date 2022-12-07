package dominio;

public class Cliente {
	private int id; 
	private String name; 
	private int idade;
	private String telefone; 
	private String endereco;
	
	public Cliente() {
		
	}
	
	public Cliente(String name, String telefone) {
		this.name = name;
		this.telefone = telefone;
	}

	public Cliente(int id, String name, int idade, String telefone, String endereco) {
		this.id = id;
		this.name = name;
		this.idade = idade;
		this.telefone = telefone;
		this.endereco = endereco;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
