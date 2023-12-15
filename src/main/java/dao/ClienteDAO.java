package dao;
import classes.Cliente;
public class ClienteDAO  extends DataDAO{
        public void save(Cliente cliente) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(cliente);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("mensagem de erro: " + e.getMessage());
                entityManager.getTransaction().rollback();
            }
        }

        public Cliente searchPorId(int id) {
            try {
                return entityManager.find(Cliente.class, id);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("mensagem de erro: " + e.getMessage());
                return null;
            }
        }
    }
