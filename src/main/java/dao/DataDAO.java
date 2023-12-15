package dao;

import javax.persistence.*;
public abstract class DataDAO {

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    public DataDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void fecharConexao() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
