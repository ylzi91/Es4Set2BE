package yurilenzi.catalog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static long id = 3000;
    private Status status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products = new ArrayList<>();
    private Customer customer;


    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product prd){
        status = Status.ORDERED;
        orderDate = LocalDate.now();
        id++;
        products.add(prd);
    }
    public void shipped(){
        status = Status.SHIPPED;
        if(orderDate != null) {
            deliveryDate = orderDate.plusDays(1);
        }
    }

    public static long getId() {
        return id;
    }

    public Status getStatus() {
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

    public void setOrderDate(String orderDate) {
        this.orderDate = LocalDate.parse(orderDate);
    }

    @Override
    public String toString() {
        return "Order" +
                "status=" + status + "\n" +
                ", orderDate=" + orderDate + "\n" +
                ", deliveryDate=" + deliveryDate + "\n" +
                ", products=" + products + "\n" +
                ", customer=" + customer + "\n"
                ;
    }
}
