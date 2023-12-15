package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import classes.Cliente;

public class ClienteDAO extends DataDAO {

	private EntityManager entityManager;

	public ClienteDAO(EntityManagerFactory entityManagerFactory) {
		super();
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public void save(Cliente cliente) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(cliente);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
		}
	}

	public Cliente searchPorId(int id) {
		try {
			return entityManager.find(Cliente.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}

	public void fecharConexao() {
		entityManager.close();
	}
}
