package classes;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Funcionario {
	@Id
	private int id;
	private String nome;
	public Funcionario() {
	}
	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}