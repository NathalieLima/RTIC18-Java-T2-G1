package interfaces;

public class Imovel extends Cliente {
	private String matricula;
	private String endereco;
	private double ultima_leitura;
	private double penultima_leitura;

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
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
