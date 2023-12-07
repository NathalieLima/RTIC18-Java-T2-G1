package entidades;

import java.time.LocalDate;

public class FalhaDistribuicao extends Falha {
    private String matricula;

    public FalhaDistribuicao(String descricao, int previsao, LocalDate dataInicio) {
        super(descricao, previsao, dataInicio);
        this.matricula = matricula;
    }
}