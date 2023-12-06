package interfaces;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	Scanner entrada = new Scanner(System.in);
	
	private String cpf;
	private String nome;
	
	public String getCPF() {
		return this.cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	//Construtor
	public Cliente(String nome, String cpf) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	//métodos
	public void incluirCliente(ArrayList<Cliente> cliente) {
		System.out.println("Incluir cliente");
		System.out.println("digite o nome:");
		String nome = entrada.next();
		System.out.println("digite o cpf:");
		String cpf = entrada.next();
		Cliente fulano = new Cliente(nome, cpf);
		cliente.add(fulano);
	}

	public void consultarCliente(ArrayList<Cliente> cliente) {
		System.out.println("Consultar cliente, digite o CPF: ");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				System.out.println("Cliente:" + c.getNome() + "CPF: " + c.getCPF());
			}
		}
	}

	public void listarCliente(ArrayList<Cliente> cliente) {
		for (Cliente c : cliente) {
			System.out.println("\nCliente: " + c.getNome());
			System.out.println("CPF: " + c.getCPF() + "\n");
		}
	}

	public void excluirCliente(ArrayList<Cliente> cliente) {
		System.out.println("Digite o cpf do cliente a ser excluido:");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				cliente.remove(c);
				System.out.println("Cliente excluido");
			}
		}
	}

	public void alterarCliente(ArrayList<Cliente> cliente) {

		System.out.println("Digite o cpf do cliente a ser alterado:");
		String cpf = entrada.next();
		for (Cliente c : cliente) {
			if (c.getCPF().equals(cpf)) {
				System.out.println("Digite o novo nome: ");
				c.setNome(entrada.next());
			}
		}
	}


}