package CiroVitiello.exceptions;


public class NoFoundException extends RuntimeException {
    public NoFoundException(long id) {
        super("The readable with " + id + " ID was not found.");
    }
}
