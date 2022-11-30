package task2;

public class ProductPriceIsZeroOrLessException extends Exception {
    public ProductPriceIsZeroOrLessException() {
    }

    public ProductPriceIsZeroOrLessException(final String message) {
        super(message);
    }

    public ProductPriceIsZeroOrLessException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
