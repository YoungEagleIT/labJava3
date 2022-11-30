package task1.human;

import java.util.Objects;

public class Customer {
    private String name;
    private double money;

    public Customer(final String name, final double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setMoney(final double money) {
        this.money = money;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Customer customer = (Customer) o;
        return Double.compare(customer.money, money) == 0 && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}
