package visão;

import persistencia.*;

public class Main {

	public static void main(String[] args) {
		
		ClienteDAO cdao = new ClienteDAO();
		Conexao conexao = new Conexao("postgres","postgres","jdbc:postgresql://localhost:5432/BDAgenda");
		
		System.out.println("Menu Principal\r\n"
				+ "--------------------------\r\n"
				+ "1 – Cadastrar\r\n"
				+ "2 – Alugar Filme\r\n"
				+ "3 – Ver filmes disponíveis\r\n"
				+ "4 – Ver meus aluguéis e prazos\r\n"
				+ "5 – Valores dos filmes\r\n"
				+ "6 - Excluir cadastro\r\n"
				+ "7 – Portal do dono\r\n"
				+ "0 – Sair do Sistema \r\n"
				+ "");
		System.out.println(conexao.getConnection());
		System.out.println("MOSTRAR TABELA CLIENTE " + cdao.mostrarClientes());
	}

}
