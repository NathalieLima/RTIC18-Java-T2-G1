package entidades;

import java.time.LocalDate;

public class FalhaGeracao extends Falha 
{
    public FalhaGeracao(String descricao, int previsao, LocalDate dataInicio) {
        super(descricao, previsao, dataInicio);
    }
}