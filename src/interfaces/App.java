package interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	Scanner entrada = new Scanner(System.in);
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	ArrayList<Imovel> imovel = new ArrayList<Imovel>();
	ArrayList<Fatura> fatura = new ArrayList<Fatura>();
    ArrayList<Reparo> reparos = new ArrayList<Reparo>();
    ArrayList<Falha> falhas = new ArrayList<Falha>();


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
			System.out.println("\nCliente: " + c.getNome());
			System.out.println("CPF: " + c.getCPF() + "\n");
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
				Imovel novoimovel = new Imovel(c.getNome(), c.getCPF(), matricula, endereco, ultima_leitura,
						penultima_leitura);

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
				System.out.println(
						"Ultima leitura:" + i.getUltima_leitura() + "Penultima leitura: " + i.getPenultima_leitura());
			}
		}
	}

	public void listarImovel() {
		for (Imovel i : imovel) {
			System.out.println("Cliente:" + i.getNome() + "CPF: " + i.getCPF());
			System.out.println("Matricula:" + i.getMatricula() + "Endereco: " + i.getEndereco());
			System.out.println(
					"Ultima leitura:" + i.getUltima_leitura() + "Penultima leitura: " + i.getPenultima_leitura());

		}
	}

	public void excluirImovel() {
		System.out.println("Para excluir imovel, digite a matricula: ");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				imovel.remove(i);
				System.out.println("Imovel excluido");
			}
		}
	}

	public void alteraImovel() {
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

	public void lerConsumo() {
		System.out.println("Digite a mátricula do imóvel");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				System.out.println("Digite a nova leitura");
				double novaleitura = entrada.nextDouble();
				i.setPenultima_leitura(i.getUltima_leitura());
				i.setUltima_leitura(novaleitura);
				double valor = 10 * (novaleitura - i.getPenultima_leitura());
				Fatura fat = new Fatura(LocalDate.now(), i.getUltima_leitura(), i.getPenultima_leitura(), valor, true);
				fatura.add(fat);
			}
		}

	}

	public void listarFatura() {
		System.out.println("Digite a mátricula do imóvel");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				for (Fatura f : fatura) {
					System.out.println("Data: " + f.getData() + "Valor: " + f.getValor() + "Quitado: " + f.getQuitado());
				}

			}
		}
	}

	public void listarFaturaInadinplente() {
		System.out.println("Digite a mátricula do imóvel");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				for (Fatura f : fatura) {
					if (!f.getQuitado()) {
						System.out.println("Data: " + f.getData() + "Valor: " + f.getValor() + "Quitado: ");
					}
				}

			}
		}
	}

    public void incluirFalha() {
        System.out.println("Informe a matrícula do imóvel associado à falha:");
        String matricula = entrada.nextLine();
        entrada.nextLine();

        Imovel imovelAssociado = buscarImovelPorMatricula(matricula);
        if (imovelAssociado == null) {
            System.out.println("Imóvel não encontrado.");
            return;
        }

        System.out.println("Informe a descrição da falha:");
        String descricao = entrada.nextLine();

        System.out.println("Informe a previsão para a resolução da falha:");
        String previsao = entrada.nextLine();

        System.out.println("Informe a data de início da falha:");
        String dataInicio = entrada.nextLine();

        Falha novaFalha = new Falha(descricao, previsao, dataInicio);
       

        falhas.add(novaFalha);

        
        Reparo reparo = new Reparo(descricao, previsao, dataInicio);
        
        reparo.resolvido = false;

        reparos.add(reparo);

        System.out.println("Falha registrada com sucesso.");
    }

     public void incluirFalhaSemMatricula() {
       
        System.out.println("Informe a descrição da falha:");
        String descricao = entrada.nextLine();

        System.out.println("Informe a previsão para a resolução da falha:");
        String previsao = entrada.nextLine();

        System.out.println("Informe a data de início da falha:");
        String dataInicio = entrada.nextLine();

        Falha novaFalha = new Falha(descricao, previsao, dataInicio);
       

        falhas.add(novaFalha);

        
        Reparo reparo = new Reparo(descricao, previsao, dataInicio);
        
        reparo.resolvido = false;

        reparos.add(reparo);

        System.out.println("Falha registrada com sucesso.");
    }


    public void listarReparosEmAberto() {
        System.out.println("===== Reparos em Aberto =====");
        for (Reparo reparo : reparos) {
            if (!reparo.resolvido) {
                System.out.println("Descrição: " + reparo.descricao);
                System.out.println("Previsão: " + reparo.previsao);
                System.out.println("Data de Início: " + reparo.dataInicio);
                System.out.println("Resolvido: " + (reparo.resolvido ? "Sim" : "Não"));
                System.out.println("-----------");
            }
        }
    }

    public void encerrarReparo() {
        System.out.println("Informe a descrição do reparo a ser encerrado:");
        String descricaoReparo = entrada.nextLine();

        Reparo reparo = buscarReparoPorDescricao(descricaoReparo);

        if (reparo == null) {
            System.out.println("Reparo não encontrado.");
            return;
        }

        System.out.println("A falha associada a este reparo foi resolvida? (Sim/Não)");
        String resposta = entrada.nextLine().toLowerCase();

        if ("sim".equals(resposta)) {
            reparo.resolvido = true;
            System.out.println("Reparo encerrado com sucesso.");
        } else if ("não".equals(resposta)) {
            
            System.out.print("Digite uma nova previsão em dias: ");
            String novaPrevisao = entrada.nextLine();
            System.out.print("Digite uma nova data para inicio ");
            String novaDataInicio = entrada.nextLine();
            Reparo novoReparo = new Reparo(descricaoReparo, novaPrevisao, novaDataInicio);
                        
            novoReparo.resolvido = false;                 

            

            reparos.add(novoReparo);

            System.out.println("Novo reparo criado para a mesma falha.");
        } else {
            System.out.println("Resposta inválida.");
        }
    }

    public Imovel buscarImovelPorMatricula(String matricula) {
        for (Imovel imov : imovel) {
            
            if (imov.getMatricula() == matricula) {
                return imov;
            }
        }
        return null;
    }

    public Reparo buscarReparoPorDescricao(String descricao) {
        for (Reparo reparo : reparos) {
            if (reparo.descricao.equals(descricao)) {
                return reparo;
            }
        }
        return null;
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