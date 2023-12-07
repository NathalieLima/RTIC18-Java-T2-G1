package entidades;

import java.util.ArrayList;

public class Imovel {
	private String matricula;
	private String endereco;
	private double ultima_leitura;
	private double penultima_leitura;
	private String cpf;

	// Getters and Setters
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setUltima_leitura(double ultima_leitura) {
		this.ultima_leitura = ultima_leitura;
	}

	public double getUltima_leitura() {
		return ultima_leitura;
	}

	public void setPenultima_leitura(double penultima_leitura) {
		this.penultima_leitura = penultima_leitura;
	}

	public double getPenultima_leitura() {
		return penultima_leitura;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	// Construtor
	public Imovel(String cpf, String matricula, String endereco, double ultima_leitura, double penultima_leitura) {
		this.matricula = matricula;
		this.endereco = endereco;
		this.ultima_leitura = ultima_leitura;
		this.penultima_leitura = penultima_leitura;
		this.cpf = cpf;
	}

}