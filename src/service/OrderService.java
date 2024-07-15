package service;

import model.Product;
import model.ListProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderService {
    private int totalCost = 0;
    private Map<Product, Integer> orderDetails = new HashMap<>();

    public int placeOrder(int availableAmount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available products:");
        ListProduct.PRODUCTS.forEach(product -> System.out.println(product));

        while (true) {
            System.out.println("Enter product name to order (or 'done' to finish):");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("done")) break;

            Product selectedProduct = ListProduct.PRODUCTS.stream()
                    .filter(product -> product.getName().equalsIgnoreCase(productName))
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null) {
                System.out.println("Enter quantity:");
                int quantity = scanner.nextInt();
                int cost = selectedProduct.getPrice() * quantity;

                if (availableAmount >= totalCost + cost) {
                    totalCost += cost;
                    orderDetails.put(selectedProduct, orderDetails.getOrDefault(selectedProduct, 0) + quantity);
                    System.out.println("Added " + quantity + " x " + productName + " to order. Current total cost: " + totalCost + " VND");
                } else {
                    System.out.println("Insufficient funds for this order.");
                    System.out.println("Do you want to add more funds? (yes/no)");
                    String response = scanner.next();
                    if (response.equalsIgnoreCase("yes")) {
                        return -1;
                    } else {
                        System.out.println("Order canceled.");
                        return 0;
                    }
                }
            } else {
                System.out.println("Invalid product name.");
            }
        }

        return totalCost;
    }

    public void resetTotalCost() {
        totalCost = 0;
        orderDetails.clear();
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }
}