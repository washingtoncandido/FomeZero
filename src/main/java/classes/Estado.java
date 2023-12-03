package classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sigla;
	private String nome;
	@OneToMany (fetch = FetchType.LAZY)
	private List<Funcionario> funcionario;
	
	public Estado(int id, String sigla, String nome, List<Funcionario> funcionario) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.funcionario = funcionario;
	}

	public Estado(String sigla, String nome, List<Funcionario> funcionario) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.funcionario = funcionario;
	}
	
	public Estado() {
		super();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Funcionario> getAlunos() {
		return funcionario;
	}
	public void setAlunos(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", sigla=" + sigla + ", nome=" + nome + ", alunos=" + funcionario + "]";
	}
}
