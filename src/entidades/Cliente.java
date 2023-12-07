package entidades;
import java.util.ArrayList;

public class Cliente {
	private String cpf;
	private String nome;
	//ArrayList<String> residencias = new ArrayList<String>();
	
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
	
}