package task1.store.human;

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
}
