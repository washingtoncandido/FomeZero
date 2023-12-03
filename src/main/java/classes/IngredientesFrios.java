package classes;

import java.sql.Date;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ultil.Validador;

@Entity
@DiscriminatorValue("FRIOS")
public class IngredientesFrios extends Ingredientes{
	
	private Date validade;
	
	
	public IngredientesFrios(int cod, String nome, String marca, Set<Produto> produto, Integer quantidade,String unidade) {
		super(cod, nome, marca, produto, quantidade,unidade);
		// TODO Auto-generated constructor stub
	}

	public void updateQtd(Integer qtd) {
		
		
	}
	

		
}
