package classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();
		// ------------------- Cadastrar ------------------------------
	/*	entity.getTransaction().begin();

		Estado estado = new Estado();
		estado.setNome("Alagoas");
		estado.setSigla("AL");

		Aluno aluno = new Aluno();
		aluno.setEndereco("Rua Pedro paulo");
		aluno.setEstado(estado);
		aluno.setNome("Alan miguel");

		List<Aluno> alunos = new ArrayList<Aluno>();

		alunos.add(aluno);
		estado.setAlunos(alunos);

		entity.persist(estado);
		entity.persist(aluno);

		entity.getTransaction().commit();*/
		// ----------------- buscar --------------------------------

		Funcionario aluno = entity.find(Funcionario.class, 1);
		Estado estado = entity.find(Estado.class, 1);

		System.out.println(aluno);
		System.out.println(estado);

//		// ----------------- Atualizar -----------------------------------
//		entity.getTransaction().begin();
//
//		aluno.setNome("Paulo");
//
//		entity.getTransaction().commit();
//
//		// --------------------- Consultar ----------------------------------
//
//		aluno = entity.find(Aluno.class, 1);
//
//		System.out.println(aluno);
//
//		// ---------------------------- apagar ------------------------------------
//		entity.getTransaction().begin();
//
//		entity.remove(aluno);
//
//		entity.getTransaction().commit();
//
//		// --------------------------------------------------------------------------
//		aluno = entity.find(Aluno.class, 1);
//
//		System.out.println(aluno);
//
//		entity.close();
//		entityFactory.close();
}

}
