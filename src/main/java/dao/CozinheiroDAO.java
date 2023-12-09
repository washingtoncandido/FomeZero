
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import classes.Cozinheiro;

public class CozinheiroDAO {

    private final EntityManager entityManager;

    public CozinheiroDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Cozinheiro cozinheiro) {
        entityManager.persist(cozinheiro);
        entityManager.getTransaction().commit();
    }

    public Cozinheiro searchPorId(int id) {
        return entityManager.find(Cozinheiro.class, id);
    }

    public Cozinheiro searchPorNome(String nome) {
        return entityManager.find(Cozinheiro.class, nome);
    }

    public List<Cozinheiro> listAllCozinheiror() {
        return entityManager.createQuery("select * from cozinheiro ", Cozinheiro.class).getResultList();

    }

    public void deletCozinheiro(int id) {
        entityManager.getTransaction().begin();
        Cozinheiro cozinheiro = entityManager.find(Cozinheiro.class, id);

        if (cozinheiro != null) {
            entityManager.remove(cozinheiro);
//			cozinheiro.
            entityManager.getTransaction().commit();
        }
    }

    public void updateCozinheiro(int id) {
        entityManager.getTransaction().begin();
        Cozinheiro cozinheiro = entityManager.find(Cozinheiro.class, id);
//			if(cozinheiro != null) {
//
//			}
    }

    public void fecharEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
