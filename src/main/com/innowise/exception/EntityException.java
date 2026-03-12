package main.com.innowise.exception;

public class EntityException extends Exception{
    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityException(Throwable cause) {
        super(cause);
    }
    public EntityException() {
    }
}
