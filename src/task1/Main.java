package task1.store;

import task1.store.human.Customer;
import task1.store.human.Product;
import task1.store.service.StoreService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(final String[] args) {
        final ProductStorage storage = new ProductStorage();
        storage.setProducts(Stream.of(
                new Product("monitor", 3200, 3),
                new Product("hat", 140, 55)
        ).collect(Collectors.toList()));
        final History history = new History();

        final Customer customer = new Customer("Andrew", 2000);

        final StoreService service = new StoreService(storage, history);

        service.sellProducts(customer, "hat", 10L);

        System.out.println(customer);
    }
}
