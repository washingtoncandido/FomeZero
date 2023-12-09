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
//	private Date dataDeAdmissao;
//	private Date dataDeDemissao;
//	private Gerente contratante;

	public Funcionario(int id, String nome, String endereco, double salario) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
//		this.contratante = contratante;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

//	public Date getDataDeAdmissao() {
//		return dataDeAdmissao;
//	}

//	public void setDataDeAdmissao(Date dataDeAdmissao) {
//		this.dataDeAdmissao = dataDeAdmissao;
//	}
//
//	public Date getDataDeDemissao() {
//		return dataDeDemissao;
//	}
//
//	public void setDataDeDemissao(Date dataDeDemissao) {
//		this.dataDeDemissao = dataDeDemissao;
//	}

//	public Gerente getContratante() {
//		return contratante;
//	}
//
//	public void setContratante(Gerente contratante) {
//		this.contratante = contratante;
//	}

//	public void exibirFuncionario(){
//		System.out.println("nome do Funcionario:" this.nome);
//	}
}