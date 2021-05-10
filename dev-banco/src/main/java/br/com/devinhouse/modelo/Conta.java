package br.com.devinhouse.modelo;

import br.com.devinhouse.exception.DepositoInvalidoException;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Conta {
    protected final String numero;
    protected double saldo;
    protected List<Evento> eventos = new ArrayList<>();
    protected PropertyChangeSupport contaEvent;

    public Conta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        contaEvent = new PropertyChangeSupport(this);
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Evento> extrato() {
        return Collections.unmodifiableList(eventos);
    }

    public boolean depositar(double valor) {
        if (valor < 0.0) {
            throw new DepositoInvalidoException(String.format("Inválido valor para depósito: %f", valor));
        }
        contaEvent.firePropertyChange("evento", eventos, Evento.novo(Operacao.CREDITO, valor));
        saldo += valor;
        return true;
    }

    public void registrarNovaOperacao(Evento evento) {
        eventos.add(evento);
    }

    public abstract boolean debitar(double montante);

    public boolean transferir(Conta destino, double valor) {
        debitar(valor);
        return destino.depositar(valor);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        contaEvent.addPropertyChangeListener(pcl);
    }

    public Evento ultimoEvento() {
        return eventos
                .stream()
                .max(Comparator.comparing(Evento::getData))
                .orElse(null);
    }

    public double[] getValoresEventos() {
        return eventos
                .stream()
                .mapToDouble(Evento::getValor)
                .toArray();
    }

}
