package dao;

import classes.Pedido;

import java.util.List;

public class PedidoDAO extends DataDAO {
	
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

	public Pedido searchPorId(int id) {
		try {
			return entityManager.find(Pedido.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}
	public List<Pedido> listAllPedidos() {
		try {
			return entityManager.createQuery( "SELECT NEW dao.Pedido(p.numeroPedido, c.nome, pp.produto.cod, prod.nome, p.total, e.nome) " +
                    "FROM Pedido p, Cliente c, PedidoProduto pp, Produto prod, entregador e " +
                    "WHERE c.id = p.cliente.id " +
                    "AND p.numeroPedido = pp.pedido.numeroPedido " +
                    "AND pp.produto.cod = prod.cod " +
                    "AND p.entregador.id = e.id", Pedido.class)
            .getResultList();
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			return null;
		}
	}

	public void deletPedido(int id) {
		try {
			entityManager.getTransaction().begin();
			Pedido pedido = entityManager.find(Pedido.class, id);
			if (pedido != null) {
				entityManager.remove(pedido);
				entityManager.getTransaction().commit();

			} else {
				System.out.println("Pedido não encontrado");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("mensagem de erro: " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}
}
