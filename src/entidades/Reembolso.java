package entidades;

import java.time.LocalDate;

public class Reembolso {
    private LocalDate dataReembolso;
    private LocalDate dataPagamento;
    private double valorreembolso;
    private String matricula;


    //Getters and Setters
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
     public LocalDate getDataReembolso() {
        return dataReembolso;
    }
    public void setDdataReembolso(LocalDate dataReembolso) {
        this.dataReembolso = dataReembolso;
    }

    public double getValorreembolso() {
        return valorreembolso;
    }
    public void setValorreembolso(double valorreembolso) {
        this.valorreembolso = valorreembolso;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    //Construtor
   public Reembolso(LocalDate dataReembolso, LocalDate dataPagamento, double valorreembolso, String matricula) {
       this.dataReembolso = dataReembolso;
       this.dataPagamento = dataPagamento;
       this.valorreembolso = valorreembolso;
       this.matricula = matricula;
   }


    
}
