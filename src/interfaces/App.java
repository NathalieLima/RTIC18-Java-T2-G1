package interfaces;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	Scanner entrada = new Scanner(System.in);
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	public void incluirCliente(){
		System.out.println("Incluir cliente");
		String nome = entrada.next("Nome: ");
		String cpf = entrada.next("CPF: ");
		Cliente fulano = new Cliente(cpf, nome);
		cliente.add(fulano);
	}
	public void consultarCliente(){
        System.out.print("Digite o CPF do cliente que deseja consultar: ");
    String cpf = entrada.next();

    boolean encontrado = false;

    for (Cliente c : cliente) {
        if (c.getCPF().equals(cpf)) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCPF());
            encontrado = true;
            break;
        }

        if (!encontrado) {
        System.out.println("Cliente não encontrado.");
        }
	
	    }
    }
	public void listarCLiente(){
        
        System.out.println("Listagem de clientes: ");
        for (Cliente c : cliente) {
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCPF());
            
        }
	}
	public void excluirCLiente(){
		
        System.out.println("Digite o cpf do cliente que deseja excluir:");
		String cpfexcluir = entrada.next();
		
        for (Cliente c : cliente) {
			if (c.getCPF().equals(cpfexcluir)) {
				cliente.remove(c);
				System.out.println("Cliente excluido com sucesso");
			}
		}
	}
	public void alterarCLiente(){
		System.out.print("Digite o CPF do cliente que deseja alterar: ");
        String cpfAlterar = entrada.next();

        for (Cliente c : cliente) {
            if (c.getCPF().equals(cpfAlterar)) {
                System.out.println("Cliente encontrado:");
                System.out.println("Nome atual: " + c.getNome());
                System.out.print("Digite o novo nome: ");
                String novoNome = entrada.next();
                c.setNome(novoNome);
                System.out.println("Nome atualizado com sucesso para: " + c.getNome());
                
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

		//variaveis teste
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

public class MenuFaturas {
    private List<Fatura> faturas;

    public MenuFaturas() {
        faturas = new ArrayList<>();
    }

    public void criaFatura(String matricula, double valorLeituraAtual) {
        for (Fatura fatura : faturas) {
            if (fatura.getImovel().getMatricula().equals(matricula)) {
                double ultimaLeitura = fatura.getUltimaLeitura();
                fatura.setPenultimaLeitura(ultimaLeitura);
                fatura.setUltimaLeitura(valorLeituraAtual);
                fatura.setValor(calcularValor(valorLeituraAtual, ultimaLeitura));
                fatura.setQuitado(false);
                return;
            }
        }

        Fatura novaFatura = new Fatura(matricula, valorLeituraAtual);
        faturas.add(novaFatura);
    }

    public double calcularValor(double valorLeituraAtual, double ultimaLeitura) {
        return (valorLeituraAtual - ultimaLeitura) * 10;
    }

    public void listaFaturas() {
        for (Fatura fatura : faturas) {
            System.out.println(fatura);
        }
    }

    public void listaFaturasEmAberto() {
        for (Fatura fatura : faturas) {
            if (!fatura.isQuitado()) {
                System.out.println(fatura);
            }
        }
    }

    public static void main(String[] args) {
        MenuFaturas menuFaturas = new MenuFaturas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Faturas");
            System.out.println("1 - Criar Fatura");
            System.out.println("2 - Listar Faturas");
            System.out.println("3 - Listar Faturas em Aberto");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a matrícula do imóvel:");
                    String matricula = scanner.next();
                    System.out.println("Digite o valor da leitura atual:");
                    double valorLeituraAtual = scanner.nextDouble();
                    menuFaturas.criaFatura(matricula, valorLeituraAtual);
                    break;
                case 2:
                    menuFaturas.listaFaturas();
                    break;
                case 3:
                    menuFaturas.listaFaturasEmAberto();
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}