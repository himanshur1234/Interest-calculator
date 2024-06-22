package in.capgerni.calculate;

import java.util.Scanner;

public class SBAccount extends Account {

    void openSBAccount() {
        double amount;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the average amount in your account: ");
        amount = sc.nextDouble();
        System.out.println("Are you NRI? Enter 'yes' if so");
        String str = sc.next();
        sc.close();

        if (amount <= 0) {
            System.out.println("Invalid amount. Amount must be greater than zero.");
            return;
        }

        double interestRate = str.equalsIgnoreCase("yes") ? 6 : 4;
        double interest = calculateInterest(interestRate, amount);
        System.out.println("Interest gained: Rs." + interest);
    }

    @Override
    double calculateInterest(double interestRate, double amount) {
        return (amount * interestRate) / 100;
    }

}
