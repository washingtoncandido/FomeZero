package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import classes.Entregador;

public class EntregadorDAO {

    private final EntityManager entityManager;

    public EntregadorDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Entregador entregador) {
        entityManager.persist(entregador);
        entityManager.getTransaction().commit();
    }

    public Entregador searchPorId(int id) {
        return entityManager.find(Entregador.class, id);
    }

    public Entregador searchPor(String nome) {
        return entityManager.find(Entregador.class, nome);
    }

    public List<Entregador> listAllEntregador() {
        return entityManager.createQuery("select * from entregador ", Entregador.class).getResultList();

    }

    public void deletEntregador(int id) {
        entityManager.getTransaction().begin();
        Entregador entregador = entityManager.find(Entregador.class, id);

        if (entregador != null) {
            entityManager.remove(entregador);
//			entregador.
            entityManager.getTransaction().commit();
        }
    }

    public void updateEntregador(int id) {
        entityManager.getTransaction().begin();
        Entregador entregador = entityManager.find(Entregador.class, id);
//			if(entregador != null) {
//
//			}
    }

    public void fecharEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
