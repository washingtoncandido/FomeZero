package classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
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
	    private Set<Ingredientes> ingrediente = new HashSet<>();	
	
	public Produto(Integer cod, String nome, Double preco, Boolean oferta, Set<Ingredientes> igredientes) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.preco = preco;
		this.oferta = oferta;
		this.ingrediente = igredientes;
	}
	public Produto() {
		super();
	}
	public Set<Ingredientes> getIngredientes() {
		return ingrediente;
	}
	public void setIngredientes(Set<Ingredientes> ingredientes) {
		this.ingrediente = ingredientes;
	}
	
	public void exibirProduto () {
		System.out.println("Código do produto: " + this.cod + "\nNome do produto: " + this.nome + "\nOferta? " + this.oferta + "\nPreço do produto: " + this.preco);
	}
	
	//Buscando produto que deseja atualizar por ID
	public void UpdateProduto(Integer buscar, Integer cod,String nome,Double preco) {
		
		//Buscando produto
		if (buscar == this.cod) {
				System.out.println("Produto não encontrado");
		}if (nome.isEmpty() && preco == 0) {
			System.out.println("campos vazio");
		}else{
			this.nome = nome;
			this.preco = preco;
		}
		
	}




	
	
	
	
	
}