package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	Scanner entrada = new Scanner(System.in);
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();

	

	public void incluirCliente() {
		System.out.println("Incluir cliente");
		System.out.println("digite o nome:");
		String nome = entrada.next();
		System.out.println("digite o cpf:");
		String cpf = entrada.next();
		Cliente fulano = new Cliente(nome, cpf);
		cliente.add(fulano);
	}


	public void consultarCliente() {
		System.out.println("Consultar cliente, digite o CPF: ");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				System.out.println("Cliente:" + c.getNome() + "CPF: " + c.getCPF());
			} 
		}
	}

	public void listarCliente() {
		for (Cliente c : cliente) {
			System.out.println("Cliente: " + c.getNome() + "  CPF: " + c.getCPF());
		}
	}

	public void excluirCliente() {
		System.out.println("Digite o cpf do cliente a ser excluido:");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				cliente.remove(c);
				System.out.println("Cliente excluido");
			} 
		}

	}

	public void alterarCliente() {
		System.out.println("Digite o cpf do cliente a ser alterado:");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				System.out.println("Digite o novo nome: ");
				c.setNome(entrada.next());
			} 
		}
	}


	public static void main(String[] args) {
		Interface app = new Interface();
		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		ArrayList<Fatura> fatura = new ArrayList<Fatura>();
		ArrayList<Imovel> imovel = new ArrayList<Imovel>();
		ArrayList<String> lista_opcoes = new ArrayList<String>(
				List.of("Clientes", "Imóveis", "Faturas", "Pagamentos", "Falhas"));
		int opcao_usuario = 1;
		String nome, email;
		Scanner entrada = new Scanner(System.in);


		Cliente a = new Cliente("123.456.789-10", "Arthur");
		Cliente b = new Cliente("123.456.789-20", "Nathalie");
		Cliente c = new Cliente("123.456.789-30", "Leane");

		while (opcao_usuario != 0) {
			Interface.montarMenu("principal", lista_opcoes);
			System.out.print("\nSua opção: ");
			opcao_usuario = entrada.nextInt();

			switch (opcao_usuario) {
				case 0:
					System.out.println("Fim do programa!");
					break;

				case 1:
					app.gestaoClientes();
					break;

				case 2:
					app.gestaoImoveis();
					break;

				case 3:
					app.gestaoFaturas();
					break;

				case 4:
					app.gestaoPagamentos();
					break;

				case 5:
					app.gestaoFalhas();
					break;

				default:
					Interface.mostrarMensagemDefault(lista_opcoes);
					break;
			}
		}
	}
}