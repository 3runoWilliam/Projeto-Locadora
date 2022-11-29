package dominio;

public class Filme {

	private int id_Filme;
	private String categoria;
	private String titulo; 
	
	public Filme() {
		
	}
	
	public Filme(int id_Filme, String categoria, String titulo) {
		this.id_Filme = id_Filme;
		this.categoria = categoria;
		this.titulo = titulo;
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
	
}
