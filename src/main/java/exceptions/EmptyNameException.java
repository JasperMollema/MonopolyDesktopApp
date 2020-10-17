package exceptions;

public class EmptyNameException extends BadNameException {
    public EmptyNameException(BadNameType badNameType) {
        super(badNameType);
    }
}
