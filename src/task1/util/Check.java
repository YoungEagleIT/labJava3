package task1.util;

import task1.human.Customer;
import task1.human.Product;

import java.time.LocalDateTime;

public class Check {
    private LocalDateTime time;
    private Product product;
    private Customer customer;

    public Check(final LocalDateTime time, final Product product, final Customer customer) {
        this.time = time;
        this.product = product;
        this.customer = customer;
    }

    public Check() {
        this.time = null;
        this.product = null;
        this.customer = null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(final LocalDateTime time) {
        this.time = time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }
}

