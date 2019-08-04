package pers.emery.exception;

public class DriverVersionException extends RuntimeException {

    public DriverVersionException() {
        super();
    }

    public DriverVersionException(String message) {
        super(message);
    }

    public DriverVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverVersionException(Throwable cause) {
        super(cause);
    }
}
