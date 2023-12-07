package classes;

public class Gerente extends Funcionario{
    private String areaEspecializacao;

    public Gerente(int id, String nome, String endereco, double salario, String areaEspecializacao) {
        super(id, nome, endereco, salario);
        this.areaEspecializacao = areaEspecializacao;
    }

    public String getAreaEspecializacao() {
        return areaEspecializacao;
    }

    public void setAreaEspecializacao(String areaEspecializacao) {
        this.areaEspecializacao = areaEspecializacao;
    }
    public void contratarFuncionario(Funcionario funcionario) {
//        return NULL;
    }
    public void demitirFuncionario(Funcionario funcionario) {
//        funcionario == NULL;
    }
    }