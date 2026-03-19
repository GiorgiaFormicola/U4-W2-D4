package GiorgiaFormicola;

import GiorgiaFormicola.entities.Customer;
import GiorgiaFormicola.entities.Order;
import GiorgiaFormicola.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private final static Logger logger = LoggerFactory.getLogger("");

    public static void main(String[] args) {
        logger.info("APPLICATION STARTED");


        List<Product> productsList1 = Arrays.asList(
                new Product("The Lord of The Rings", "Books", 17.5),
                new Product("Game of Thrones", "Books", 20.0),
                new Product("Harry Potter", "Books", 17.5),
                new Product("Rarest Book Ever", "Books", 1000.0),
                new Product("Second Rarest Book Ever", "Books", 500.0),
                new Product("Pacifier", "Baby", 3.0),
                new Product("Puppet", "Baby", 5.0),
                new Product("Hot Wheels", "Boys", 15.5),
                new Product("Lego Darth Vader", "Boys", 40.0),
                new Product("Barbie", "Girls", 20.0),
                new Product("Bag", "Girls", 40.0)
        );

        List<Product> productsList2 = Arrays.asList(
                new Product("The Da Vinci Code", "Books", 20.0),
                new Product("PlayStation 5", "Boys", 40.0),
                new Product("Bratz", "Girls", 15.0)
        );

        Customer customer1 = new Customer("Giorgia", 1);
        Customer customer2 = new Customer("Marco", 3);
        Customer customer3 = new Customer("Chiara", 2);

        List<Order> ordersList = Arrays.asList(
                new Order(productsList1, customer1),
                new Order(productsList2, customer2),
                new Order(productsList1, customer3),
                new Order(productsList2, customer3)
        );

        System.out.println("\n---------------------------------------------------------------------------------------------");
        logger.info("EXERCISE 1\n");

        System.out.println("ORDERS LIST");
        ordersList.forEach(order -> System.out.println(order));

        Map<Customer, List<Order>> ordersByCustomer = ordersList
                .stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer()));

        System.out.println("\nORDERS GROUPED BY CUSTOMERS");
        ordersByCustomer.forEach(((customer, orders) -> {
            System.out.println("CUSTOMER: " + customer.getName());
            orders.forEach(order -> System.out.println("OrderID = " + order.getId() + " -> Products List: " + order.getProducts().stream().map(product -> product.getName()).toList()));
        }));

        System.out.println("\n---------------------------------------------------------------------------------------------");
        logger.info("EXERCISE 2\n");
        System.out.println("ORDERS LIST");
        ordersList.forEach(order -> System.out.println("Order ID = " + order.getId() + ", Customer = " + order.getCustomer().getName() + " -> Total Cost: " + order.calculateTotalCost()));

        Map<Customer, Double> orderTotalSpendingForEachCustomer = ordersList
                .stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer(), Collectors.summingDouble(order -> order.calculateTotalCost())));

        System.out.println("\nCUSTOMER TOTAL SPENDING");
        orderTotalSpendingForEachCustomer.forEach((customer, totalSpending) -> System.out.println("Customer = " + customer.getName() + " -> Total Spending: " + totalSpending));

        System.out.println("\n---------------------------------------------------------------------------------------------");
        logger.info("EXERCISE 3\n");
        System.out.println("PRODUCTS LIST");
        productsList1.forEach(product -> System.out.println(product));

        List<Product> top3MostExpensiveProducts = productsList1.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(3).toList();


        System.out.println("\nTOP 3 MOST EXPENSIVE PRODUCTS");
        top3MostExpensiveProducts.forEach(product -> System.out.println(product));

        System.out.println("\n---------------------------------------------------------------------------------------------");
        logger.info("EXERCISE 4\n");

        System.out.println("ORDERS LIST");
        ordersList.forEach(order -> System.out.println("Order ID = " + order.getId() + " -> Total Cost: " + order.calculateTotalCost()));

        OptionalDouble ordersAverageCost = ordersList.stream().mapToDouble(order -> order.calculateTotalCost()).average();
        System.out.println("\nAVERAGE COST OF THE ORDERS");
        System.out.println(ordersAverageCost.getAsDouble());


        System.out.println();
        logger.info("APPLICATION ENDED");
    }

}
