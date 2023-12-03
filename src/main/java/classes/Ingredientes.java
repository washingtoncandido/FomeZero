package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ultil.Validador;



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
