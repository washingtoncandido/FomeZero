package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.*;

import java.util.List;
import java.util.Set;

public class ProdutoDAO  extends DataDAO{


	// Salvando Produto no banco de dados
	public void save(Produto produto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(produto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	// retorna um produto por ID; e por nome;
	public Produto searchPorId(Integer cod) {
		try {
			return entityManager.find(Produto.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}

	public Produto searchPorNome(String nome) {
		try {
			return entityManager.find(Produto.class, nome);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}

	public List<Produto> listAllProduct() {
		try {
			return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
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

	public void updateProduto(Integer cod, String novoNome, Double NovoPreco, Boolean novaOferta,
			Set<Ingredientes> NovosIgredientes) {
		try {
			entityManager.getTransaction().begin();
			Produto produto = entityManager.find(Produto.class, cod);

//			if(produto != null){
//				produto.
//				produto.
//				produto.
//				produto.
//			}
			entityManager.merge(produto);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	public void fecharEntityManager() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
