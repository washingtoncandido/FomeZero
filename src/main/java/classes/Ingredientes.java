package classes;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredientes {

	@Id
	private Integer cod;
	private String nome;
	private String marca;
	private Integer quantidade;
	private String unidade;

	@ManyToMany(mappedBy = "ingrediente")
	protected Set<Produto> produto = new HashSet<Produto>();

	public Ingredientes() {

	}

	public Ingredientes(int cod, String nome, String marca, Set<Produto> produto, Integer quantidade, String unidade) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.marca = marca;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.produto = produto;

	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Set<Produto> getProdutos() {
		return produto;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produto = produtos;
	}

	public void updateQtd(Integer qtd) {

		if (qtd > this.quantidade) {
			System.out.println("Quantidade insuficiente no estoque");
			System.out.println("solicitou:" + qtd + "un");
			System.out.println("Quantidade no estoque:" + this.quantidade + "un");
		} else {
			this.quantidade = this.quantidade - qtd;
			System.out.println("Quantidade de produto atualiza:" + this.quantidade + "un em estoque");
		}
	}

}
