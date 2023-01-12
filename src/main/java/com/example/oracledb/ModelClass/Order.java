package com.example.oracledb.ModelClass;

import javax.persistence.*;

@Entity
@Table
public class Order {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cust_id",referencedColumnName = "id")
    private Customer customer;
    private double price;
    private double discount;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Long getCustomerId ( ) {
        return customer.getId();
    }
}

