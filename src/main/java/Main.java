 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Funcionario;
import classes.Ingredientes;
import classes.IngredientesFrios;
import classes.IngredientesPa;
import classes.Produto;
import ultil.Validador;
import classes.Cozinheiro;
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

//		Ingredientes pao =  new Ingredientes();
//		pao.setCod(3);
//		pao.setNome("Pão");
//		pao.setMarca("frances");
//		
//		Ingredientes carneMoida = new Ingredientes();
//		carneMoida.setCod(1);
//		carneMoida.setNome("alcatra");
//		carneMoida.setMarca("friboi");
//		
//		Ingredientes alface = new Ingredientes();
//		alface.setCod(2);
//		alface.setNome("alface");
//		alface.setMarca("natural");
		
		
		Produto lobisome = new Produto();
		lobisome.setCod(123);
		lobisome.setNome("lobisome");
		lobisome.setOferta(true);
		lobisome.setPreco(23.0);
		
		Set<Produto> conjuntoProdutos = new HashSet<Produto>();
		Set<IngredientesFrios> conjuntoIngredientesFrios = new HashSet<IngredientesFrios>();
		Set<IngredientesPa> conjuntoIngredientesPa = new HashSet<IngredientesPa>();
		
		IngredientesFrios carne = new IngredientesFrios(1, "moida", "sadia",conjuntoProdutos , 100,"FR");
		IngredientesPa guarana = new IngredientesPa(2,"guaradana","teste", conjuntoProdutos, 102, "PA");
	
	
		conjuntoIngredientesPa.add(guarana);
		conjuntoIngredientesFrios.add(carne);
		
		lobisome.getIngredientes().addAll( conjuntoIngredientesPa);
		lobisome.getIngredientes().addAll(conjuntoIngredientesFrios);
		
		
		

		
		Estado estado = new Estado();
		estado.setNome("Permanbuco");
		estado.setSigla("PE");
		
	
		
		
		
	Validador validador = new Validador();
		if (validador.validarNumero(1) ) {
			carne.updateQtd(1);
		}else {
			System.out.println("valor invalido");
		}
		
//		Cozinheiro funcionario = new Cozinheiro();
//		fun
//		funcionario.setEndereco("Rua  barao de grajau");
//		funcionario.setNome("washington candido dos santos da silva");
//		funcionario.setFuncao("Entregador");
//		funcionario.setEstado(estado);
		
		//gravando dados no banco 
		entity.getTransaction().begin();		
		entity.persist(estado);
////	entity.persist(funcionario);
		entity.persist(carne);
		entity.persist(guarana);
		entity.persist(lobisome);
//		
		entity.getTransaction().commit();
		
		entity.close();
		entityFactory.close();
	}

}
