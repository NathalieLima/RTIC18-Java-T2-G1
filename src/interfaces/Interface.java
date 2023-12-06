package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface {
	

	
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
	
	public static void gestaoClientes() {
		App x = new App();
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
					x.incluirCliente();
					break;
					
				case 2:
					x.consultarCliente();
					break;
					
				case 3:
					x.listarCliente();
					break;
					
				case 4:
					x.excluirCliente();
					break;
					
				case 5:
					x.alterarCliente();
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoImoveis() {
		int opcao_usuario = 1;
		App x = new App();
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
					x.incluirImovel();
					break;
					
				case 2:
					x.consultaImovel();
					break;
					
				case 3:
					x.listarImovel();
					break;
					
				case 4:
					x.excluirImovel();
					break;
					
				case 5:
					x.alteraImovel();
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}

	public static void gestaoFaturas() {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Registro de consumo", "Listar faturas")
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
					break;
					
				case 2:
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoPagamentos() {
		int opcao_usuario = 1;
		Scanner entrada = new Scanner(System.in);
		ArrayList<String> lista_opcoes = new ArrayList<String>(
		List.of("Inclusão de pagamentos", "Listar pagamentos", "Listar reembolsos")
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
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoFalhas() {
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
					break;
					
				case 2:
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	public static void gestaoReparos() {
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
					break;
					
				case 2:
					break;
					
				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
	
	
		
	
}