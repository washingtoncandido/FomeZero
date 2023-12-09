
package dao;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityManagerFactory;
        import javax.persistence.Persistence;

        import java.util.List;

        import classes.ServicosGerais;

public class ServicosGeraisDAO {

    private final EntityManager entityManager;

    public ServicosGeraisDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(ServicosGerais servicosGerais) {
        entityManager.persist(servicosGerais);
        entityManager.getTransaction().commit();
    }

    public ServicosGerais searchPorId(int id) {
        return entityManager.find(ServicosGerais.class, id);
    }
    public ServicosGerais searchPorNome(String nome) {
        return entityManager.find(ServicosGerais.class, nome);
    }

    public List<ServicosGerais> listAllServicosGerais() {
        return entityManager.createQuery("select * from servicosGerais ", ServicosGerais.class).getResultList();

    }

    public void deletServicosGerais(int id){
        entityManager.getTransaction().begin();
        ServicosGerais servicosGerais = entityManager.find(ServicosGerais.class, id);

        if(servicosGerais != null) {
            entityManager.remove(servicosGerais);
//			servicosGerais.
            entityManager.getTransaction().commit();
        }
    }
    public void updateServicosGerais(int id) {
        entityManager.getTransaction().begin();
        ServicosGerais servicosGerais = entityManager.find(ServicosGerais.class,id);
//			if(servicosGerais != null) {
//
//			}
    }
    public void fecharEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
