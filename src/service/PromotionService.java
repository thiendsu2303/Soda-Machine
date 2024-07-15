package service;

import java.util.Random;

public class PromotionService {
    private static final int DAILY_BUDGET = 50000;
    private static final int BASE_WIN_RATE = 10;
    private int dailySpent = 0;
    private int currentWinRate = BASE_WIN_RATE;

    public boolean applyPromotion(int quantity, int productPrice) {
        if (quantity >= 3) {
            Random random = new Random();
            int chance = random.nextInt(100);
            if (chance < currentWinRate) {
                if (dailySpent + productPrice <= DAILY_BUDGET) {
                    dailySpent += productPrice;
                    System.out.println("Congratulations! You won a free product.");
                    return true;
                }
            }
            else {
                System.out.println("Good luck next time for the promotion :>");
            }
        }
        return false;
    }

    public void adjustWinRate(boolean budgetExceeded) {
        if (!budgetExceeded) {
            currentWinRate = 50;
        } else {
            currentWinRate = BASE_WIN_RATE;
        }
    }

    public int getDailySpent() {
        return dailySpent;
    }

    public boolean isBudgetExceeded() {
        return dailySpent >= DAILY_BUDGET;
    }
}