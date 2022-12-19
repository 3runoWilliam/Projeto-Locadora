package dominio;

public class Filme {

	private int id_Filme;
	private String categoria;
	private String titulo;
	private int valor_aluguel;

	public Filme() {
		
	}
	
	public Filme(String categoria, String titulo, int valor_aluguel) {
		this.categoria = categoria;
		this.titulo = titulo;
		this.valor_aluguel = valor_aluguel;
	}
	public Filme(int id_Filme, String categoria, String titulo, int valor_aluguel) {
		this.id_Filme = id_Filme;
		this.categoria = categoria;
		this.titulo = titulo;
		this.valor_aluguel = valor_aluguel;
	}

	public int getId_Filme() {
		return id_Filme;
	}

	public void setId_Filme(int id_Filme) {
		this.id_Filme = id_Filme;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getValor_aluguel() {
		return valor_aluguel;
	}
	
	public void setValor_aluguel(int valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}	
}
