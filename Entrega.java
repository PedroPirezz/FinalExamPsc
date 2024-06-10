public class Entrega {
    private String codigoPedido;
    private String destinatario;
    private String endereco;
    private String dataEntrega;

    public Entrega(String codigoPedido, String destinatario, String endereco, String dataEntrega) {
        this.codigoPedido = codigoPedido;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.dataEntrega = dataEntrega;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "codigoPedido='" + codigoPedido + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataEntrega='" + dataEntrega + '\'' +
                '}';
    }
}
