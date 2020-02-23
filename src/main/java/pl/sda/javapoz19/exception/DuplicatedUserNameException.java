package pl.sda.javapoz19.exception;

public class DuplicatedUserNameException extends RuntimeException{
    public DuplicatedUserNameException(String message) {
        super(message);
    }
}
