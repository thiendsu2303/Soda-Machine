package service;

import model.Note;
import model.ListNote;

import java.util.Scanner;

public class MoneyService {
    private int totalAmount = 0;

    public void acceptNotes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter denominations (10000, 20000, 50000, 100000, 200000). Enter 0 to stop:");

        while (true) {
            int noteValue = scanner.nextInt();
            if (noteValue == 0) break;

            boolean isValidNote = ListNote.NOTES.stream()
                    .anyMatch(note -> note.getDenomination() == noteValue);

            if (isValidNote) {
                totalAmount += noteValue;
                System.out.println("Accepted: " + noteValue + " VND");
                System.out.println("Current total amount: " + totalAmount + " VND");
            } else {
                System.out.println("Invalid denomination: " + noteValue);
            }
        }
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}