
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import classes.Cozinheiro;
import classes.Entregador;
import classes.ServicosGerais;

public class CozinheiroDAO {

    private final EntityManager entityManager;

    public CozinheiroDAO() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Cozinheiro cozinheiro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cozinheiro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public Cozinheiro searchPorId(int id) {
        try {
            return entityManager.find(Cozinheiro.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }
    public Cozinheiro searchPorNome(String nome) {
        try {
            return entityManager.find(Cozinheiro.class, nome);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public List<Cozinheiro> listAllEntregador() {
        try {
            return entityManager.createQuery("select * from cozinheiro ", Cozinheiro.class).getResultList();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public void deletCozinheiro(int id) {
        try {
            entityManager.getTransaction().begin();
            Cozinheiro cozinheiro = entityManager.find(Cozinheiro.class, id);
            if (cozinheiro != null) {
                entityManager.remove(cozinheiro);
                entityManager.getTransaction().commit();

            } else {
                System.out.println("Cozinheiro não encontrado");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public void updateCozinheiro(int id, String novoNome, String novoEndereco,
                                     double novoSalario, double novoBonus, String novasCertificacaoCulinaria) {
        try {
            entityManager.getTransaction().begin();
            Cozinheiro cozinheiro = entityManager.find(Cozinheiro.class, id);

            if(cozinheiro != null){
                cozinheiro.setNome(novoNome);
                cozinheiro.setEndereco(novoEndereco);
                cozinheiro.setSalario(novoSalario);
                cozinheiro.setBonus(novoBonus);
                cozinheiro.setCertificacaoCulinaria(novasCertificacaoCulinaria);

            }else{
                System.out.println("Cozinheiro não encontrado");
            }
            entityManager.merge(cozinheiro);
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
