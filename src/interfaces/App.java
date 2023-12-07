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
				Imovel i = new Imovel(cpf, matricula, endereco, ultima_leitura, penultima_leitura);
				imovel.add(i);

			}
		}
	}

	public void consultaImovel() {
		System.out.println("Consultar imovel, digite a matricula: ");
		String matricula = entrada.next();
		String nome = new String();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
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
	}

	public void listarImovel() {
		for (Imovel i : imovel) {
			System.out.println("Matricula:  " + i.getMatricula() + "  Endereco: " + i.getEndereco());
			System.out.println(
					"Ultima leitura:  " + i.getUltima_leitura() + "  Penultima leitura: " + i.getPenultima_leitura());
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
				Fatura fat = new Fatura(LocalDate.now(), i.getUltima_leitura(), i.getPenultima_leitura(), valor,
						matricula, false);
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
					System.out.println(
							"Data: " + f.getData() + "  Valor: " + f.getValor() + "  Quitado: " + f.getQuitado());
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
						System.out.println("Data: " + f.getData() + "  Valor: " + f.getValor() + "  Quitado: ");
					}
				}
			}
		}
	}

	public void pagarfatura() {
		System.out.println("Digite a matricula do imovel");
		String matricula = entrada.next();
		System.out.println("Digite a data da fatura no formato AAAA-MM-DD:");
		LocalDate dataFatura = LocalDate.parse(entrada.next());
		double totalpagamento = 0, pagamento = 0;
		LocalDate dataPagamento = LocalDate.now();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
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
}