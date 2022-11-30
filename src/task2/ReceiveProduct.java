package task2;

import task1.store.ProductStorage;
import task1.human.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReceiveProduct {
    private final ProductStorage storage;

    public ReceiveProduct(final ProductStorage storage) {
        this.storage = storage;
    }

    public ProductStorage getStorage() {
        return storage;
    }

    public Report sendToStorage(final Product product) {
        storage.getProducts().add(product);
        return new Report(Stream.of(product).collect(Collectors.toList()));
    }

    public Report sendToStorage(final List<Product> products) {
        storage.getProducts().addAll(products);
        return new Report(products);
    }

}
