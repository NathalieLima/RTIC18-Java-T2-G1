package entidades;
import java.time.LocalDate;

 public class Pagamento {
    private LocalDate dataPagamento;
    private LocalDate dataFatura;
    private double valor;
    private String matricula;


    //Getters and Setters
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
     public LocalDate getDataFatura() {
        return dataFatura;
    }
    public void setDataFatura(LocalDate dataFatura) {
        this.dataFatura = dataFatura;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    //Construtor
    public Pagamento(LocalDate dataPagamento,LocalDate dataFatura, double valor, String matricula) {
        this.dataPagamento = dataPagamento;
        this.dataFatura = dataFatura;
        this.matricula = matricula;
        this.valor = valor;
    }
 }
