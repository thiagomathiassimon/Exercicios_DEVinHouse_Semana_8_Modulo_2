package br.com.devinhouse.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Evento {
    private final Operacao operacao;
    private final double valor;
    private final LocalDateTime data;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSSS");

    private Evento(Operacao operacao, double valor, LocalDateTime data) {
        this.operacao = operacao;
        this.valor = valor;
        this.data = data;
    }

    public static Evento novo(Operacao operacao, double valor) {
        return new Evento(operacao, valor, LocalDateTime.now());
    }

    public LocalDateTime getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return operacao == evento.operacao && Objects.equals(valor, evento.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operacao, valor);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "operacao=" + operacao +
                ", valor=" + valor +
                ", data=" + formatter.format(data) +
                '}';
    }

}
