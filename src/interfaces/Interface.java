package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entidades.Cliente;
import entidades.Fatura;
import entidades.Imovel;

public class Interface 
{
	public static void executarSistema(App app) {
		Scanner entrada = new Scanner(System.in);
		int opcao_usuario = 1;
		ArrayList<String> lista_opcoes = new ArrayList<String>(
				List.of("Clientes", "Imóveis", "Faturas", "Pagamentos", "Falhas"));

		while (opcao_usuario != 0) {
			// Exibir opções do menu
			Interface.montarMenu("principal", lista_opcoes);

			// Pegar opção do usuário
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();

			// Execução de gestão conforme opção do usuário
			switch (opcao_usuario) {
				case 0:
					System.out.println("Fim do programa!");
					break;

				case 1:
					gestaoClientes(app);
					break;

				case 2:
					gestaoImoveis(app);
					break;

				case 3:
					gestaoFaturas(app);
					break;

				case 4:
					gestaoPagamentos(app);
					break;

				case 5:
					gestaoFalhas(app);
					break;

				default:
					mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}

	public static void mostrarMensagemDefault(ArrayList<String> lista_opcoes) {
		System.out.println("Insira um número entre 0 e " + lista_opcoes.size());
	}
	
	public static void montarMenu(String tipo, ArrayList<String> lista_opcoes) {
		boolean is_principal = tipo.equals("principal");
		String complemento = (is_principal ? "Gestão de " : "");
		
		System.out.println("MENU " + tipo.toUpperCase());
		
		for (int i = 0; i < lista_opcoes.size(); i++) {
			System.out.println((i + 1) + ". " + complemento + lista_opcoes.get(i));
		}
		
		System.out.println("0. " + (is_principal ? "Sair do programa" : "Voltar ao menu anterior"));
	}
	
	public static void gestaoClientes(App app) {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Inserir", "Consultar", "Listar", "Excluir", "Alterar")
		);
		
		while (opcao_usuario != 0) 
		{
			Interface.montarMenu("gestão de clientes", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();
			
			switch (opcao_usuario)
			{
				case 0:
					System.out.println("Retornando...");
					break;
			
				case 1:
					app.incluirCliente();
					break;
					
				case 2:
					app.consultarCliente();
					break;
					
				case 3:
					app.listarCliente();
					break;
					
				case 4:
					app.excluirCliente();
					break;
					
				case 5:
					app.alterarCliente();
					break;
					
				default:
					mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoImoveis(App app) {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Inserir", "Consultar", "Listar", "Excluir", "Alterar")
		);
		
		while (opcao_usuario != 0) 
		{
			Interface.montarMenu("gestão de imóveis", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();
			
			switch (opcao_usuario)
			{
				case 0:
					System.out.println("Retornando...");
					break;
			
				case 1: 
					app.incluirImovel();
					break;
					
				case 2:
					app.consultaImovel();
					break;
					
				case 3:
					app.listarImovel();
					break;
					
				case 4:
					app.excluirImovel();
					break;
					
				case 5:
					app.alteraImovel();
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}

	public static void gestaoFaturas(App app) {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Registro de consumo", "Listar faturas", "Listar Faturas não pagas")
		);
		
		while (opcao_usuario != 0) 
		{
			Interface.montarMenu("gestão de faturas", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();
			
			switch (opcao_usuario)
			{
				case 0:
					System.out.println("Retornando...");
					break;
			
				case 1: 
					app.lerConsumo();
					break;
					
				case 2:
					app.listarFatura();
					break;
				
					case 3:
					app.listarFaturaInadinplente();
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoPagamentos(App app) {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Inclusão de pagamentos", "Listar todos os pagamentos", "Listar pagamentos de uma fatura", "Listar todos reembolsos", "Listar reembolsos de uma fatura"));
		
		while (opcao_usuario != 0) 
		{
			Interface.montarMenu("gestão de pagamentos", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();
			
			switch (opcao_usuario)
			{
				case 0:
					System.out.println("Retornando...");
					break;
					
				case 1: 
					app.pagarfatura();
					break;
					
				case 2:
					app.listarPagamentos();
					break;
				case 3:
					app.listarPagamentosFatura();
					break;
				case 4:
					app.listarreembolsos();
					break;
				case 5:
					app.listarReembolsosFatura();
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoFalhas(App app) {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Incluir falhas com matrícula", "Incluir falhas sem matrícula")
		);
		
		while (opcao_usuario != 0) 
		{
			Interface.montarMenu("gestão de falhas", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();
			
			switch (opcao_usuario)
			{
				case 0:
					System.out.println("Retornando...");
					break;
				
				case 1: 
					//app.
					break;
					
				case 2:
					//app.
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoReparos(App app) {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Listar reparos em aberto", "Encerrar reparo (poss outro)")
		);
		
		while (opcao_usuario != 0) 
		{
			Interface.montarMenu("gestão de reparos", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();
			
			switch (opcao_usuario)
			{
				case 0:
					System.out.println("Retornando...");
					break;
			
				case 1: 
					//app.
					break;
					
				case 2:
					//app.
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		App app = new App();
		executarSistema(app);
	}
}