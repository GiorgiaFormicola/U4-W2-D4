package GiorgiaFormicola.entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private static Long ordersAmount = 0L;
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(List<Product> products, Customer customer) {
        ordersAmount++;
        this.id = ordersAmount;
        this.status = "In progress";
        this.orderDate = LocalDate.now();
        this.deliveryDate = this.orderDate.plusDays(4);
        this.products = products;
        this.customer = customer;
    }

    public Order(LocalDate orderDate, List<Product> products, Customer customer) {
        ordersAmount++;
        this.id = ordersAmount;
        this.status = "Delivered";
        this.orderDate = orderDate;
        this.deliveryDate = this.orderDate.plusDays(4);
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double calculateTotalCost() {
        return products.stream().mapToDouble(product -> product.getPrice()).sum();
    }

    ;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer= " + customer +
                ", status='" + status +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +

                '}';
    }
}
