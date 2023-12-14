
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Ingredientes;
import classes.Produto;
import dao.ProdutoDAO;

public class MainFomeZero {
	
	ProdutoDAO produtoDao = new ProdutoDAO();
	public static void main(String[] args) {
		
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();

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

		//gravando dados no banco  de ingredientes
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
		Scanner scanner = new Scanner(System.in);
	
		boolean continuar = true;

		do {
			exibirMenu();

			// Solicita ao usuário para fazer uma escolha
			System.out.print("Digite sua escolha: ");
			int escolha = scanner.nextInt();

			// Executa a ação com base na escolha do usuário
			switch (escolha) {
			case 1:
				System.out.println("Catalogo");
				// Obtém a lista de todos os produtos
				exibirAllProduct(produtoDao.listAllProduct());

				break;
			case 2:
				System.out.println("Fazer Pedido");
				// Adicione a lógica da ação desejada aqui
				break;
			case 3:
				System.out.println("Você escolheu a opção 3 - Mais uma ação.");
				// Adicione a lógica da ação desejada aqui
				break;
			case 0:
				System.out.println("Saindo do programa. Até mais!");
				continuar = false;
				break;
			default:
				System.out.println("Escolha inválida. Por favor, escolha novamente.");
			}

			// Verifica se o usuario deseja voltar ao inicio
			if (continuar) {
				continuar = perguntarSeDesejaContinuar(scanner);
			}

		} while (continuar);

		// Fecha o scanner ao finalizar o programa
		scanner.close();
	}

	private static void exibirMenu() {
		System.out.println("\n==== BEM VINDO AO FOME ZERO ====");
		System.out.println("\n==== ESCOLHA UMA OPÇÃO ====");
		System.out.println("1. Ver Catalogo");
		System.out.println("2. Fazer pedido ");
		System.out.println("3. Opção 3");
		System.out.println("0. Sair");
	}

	private static void exibirAllProduct(List<Produto> listaDeProdutos) {
		// Iterage sobre a lista e exibe cada produto
		for (Produto encontrado : listaDeProdutos) {
			encontrado.exibirProduto();
			exibirIngredientProduct(encontrado.getCod());
		}
	}

	private static void exibirIngredientProduct(int id) {
		List<Ingredientes> ingredientesList = produtoDao.listAllIngredientProduct(id);
		for (Ingredientes ingrediente : ingredientesList) {
			System.out.println("Nome: " + ingrediente.getNome());
		}
	}

	private static boolean perguntarSeDesejaContinuar(Scanner scanner) {
		System.out.print("Deseja voltar ao início (sim/não)? ");
		String resposta = scanner.next().toLowerCase();
		return resposta.equals("sim");
	}
}
