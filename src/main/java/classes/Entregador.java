package classes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;
@Entity
public class Entregador extends Funcionario {
    private String transporteDeEntrega;
    private String rotaDeEntrega;
    private String telefone;
    private double gorjeta;

    public Entregador(int id, String nome, String endereco, double salario, String transporteDeEntrega, String rotaDeEntrega, String telefone, double gorjeta) {
        super(id, nome, endereco, salario);
        this.transporteDeEntrega = transporteDeEntrega;
        this.rotaDeEntrega = rotaDeEntrega;
        this.telefone = telefone;
        this.gorjeta = gorjeta;
    }

    public String getTransporteDeEntrega() {
        return transporteDeEntrega;
    }

    public void setTransporteDeEntrega(String transporteDeEntrega) {
        this.transporteDeEntrega = transporteDeEntrega;
    }

    public String getRotaDeEntrega() {
        return rotaDeEntrega;
    }

    public void setRotaDeEntrega(String rotaDeEntrega) {
        this.rotaDeEntrega = rotaDeEntrega;
    }
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getGorjeta() {
        return gorjeta;
    }

    public void setGorjeta(double gorjeta) {
        this.gorjeta = gorjeta;
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "transporteDeEntrega='" + transporteDeEntrega + '\'' +
                ", rotaDeEntrega='" + rotaDeEntrega + '\'' +
                ", telefone='" + telefone + '\'' +
                ", gorjeta=" + gorjeta +
                '}';
    }
}
