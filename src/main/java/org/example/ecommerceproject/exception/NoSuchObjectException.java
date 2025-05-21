package org.example.ecommerceproject.exception;

public class NoSuchObjectException extends RuntimeException {

    public NoSuchObjectException() {
    }

    public NoSuchObjectException(String message) {
        super(message);
    }

    public NoSuchObjectException(Throwable cause) {
        super(cause);
    }

    public NoSuchObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
