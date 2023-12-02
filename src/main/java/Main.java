 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Funcionario;
import classes.Ingredientes;
import classes.Produto;
import classes.Estado;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();
		
//		Ingredientes Camembert = new Ingredientes(3, "Camembert", "França");
//		Ingredientes Brie = new Ingredientes(4, "Brie", "França");
//		Ingredientes Roquefort = new Ingredientes(5, "Brie", "Roquefort");
//		Ingredientes Gorgonzola  = new Ingredientes(6, "Gorgonzola", "Itália");
//		Ingredientes Muçarela  = new Ingredientes(7, "Muçarela", "Itália");
//		Ingredientes batataIngl = new Ingredientes(8,"batata Inglesa","natural");
//		Ingredientes tomate = new Ingredientes(9,"tomate","natural");
//		Ingredientes cebola = new Ingredientes(10,"cebola","natural");

		Ingredientes pao =  new Ingredientes();
		pao.setCod(3);
		pao.setNome("Pão");
		pao.setMarca("frances");
		
		Ingredientes carneMoida = new Ingredientes();
		carneMoida.setCod(1);
		carneMoida.setNome("alcatra");
		carneMoida.setMarca("friboi");
		
		Ingredientes alface = new Ingredientes();
		alface.setCod(2);
		alface.setNome("alface");
		alface.setMarca("natural");
		
		
		Produto lobisome = new Produto();
		lobisome.setCod(123);
		lobisome.setNome("lobisome");
		lobisome.setOferta(true);
		lobisome.setPreco(23.0);

		Set<Ingredientes> conjuntoIngredientes = new HashSet<Ingredientes>();
		
		conjuntoIngredientes.add(alface);
		conjuntoIngredientes.add(carneMoida);
		lobisome.setIngredientes(conjuntoIngredientes);
		
		Estado estado = new Estado();
		estado.setNome("Permanbuco");
		estado.setSigla("PE");
		
		Funcionario funcionario = new Funcionario();
		funcionario.setEndereco("Rua  barao de grajau");
		funcionario.setNome("washington candido dos santos da silva");
		funcionario.setFuncao("Entregador");
		funcionario.setEstado(estado);
		
		entity.getTransaction().begin();
		
		entity.persist(estado);
		entity.persist(funcionario);
		entity.persist(lobisome);
		entity.persist(carneMoida);
		entity.persist(alface);
		
		entity.getTransaction().commit();
		
		entity.close();
		entityFactory.close();
	}

}
