package classes;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.List;
@Entity
public class ServicosGerais extends Funcionario {

    private String servicoAtual;
    @ElementCollection
    @JoinTable(
            name = "servicos_especialidades",
            joinColumns = @JoinColumn(name = "servicos_id")
    )
    private List<String> especialidades;
    private double bonusDeInsalubridade;

    public ServicosGerais(int id, String nome, String endereco, double salario , String servicoAtual, List<String> especialidades, double bonusDeInsalubridade) {
        super(id, nome, endereco, salario);
        this.servicoAtual = servicoAtual;
        this.especialidades = especialidades;
        this.bonusDeInsalubridade = bonusDeInsalubridade;
    }

    public String getServicoAtual() {
        return servicoAtual;
    }

    public void setServicoAtual(String servicoAtual) {
        this.servicoAtual = servicoAtual;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<String> especialidades) {
        this.especialidades = especialidades;
    }

    public double getBonusDeInsalubridade() {
        return bonusDeInsalubridade;
    }

    public void setBonusDeInsalubridade(double bonusDeInsalubridade) {
        this.bonusDeInsalubridade = bonusDeInsalubridade;
    }

    @Override
    public String toString() {
        return "ServicosGerais{" +
                "servicoAtual='" + servicoAtual + '\'' +
                ", especialidades=" + especialidades +
                ", bonusDeInsalubridade=" + bonusDeInsalubridade +
                '}';
    }
}
