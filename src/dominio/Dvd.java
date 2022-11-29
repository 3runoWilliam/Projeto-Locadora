package dominio;


public class Dvd {

	private int Id_Dvd;
	private String Adicionar_Dvd;
	//private int FK_Cliente;
	private String Qnt_Dvd_Daquele_Filme;
	
	public Dvd() {
		
	}
	
	public Dvd(int Id_Dvd, String Adicionar_Dvd, String Qnt_Dvd_Daquele_Filme) {
		this.Id_Dvd = Id_Dvd;
		this.Adicionar_Dvd = Adicionar_Dvd;
		this.Qnt_Dvd_Daquele_Filme = Qnt_Dvd_Daquele_Filme;
	}

	public int getId_Dvd() {
		return Id_Dvd;
	}

	public void setId_Dvd(int id_Dvd) {
		Id_Dvd = id_Dvd;
	}

	public String getAdicionar_Dvd() {
		return Adicionar_Dvd;
	}

	public void setAdicionar_Dvd(String adicionar_Dvd) {
		Adicionar_Dvd = adicionar_Dvd;
	}

	public String getQnt_Dvd_Daquele_Filme() {
		return Qnt_Dvd_Daquele_Filme;
	}

	public void setQnt_Dvd_Daquele_Filme(String qnt_Dvd_Daquele_Filme) {
		Qnt_Dvd_Daquele_Filme = qnt_Dvd_Daquele_Filme;
	}
	
}
