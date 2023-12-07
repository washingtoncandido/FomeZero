package classes;

import javax.persistence.*;


@MappedSuperclass
public abstract class Funcionario {
	@Id
	private int id;
	private String nome;
	private String endereco;
	private double salario;

	public Funcionario(int id, String nome, String endereco, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		}

}
