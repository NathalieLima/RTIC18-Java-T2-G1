package interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
    private Date data;

    // Construtor sem parâmetros
    public Data() {
        this.data = new Date();
    }

    // Construtor recebendo objeto do tipo Date
    public Data(Date data_date) {
        this.data = new Date();
        this.data = data_date;
    }

    // Obter o objeto Date
    public Date getData() {
        return this.data;
    }

    // Setar data
    public void setData(Date data) {
        this.data = data;
    }

    // Converter a data em uma string no formato DD/MM/YYYY
    public String formatarData() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(this.data);
    }

    // Obter a data atual do sistema no formato DD/MM/YYYY
    public static String obterDataAtual() {
        Data data_atual = new Data();
        
        return data_atual.formatarData();
    }

    // Obter objeto do tipo Date de uma data-string
    public static Data obterDataDeString(String data_string) {
        Date data_date = new Date();
        Data data_data = new Data();

        // Tratamento da exceção se a data não for válida
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            data_date = formato.parse(data_string);
            data_data.setData(data_date);

        } catch (ParseException e) {
            System.out.println("A string não representa uma data válida.");
        }

        return data_data;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        // Criar uma instância com a data atual
        Data data_errada = Data.obterDataDeString("15/1");
        System.out.println("Data Atual: " + data_errada.formatarData());

        Data data_certa = Data.obterDataDeString("15/12/2010");
        System.out.println("Data Atual: " + data_certa.formatarData());
    }
}
