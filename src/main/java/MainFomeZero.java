
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Cliente;
import classes.Entregador;
import classes.Ingredientes;
import classes.Pedido;
import classes.PedidoDTO;
import classes.Produto;
import dao.ClienteDAO;
import dao.EntregadorDAO;
import dao.IngredienteDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;

public class MainFomeZero {

	public static void main(String[] args) {
		ProdutoDAO produtoDao = new ProdutoDAO();
		PedidoDAO pedidoDao = new PedidoDAO();
		EntregadorDAO entregadoDao = new EntregadorDAO();
		IngredienteDAO ingredienteDao = new IngredienteDAO();
		ClienteDAO clienteDao = new ClienteDAO();

		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();

		Set<Produto> conjuntoProdutos = new HashSet<Produto>();
		Set<Ingredientes> conjuntoIngredientesFrankistai = new HashSet<Ingredientes>();
		Set<Ingredientes> conjuntoIngredientesLobisome = new HashSet<Ingredientes>();

		Entregador entregador = new Entregador(1, "Tony");
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

		// gravando dados no banco de ingredientes
		ingredienteDao.save(camembert);
		ingredienteDao.save(carne);
		ingredienteDao.save(mortadela);
		ingredienteDao.save(guarana);
		ingredienteDao.save(brie);
		ingredienteDao.save(gorgonzola);
		ingredienteDao.save(batataIngl);
		ingredienteDao.save(guarana);
		ingredienteDao.save(tomate);
		ingredienteDao.save(cebola);
		ingredienteDao.save(mucarela);

		// gravando dados no banco de produtos
		produtoDao.save(frankistai);
		produtoDao.save(lobisome);
		
		Scanner scanner = new Scanner(System.in);
	

		boolean continuar = true;

		while (continuar) {
			exibirMenu();
			// Solicita ao usuário para fazer uma escolha
			System.out.print("Digite sua escolha: ");
			int escolha = scanner.nextInt();

			// Executa a ação com base na escolha do usuário
			switch (escolha) {
			case 1:
				System.out.println("\nCatalogo\n");
				// Pegando todos os produtos do banco
				List<Produto> listaDeProdutos = produtoDao.listAllProduct();
				// armazenando ids do produtos
				List<Integer> ids = exibirIdProduct(listaDeProdutos);

				// Informando o usuario todos os produtos e os ingredientes de cada produto
				for (Integer id : ids) {
					Produto encontrado = produtoDao.searchPorId(id);
					encontrado.exibirProduto();
					System.out.println("Ingredientes do produto: " + encontrado.getNome());
					List<Ingredientes> ingredientesList = produtoDao.listAllIngredientProduct(id);
					for (Ingredientes ingrediente : ingredientesList) {
						System.out.println(" " + ingrediente.getNome());
					}
					System.out.println();
				}
				break;
			case 2:
				boolean adicionarOutroProduto = true;
				
				Pedido novo = new Pedido();
				System.out.println("\nLista de produtos\n");
				exibirAllProduct(produtoDao.listAllProduct());

				while (adicionarOutroProduto) {
					// Solicita ao usuário para fazer uma escolha do pedido
					System.out.print("\nDigite o produto que deseja compra: ");
					int idProduto = scanner.nextInt();
					
					Produto produtoPedido = produtoDao.searchPorId(idProduto);
					// Mostrando Produto escolhido para o pedido
					System.out.println("Produto escolhido:");
					produtoPedido.exibirProduto();
					novo.adicionarProduto(produtoPedido);
					// Pergunta se ele deseja adicionar outro produto
					System.out.println("\nDeseja adicionar outro produto ao pedido? (Digite 'sim' ou 'nao')");
					String resposta = scanner.next();

					adicionarOutroProduto = resposta.equalsIgnoreCase("sim");
				}
				Cliente cliente = criarCliente();
				novo.setCliente(cliente);
				novo.setEntregador(entregador);
				
				//Salvando no banco de dados os dado do pedido 
				
				clienteDao.save(cliente);;
				entregadoDao.save(entregador);
				pedidoDao.save(novo);
				
				
				//Buscando do banco as informações do pedido
				System.out.println();
				System.out.println("Pedido finalizado");
	
				Pedido encontradoPedido = pedidoDao.searchPorId(novo.getNumPedido());
				System.out.println("Pedido:");
				

				List<Produto> idProduto = encontradoPedido.getProdutos();
				//Mostrando detalhes do pedido
				
				System.out.println("Total:" + encontradoPedido.getTotal());
				List<Integer> idProdutos = exibirIdProduct(idProduto);
				System.out.println("Total de produtos:"+idProduto.size() );
				// Informando o usuario todos os produtos e os ingredientes de cada produto
				for (Integer id : idProdutos) {
					Produto encontrado = produtoDao.searchPorId(id);
					encontrado.exibirProduto();
					System.out.println("Ingredientes do produto: " + encontrado.getNome());
					List<Ingredientes> ingredientesList = produtoDao.listAllIngredientProduct(id);
					for (Ingredientes ingrediente : ingredientesList) {
						System.out.println(" " + ingrediente.getNome());
					}
					System.out.println();
				}
				Cliente clientePedido = clienteDao.searchPorId(encontradoPedido.getCliente().getId());
				System.out.println("\n Cliente:"+clientePedido.getNome()+ ",telefon:"+ clientePedido.getTelefone());
				
				Entregador entregadorPedido = entregadoDao.searchPorId(encontradoPedido.getEntregador().getId());
				System.out.println("\n Entregador:"+entregadorPedido.getNome());
				
				
				break;
			case 3:
				System.out.println("Pesquiser o produto ");
				// Solicita ao usuário para fazer a escolha do produto

				System.out.print("Digite o id do produto: ");
				int escolhaId = scanner.nextInt();
				Produto produtoEcontrado = produtoDao.searchPorId(escolhaId);
				//retornando produto encontrado
				System.out.println();
				System.out.println("Produto encontrado: ");
				produtoEcontrado.exibirProduto();
				//retornando ingrediente dos produto encontrado
				System.out.println("Lista de ingrediente do produto: " + produtoEcontrado.getNome());
				List<Ingredientes> ingredientesList = produtoDao.listAllIngredientProduct(escolhaId);
				for (Ingredientes ingrediente : ingredientesList) {
					System.out.println("  " + ingrediente.getNome());
				}
				
				break;
			case 4:
				break;
			case 0:
				System.out.println(" \n Saindo do programa. Até mais!");
				continuar = false;
				break;
			default:
				System.out.println("Escolha inválida. Por favor, escolha novamente.");
			}

			// Verifica se o usuario deseja voltar ao inicio
			if (continuar) {
				continuar = perguntarSeDesejaContinuar(scanner);
			}
		}

		System.out.println("\n Saindo do programa. Até mais!");
		System.out.println("Sistema finalizado");
		// Fecha o scanner ao finalizar o programa
		scanner.close();
	}
	
