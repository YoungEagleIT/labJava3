package task2;

public class ProductNameException extends Exception {
    public ProductNameException() {
    }

    public ProductNameException(final String message) {
        super(message);
    }

    public ProductNameException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
