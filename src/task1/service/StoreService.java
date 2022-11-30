package task1.store.service;

import task1.store.History;
import task1.store.ProductStorage;
import task1.store.human.Customer;
import task1.store.human.Product;
import task1.store.util.Check;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class StoreService {
    private final ProductStorage productStorage;
    private final History history;

    public StoreService(final ProductStorage productStorage, final History history) {
        this.productStorage = productStorage;
        this.history = history;
    }

    public Product getProductByName(final String name) {
        return productStorage.getProducts().stream()
                .filter(e -> e.getName().equals(name)).findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find product with this name(\"" + name + "\")"));
    }

    public Check sellProduct(final Customer customer, final String nameProduct) {
        return sellProducts(customer, nameProduct, 1L);
    }

    public Check sellProducts(final Customer customer, final String nameProduct, final Long count) {
        final long ZERO = 0L;
        final Product product = getProductByName(nameProduct);
        final Check check = new Check();

        final double totalMoney = count * product.getPrice();
        if (customer.getMoney() < totalMoney) {
            throw new RuntimeException("Not enough money " + customer.getMoney() + "/" + totalMoney);
        }

        if (product.getCount() > count) {
            product.setCount(product.getCount() - count);
        } else {
            throw new RuntimeException("Not enough products. Only " + product.getCount() + " available");
        }

        if (product.getCount() == ZERO) {
            productStorage.setProducts(productStorage.getProducts().stream()
                    .filter(e -> !e.getName().equals(nameProduct)).collect(Collectors.toList()));
        }

        check.setProduct(new Product(product.getName(), product.getPrice(), count));
        check.setTime(LocalDateTime.now());

        history.getReceipts().add(check);

        customer.setMoney(customer.getMoney() - totalMoney);

        return check;
    }
}
