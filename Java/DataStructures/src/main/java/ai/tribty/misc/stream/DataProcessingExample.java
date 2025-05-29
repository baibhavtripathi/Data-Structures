package ai.tribty.misc.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    String customerName;
    double amount;

    public Order(String name, double amount) {
        customerName = name;
        this.amount = amount;
    }

    public String getCustomer() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }
}

public class DataProcessingExample {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", 20.5),
            new Order("Bittu", 30.6),
            new Order("Chiti", 40.7),
            new Order("Alice", 67.8),
            new Order("Chiti", 456.7)
        );

        // Group Order by customer and Calculate total amount
        Map<String, Double> customerTotal = orders.stream()
            .collect(
                Collectors.groupingBy(
                    Order::getCustomer,
                    Collectors.summingDouble(Order::getAmount))
            );
        customerTotal.forEach((k,v) -> System.out.println(k + " spent: " + v));
    }
}
