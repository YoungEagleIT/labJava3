package task2;

import task1.human.Product;

import java.util.List;

public class Report {
    private final List<Product> products;

    public Report(final List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void validate() throws ProductNameException, ProductPriceIsZeroOrLessException, ProductCountIsZeroOrLessException {
        for (final Product product : products) {
            if (product.getName().isEmpty()) {
                throw new ProductNameException();
            }
            if (product.getPrice() <= 0L) {
                throw new ProductPriceIsZeroOrLessException();
            }
            if (product.getCount() <= 0L) {
                throw new ProductCountIsZeroOrLessException();
            }
        }
    }
}