	private static void exibirMenu() {
		System.out.println("\n==== BEM VINDO AO FOME ZERO ====");
		System.out.println("\n==== ESCOLHA UMA OPÇÃO ====");
		System.out.println("1. Ver Catalogo");
		System.out.println("2. Fazer pedido ");
		System.out.println("3. Buscar Produto");
		System.out.println("4. Ver pedido");
		System.out.println("0. Sair");
		System.out.println();
	}

	private static Cliente criarCliente() {
		Scanner input = new Scanner(System.in);

		System.out.println("Digite o seus dados:");
		System.out.print("Digite o seu nome");
		String nome = input.next();
		System.out.print("Digit o seu telefone");
		Long telefone = input.nextLong();
		return new Cliente(nome, telefone);
	}



	private static void exibirAllProduct(List<Produto> listaDeProdutos) {
		// Iterage sobre a lista e exibe cada produto
		for (Produto encontrado : listaDeProdutos) {
			encontrado.exibirProduto();
		}
	}
	private static List<Integer> exibirIdPedido(List<Pedido> listaDePedido) {
		// Iterage sobre a lista e exibe cada id do produto
		List<Integer> idProduct = new ArrayList();
		for (Pedido encontrado : listaDePedido) {
			idProduct.add(encontrado.getNumPedido());
		}
		return idProduct;
	}

	private static List<Integer> exibirIdProduct(List<Produto> listaDeProdutos) {
		// Iterage sobre a lista e exibe cada id do produto
		List<Integer> idProduct = new ArrayList();
		for (Produto encontrado : listaDeProdutos) {
			idProduct.add(encontrado.getCod());
		}
		return idProduct;
	}

	private static boolean perguntarSeDesejaContinuar(Scanner scanner) {
		System.out.print("\n Deseja voltar ao início (sim/não)? ");
		String resposta = scanner.next().toLowerCase();
		return resposta.equals("sim");
	}
}
