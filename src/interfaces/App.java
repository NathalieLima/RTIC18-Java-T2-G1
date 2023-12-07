package interfaces;

import entidades.*;
import auxiliares.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	Scanner entrada = new Scanner(System.in);
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	ArrayList<Imovel> imovel = new ArrayList<Imovel>();
	ArrayList<Fatura> fatura = new ArrayList<Fatura>();
	ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
	ArrayList<Reembolso> reembolsos = new ArrayList<Reembolso>();
	ArrayList<Reparo> reparos = new ArrayList<Reparo>();
	ArrayList<Falha> falhas = new ArrayList<Falha>();

	public void incluirCliente() {
		System.out.println("Incluir cliente");
		System.out.println("digite o nome:");
		String nome = entrada.nextLine();
		System.out.println("digite o cpf:");
		String cpf = entrada.next();
		Cliente fulano = new Cliente(nome, cpf);
		cliente.add(fulano);
	}

	public void consultarCliente() {
		System.out.println("Consultar cliente, digite o CPF: ");
		String cpf = entrada.next();
		boolean flag = false;
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				System.out.println("Cliente:" + c.getNome() + "  CPF: " + c.getCPF());
				flag = true;
				}
			
		}
		if(!flag) {
			System.out.println("CPF nao encontrado");
		}
	}

	public void listarCliente() {
		for (Cliente c : cliente) {
			System.out.println("\nCliente: " + c.getNome());
			System.out.println("CPF: " + c.getCPF() + "\n");
		}
	}

	public void excluirCliente() {
		boolean flag = false;
		System.out.println("Digite o cpf do cliente a ser excluido:");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				cliente.remove(c);
				System.out.println("Cliente excluido");
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("CPF nao encontrado");
		}
		
	}

	public void alterarCliente() {
		boolean flag = false;
		System.out.println("Digite o cpf do cliente a ser alterado:");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				System.out.println("Digite o novo nome: ");
				c.setNome(entrada.next());
				flag = true;

			}
		}
		if(!flag) {
			System.out.println("CPF nao encontrado");
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
				Imovel i = new Imovel(cpf, matricula, endereco, ultima_leitura, penultima_leitura);
				imovel.add(i);

			}
		}
	}

	public void consultaImovel() {
		System.out.println("Consultar imovel, digite a matricula: ");
		String matricula = entrada.next();
		boolean flag = false;
		String nome = new String();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				flag = true;
				for (Cliente c : cliente) {
					if (c.getCPF().equals(i.getCPF())) {
						nome = c.getNome();
					}
				}
				System.out.println("Cliente: " + nome + " | CPF: " + i.getCPF());
				System.out.println("Matricula: " + i.getMatricula() + " | Endereco: " + i.getEndereco());
				System.out.println("Ultima leitura: " + i.getUltima_leitura() + " | Penultima leitura: "
						+ i.getPenultima_leitura());
			}
		}
		if(!flag) {
			System.out.println("Matricula nao encontrada");
		}
	}

	public void listarImovel() {
		for (Imovel i : imovel) {
			System.out.println("Matricula:  " + i.getMatricula() + "  Endereco: " + i.getEndereco());
			System.out.println(
					"Ultima leitura:  " + i.getUltima_leitura() + "  Penultima leitura: " + i.getPenultima_leitura());
		}
	}

	public void excluirImovel() {
		boolean flag = false;
		System.out.println("Para excluir imovel, digite a matricula: ");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				imovel.remove(i);
				System.out.println("Imovel excluido");
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("Matricula nao encontrada");
		}
	}

	public void alteraImovel() {
		System.out.println("Para alterar imovel, digite a matricula: ");
		String matricula = entrada.next();
		boolean flag = false;
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				System.out.println("Digite o novo endereço: ");
				i.setEndereco(entrada.next());
				System.out.println("Digite a nova ultima leitura: ");
				i.setUltima_leitura(entrada.nextDouble());
				System.out.println("Digite o nova penultima leitura: ");
				i.setPenultima_leitura(entrada.nextDouble());
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("Matricula nao encontrada");
		}
	}

	public void lerConsumo() {
		System.out.println("Digite a mátricula do imóvel");
		boolean flag = false;

		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				System.out.println("Digite a nova leitura");
				double novaleitura = entrada.nextDouble();
				i.setPenultima_leitura(i.getUltima_leitura());
				i.setUltima_leitura(novaleitura);
				double valor = 10 * (novaleitura - i.getPenultima_leitura());
				Fatura fat = new Fatura(LocalDate.now(), i.getUltima_leitura(), i.getPenultima_leitura(), valor,
						matricula, false);
				fatura.add(fat);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("Matricula nao encontrada");
		}
	}

	public void listarFatura() {
		System.out.println("Digite a mátricula do imóvel");
		boolean flag = false;
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				for (Fatura f : fatura) {
					System.out.println(
							"Data: " + f.getData() + "  Valor: " + f.getValor() + "  Quitado: " + f.getQuitado());
				}
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("Matricula nao encontrada");
		}
	}

	public void listarFaturaInadinplente() {
		System.out.println("Digite a mátricula do imóvel");
		boolean flag = false;
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				for (Fatura f : fatura) {
					if (!f.getQuitado()) {
						System.out.println("Data: " + f.getData() + "  Valor: " + f.getValor() + "  Quitado: ");
					}
				}
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("Matricula nao encontrada");
		}
	}

	public void pagarfatura() {
		System.out.println("Digite a matricula do imovel");
		String matricula = entrada.next();
		boolean flag = false;
		System.out.println("Digite a data da fatura no formato AAAA-MM-DD:");
		LocalDate dataFatura = LocalDate.parse(entrada.next());
		double totalpagamento = 0, pagamento = 0;
		LocalDate dataPagamento = LocalDate.now();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				flag = true;
				for (Fatura f : fatura) {
					if (!f.getQuitado()) {
						System.out.println("Insira seu pagamento: ");
						pagamento = entrada.nextDouble();
						Pagamento pag = new Pagamento(dataPagamento, dataFatura, pagamento, matricula);
						pagamentos.add(pag);
						// verifica se a fatura foi quitada
						for (Pagamento p : pagamentos) {
							if (dataFatura.equals(p.getDataPagamento()) && matricula.equals(p.getMatricula())) {
								totalpagamento += p.getValor();
							}
						}
						if (totalpagamento < f.getValor()) {
							f.setQuitado(false);
							System.out.println("Fatura ainda pendente!!");
							System.out.println("Pagamento restante = " + (f.getValor() - totalpagamento));
						} else {
							f.setQuitado(true);
							System.out.println("Fatura foi quitada!!");
							if (totalpagamento > f.getValor()) {
								double valorreembolso = totalpagamento - f.getValor();
								System.out.println("Pagamento excedente = " + (valorreembolso));
								System.out.println("Você recebera esse valor como reembolso!");
								Reembolso reembolso = new Reembolso(dataPagamento, dataFatura,
										valorreembolso, matricula);
								reembolsos.add(reembolso);
							}
						}
					}
				}
			}
			if(!flag) {
			System.out.println("Matricula nao encontrada");
		}
		}
	}

	public void listarPagamentosFatura() {
		System.out.println("Digite a matricula do imovel");
		String matricula = entrada.next();
		System.out.println("Digite a data da fatura no formato AAAA-MM-DD:");
		LocalDate dataFatura = LocalDate.parse(entrada.next());
		for (Pagamento p : pagamentos) {
			if (dataFatura.equals(p.getDataFatura()) && matricula.equals(p.getMatricula())) {
				System.out.println("Data do Pagamento: " + p.getDataPagamento() + " | Data da fatura: "
						+ p.getDataFatura() + " | Matricula: " + p.getMatricula() + " | Valor: " + p.getValor());

			}
		}
	}

	public void listarPagamentos() {
		for (Pagamento p : pagamentos) {
			System.out.println("Data do Pagamento: " + p.getDataPagamento() + " | Data da fatura: "
					+ p.getDataFatura() + " | Matricula: " + p.getMatricula() + " | Valor: " + p.getValor());

		}
	}

	public void listarreembolsos() {

		for (Reembolso r : reembolsos) {

			System.out.println("Data do Pagamento: " + r.getDataPagamento() + " | Data da fatura: "
					+ r.getDataPagamento() + " | Matricula: " + r.getMatricula() + " | Valor: "
					+ r.getValorreembolso());
		}
	}

	public void listarReembolsosFatura() {

		System.out.println("Digite a matricula do imovel");
		String matricula = entrada.next();
		System.out.println("Digite a data da fatura no formato AAAA-MM-DD:");
		LocalDate dataFatura = LocalDate.parse(entrada.next());
		for (Reembolso r : reembolsos) {
			if (dataFatura.equals(r.getDataPagamento()) && matricula.equals(r.getMatricula())) {
				System.out.println("Data do Pagamento: " + r.getDataPagamento() + " | Data da fatura: "
						+ r.getDataPagamento() + " | Matricula: " + r.getMatricula() + " | Valor: "
						+ r.getValorreembolso());

			}
		}
	}

	public void incluirFalha() {
		System.out.println("Informe a matrícula do imóvel associado à falha:");
		String matricula = entrada.next();
		entrada.nextLine();
		boolean flag = false;

		for (Imovel i : imovel) {
			if (matricula.equals(i.getMatricula())) {
				System.out.println("Informe a descrição da falha:");
				String descricao = entrada.nextLine();
				System.out.println("Informe a previsão em dias:");
				int previsao = entrada.nextInt();
				System.out.println("Informe a data que aconteceu da falha no formato aaaa-mm-dd:");
				LocalDate dataInicio = LocalDate.parse(entrada.next());
				Falha novaFalha = new Falha(descricao, previsao, dataInicio);
				falhas.add(novaFalha);
				Reparo reparo = new Reparo(descricao, previsao, dataInicio);
				reparos.add(reparo);
				System.out.println("Falha registrada com sucesso.");
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("Matricula não encontrada.");
		}
	}

	public void incluirFalhaSemMatricula() {
		entrada.nextLine();
		System.out.println("Informe a descrição da falha:");
		String descricao = entrada.nextLine();
		System.out.println("Informe a previsão para a resolução da falha:");
		int previsao = entrada.nextInt();
		System.out.println("Informe a data de início da falha no formato aaaa-mm-dd:");
		LocalDate dataInicio = LocalDate.parse(entrada.next());
		Falha novaFalha = new Falha(descricao, previsao, dataInicio);
		falhas.add(novaFalha);
		Reparo reparo = new Reparo(descricao, previsao, dataInicio);
		reparos.add(reparo);
		System.out.println("Falha registrada com sucesso.");
	}

	public void listarReparosEmAberto() {
		System.out.println("===== Reparos em Aberto =====");
		int i = 0;
		for (Reparo reparo : reparos) {
			if (!reparo.resolvido) {
				System.out.println("Reparo "+ i+1);
				System.out.println("Descrição: " + reparo.descricao);
				System.out.println("Previsão: " + reparo.previsao);
				System.out.println("Data de Início: " + reparo.dataInicio);
				System.out.println("Data de Fim: " + reparo.dataFim);
				System.out.println("Resolvido: " + (reparo.resolvido ? "Sim" : "Não"));
				System.out.println("-----------");
			} else {
				System.out.println(" ");
				System.out.println("Nenhum Raparo encontrado!");
				System.out.println(" ");
			}
			i++;
		}
	}

	public void encerrarReparo() {
		entrada.nextLine();
		System.out.println("Informe o número do reparo:");
		int descricaoReparo = entrada.nextInt();
		Reparo reparo = reparos.get(descricaoReparo-1);
		System.out.println();
		System.out.println("Descrição: " + reparo.descricao);
		System.out.println("Previsão: " + reparo.previsao);
		System.out.println("Data de Início: " + reparo.dataInicio);
		System.out.println("Data de Fim: " + reparo.dataFim);
		System.out.println("Resolvido: " + (reparo.resolvido ? "Sim" : "Não"));
		System.out.println("-----------");

		entrada.nextLine();
		System.out.println("A falha associada a este reparo foi resolvida? (Digite 's' para Sim ou 'n' para Não)");
		char resposta = entrada.nextLine().toLowerCase().charAt(0);
		if (resposta == 's') {
			reparo.resolvido = true;
			System.out.println("Reparo encerrado com sucesso.");
		} else if (resposta == 'n') {
			System.out.println("Digite uma nova previsão em dias: ");
			int novaPrevisao = entrada.nextInt();
			entrada.nextLine();
			LocalDate novaDataInicio;
			try {
				System.out.print("Digite uma nova data para inicio (no formato yyyy-mm-dd): ");
				novaDataInicio = LocalDate.parse(entrada.nextLine());

				Reparo novoReparo = new Reparo(reparo.getDescricao(), novaPrevisao, novaDataInicio);
				novoReparo.resolvido = false;

				reparos.add(novoReparo);

				System.out.println("Novo reparo criado para a mesma falha.");
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida para previsão. Certifique-se de inserir um valor numérico.");
			}
		} else {
			System.out.println("Resposta inválida.");
		}

	}

	public Reparo buscarReparoPorDescricao(String descricao) {
		for (Reparo reparo : reparos) {
			if (reparo.descricao.equals(descricao)) {
				return reparo;
			}
		}
		return null;
	}
}