package visão;

import java.util.*;

import dominio.*;
import persistencia.*;

public class Main {

	public static void main(String[] args) {
		
		int opc = -1, opc2 = -1;
		ClienteDAO cdao = new ClienteDAO();
		AluguelDAO adao = new AluguelDAO();
		FilmeDAO fdao = new FilmeDAO();
		Scanner entrada = new Scanner(System.in);
		ArrayList<Cliente> listaNova = cdao.mostrarClientes();
		ArrayList<Aluguel> listaAluguel = adao.mostrarAlugueis();
		ArrayList<Filme> listaFilmes = fdao.mostrarFilmes();

		do {
			System.out.println("Menu Principal\r\n"
					+ "--------------------------\r\n"
					+ "1 – Cadastrar\r\n"
					+ "2 – Excluir cadastro\r\n"
					+ "3 – Alterar Usuario\r\n"
					+ "4 – Ver meus aluguéis e prazos\r\n"
					+ "5 – Valores dos filmes\r\n"
					+ "6 - Alugar Filme\r\n"
					+ "7 – Ver filmes disponíveis\r\n"
					+ "8 – Portal do dono\r\n"
					+ "0 – Sair do Sistema \r\n"
					+ "");
			
			opc = entrada.nextInt();
			
			switch(opc) {
			case 1:
				Cliente c = new Cliente();
				System.out.println("DIGITE O NOME: \n");
				entrada.nextLine();
				c.setName(entrada.nextLine());
				System.out.println("DIGITE O IDADE: \n");
				c.setIdade(entrada.nextInt());
				System.out.println("DIGITE O TELEFONE: \n");
				entrada.nextLine();
				c.setTelefone(entrada.nextLine());
				System.out.println("DIGITE O ENDEREÇO: \n");
				c.setEndereco(entrada.nextLine());
				
				cdao.inserirCliente(c);
				
				break;
			case 2:
				
				System.out.println("DIGITE O SEU ID: ");
				opc2 = entrada.nextInt();
				
				cdao.deletarCliente(opc2);
				
				break;
			case 3:
				for(int i=0; i < listaNova.size(); i++) {
					System.out.println(""+listaNova.get(i).getId()+"\t"+listaNova.get(i).getName()+"\t"+listaNova.get(i).getIdade()+"\t"+
							listaNova.get(i).getTelefone()+"\t"+listaNova.get(i).getEndereco());		
				}
				System.out.println("\nDE QUEM VOCÊ DESEJA ALTERAR? (DIGITE O ID) ");
				
				int aux = entrada.nextInt();
				for(int i=0; i < listaNova.size(); i++) {
					if(aux == listaNova.get(i).getId()) {
						System.out.println("O QUE VOCÊ DESEJA MUDAR? \n" +
								"1- NOME COMPLETO\n" +
								"2- IDADE\n" +
								"3- TELEFONE\n" +
								"4- ENDEREÇO\n");
						
						opc2 = entrada.nextInt();
						String aux4 = "";
						
						if(opc2 == 1) {
							System.out.println("DIGITE O NOME \n");
							entrada.nextLine();
							listaNova.get(i).setName(entrada.nextLine());
						}if(opc2 == 2) {
							System.out.println("DIGITE O IDADE: \n");
							listaNova.get(i).setIdade(entrada.nextInt());
						}if(opc2 == 3) {
							System.out.println("DIGITE O TELEFONE: \n");
							entrada.nextLine();
							listaNova.get(i).setTelefone(entrada.nextLine());
						}if(opc2 == 4) {
							System.out.println("DIGITE O ENDERECO: \n");
							entrada.nextLine();
							listaNova.get(i).setEndereco(entrada.nextLine());									
						}
						cdao.alterarCliente(listaNova.get(i));
					}
				}
				
				break;
			case 4:
				
				//mostrar os alugueis e os prazos do cliente pelo ID
				
				System.out.println("DIGITE SEU *ID* PARA LOCALIZARMOS SEUS ALUGUEIS PENDENTES: ");
				int aux2 = entrada.nextInt();
				
				for(int i=0; i < listaNova.size(); i++) {
					if(aux2 == listaNova.get(i).getId()) {
						for(i=0; i < listaAluguel.size(); i++) {
							System.out.println(""+listaAluguel.get(i).getData_aluguel()+"\t"+listaAluguel.get(i).getData_entrega()+"\t"+listaAluguel.get(i).getValor_aluguel());		
						}
					}
				}
				
				break;
			case 5:
				
				break;
			case 6:				
				System.out.println("DIGITE SEU *ID* PARA INICIARMOS UM ALUGUEL : ");
				aux2 = entrada.nextInt();
				
				for(int i=0; i < listaNova.size(); i++) {
					if(aux2 == listaNova.get(i).getId()) {
						System.out.println("OLÁ, " + listaNova.get(i).getName());
						System.out.println("\n");
						
						
						for(i=0; i < listaFilmes.size(); i++) {
							System.out.println(""+ listaFilmes.get(i).getId_Filme() + "\t" + listaFilmes.get(i).getCategoria() + "\t" + listaFilmes.get(i).getTitulo());		
						}
						System.out.println("\nDIGITE O *ID* DO FILME QUE VOCÊ DESEJA ALUGAR: ");
						aux2 = entrada.nextInt();
						
						for(i=0; i < listaFilmes.size(); i++) {
							if(aux2 == listaFilmes.get(i).getId_Filme()) {
								System.out.println("VOCÊ ALUGOU: " + listaFilmes.get(i).getTitulo());
								
								
							}
						}
						//lista dos filmes cadastrados -- Select * FROM Filme
					}
				}
				
				break;
			case 7:
				
				break;
			case 8:
				//CADASTRAR FILMES
				
				Filme f = new Filme();
				
				for(int i=0; i < listaFilmes.size(); i++) {
					System.out.println(""+ listaFilmes.get(i).getId_Filme() + "\t" + listaFilmes.get(i).getCategoria() + "\t" + listaFilmes.get(i).getTitulo());		
				}
				
				
				System.out.println("\nDIGITE A CATEGORIA DO FILME : \n");
				entrada.nextLine();
				f.setCategoria(entrada.nextLine());
				System.out.println("DIGITE O TITULO DO FILME: \n");
				f.setTitulo(entrada.nextLine());
				
				fdao.inserirFilme(f);				
				break;
			}
		}while(opc != 0);
			System.out.println("SISTEMA FECHADO");
	}
}