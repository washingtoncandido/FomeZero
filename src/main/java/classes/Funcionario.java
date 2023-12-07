package classes;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Funcionario {
	@Id
	private int id;
	private String nome;
	private String endereco;
	private double salario;
	private Date dataDeAdmissao;
	private Date dataDeDemissao;
	private Gerente contratante;

	public Funcionario(int id, String nome, String endereco, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		}

}
