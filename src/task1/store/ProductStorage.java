package task1;

import task1.human.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
    private List<Product> products;

    public ProductStorage() {
        products = new ArrayList<>();
    }

    public ProductStorage(final List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }
}
