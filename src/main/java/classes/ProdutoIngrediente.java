
package classes;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produto_ingrediente")
public class ProdutoIngrediente {

    @EmbeddedId
    private ProdutoIngredienteId id;

    // outros atributos, getters e setters

    public ProdutoIngredienteId getId() {
        return id;
    }

    public void setId(ProdutoIngredienteId id) {
        this.id = id;
    }
}
