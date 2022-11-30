package task1.store.util;

import task1.store.human.Product;

import java.time.LocalDateTime;

public class Check {
    private LocalDateTime time;
    private Product product;

    public Check(final LocalDateTime time, final Product product) {
        this.time = time;
        this.product = product;
    }

    public Check() {
        this.time = null;
        this.product = null;
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

