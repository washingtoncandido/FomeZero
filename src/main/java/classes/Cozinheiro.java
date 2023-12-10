package classes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cozinheiro extends Funcionario {
    private double bonus;
    private String certificacaoCulinaria;


    public Cozinheiro(int id, String nome, String endereco, double salario, double bonus, String certificacaoCulinaria) {
        super(id, nome, endereco, salario);
        this.bonus = bonus;
        this.certificacaoCulinaria = certificacaoCulinaria;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getCertificacoesCulinarias() {
        return certificacaoCulinaria;
    }

    public void setCertificacaoCulinaria(String certificacaoCulinaria) {
        this.certificacaoCulinaria = certificacaoCulinaria;
    }
    @Override
    public String toString() {
        return "Cozinheiro{" +
                "bonus=" + bonus +
                ", certificacoesCulinarias='" + certificacaoCulinaria + '\'' +
                '}';
    }
}
