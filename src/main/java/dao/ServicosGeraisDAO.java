
package dao;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityManagerFactory;
        import javax.persistence.Persistence;

        import java.util.List;

        import classes.Entregador;
        import classes.Funcionario;
        import classes.ServicosGerais;

public class ServicosGeraisDAO {

    private final EntityManager entityManager;

    public ServicosGeraisDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(ServicosGerais servicosGerais) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(servicosGerais);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public ServicosGerais searchPorId(int id) {
        try {
            return entityManager.find(ServicosGerais.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }
    public ServicosGerais searchPorNome(String nome) {
        try {
            return entityManager.find(ServicosGerais.class, nome);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public List<ServicosGerais> listAllEntregador() {
        try {
            return entityManager.createQuery("select * from servicosGerais ", ServicosGerais.class).getResultList();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public void deletServicosGerais(int id) {
        try {
            entityManager.getTransaction().begin();
            ServicosGerais servicosGerais = entityManager.find(ServicosGerais.class, id);
            if (servicosGerais != null) {
                entityManager.remove(servicosGerais);
                entityManager.getTransaction().commit();

            } else {
                System.out.println("Profissional de ServicosGerais não encontrado");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
    public void updateServicosGerais(int id, String novoNome, String novoEndereco,
                                 double novoSalario, String novoServicoAtual, List<String> novaEspecialidades,
                                     double novoBonusDeInsalubridade) {
        try {
            entityManager.getTransaction().begin();
            ServicosGerais servicosGerais = entityManager.find(ServicosGerais.class, id);

            if(servicosGerais != null){
                servicosGerais.setNome(novoNome);
                servicosGerais.setEndereco(novoEndereco);
                servicosGerais.setSalario(novoSalario);
                servicosGerais.setServicoAtual(novoServicoAtual);
                servicosGerais.setEspecialidades(novaEspecialidades);
                servicosGerais.setBonusDeInsalubridade(novoBonusDeInsalubridade);
            }else{
                System.out.println("Pofissional de ServicosGerais não encontrado");
            }
            entityManager.merge(servicosGerais);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
    public void fecharEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
