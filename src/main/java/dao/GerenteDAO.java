package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import classes.Entregador;
import classes.Gerente;

public class GerenteDAO {

    private final EntityManager entityManager;

    public GerenteDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Gerente gerente) {
        entityManager.persist(gerente);
        entityManager.getTransaction().commit();
    }

    public Gerente searchPorId(int id) {
        return entityManager.find(Gerente.class, id);
    }
    public Gerente searchPorNome
            (String nome) {
        return entityManager.find(Gerente.class, nome);
    }

    public List<Gerente> listAllGerente() {
        return entityManager.createQuery("select * from gerente ", Gerente.class).getResultList();

    }

    public void deletGerente(int id){
        entityManager.getTransaction().begin();
        Gerente gerente = entityManager.find(Gerente.class, id);

        if(gerente != null) {
            entityManager.remove(gerente);
//			gerente.
            entityManager.getTransaction().commit();
        }
    }
    public void updateGerente(int id) {
        entityManager.getTransaction().begin();
        Gerente gerente = entityManager.find(Gerente.class,id);
//			if(gerente != null) {
//
//			}
    }
    public void fecharEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
