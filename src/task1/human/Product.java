package task1.store.human;

public class Product {
    private String name;
    private double price;
    private long count;

    public Product(final String name, final double price, final long count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Product(final Product product) {
        this.name = product.name;
        this.count = product.count;
        this.price = product.price;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public long getCount() {
        return count;
    }

    public void setCount(final long count) {
        this.count = count;
    }
}
