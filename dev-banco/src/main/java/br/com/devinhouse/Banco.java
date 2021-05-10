package br.com.devinhouse;

import br.com.devinhouse.eventos.EventoListener;
import br.com.devinhouse.modelo.ContaCorrente;
import br.com.devinhouse.modelo.ContaPoupanca;

import java.math.BigDecimal;

public class Banco {

    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("1", 100, 1000);
        contaCorrente.addPropertyChangeListener(new EventoListener(contaCorrente));

        ContaPoupanca contaPoupanca = new ContaPoupanca("1.1", 200);
        contaPoupanca.addPropertyChangeListener(new EventoListener(contaPoupanca));

        contaCorrente.debitar(900);
        contaPoupanca.debitar(50);
        contaPoupanca.depositar(100);

        System.out.println(contaPoupanca.extrato());
        System.out.println(contaCorrente.extrato());

        System.out.println(contaCorrente);
        System.out.println(contaPoupanca);

        System.out.println(contaPoupanca.ultimoEvento());
    }

}
