package br.com.devinhouse.modelo;

import br.com.devinhouse.exception.DepositoInvalidoException;
import br.com.devinhouse.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    private static Conta conta;
    private static ContaCorrente contaCorrente;

    @BeforeAll
    static void setup(){
        conta = new ContaCorrente("114", 0, 0);
        contaCorrente = new ContaCorrente("114", 0, 0);
    }

    @Test
    void Deve_Testar_Se_Saldo_Da_Conta_Igual_A_0(){
        conta.saldo = 0;
        double actual = conta.getSaldo();

        double expected = 0.0;

        assertEquals(actual, expected);
    }

    @Test
    void Deve_Testar_Se_Saldo_Da_Conta_Igual_A_0_Com_Assert_True(){
        conta.saldo = 0;
        double actual = conta.getSaldo();

        double expected = 0.0;

        assertTrue(actual == expected);
    }

    @Test
    void Deve_Testar_Deposito_Valido_Com_Saldo_Inicial_0(){
        conta.saldo = 0;
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

        contaCorrente.saldo = valorDeSaldoInicial;

        final double expected = contaCorrente.getSaldo() - valorDeDebito;

        contaCorrente.debitar(valorDeDebito);

        final double actual = contaCorrente.getSaldo();

        assertEquals(expected, actual);
    }

    @Test
    void Deve_Testar_Debito_Com_Saldo_Inicial_Igual_A_0_E_Limite_Maior_Do_Que_0(){
        final double valorDeLimiteInicial = 100.00;
        final double valorDeDebito = 50.00;

        contaCorrente.setLimite(valorDeLimiteInicial);

        final double expected = contaCorrente.getLimite() - valorDeDebito;

        contaCorrente.debitar(valorDeDebito);

        final double actual = contaCorrente.getLimite();

        assertEquals(expected, actual);
    }

    @Test
    void Deve_Testar_Debito_Com_Saldo_E_Limite_Iguais_A_0(){
        contaCorrente.saldo = 0;
        contaCorrente.setLimite(0);
        final double valorDeDebito = 50.00;

        assertThrows(SaldoInsuficienteException.class, () -> contaCorrente.debitar(valorDeDebito));
    }

    @ParameterizedTest(name = "Teste parametrizado")
    @CsvSource({"10,10","100,100"})
    void Deve_Testar_Deposito_Com_O_Uso_De_Parametros(double valorDeDeposito, double valorFinalEsperado){
        conta.saldo = 0;

        conta.depositar(valorDeDeposito);

        assertEquals(valorDeDeposito, valorFinalEsperado);
    }

}