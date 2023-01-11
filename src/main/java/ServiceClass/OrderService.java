package ServiceClass;

import ModelClass.Customer;

import java.io.Serializable;
import java.util.Objects;
public class OrderService implements Serializable {
    private final Long id;
    private final String name;
    private final int orders;
    private final String category;
    private final int discount;

    public OrderService (Long id, String name, int orders, String category, int discount) {
        this.id = id;
        this.name = name;
        this.orders = orders;
        this.category = category;
        this.discount = discount;
    }

    public Long getId ( ) {
        return id;
    }

    public String getName ( ) {
        return name;
    }

    public int getOrders ( ) {
        return orders;
    }

    public String getCategory ( ) {
        return category;
    }

    public int getDiscount ( ) {
        return discount;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderService entity = (OrderService) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.orders, entity.orders) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.discount, entity.discount);
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash(id, name, orders, category, discount);
    }

    @Override
    public String toString ( ) {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "orders = " + orders + ", " +
                "category = " + category + ", " +
                "discount = " + discount + ")";
    }
}