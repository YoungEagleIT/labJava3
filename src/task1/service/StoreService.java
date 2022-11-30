package task1.service;

import task1.store.History;
import task1.store.ProductStorage;
import task1.human.Customer;
import task1.human.Product;
import task1.util.Check;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class StoreService {
    protected final ProductStorage storage;
    protected final History history;

    public StoreService(final ProductStorage storage, final History history) {
        this.storage = storage;
        this.history = history;
    }

    public Product getProductByName(final String name) {
        return storage.getProducts().stream()
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
            storage.setProducts(storage.getProducts().stream()
                    .filter(e -> !e.getName().equals(nameProduct)).collect(Collectors.toList()));
        }

        history.getChecks().add(check);

        customer.setMoney(customer.getMoney() - totalMoney);

        check.setProduct(new Product(product.getName(), product.getPrice(), count));
        check.setTime(LocalDateTime.now());
        check.setCustomer(customer);

        return check;
    }
}
