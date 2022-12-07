package dominio;


public class Aluguel {
	
	private String Data_aluguel;
	private String Data_entrega; 
	private int valor_aluguel;
	private int fk_filme;
	private int fk_cliente;
	//quando um cliente alugar um filme, este filme terá prazo e valor (dependendo se for lançamento ou não)
	
	public Aluguel() {
		
	}
	
	public Aluguel(String Data_aluguel, String Data_entrega, int valor_aluguel, int fk_filme) {
		this.Data_aluguel = Data_aluguel;
		this.Data_entrega = Data_entrega;
		this.valor_aluguel = valor_aluguel;
		this.fk_filme = fk_filme;
	}

	public String getData_aluguel() {
		return Data_aluguel;
	}

	public void setData_aluguel(String data_aluguel) {
		Data_aluguel = data_aluguel;
	}

	public String getData_entrega() {
		return Data_entrega;
	}

	public void setData_entrega(String data_entrega) {
		Data_entrega = data_entrega;
	}

	public int getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(int valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}

	public int getFk_filme() {
		return fk_filme;
	}

	public void setFk_filme(int fk_filme) {
		this.fk_filme = fk_filme;
	}

	public int getFk_cliente() {
		return fk_cliente;
	}

	public void setFk_cliente(int fk_cliente) {
		this.fk_cliente = fk_cliente;
	}
}
