package service;

import model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaymentService {
    private Map<Product, Integer> finalOrderDetails = new HashMap<>();

    public int processPayment(int totalAmount, int totalCost, Map<Product, Integer> orderDetails, PromotionService promotionService) {
        Scanner scanner = new Scanner(System.in);
        int change = totalAmount - totalCost;

        if (change >= 0) {
            System.out.println("Total cost: " + totalCost + " VND");
            System.out.println("Do you want to proceed with the payment? (yes/no)");
            String response = scanner.next();

            if (response.equalsIgnoreCase("yes")) {
                System.out.println("Payment successful. Change to be returned: " + change + " VND");

                // Apply promotion if applicable
                orderDetails.forEach((product, quantity) -> {
                    int finalQuantity = quantity;
                    if (quantity >= 3) {
                        boolean promotionWon = promotionService.applyPromotion(quantity, product.getPrice());
                        if (promotionWon) {
                            finalQuantity += 1;
                            System.out.println("You have received an additional free " + product.getName());
                        }
                    }
                    finalOrderDetails.put(product, finalQuantity);
                });

                return change;
            } else {
                System.out.println("Transaction canceled, refunding " + totalAmount + " VND.");
                return -1;
            }
        } else {
            System.out.println("Insufficient funds. Payment failed.");
            return -1;
        }
    }

    public Map<Product, Integer> getFinalOrderDetails() {
        return finalOrderDetails;
    }
}