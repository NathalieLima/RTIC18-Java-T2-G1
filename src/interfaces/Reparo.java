package interfaces;

import java.sql.Date;

public class Reparo {
    String descricao;
    String previsao;
    String dataInicio;
    String dataFim;
    boolean resolvido;

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
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public Reparo(String descricao, String previsao, String dataInicio) {
        this.descricao = descricao;
        this.previsao = previsao;
        this.dataInicio = dataInicio;
        this.dataFim = "dd/mm/yyyy";
        this.resolvido = false;
    }


}
