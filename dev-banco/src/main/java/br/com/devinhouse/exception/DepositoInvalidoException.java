package br.com.devinhouse.exception;

public class DepositoInvalidoException extends RuntimeException {

    public DepositoInvalidoException(String format) {
        super(format);
    }
}
