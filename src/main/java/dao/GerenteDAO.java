package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import classes.*;

public class GerenteDAO {

    private final EntityManager entityManager;

    public GerenteDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Gerente gerente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gerente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public Gerente searchPorId(int id) {
        try {
            return entityManager.find(Gerente.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }
    public Gerente searchPorNome(String nome) {
        try {
            return entityManager.find(Gerente.class, nome);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public List<Gerente> listAllEntregador() {
        try {
            return entityManager.createQuery("select * from gerente ", Gerente.class).getResultList();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public void deletGerente(int id) {
        try {
            entityManager.getTransaction().begin();
            Gerente gerente = entityManager.find(Gerente.class, id);
            if (gerente != null) {
                entityManager.remove(gerente);
                entityManager.getTransaction().commit();

            } else {
                System.out.println("Gerente não encontrado");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
    public void updateGerente(int id, String novoNome, String novoEndereco,
                                 double novoSalario, String NovaAreaEspecializacao) {
        try {
            entityManager.getTransaction().begin();
            Gerente gerente = entityManager.find(Gerente.class, id);

            if(gerente != null){
                gerente.setNome(novoNome);
                gerente.setEndereco(novoEndereco);
                gerente.setSalario(novoSalario);
                gerente.setAreaEspecializacao(NovaAreaEspecializacao);
            }
            entityManager.merge(gerente);
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
