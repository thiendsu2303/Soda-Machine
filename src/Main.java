import model.Product;
import service.MoneyService;
import service.OrderService;
import service.PaymentService;
import service.PromotionService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MoneyService moneyService = new MoneyService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();
        PromotionService promotionService = new PromotionService();

        moneyService.acceptNotes();
        int totalAmount = moneyService.getTotalAmount();

        int totalCost = orderService.placeOrder(totalAmount);
        if (totalCost == -1) {
            moneyService.acceptNotes();
            totalAmount = moneyService.getTotalAmount();
            totalCost = orderService.placeOrder(totalAmount);
        }

        if (totalCost > 0) {
            Map<Product, Integer> orderDetails = orderService.getOrderDetails();
            int change = paymentService.processPayment(totalAmount, totalCost, orderDetails, promotionService);
            if (change >= 0) {
                // Show the final order details with promotions applied
                Map<Product, Integer> finalOrderDetails = paymentService.getFinalOrderDetails();
                finalOrderDetails.forEach((product, quantity) -> {
                    System.out.println("You received a total of " + quantity + " x " + product.getName());
                });
            } else {
                System.out.println("Transaction canceled, refunding " + totalAmount + " VND.");
            }
        }

        promotionService.adjustWinRate(promotionService.isBudgetExceeded());
    }
}