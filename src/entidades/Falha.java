package entidades;

import java.time.LocalDate;


public class Falha {
    private String descricao;
    private int previsao;
    private LocalDate dataInicio;
    private LocalDate dataFim;



    public Falha(String descricao, int previsao, LocalDate dataInicio) {
        this.descricao = descricao;
        this.previsao = previsao;
        this.dataInicio = dataInicio;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrevisao() {
        return previsao;
    }

    public void setPrevisao(int previsao) {
        this.previsao = previsao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        
    }
    public LocalDate getDataFim() {
        return dataInicio.plusDays(previsao);
    } 
}