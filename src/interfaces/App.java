package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	Scanner entrada = new Scanner(System.in);
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	ArrayList<Imovel> imovel = new ArrayList<Imovel>();

	

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
	public void incluirImovel() {
			System.out.println("Digite o cpf do dono do imovel: ");
			String cpf = entrada.next();
			for (Cliente c : cliente) {
				if (c.getCPF().equals(cpf)) {
					System.out.println("digite a matricula:");
					String matricula = entrada.next();
					System.out.println("digite o endereço:");
					String endereco = entrada.next();
					System.out.println("digite a ultima leitura:");
					double ultima_leitura = entrada.nextDouble();
					System.out.println("digite a penultima leitura:");
					double penultima_leitura = entrada.nextDouble();
					Imovel imovel = new Imovel(c.getNome(), c.getCPF(), matricula, endereco, ultima_leitura, penultima_leitura);
					
				} 
			}
		}

	public void consultaImovel() {
		System.out.println("Consultar imovel, digite a matricula: ");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				System.out.println("Cliente:" + i.getNome() + "CPF: " + i.getCPF());
				System.out.println("Matricula:" + i.getMatricula() + "Endereco: " + i.getEndereco());
				System.out.println("Ultima leitura:" + i.getUltima_leitura() + "Penultima leitura: " + i.getPenultima_leitura());
			} 
		}
	}

	public void listarImovel(){
		for (Imovel i : imovel) {
			System.out.println("Cliente:" + i.getNome() + "CPF: " + i.getCPF());
			System.out.println("Matricula:" + i.getMatricula() + "Endereco: " + i.getEndereco());
			System.out.println("Ultima leitura:" + i.getUltima_leitura() + "Penultima leitura: " + i.getPenultima_leitura());
			
		}
	}
	public void excluirImovel(){
		System.out.println("Para excluir imovel, digite a matricula: ");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				imovel.remove(i);
				System.out.println("Imovel excluido");
			} 
		}
	}
	public void alteraImovel(){
		System.out.println("Para alterar imovel, digite a matricula: ");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				System.out.println("Digite o novo endereço: ");
				i.setEndereco(entrada.next());
				System.out.println("Digite a nova ultima leitura: ");
				i.setUltima_leitura(entrada.nextDouble());
				System.out.println("Digite o nova penultima leitura: ");
				i.setPenultima_leitura(entrada.nextDouble());
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