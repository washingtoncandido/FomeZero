package dao;

import java.util.List;

import classes.Entregador;

public class EntregadorDAO extends DataDAO {



    public void save(Entregador entregador) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entregador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    public Entregador searchPorId(int id) {
        try {
            return entityManager.find(Entregador.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }
    public Entregador searchPorNome(String nome) {
        try {
            return entityManager.find(Entregador.class, nome);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public List<Entregador> listAllEntregador() {
        try {
            return entityManager.createQuery("select * from entregador ", Entregador.class).getResultList();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            return null;
        }
    }

    public void deletEntregador(int id) {
        try {
            entityManager.getTransaction().begin();
            Entregador entregador = entityManager.find(Entregador.class, id);
            if (entregador != null) {
                entityManager.remove(entregador);
                entityManager.getTransaction().commit();

            } else {
                System.out.println("Entregador não encontrado");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
    public void updateEntregador(int id, String novoNome) {
        try {
            entityManager.getTransaction().begin();
            Entregador entregador = entityManager.find(Entregador.class, id);

            if(entregador != null){
                entregador.setNome(novoNome);
            }
            entityManager.merge(entregador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mensagem de erro: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

}
