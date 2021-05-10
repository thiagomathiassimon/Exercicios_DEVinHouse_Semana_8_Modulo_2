package br.com.devinhouse.modelo;

import br.com.devinhouse.exception.SaldoInsuficienteException;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numero, double saldo, double limite) {
        super(numero, saldo);
        this.limite = limite;
    }

    @Override
    public boolean debitar(double montante) {
        if (montante <= saldo) {
            saldo -= montante;
            novoEvento(montante);

            return true;
        } else if (limite > 0 && limite >= montante) {
            limite = limite - (montante - saldo);
            saldo -= montante;
            novoEvento(montante);

            return true;
        }
        String msg = String.format("Saldo em conta %.2f mas foi realizada uma tentativa de débito no valor de %.2f",
                saldo, montante);

        throw new SaldoInsuficienteException(msg);
    }

    private void novoEvento(double montante) {
        contaEvent.firePropertyChange("evento", eventos, Evento.novo(Operacao.DEBITO, montante));
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }

}
