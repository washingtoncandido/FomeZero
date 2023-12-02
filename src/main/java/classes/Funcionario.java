package classes;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Funcionario")
public abstract class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String endereco;
	private double salario;
	@ManyToOne(fetch = FetchType.LAZY)
	private Estado estado;

	public Funcionario(int id, String nome, String endereco, Estado estado, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.estado = estado;
		this.salario = salario;
	}

}
