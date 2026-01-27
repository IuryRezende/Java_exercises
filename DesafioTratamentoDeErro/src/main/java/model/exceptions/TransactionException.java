package model.exceptions;

public class TransactionException extends RuntimeException {
    public TransactionException(String message) {
        super(message);
    }
}
