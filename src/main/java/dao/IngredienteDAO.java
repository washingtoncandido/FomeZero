package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Ingredientes;
import classes.Produto;

public class IngredienteDAO extends DataDAO {

	private EntityManager entityManager;

	public IngredienteDAO(EntityManagerFactory entityManagerFactory) {
		super();
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	// Salvando Produto no banco de dados
	public void save(Ingredientes ingrediente) {
		entityManager.getTransaction().begin();
		entityManager.persist(ingrediente);
		entityManager.getTransaction().commit();

	}

	// retorna um produto por ID
	public Ingredientes searchPorID(Integer id) {
		return entityManager.find(Ingredientes.class, id);
	}

	// retorna todos os produto da tabela produto
	public List<Ingredientes> listAllProduct() {
		return entityManager.createQuery("Select * from Ingredientes  ", Ingredientes.class).getResultList();
	}

	public void deletIngredientes(Integer productId) {
		entityManager.getTransaction().begin();
		Ingredientes ingredientes = entityManager.find(Ingredientes.class, productId);
		if (ingredientes != null) {
			entityManager.remove(ingredientes);
			entityManager.getTransaction().commit();

		} else {
			System.out.println("produto não encontrado");
		}
	}

	public void fecharConexao() {
		entityManager.close();
	}

}
