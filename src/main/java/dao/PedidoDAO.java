package dao;

import java.util.List;

import javax.persistence.EntityManager;

import classes.Pedido;
import classes.Produto;

public class PedidoDAO extends DataDAO {

	public void salvarPedido(Pedido pedido) {
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
	}


	public List<Produto> listAllProduct() {
		try {
			return entityManager.createQuery("SELECT * FROM Pedido ", Produto.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}
}
