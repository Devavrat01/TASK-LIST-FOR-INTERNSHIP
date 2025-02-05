import java.util.Scanner;

public class ATM {
    private Account currentAccount;
    private Scanner scanner;

    public ATM() {
        this.scanner = new Scanner(System.in);
    }

    // User login method
    public boolean login(String accountNumber, String pin) {
        // Hardcoded account for simplicity. Ideally, accounts should be stored in a database.
        Account account = new Account("123456", "1234", 1000.00);  // Example account
        if (account.getAccountNumber().equals(accountNumber) && account.getPin().equals(pin)) {
            currentAccount = account;
            return true;
        }
        return false;
    }

    // Display ATM menu
    public void showMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    // Check balance
    private void checkBalance() {
        System.out.println("Current Balance: $" + currentAccount.getBalance());
    }

    // Deposit money
    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Successfully deposited: $" + amount);
        checkBalance();
    }

    // Withdraw money
    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (currentAccount.withdraw(amount)) {
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
        checkBalance();
    }
}
