package br.com.devinhouse.modelo;

import br.com.devinhouse.exception.SaldoInsuficienteException;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 1.0016;

    public ContaPoupanca(String numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public boolean debitar(double montante) {
        if (montante <= saldo) {
            saldo -= montante;

            contaEvent.firePropertyChange("historico", eventos,
                    Evento.novo(Operacao.DEBITO, montante));
            return true;
        }

        throw new SaldoInsuficienteException("O valor solicitado de resgate não está disponível!");
    }

    @Override
    public boolean depositar(double valor) {
        valor *= TAXA_RENDIMENTO;
        return super.depositar(valor);
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
