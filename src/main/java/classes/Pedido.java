package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numPedido;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToMany
	@JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_numero"), inverseJoinColumns = @JoinColumn(name = "produto_cod"))
	private List<Produto> produtos;
	@ManyToOne
	@JoinColumn(name = "entregador_id")
	private Entregador entregador;

	private Double total;

	public Pedido() {
	}

	public Pedido(Cliente cliente, List<Produto> produtos, Entregador entregador, Double total) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.entregador = entregador;
		this.total = total;
		atualizarTotal();
	}
	

	public List<Produto> getProdutos() {
		if (produtos == null) {
			produtos = new ArrayList<>();
		}
		return produtos;
	}

	public Integer getNumPedido() {
		return numPedido;
	}

	public void adicionarProduto(Produto produto) {
		getProdutos().add(produto);
		produto.getPedidos().add(this);
		atualizarTotal();
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		 atualizarTotal();
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
		 atualizarTotal();
	}
 
	public double getTotal() {
		return this.total;
	}
	
	
	// Método para atualizar o total com base nos preços dos produtos
	private void atualizarTotal() {
		this.total = getProdutos().stream().mapToDouble(Produto::getPreco).sum();
	}
}
