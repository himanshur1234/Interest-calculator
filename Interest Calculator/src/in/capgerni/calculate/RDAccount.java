package in.capgerni.calculate;

import java.util.Scanner;

public class RDAccount extends Account {
    
    // Constructor
   void openRDAccount() {
        // Scanner to take input from user
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the monthly amount
        System.out.println("Enter monthly Amount:");
        double monthlyAmount = scanner.nextDouble();

        // Prompt user for the maturity period in months
        System.out.println("Enter the maturity period (in months): ");
        int months = scanner.nextInt();

        // Prompt user for the customer type
        System.out.println("Enter the customer type (general/senior): ");
        String customerType = scanner.next().toLowerCase();

        // Determine the interest rate based on the input
        double interestRate = 0.0;
        if (months == 6) {
            interestRate = customerType.equals("senior") ? 8.00 : 7.50;
        } else if (months == 9) {
            interestRate = customerType.equals("senior") ? 8.25 : 7.75;
        } else if (months == 12) {
            interestRate = customerType.equals("senior") ? 8.50 : 8.00;
        } else if (months == 15) {
            interestRate = customerType.equals("senior") ? 8.75 : 8.25;
        } else if (months == 18) {
            interestRate = customerType.equals("senior") ? 9.00 : 8.50;
        } else if (months == 21) {
            interestRate = customerType.equals("senior") ? 9.25 : 8.75;
        } else {
            System.out.println("Invalid maturity period entered.");
            return;
        }

        // Calculate the interest
        double interest = calculateInterest(interestRate, monthlyAmount);
        System.out.println("Interest gained: " + interest);
    }

    @Override
    double calculateInterest(double interestRate, double amount) {
        // Simple interest formula
        return (amount * interestRate) / 100;
    }


}
