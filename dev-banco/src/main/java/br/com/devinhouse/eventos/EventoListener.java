package br.com.devinhouse.eventos;

import br.com.devinhouse.modelo.Evento;
import br.com.devinhouse.modelo.Conta;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EventoListener implements PropertyChangeListener {
    private final Conta conta;

    public EventoListener(Conta conta) {
        this.conta = conta;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        conta.registrarNovaOperacao((Evento) evt.getNewValue());
    }
}
