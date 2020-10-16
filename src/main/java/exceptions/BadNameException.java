package exceptions;

public class BadNameException extends Exception {
    public BadNameException() {
        super("Trying to add a player with an identical name as an existing player.");
    }

    public BadNameException(BadNameType badNameType) {
        super(badNameType.getMessage());
    }

    public enum BadNameType {
        IDENTICAL_NAME("Name already exists"), EMPTY_NAME("Name is empty"), NAME_TOO_LONG("Name is too long");

        private String message;

        private BadNameType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
