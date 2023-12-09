package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;
import classes.Funcionario;
public class FuncionarioDAO {

	private final EntityManager entityManager;

	public FuncionarioDAO() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void save(Funcionario funcionario) {
		entityManager.persist(funcionario);
		entityManager.getTransaction().commit();
	}
	
	public Funcionario searchPor(int id) {
		return entityManager.find(Funcionario.class, id);
	}
	public Funcionario searchPor(String nome) {
		return entityManager.find(Funcionario.class, nome);
	}
	
	public List<Funcionario> listAllFuncionario(int id) {
		return entityManager.createQuery("select * from funcionario ", Funcionario.class).getResultList();
		
	}

	public void deletFuncionario(int id){
		entityManager.getTransaction().begin();
		Funcionario funcionario = entityManager.find(Funcionario.class, id);

		if(funcionario != null) {
			entityManager.remove(funcionario);
//			funcionario.
			entityManager.getTransaction().commit();
		}
		}
		public void updateFuncionario(int id) {
			entityManager.getTransaction().begin();
			Funcionario funcionario = entityManager.find(Funcionario.class,id);
//			if(funcionario != null) {
//
//			}
		}
	public void fecharEntityManager() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
