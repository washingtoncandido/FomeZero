package classes;
import javax.persistence.Entity;
@Entity
public class Entregador extends Funcionario {

    public Entregador(int id, String nome, String endereco, double salario) {
        super(id, nome, endereco, salario);
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "id='" + super.getId() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                ", endereco='" + super.getEndereco() + '\'' +
                ", salario='" + super.getSalario() + '\'' +
                '}';
    }
}
