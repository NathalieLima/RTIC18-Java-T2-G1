package interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reparo {
    public String descricao;
    public String previsao;
    public LocalDate dataInicio;
    public LocalDate dataFim;
    public boolean resolvido;

    public Reparo(String descricao, String previsao, String dataInicio) {
        this.descricao = descricao;
        this.previsao = previsao;
        this.dataInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.dataFim = calcularDataFim();
        this.resolvido = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrevisao() {
        return previsao;
    }

    public void setPrevisao(String previsao) {
        this.previsao = previsao;
        this.dataFim = calcularDataFim();
    }

    public String getDataInicio() {
        return dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.dataFim = calcularDataFim();
    }

    public String getDataFim() {
        return dataFim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    private LocalDate calcularDataFim() {
        int diasPrevisao = Integer.parseInt(previsao);
        return this.dataInicio.plusDays(diasPrevisao);
    }
}



