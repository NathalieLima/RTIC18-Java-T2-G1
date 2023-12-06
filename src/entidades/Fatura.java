package entidades;

import java.time.LocalDate;

public class Fatura {
    private LocalDate data;
    private double ultima_leitura;
    private double penultima_leitura;
    private double valor;
    private boolean quitado = false;

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
}
