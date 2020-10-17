package exceptions;

public abstract class BadNameException extends Exception {
    protected BadNameType badNameType;

    public BadNameException(BadNameType badNameType) {
        super(badNameType.getMessage());
        this.badNameType = badNameType;
    }

    public BadNameType getBadNameType() {
        return badNameType;
    }

    public enum BadNameType {
        IDENTICAL_NAME("Name already exists"), EMPTY_NAME("Name is empty");

        private String message;

        private BadNameType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
