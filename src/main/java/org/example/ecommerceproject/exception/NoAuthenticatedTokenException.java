package org.example.ecommerceproject.exception;

public class NoAuthenticatedTokenException extends Exception {

    public NoAuthenticatedTokenException() {
    }

    public NoAuthenticatedTokenException(String message) {
        super(message);
    }

    public NoAuthenticatedTokenException(Throwable cause) {
        super(cause);
    }

    public NoAuthenticatedTokenException(String message, Throwable cause) {
        super(message, cause);
    }

}
