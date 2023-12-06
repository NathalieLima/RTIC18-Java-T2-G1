package interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Fatura {
    private LocalDate data;
    private double ultima_leitura;
    private double penultima_leitura;
    private double valor;
    private boolean quitado = false;
    
    Scanner entrada = new Scanner(System.in);


    // setters and getters

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }

    public double getUltima_leitura() {
        return ultima_leitura;
    }

    public void setUltima_leitura(double ultima_leitura) {
        this.ultima_leitura = ultima_leitura;
    }

    public double getPenultima_leitura() {
        return penultima_leitura;
    }

    public void setPenultima_leitura(double penultima_leitura) {
        this.penultima_leitura = penultima_leitura;
    }

    // Construtor
    public Fatura(LocalDate data, double ultima_leitura, double penultima_leitura, double valor, boolean quitado) {
        this.data = data;
        this.ultima_leitura = ultima_leitura;
        this.penultima_leitura = penultima_leitura;
        this.valor = valor;
        this.quitado = quitado;
    }
    //Metodos
    public void lerConsumo(ArrayList<Imovel>imovel,ArrayList<Fatura> fatura) {
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

	public void listarFatura(ArrayList<Imovel>imovel,ArrayList<Fatura> fatura) {
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

	public void listarFaturaInadinplente(ArrayList<Imovel>imovel,ArrayList<Fatura> fatura) {
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
}
