package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ingredientes")
public class Ingredientes {
	
	@Id
	private Integer cod;
	private String nome;
	private String marca;

	 @ManyToMany(mappedBy = "ingredientes")
	    private Set<Produto> produtos = new HashSet<>();
	
	
	public Ingredientes(int cod, String nome, String marca,Set<Produto> produto) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.marca = marca;
		this.produtos = produto;
	}
	public Ingredientes() {
		super();
	}

	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
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
	
}
