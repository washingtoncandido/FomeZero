package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Ingredientes;
import classes.Produto;

import java.util.List;

public class ProdutoDAO {

	private final EntityManager entityManager;

	public ProdutoDAO() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		entityManager = entityManagerFactory.createEntityManager();
	}

	// Salvando Produto no banco de dados
	public void save(Produto produto) {
		entityManager.persist(produto);
	}

	// retorna um produto por ID
	public Produto searchPorID(Integer id) {
		return entityManager.find(Produto.class, id);
	}

	// retorna todos os produto da tabela produto
	public List<Produto> listAllProduct() {
		return entityManager.createQuery("Select p from Produto p ", Produto.class).getResultList();
	}

	// Retorna a lista de ingrediente de um produto
	public List<Ingredientes> listAllIngredientProduct(Integer produtId) {
		String query = "SELECT i FROM classes.Ingredientes i WHERE i.cod IN "
				+ "(SELECT pi.id.ingrediente.cod FROM classes.ProdutoIngrediente pi WHERE pi.id.produto.cod = :produtId)";
		return entityManager.createQuery(query, Ingredientes.class).setParameter("produtId", produtId).getResultList();
	}

	public void deletProduct(Integer productId) {
		entityManager.getTransaction().begin();
		Produto produto = entityManager.find(Produto.class, productId);
		if (produto != null) {
			entityManager.remove(produto);
			produto.exibirProduto();
			entityManager.getTransaction().commit();
			
		} else {
			System.out.println("produto não encontrado");
		}
	}

	public void fecharEntityManager() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
