package classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto {
	
	@Id
	private Integer cod;
	private String nome;
	private Double preco;
	private Boolean oferta=false;
	
	 @ManyToMany
	    @JoinTable(
	        name = "produto_ingrediente",
	        joinColumns = @JoinColumn(name = "produto_id"),
	        inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
	    )
	    private Set<Ingredientes> ingredientes = new HashSet<>();	
	
	public Produto(Integer cod, String nome, Double preco, Boolean oferta, Set<Ingredientes> igredientes,Set<IngredientesPa> igredientesPa) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.preco = preco;
		this.oferta = oferta;
		this.ingredientes = igredientes;
	}
	public Produto() {
		super();
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


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Boolean getOferta() {
		return oferta;
	}


	public void setOferta(Boolean oferta) {
		this.oferta = oferta;
	}
	public Set<Ingredientes> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Set<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}



	
	
	
	
	
}