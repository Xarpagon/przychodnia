package pl.sda.javapoz19.exceptions;

public class DuplicatedUserNameException extends RuntimeException{
    public DuplicatedUserNameException(String message) {
        super(message);
    }
}
