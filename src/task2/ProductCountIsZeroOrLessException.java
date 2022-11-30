package task2;

public class ProductCountIsZeroOrLessException extends Exception {
    public ProductCountIsZeroOrLessException() {
    }

    public ProductCountIsZeroOrLessException(final String message) {
        super(message);
    }

    public ProductCountIsZeroOrLessException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
