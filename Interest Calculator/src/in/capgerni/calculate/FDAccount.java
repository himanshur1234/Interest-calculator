package in.capgerni.calculate;

import java.util.Scanner;

public class FDAccount extends Account {
    int noOfDays;
    int ageOfACHolder;
    double amount;

    void calculateFDInterest() {
        System.out.println("Enter the FD amount:");
        Scanner sc = new Scanner(System.in);
        amount = sc.nextDouble();
        System.out.println("Enter the number of days:");
        noOfDays = sc.nextInt();
        System.out.println("Enter your age:");
        ageOfACHolder = sc.nextInt();
        sc.close();

        if (amount <= 0 || noOfDays <= 0 || ageOfACHolder <= 0) {
            System.out.println("Enter valid info");
            return;
        } 

        double interestRate = rate(noOfDays, ageOfACHolder, amount);
        if (interestRate == -1) {
            System.out.println("Invalid maturity period");
        } else {
            double interest = calculateInterest(interestRate, amount);
            System.out.println("Interest gained is: " + interest);
        }
    }

    double rate(int maturityDays, int age, double amount) {
        boolean isSeniorCitizen = age > 50;

        if (amount > 10000000) {
            if (maturityDays >= 7 && maturityDays <= 14) {
                return 6.50;
            } else if (maturityDays >= 15 && maturityDays <= 29) {
                return 6.75;
            } else if (maturityDays >= 30 && maturityDays <= 45) {
                return 6.75;
            } else if (maturityDays >= 45 && maturityDays <= 60) {
                return 8.00;
            } else if (maturityDays >= 61 && maturityDays <= 184) {
                return 8.50;
            } else if (maturityDays >= 185 && maturityDays <= 365) {
                return 10.00;
            } else {
                return -1; 
            }
        } else {
            if (maturityDays >= 7 && maturityDays <= 14) {
                return isSeniorCitizen ? 5.00 : 4.50;
            } else if (maturityDays >= 15 && maturityDays <= 29) {
                return isSeniorCitizen ? 5.25 : 4.75;
            } else if (maturityDays >= 30 && maturityDays <= 45) {
                return isSeniorCitizen ? 6.00 : 5.50;
            } else if (maturityDays >= 45 && maturityDays <= 60) {
                return isSeniorCitizen ? 7.50 : 7.00;
            } else if (maturityDays >= 61 && maturityDays <= 184) {
                return isSeniorCitizen ? 8.00 : 7.50;
            } else if (maturityDays >= 185 && maturityDays <= 365) {
                return isSeniorCitizen ? 8.50 : 8.00;
            } else {
                return -1; 
            }
        }
    }

    @Override
    double calculateInterest(double interestRate, double amount) {
        return (amount * interestRate) / 100;
    }

}
