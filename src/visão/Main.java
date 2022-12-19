package visão;

import java.util.*;

import dominio.*;
import persistencia.*;

public class Main {

	public static void main(String[] args) {
		
		ClienteDAO cdao = new ClienteDAO();
		AluguelDAO adao = new AluguelDAO();
		FilmeDAO fdao = new FilmeDAO();
		Filme f = new Filme();
		Scanner entrada = new Scanner(System.in);
		ArrayList<Cliente> listaCliente = cdao.mostrarClientes();
		ArrayList<Filme> listaFilmes = fdao.mostrarFilmes();
		int opc = -1, opc2 = -1;

		do {
			System.out.println("\nMenu Principal\r\n"
					+ "--------------------------\r\n"
					+ "1 – Cadastrar\r\n"
					+ "2 – Excluir cadastro\r\n"
					+ "3 – Alterar Usuario\r\n"
					+ "4 – Ver meus aluguéis e prazos\r\n"
					+ "5 – Valores dos filmes\r\n"
					+ "6 - Alugar Filme\r\n"
					+ "7 – Portal do dono\r\n"
					+ "0 – Sair do Sistema \r\n"
					+ "--------------------------\r\n");
						
			opc = entrada.nextInt();
			
			switch(opc) {
			case 1:
				Cliente c = new Cliente();
				System.out.println("\nDIGITE O NOME: ");
				entrada.nextLine();
				c.setName(entrada.nextLine());
				System.out.println("\nDIGITE O IDADE: ");
				c.setIdade(entrada.nextInt());
				System.out.println("\nDIGITE O TELEFONE: ");
				entrada.nextLine();
				c.setTelefone(entrada.nextLine());
				System.out.println("\nDIGITE O ENDEREÇO: ");
				c.setEndereco(entrada.nextLine());
				
				cdao.inserirCliente(c);
				break;
			case 2:
				System.out.println("DIGITE O SEU ID: ");
				opc2 = entrada.nextInt();
				
				cdao.deletarCliente(opc2);
				break;
			case 3:
				System.out.println("\nDE QUEM VOCÊ DESEJA ALTERAR? (DIGITE O ID) ");
				
				int aux = entrada.nextInt();
				for(int i=0; i < listaCliente.size(); i++) {
					if(aux == listaCliente.get(i).getId()) {
						System.out.println("O QUE VOCÊ DESEJA MUDAR? \n" +
								"1- NOME COMPLETO\n" +
								"2- IDADE\n" +
								"3- TELEFONE\n" +
								"4- ENDEREÇO\n");
						opc2 = entrada.nextInt();
						
						if(opc2 == 1) {
							System.out.println("\nDIGITE O NOME ");
							entrada.nextLine();
							listaCliente.get(i).setName(entrada.nextLine());
						}if(opc2 == 2) {
							System.out.println("\nDIGITE O IDADE: ");
							listaCliente.get(i).setIdade(entrada.nextInt());
						}if(opc2 == 3) {
							System.out.println("\nDIGITE O TELEFONE: ");
							entrada.nextLine();
							listaCliente.get(i).setTelefone(entrada.nextLine());
						}if(opc2 == 4) {
							System.out.println("\nDIGITE O ENDERECO: ");
							entrada.nextLine();
							listaCliente.get(i).setEndereco(entrada.nextLine());									
						}
						cdao.alterarCliente(listaCliente.get(i));
					}
				}
				break;
			case 4:
				
				System.out.println("DIGITE SEU *ID* PARA LOCALIZARMOS SEUS ALUGUEIS PENDENTES: ");
				int id1 = entrada.nextInt();
				entrada.nextLine();
				
				for(int i=0; i < listaCliente.size(); i++) {
					if(id1 == listaCliente.get(i).getId()) {
						System.out.println("OLÁ, " + listaCliente.get(i).getName() + " SEUS ALUGUEIS PENDENTES SÃO: ");
					}
				}
				Aluguel a = new Aluguel();
				ArrayList<Filme> listaFilmes1 = new ArrayList<>();
				listaFilmes1 = a.relatorioFilme(id1);
				
				for(int i=0; i<listaFilmes1.size();i++){
					System.out.println("\n" + listaFilmes.get(i).getId_Filme() + "	|	" + listaFilmes.get(i).getCategoria() + "	|	" + listaFilmes.get(i).getTitulo() + "	|	R$" + listaFilmes.get(i).getValor_aluguel());
				}
				break;
				
			case 5:
				for(int i=0; i < listaFilmes.size(); i++) {
					System.out.println("\n" + listaFilmes.get(i).getId_Filme() + "	|	" + listaFilmes.get(i).getCategoria() + "	|	" + listaFilmes.get(i).getTitulo() + "	|	R$" + listaFilmes.get(i).getValor_aluguel());		
				}
				break;
				
			case 6:		
				a = new Aluguel();
				int aux2;
				
				System.out.println("DIGITE SEU *ID* PARA INICIARMOS UM ALUGUEL : ");
				aux2 = entrada.nextInt();
				a.setFk_cliente(aux2);
				
				for(int i=0; i < listaCliente.size(); i++) {
					if(aux2 == listaCliente.get(i).getId()) {
						System.out.println("OLÁ, " + listaCliente.get(i).getName());
						System.out.println("\n");
						
						for(i=0; i < listaFilmes.size(); i++) {
							System.out.println(""+ listaFilmes.get(i).getId_Filme() + "	|	" + listaFilmes.get(i).getCategoria() + "	|	" + listaFilmes.get(i).getTitulo() + "	|	" + listaFilmes.get(i).getValor_aluguel());		
						}
						
						System.out.println("\nDIGITE O *ID* DO FILME QUE VOCÊ DESEJA ALUGAR: ");
						aux2 = entrada.nextInt();
						a.setFk_filme(aux2);

						for(i=0; i < listaFilmes.size(); i++) {
							if(aux2 == listaFilmes.get(i).getId_Filme()) {
								System.out.println("VOCÊ ALUGOU: " + listaFilmes.get(i).getTitulo());;
								
								System.out.println("DIGITE O DIA QUE VOCÊ QUER *ALUGAR* ESTE FILME: ");
								entrada.nextLine();
								a.setData_aluguel(entrada.nextLine());
								System.out.println("DIGITE O DIA QUE VOCÊ QUER *ENTREGAR* ESTE FILME: ");
								a.setData_entrega(entrada.nextLine());
								
								a.setValor_aluguel(listaFilmes.get(i).getValor_aluguel());
								
								adao.adicionarAluguel(a);
							}
						}
					}
				}
				break;
			case 7:
				
				DonoDAO ddao = new DonoDAO();
				ArrayList<Dono> d = ddao.pegarDono();
				String aux3 = "";
								
				System.out.println("DIGITE SEU ID \n");
				aux2 = entrada.nextInt();
				entrada.nextLine();
				
				System.out.println("DIGITE SUA SENHA \n");
				aux3 = entrada.nextLine();
				
				for(int i = 0; i < d.size(); i++) {
					if(d.get(i).getId_Dono() == aux2) {
						if(aux3.equals(d.get(i).getSenha())) {
							System.out.println("\nBEM VINDO " + d.get(i).getNome());
							
							listaFilmes = fdao.mostrarFilmes();
							for(i=0; i < listaFilmes.size(); i++) {
								System.out.println(""+ listaFilmes.get(i).getId_Filme() +  "	|	" + listaFilmes.get(i).getCategoria() + "	|	" + listaFilmes.get(i).getTitulo() + "	|	R$ " + listaFilmes.get(i).getValor_aluguel());		
							}

							System.out.println("\nO QUE VOCÊ DESEJA FAZER? \n" +
									"1- ADICIONAR UM FILME\n" +
									"2- ALTERAR UM FILME\n" +
									"3- DELETAR UM FILME\n" +
									"4- VÊ CADASTROS\n");
							aux2 = entrada.nextInt();
							
							if(aux2 == 1) {
								System.out.println("\nDIGITE A *CATEGORIA* DO FILME : \n");
								entrada.nextLine();
								f.setCategoria(entrada.nextLine());
								System.out.println("DIGITE O *TITULO* DO FILME: \n");
								f.setTitulo(entrada.nextLine());
								System.out.println("DIGITE O *VALOR* DO FILME: \n");
								f.setValor_aluguel(entrada.nextInt());
								
								fdao.inserirFilme(f);
							}if(aux2 == 2) {
								System.out.println("\nDE QUEM VOCÊ DESEJA ALTERAR? (DIGITE O ID) ");
								aux = entrada.nextInt();
								
								for(i=0; i < listaFilmes.size(); i++) {
									if(aux == listaFilmes.get(i).getId_Filme()) {
										System.out.println("\nO QUE VOCÊ DESEJA MUDAR? \n" +
												"1- CATEGORIA\n" +
												"2- TITULO\n" +
												"3- VALOR DO ALUGUEL\n");
										opc2 = entrada.nextInt();
										listaFilmes.get(i).setId_Filme(aux);
										
										if(opc2 == 1) {
											System.out.println("DIGITE A CATEGORIA:\n");
											entrada.nextLine();
											listaFilmes.get(i).setCategoria(entrada.nextLine());
										}if(opc2 == 2) {
											System.out.println("DIGITE O TITULO: \n");
											entrada.nextLine();
											listaFilmes.get(i).setTitulo(entrada.nextLine());
										}if(opc2 == 3) {
											System.out.println("DIGITE O VALOR DO ALUGUEL: \n");
											listaFilmes.get(i).setValor_aluguel(entrada.nextInt());
										}
										fdao.alterarFilme(listaFilmes.get(i));
									}
								}
							}if(aux2 == 3) {
								System.out.println("DIGITE O *ID* DE QUEM VOCÊ DESEJA DELETAR: ");
								opc2 = entrada.nextInt();
								
								fdao.deletarFilme(opc2);
							}if(aux2 == 4) {
								listaCliente = cdao.mostrarClientes();
								for(i=0; i < listaCliente.size(); i++) {
									System.out.println(""+listaCliente.get(i).getId() + "	|	" + listaCliente.get(i).getName() + "	|	"+listaCliente.get(i).getIdade() + "	|	" +
											listaCliente.get(i).getTelefone() + "	|	"+listaCliente.get(i).getEndereco());		
								}
							}
						}else {
							System.out.println("--- SENHA ERRADA ---");
						}
					}else {
						System.out.println("--- ID ERRADO ---");
					}
				}
				break;
			}
		}while(opc != 0);
			System.out.println("SISTEMA FECHADO");
	}
}