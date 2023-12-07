package entidades;
import java.time.LocalDate;


public class Reparo {
    public String descricao;
    public int previsao;
    public LocalDate dataInicio;
    public LocalDate dataFim;
    public boolean resolvido;

    public Reparo(String descricao, int previsao, LocalDate dataInicio) {
        this.descricao = descricao;
        this.previsao = previsao;
        this.dataInicio = dataInicio;
        this.resolvido = false;
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

    public LocalDate setDataFim() {
        if (resolvido) {
            this.dataFim = dataInicio.plusDays(previsao);
        }

        return this.dataFim;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }
}