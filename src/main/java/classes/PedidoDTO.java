package classes;

public class PedidoDTO {
    private Integer numeroPedido;
    private String nomeCliente;
    private Integer codigoProduto;
    private String nomeProduto;
    private Double totalPedido;
    private String nomeEntregador;
	public Integer getNumeroPedido() {
		return numeroPedido;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public Double getTotalPedido() {
		return totalPedido;
	}
	public String getNomeEntregador() {
		return nomeEntregador;
	}

    // Construtor, getters e setters
}
