
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder.In;
import classes.Ingredientes;
import classes.Produto;
import dao.ProdutoDAO;
import ultil.Validador;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		Set<Produto> conjuntoProdutos = new HashSet<Produto>();
		Set<Ingredientes> conjuntoIngredientesFrankistai = new HashSet<Ingredientes>();
		Set<Ingredientes> conjuntoIngredientesLobisome = new HashSet<Ingredientes>();
		
		
		Ingredientes carne = new Ingredientes(1, "moida", "sadia",conjuntoProdutos , 100,"FR");
		Ingredientes guarana = new Ingredientes(2,"guaradana","bovinos", conjuntoProdutos, 102, "FR");
		Ingredientes mortadela = new Ingredientes(11,"mortadela","bovinos", conjuntoProdutos, 102, "PA");
		Ingredientes camembert = new Ingredientes(3, "Camembert", "França",conjuntoProdutos,123,"PA");
		Ingredientes brie = new Ingredientes(4, "Brie", "França",conjuntoProdutos,123,"PA");
		Ingredientes gorgonzola  = new Ingredientes(6, "Gorgonzola", "Itália",conjuntoProdutos,123,"PA");
		Ingredientes mucarela  = new Ingredientes(7, "Muçarela", "Itália",conjuntoProdutos,123,"PA");
		Ingredientes batataIngl = new Ingredientes(8,"batata Inglesa","natural",conjuntoProdutos,123,"PA");
		Ingredientes tomate = new Ingredientes(9,"tomate","natural",conjuntoProdutos,123,"PA");
		Ingredientes cebola = new Ingredientes(10,"cebola","natural",conjuntoProdutos,123,"PA");
		
		Produto lobisome = new Produto(123,"lobisome",23.0,true,conjuntoIngredientesLobisome);
		Produto frankistai = new Produto(1234,"Classic Burger Deluxe",12.2,false,conjuntoIngredientesFrankistai);
	
		conjuntoIngredientesLobisome.add(cebola);
		conjuntoIngredientesLobisome.add(tomate);
		conjuntoIngredientesLobisome.add(mucarela);
		conjuntoIngredientesLobisome.add(guarana);
		conjuntoIngredientesLobisome.add(carne);
		
		conjuntoIngredientesFrankistai.add(carne);
		conjuntoIngredientesFrankistai.add(gorgonzola);
		conjuntoIngredientesFrankistai.add(cebola);
		conjuntoIngredientesFrankistai.add(tomate);
		conjuntoIngredientesFrankistai.add(brie);		

		entity.getTransaction().begin();
		entity.persist(camembert);
		entity.persist(carne);
		entity.persist(mortadela);
		entity.persist(guarana);
		entity.persist(brie);
		entity.persist(gorgonzola);
		entity.persist(batataIngl);
		entity.persist(guarana);
		entity.persist(tomate);
		entity.persist(cebola);
		entity.persist(mucarela);

		//gravando dados no banco  de produtos
		entity.persist(frankistai);
		entity.persist(lobisome);
		entity.getTransaction().commit();
		
		
		//Buscando produto espercifico e listando os ingrediente dele 
		//pergunta ao cliente qual produto ele deseja 
		Produto produtoEcontrado = produtoDao.searchPorID(123);
		System.out.println("Produto encontrado");
		produtoEcontrado.exibirProduto();
		System.out.println("Lista de ingrediente do produto encontrado");
		List<Ingredientes> ingredientesList = produtoDao.listAllIngredientProduct(123);
		for (Ingredientes ingrediente : ingredientesList) {
		    System.out.println("Nome: " + ingrediente.getNome());
		}
		
		produtoDao.deletProduct(123);
		//System.out.println(produtoEcontrado);

		

		entity.close();
		entityFactory.close();
	}

}
