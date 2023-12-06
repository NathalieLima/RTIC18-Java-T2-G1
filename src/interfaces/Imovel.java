package interfaces;

import java.util.ArrayList;
import java.util.Scanner;

public class Imovel extends Cliente {
	private String matricula;
	private String endereco;
	private double ultima_leitura;
	private double penultima_leitura;
		Scanner entrada = new Scanner(System.in);
	
	
	// Getters and Setters
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMatricula(){
		return matricula;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;

	}
	public String getEndereco(){
		return endereco;
	}

	public void setUltima_leitura(double ultima_leitura) {
		
		this.ultima_leitura = ultima_leitura;
	}
	public double getUltima_leitura(){
		return ultima_leitura;
	}

	public void setPenultima_leitura(double penultima_leitura) {
		
		this.ultima_leitura = penultima_leitura;
	}
	public double getPenultima_leitura(){
		return penultima_leitura;
	}
	//Construtor
	public Imovel(String cpf, String nome, String matricula, String endereco, double ultima_leitura, double penultima_leitura) {
		super(nome,cpf);
		this.matricula = matricula;
		this.endereco = endereco;
		this.ultima_leitura = ultima_leitura;
		this.penultima_leitura = penultima_leitura;	
	}
	//Métodos
	public void incluirImovel(ArrayList<Imovel> imovel, ArrayList<Cliente> cliente) {
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

	public void consultaImovel(ArrayList<Imovel> imovel) {
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

	public void listarImovel(ArrayList<Imovel> imovel) {
		for (Imovel i : imovel) {
			System.out.println("Cliente:" + i.getNome() + "CPF: " + i.getCPF());
			System.out.println("Matricula:" + i.getMatricula() + "Endereco: " + i.getEndereco());
			System.out.println(
					"Ultima leitura:" + i.getUltima_leitura() + "Penultima leitura: " + i.getPenultima_leitura());

		}
	}

	public void excluirImovel(ArrayList<Imovel> imovel) {
		System.out.println("Para excluir imovel, digite a matricula: ");
		String matricula = entrada.next();
		for (Imovel i : imovel) {
			if (i.getMatricula().equals(matricula)) {
				imovel.remove(i);
				System.out.println("Imovel excluido");
			}
		}
	}
	public void alteraImovel(ArrayList<Imovel> imovel) {
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


}