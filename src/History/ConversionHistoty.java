package History;
import java.util.Date;

public class ConversionHistoty {
    private String moedaOrigem;
    private String moedaDestino;
    private double valorConvertido;
    private double taxaCambio;
    private Date dataHora;

    public ConversionHistoty(String moedaOrigem, String moedaDestino, double valorConvertido, double taxaCambio, Date dataHora) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valorConvertido = valorConvertido;
        this.taxaCambio = taxaCambio;
        this.dataHora = dataHora;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }
    public String getMoedaDestino() {
        return moedaDestino;
    }
    public double getValorConvertido() {
        return valorConvertido;
    }
    public double getTaxaCambio() {
        return taxaCambio;
    }
    public Date getDataHora() {
        return dataHora;
    }
}

