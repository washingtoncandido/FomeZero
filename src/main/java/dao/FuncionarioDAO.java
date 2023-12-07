package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Funcionario;
import classes.Produto;

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
	
	public Funcionario searchPor(Integer id) {
		return entityManager.find(Funcionario.class, id);
	}
	public Funcionario searchPor(String nome) {
		return entityManager.find(Funcionario.class, nome);
	}
	
	public List<Funcionario> listAllFuncionario(Integer id) {
		return entityManager.createQuery("select * from funcionario ", Funcionario.class).getResultList();
		
	}
	
	

	}