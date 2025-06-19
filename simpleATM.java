import java.util.Scanner;

public class simpleATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int CORRECT_PIN = 1234;
        int enteredPin;
        double savingsBalance = 1500.00;
        double currentBalance = 2500.00;
        int choice;
        double amount;
        String accNo;

        // PIN verification loop
        do {
            System.out.print("Enter your 4-digit PIN: ");
            enteredPin = scanner.nextInt();
            if (enteredPin != CORRECT_PIN) {
                System.out.println("Wrong PIN! Please try again.");
            }
        } while (enteredPin != CORRECT_PIN);

        System.out.println("PIN verified. Access granted.");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    checkBalance(scanner, savingsBalance, currentBalance);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accNo = scanner.nextLine();

                    System.out.print("Enter deposit amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (amount > 0) {
                        savingsBalance += amount; // For simplicity deposits go to savings
                        System.out.printf("Amount $%.2f deposited to account %s.%n", amount, accNo);
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Select account type for withdrawal:");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    System.out.print("Enter choice: ");
                    int accChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (amount <= 0) {
                        System.out.println("Invalid withdrawal amount!");
                    } else if (accChoice == 1) {
                        if (amount <= savingsBalance) {
                            savingsBalance -= amount;
                            System.out.printf("Successfully withdrew Rs%.2f from Savings account.%n", amount);
                        } else {
                            System.out.println("Insufficient funds in Savings account.");
                        }
                    } else if (accChoice == 2) {
                        if (amount <= currentBalance) {
                            currentBalance -= amount;
                            System.out.printf("Successfully withdrew Rs%.2f from Current account.%n", amount);
                        } else {
                            System.out.println("Insufficient funds in Current account.");
                        }
                    } else {
                        System.out.println("Invalid account type choice!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Simple ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void checkBalance(Scanner scanner, double savingsBalance, double currentBalance) {
        System.out.println("Select account type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("Enter choice: ");
    
        int accChoice = scanner.nextInt();
        scanner.nextLine();

        if (accChoice == 1) {
            System.out.printf("Savings Account Balance: Rs%.2f%n", savingsBalance);
        } else if (accChoice == 2) {
            System.out.printf("Current Account Balance: Rs%.2f%n", currentBalance);
        } else {
            System.out.println("Invalid account type choice!");
        }
    }
}
