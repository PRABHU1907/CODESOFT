package TasksCodeSoft1;//ATM INTERFACE

import java.util.Scanner; 


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; // Insufficient funds
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }
}

// Class representing the ATM interface
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    // Show the menu to the user
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- ATM Interface ---");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawMoney();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a Nice Day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    // Withdraw money method
    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            if (bankAccount.withdraw(amount)) {
                System.out.println("Withdrawal successful. Please take your cash.");
            } else {
                System.out.println("Insufficient funds. Please try again with a smaller amount.");
            }
        }
    }

    // Deposit money method
    private void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            bankAccount.deposit(amount);
            System.out.println("Deposit successful. Your new balance is: " + bankAccount.checkBalance());
        }
    }

    // Check balance method
    private void checkBalance() {
        System.out.println("Your current balance is: " + bankAccount.checkBalance());
    }
}

// Main class to run the ATM system
public class Task2 {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Creating the ATM object that will interact with the user's account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.displayMenu();
    }
}
