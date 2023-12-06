package interfaces;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	Scanner entrada = new Scanner(System.in);
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
<<<<<<< Updated upstream
	public void incluirCliente(){
=======

	public void incluirCliente() {
>>>>>>> Stashed changes
		System.out.println("Incluir cliente");
		String nome = entrada.next("Nome: ");
		String cpf = entrada.next("CPF: ");
		Cliente fulano = new Cliente(cpf, nome);
		cliente.add(fulano);
	}
<<<<<<< Updated upstream
	public void consultarCliente(){
	
	}
	public void listarCLiente(){

	}
	public void excluirCLiente(){
		
	}
	public void alterarCLiente(){
		
	}
=======

	public void consultarCliente() {
		String cpf = entrada.next("Digite o cpf do cliente: ");
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				System.out.println("Cliente:" + c.getNome() + "CPF: " + c.getCPF());
			} else {
				System.out.println("Cliente não encontrado");

			}
		}
	}

	public void listarCLiente() {
		for (Cliente c : cliente) {
			System.out.println("Cliente:" + c.getNome() + "CPF: " + c.getCPF());
		}
	}

	public void excluirCLiente() {
		String cpf = entrada.next("Digite o cpf do cliente a ser excluido: ");
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				cliente.remove(c);
				System.out.println("Cliente excluido");
			} else {
				System.out.println("Cliente não encontrado");

			}
		}

	}

	public void alterarCLiente() {
		String cpf = entrada.next("Digite o cpf do cliente a ser alterado: ");
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				c.setNome(entrada.next("Digite o novo nome: "));
			} else {
				System.out.println("Cliente não encontrado");
			}
		}
	}

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
		//variaveis teste
=======
		// variaveis teste
>>>>>>> Stashed changes
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