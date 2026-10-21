import java.util.Scanner;

public class MiniBank {
    record BankInfo(String name, String branch) {}
    enum MenuOption { OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT }

    public static void main(String[] args) {
        BankInfo bank = new BankInfo("MiniBank", "Airport Branch");
        System.out.println(bank.name() + " - " + bank.branch());
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Open Account  2. Deposit  3. Withdraw  4. Transfer  5. Exit");
            int choice = scanner.nextInt();
            MenuOption option = switch (choice) {
                case 1 -> MenuOption.OPEN_ACCOUNT;
                case 2 -> MenuOption.DEPOSIT;
                case 3 -> MenuOption.WITHDRAW;
                case 4 -> MenuOption.TRANSFER;
                case 5 -> MenuOption.EXIT;
                default -> null;
            };
            if (option == null) System.out.println("Invalid choice");
            else if (option == MenuOption.EXIT) running = false;
            else System.out.println(option + " - to be implemented in a later practical");
        }
        System.out.println("Goodbye");
        scanner.close();
    }
}
