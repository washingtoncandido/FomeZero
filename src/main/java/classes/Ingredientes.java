package classes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_ingrediente", discriminatorType = DiscriminatorType.STRING)
public  abstract class Ingredientes {
	
	@Id
	protected Integer cod;
	protected String nome;
	protected String marca;
	protected Integer quantidade;
	protected String unidade;
	
	 @ManyToMany(mappedBy = "ingredientes")
	    private Set<Produto> produtos = new HashSet<>();

	
	
	public Ingredientes(int cod, String nome, String marca,Set<Produto> produto,Integer quantidade,String unidade) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.marca = marca;
		this.produtos = produto;
		this.quantidade = quantidade;
		this.unidade = unidade;

	}

	protected abstract void updateQtd(Integer qtd);


	
}
