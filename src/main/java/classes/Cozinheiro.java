package classes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cozinheiro extends Funcionario {
    private double bonus;
    private String certificacoesCulinarias;
    private String experienciaNaCozinha;

    public Cozinheiro(int id, String nome, String endereco, double salario, double bonus, String certificacoesCulinarias, String experienciaNaCozinha) {
        super(id, nome, endereco, salario);
        this.bonus = bonus;
        this.certificacoesCulinarias = certificacoesCulinarias;
        this.experienciaNaCozinha = experienciaNaCozinha;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getCertificacoesCulinarias() {
        return certificacoesCulinarias;
    }

    public void setCertificacoesCulinarias(String certificacoesCulinarias) {
        this.certificacoesCulinarias = certificacoesCulinarias;
    }

    public String getExperienciaNaCozinha() {
        return experienciaNaCozinha;
    }

    public void setExperienciaNaCozinha(String experienciaNaCozinha) {
        this.experienciaNaCozinha = experienciaNaCozinha;
    }

    @Override
    public String toString() {
        return "Cozinheiro{" +
                "bonus=" + bonus +
                ", certificacoesCulinarias='" + certificacoesCulinarias + '\'' +
                ", experienciaNaCozinha='" + experienciaNaCozinha + '\'' +
                '}';
    }
}
