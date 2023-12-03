package classes;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainJPQL {
	
	public static void main(String[] args) {

		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();
		/*
		Aluno aluno = entity.find(Aluno.class, 1);
		System.out.println(aluno);
		*/
		/*//Sql Native para um aluno
		String sql = "select * from aluno where id = :id";
		Aluno alunoSql = (Aluno) entity.createNativeQuery(sql, Aluno.class)
							.setParameter("id", 1)
							.getSingleResult();
		
		System.out.println(alunoSql);
		
		String sql2 = "select * from aluno";
		List<Aluno> alunosSql = entity.createNativeQuery(sql2, Aluno.class).getResultList();
		alunosSql.forEach(System.out::println);
		*/
		//JPQL consulta Aluno
	/*	String sqlJPQL = "select a from Aluno a where a.id = :id";
		Aluno alunoJPQL = entity.createQuery(sqlJPQL, Aluno.class).setParameter("id", 3).getSingleResult();
		System.out.println(alunoJPQL);
//		*/
//		String sqlJPQL2 = "select a from Aluno a";
//		List<Aluno> alunosJPQL = entity.createQuery(sqlJPQL2, Aluno.class).getResultList();
//		alunosJPQL.forEach(System.out::println);
		
		//diferen�as para SQL native
//		String sqlJPQL3 = "SELECT a FROM Aluno a WHERE a.estado.nome = :nomestado";
//		List<Funcionario> alunosJPQL2 = entity.createQuery(sqlJPQL3, Funcionario.class)
//				.setParameter("nomestado", "Pernanbuco")
//				.getResultList();
//		alunosJPQL2.forEach(System.out::println);
		
		// buscando por um objeto
		/*String sqlJPQL4 = "SELECT a FROM Aluno a WHERE a.estado = :estado";
		List<Aluno> alunoJPQL3 = entity.createQuery(sqlJPQL4, Aluno.class)
				.setParameter("estado", entity.find(Estado.class, 1))
				.getResultList();
		
		alunoJPQL3.forEach(System.out::println);*/
	
	}
}
