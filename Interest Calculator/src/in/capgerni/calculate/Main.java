package in.capgerni.calculate;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("Select the option:\r\n"
                    + "1. Interest Calculator – SB\r\n"
                    + "2. Interest Calculator – FD\r\n"
                    + "3. Interest Calculator – RD\r\n"
                    + "4. Exit");
            
            int a = getValidIntegerInput(sc);
            
            switch (a) {
                case 1: {
                    SBAccount sb = new SBAccount();
                    sb.openSBAccount();
                    break;
                }
                case 2: {
                    FDAccount fd = new FDAccount();
                    fd.calculateFDInterest();
                    break;
                }
                case 3: {
                    RDAccount rd = new RDAccount();
                    rd.openRDAccount();
                    break;
                }
                case 4: {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default: {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        
    }

    private static int getValidIntegerInput(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Please enter a valid integer option.");
                sc.next(); // Clear the invalid input
            }
        }
    }
}