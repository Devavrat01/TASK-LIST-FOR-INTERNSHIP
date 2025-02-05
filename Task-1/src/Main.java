
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (atm.login(accountNumber, pin)) {
            System.out.println("Login successful!");
            atm.showMenu();
        } else {
            System.out.println("Invalid account number or PIN!");
        }

        scanner.close();
    }
}
