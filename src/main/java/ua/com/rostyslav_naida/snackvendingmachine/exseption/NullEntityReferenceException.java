package ua.com.rostyslav_naida.snackvendingmachine.exseption;

public class NullEntityReferenceException extends RuntimeException {

    public NullEntityReferenceException() {
    }

    public NullEntityReferenceException(String message) {
        super(message);
    }
}
