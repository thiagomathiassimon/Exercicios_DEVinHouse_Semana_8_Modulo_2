package br.com.devinhouse.modelo;

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
        double atual = conta.getSaldo();

        double resultado = 0.0;

        assertEquals(atual, resultado);
    }

    @Test
    void Deve_Testar_Se_Saldo_Da_Conta_Igual_A_0_Com_Assert_True(){
        double atual = conta.getSaldo();

        double resultado = 0.0;

        assertTrue(atual == resultado);
    }

    @Test
    void Deve_Testar_Deposito_Valido_Com_Saldo_Inicial_0(){

        double valorDeDeposito = 100.00;
        boolean atual = conta.depositar(valorDeDeposito);

        double saldoAtual = conta.getSaldo();

        assertTrue(atual);
        assertEquals(saldoAtual, valorDeDeposito);
    }
}