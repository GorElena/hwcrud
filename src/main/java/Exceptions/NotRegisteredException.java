package Exceptions;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) {
        super(s + " is not registered!");
    }
}

