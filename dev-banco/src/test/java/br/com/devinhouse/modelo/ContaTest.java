package br.com.devinhouse.modelo;

import br.com.devinhouse.exception.DepositoInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Conta conta;

    @BeforeEach
    void setup(){
        conta = new ContaCorrente("114", 0, 0);
    }

    @Test
    void Deve_Testar_Se_Saldo_Da_Conta_Igual_A_0(){
        double actual = conta.getSaldo();

        double expected = 0.0;

        assertEquals(actual, expected);
    }

    @Test
    void Deve_Testar_Se_Saldo_Da_Conta_Igual_A_0_Com_Assert_True(){
        double actual = conta.getSaldo();

        double expected = 0.0;

        assertTrue(actual == expected);
    }

    @Test
    void Deve_Testar_Deposito_Valido_Com_Saldo_Inicial_0(){

        double valorDeDeposito = 100.00;
        boolean actual = conta.depositar(valorDeDeposito);

        double saldoAtual = conta.getSaldo();

        assertTrue(actual);
        assertEquals(saldoAtual, valorDeDeposito);
    }

    @Test
    void Deve_Testar_Deposito_Invalido(){

        final double valorDeDeposito = -100.00;

        assertThrows(DepositoInvalidoException.class, () ->
                conta.depositar(valorDeDeposito)
        );
    }

    @Test
    void Deve_Testar_Debito_Com_Saldo_Inicial_Maior_Que_0(){
        final double valorDeSaldoInicial = 100.00;
        final double valorDeDebito = 50.00;

        conta.saldo = valorDeSaldoInicial;

        final double expected = conta.getSaldo() - valorDeDebito;

        conta.debitar(valorDeDebito);

        final double actual = conta.getSaldo();

        assertEquals(expected, actual);
    }

}