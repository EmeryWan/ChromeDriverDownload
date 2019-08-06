package pers.emery.exception;

public class LocalVersionException extends RuntimeException {

    public LocalVersionException() {
        super();
    }

    public LocalVersionException(String message) {
        super(message);
    }

    public LocalVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalVersionException(Throwable cause) {
        super(cause);
    }
}
