package classes;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import ultil.Validador;

@Entity
@DiscriminatorValue("PA")
public class IngredientesPa extends Ingredientes {

	public IngredientesPa(int cod, String nome, String marca, Set<Produto> produto, Integer quantidade,String unidade) {
		super(cod, nome, marca, produto, quantidade,unidade);
		// TODO Auto-generated constructor stub
	}


	public void updateQtd(Integer qtd) {
		
		if (qtd > this.quantidade  ) {
			System.out.println("Quantidade insuficiente no estoque");
			System.out.println("solicitou:" +qtd+"un");
			System.out.println("Quantidade no estoque:"+this.quantidade +"un");
		}else {
			this.quantidade = this.quantidade- qtd;
				System.out.println("Quantidade de produto atualiza:" + this.quantidade + "un em estoque");
			}
		}

}
