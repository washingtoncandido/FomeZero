package classes;

import java.util.List;

public class Cozinheiro extends Funcionario {
    private double bonus;
    private String certificacoesCulinarias;
    private List<String> premiosCulinarios;
    private String experienciaNaCozinha;

    public Cozinheiro(int id, String nome, String endereco, Estado estado, double salario, double bonus, String certificacoesCulinarias, List<String> premiosCulinarios, String experienciaNaCozinha) {
        super(id, nome, endereco, estado, salario);
        this.bonus = bonus;
        this.certificacoesCulinarias = certificacoesCulinarias;
        this.premiosCulinarios = premiosCulinarios;
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

    public List<String> getPremiosCulinarios() {
        return premiosCulinarios;
    }

    public void setPremiosCulinarios(List<String> premiosCulinarios) {
        this.premiosCulinarios = premiosCulinarios;
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
                ", premiosCulinarios=" + premiosCulinarios +
                ", experienciaNaCozinha='" + experienciaNaCozinha + '\'' +
                '}';
    }
}
