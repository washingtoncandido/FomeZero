package dao;

import classes.Pedido;
import classes.Produto;

import java.util.List;

import javax.persistence.*;

public class PedidoDAO extends DataDAO {

	private EntityManager entityManager;

	public PedidoDAO(EntityManagerFactory entityManagerFactory) {
		super();
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public void save(Pedido pedido) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(pedido);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	public Pedido searchPorId(Integer numPedido) {
		try {
			return entityManager.find(Pedido.class, numPedido);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}

	public List<Pedido> listAllPedidos() {
		try {
			return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}
		public void deletPedido(Integer numPedido) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			try {
				entityManager.getTransaction().begin();
				Pedido pedido = entityManager.find(Pedido.class, numPedido);
				if (pedido != null) {
					entityManager.remove(pedido);
					entityManager.getTransaction().commit();
				} else {
					System.out.println("Pedido não encontrado");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("mensagem de erro: " + e.getMessage());
				if (entityManager.getTransaction().isActive()) {
					entityManager.getTransaction().rollback();
				}
			} finally {
				entityManager.close();
			}
		}
	public void fecharConexao() {
		entityManager.close();
	}
}
