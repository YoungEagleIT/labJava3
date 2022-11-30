package task2;

public class PriceIsZeroOrLessException extends Exception {
    public PriceIsZeroOrLessException() {
    }

    public PriceIsZeroOrLessException(final String message) {
        super(message);
    }

    public PriceIsZeroOrLessException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
