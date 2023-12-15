package classes;

import java.util.List;

import javax.persistence.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private Long telefone;
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;

	public Cliente(String nome, Long telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	

}
