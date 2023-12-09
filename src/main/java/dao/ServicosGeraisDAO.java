package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import classes.Entregador;
import classes.Gerente;
import classes.ServicosGerais;

public class GerenteDAO {

    private final EntityManager entityManager;

    public GerenteDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(GerenteDAO entregador) {
        entityManager.persist(entregador);
        entityManager.getTransaction().commit();
    }

    public GerenteDAO searchPorId(int id) {
        return entityManager.find(Gerente.class, id);
    }
    public GerenteDAO searchPor(String nome) {
        return entityManager.find(Gerente.class, nome);
    }

    public List<Entregador> listAllEntregador() {
        return entityManager.createQuery("select * from entregador ", Gerente.class).getResultList();

    }

    public void deletEntregador(int id){
        entityManager.getTransaction().begin();
        GerenteDAO entregador = entityManager.find(Gerente.class, id);

        if(entregador != null) {
            entityManager.remove(entregador);
//			entregador.
            entityManager.getTransaction().commit();
        }
    }
    public void updateEntregador(int id) {
        entityManager.getTransaction().begin();
        GerenteDAO entregador = entityManager.find(Gerente.class,id);
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
package dao;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityManagerFactory;
        import javax.persistence.Persistence;

        import java.util.List;

        import classes.Entregador;
        import classes.Gerente;

public class ServicosGeraisDAO {

    private final EntityManager entityManager;

    public ServicosGeraisDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(ServicosGerais entregador) {
        entityManager.persist(entregador);
        entityManager.getTransaction().commit();
    }

    public ServicosGerais searchPorId(int id) {
        return entityManager.find(ServicosGerais.class, id);
    }
    public ServicosGerais searchPorNome(String nome) {
        return entityManager.find(ServicosGerais.class, nome);
    }

    public List<Entregador> listAllEntregador() {
        return entityManager.createQuery("select * from entregador ", Gerente.class).getResultList();

    }

    public void deletEntregador(int id){
        entityManager.getTransaction().begin();
        GerenteDAO entregador = entityManager.find(Gerente.class, id);

        if(entregador != null) {
            entityManager.remove(entregador);
//			entregador.
            entityManager.getTransaction().commit();
        }
    }
    public void updateEntregador(int id) {
        entityManager.getTransaction().begin();
        GerenteDAO entregador = entityManager.find(Gerente.class,id);
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
