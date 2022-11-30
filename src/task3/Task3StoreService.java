package task3;

import task1.human.Customer;
import task1.human.Product;
import task1.service.StoreService;
import task1.store.History;
import task1.store.ProductStorage;
import task1.util.Check;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3StoreService extends StoreService {
    public Task3StoreService(final ProductStorage storage, final History history) {
        super(storage, history);
    }

    public List<Product> filterByPrice(final double lowPrice, final double highPrice) {
        return storage.getProducts().stream()
                .filter(e -> e.getPrice() >= lowPrice && e.getPrice() <= highPrice).collect(Collectors.toList());
    }

    public void sortByName() {
        storage.getProducts().sort(Comparator.comparing(Product::getName));
    }

    public double avgPriceAllProducts() {
        return storage.getProducts().stream().mapToDouble(Product::getPrice)
                .average().orElseThrow(() -> new RuntimeException("Something went wrong when calculating avg price"));
    }

    private List<Check> getAllCustomerChecks(final Customer customer) {
        return history.getChecks().stream().filter(e -> e.getCustomer().equals(customer)).collect(Collectors.toList());
    }

    public double getAllCustomerExpenses(final Customer customer) {
        return getAllCustomerChecks(customer)
                .stream()
                .mapToDouble(e -> e.getProduct().getPrice() * e.getProduct().getCount())
                .sum();
    }

    private long sumAllProducts(final List<Check> checks) {
        return checks.stream().mapToLong(check -> check.getProduct().getCount()).sum();
    }

    public Map<Product, Long> getProductCountByCustomer(final Customer customer) {
        return getAllCustomerChecks(customer).stream()
                .collect(Collectors.groupingBy(Check::getProduct))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, checks -> sumAllProducts(checks.getValue())));
    }

    public Product getPopularProduct() {
        return history.getChecks().stream()
                .collect(Collectors.groupingBy(Check::getProduct))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, checks -> sumAllProducts(checks.getValue())))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("Something went wrong when calculating popular product"))
                .getKey();
    }

    private double sumIncome(final List<Check> checks) {
        return checks.stream().mapToDouble(check -> check.getProduct().getCount() * check.getProduct().getPrice()).sum();
    }

    public double getMostIncomePerDay() {
        return history.getChecks().stream()
                .collect(Collectors.groupingBy(Check::getTime))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, checks -> sumIncome(checks.getValue())))
                .entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("Something went wrong when calculating income per day"))
                .getValue();
    }
}
