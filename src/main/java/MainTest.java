import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import classes.Cliente;
import classes.Entregador;
import classes.Ingredientes;
import classes.Pedido;
import classes.Produto;

public class MainTest {

	public static void main(String[] args) {
		

		Set<Produto> conjuntoProdutos = new HashSet<Produto>();
		Set<Ingredientes> conjuntoIngredientesFrankistai = new HashSet<Ingredientes>();
		Set<Ingredientes> conjuntoIngredientesLobisome = new HashSet<Ingredientes>();
		Entregador entregador = new Entregador(1, "washington", "rua barao", 12, null, null, null, 0);
		Ingredientes carne = new Ingredientes(1, "moida", "sadia", conjuntoProdutos, 100, "FR");
		Ingredientes guarana = new Ingredientes(2, "guaradana", "bovinos", conjuntoProdutos, 102, "FR");
		Ingredientes mortadela = new Ingredientes(11, "mortadela", "bovinos", conjuntoProdutos, 102, "PA");
		Ingredientes camembert = new Ingredientes(3, "Camembert", "França", conjuntoProdutos, 123, "PA");
		Ingredientes brie = new Ingredientes(4, "Brie", "França", conjuntoProdutos, 123, "PA");
		Ingredientes gorgonzola = new Ingredientes(6, "Gorgonzola", "Itália", conjuntoProdutos, 123, "PA");
		Ingredientes mucarela = new Ingredientes(7, "Muçarela", "Itália", conjuntoProdutos, 123, "PA");
		Ingredientes batataIngl = new Ingredientes(8, "batata Inglesa", "natural", conjuntoProdutos, 123, "PA");
		Ingredientes tomate = new Ingredientes(9, "tomate", "natural", conjuntoProdutos, 123, "PA");
		Ingredientes cebola = new Ingredientes(10, "cebola", "natural", conjuntoProdutos, 123, "PA");

		Produto lobisome = new Produto(123, "lobisome", 23.0, true, conjuntoIngredientesLobisome);
		Produto frankistai = new Produto(1234, "Classic Burger Deluxe", 12.2, false, conjuntoIngredientesFrankistai);
		
		//Cliente washington = new Cliente("washington",998877034);
		List <Produto> ListaProdutoWashington = new ArrayList<Produto>();
				
	//	Pedido pedidoWashington = new Pedido(washington, null, entregador, 123.0);
		
		//lobisome.adicionarPedido(pedidoWashington);
		

	}

}
