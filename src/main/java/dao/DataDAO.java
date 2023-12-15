package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DataDAO {

	  protected static EntityManagerFactory entityManagerFactory;

	    static {
	        entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
	    }

 
}

