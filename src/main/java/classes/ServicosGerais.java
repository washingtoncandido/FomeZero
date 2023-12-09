package classes;

import javax.persistence.Entity;
import java.util.List;

public class ServicosGerais extends Funcionario {

    private String servicoAtual;
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
