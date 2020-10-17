package exceptions;

public class IdenticalNameException extends BadNameException {
    public IdenticalNameException(BadNameType badNameType) {
        super(badNameType);
    }
}
