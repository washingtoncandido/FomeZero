package classes;
import javax.persistence.Entity;
@Entity
public class Entregador extends Funcionario {

    public Entregador(int id, String nome) {
        super(id, nome);
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "id='" + super.getId() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                '}';
    }
    
    
}
