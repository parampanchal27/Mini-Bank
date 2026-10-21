import java.util.*;

public class MiniBank14 {
    static class Account { final String owner; long balance; Account(String owner, long balance) { this.owner = owner; this.balance = balance; } }
    static class BankService {
        private final ArrayList<Account> accounts = new ArrayList<>();
        void add(Account account) { accounts.add(account); }
        void deposit(Account account, long amount) { if (amount <= 0) throw new IllegalArgumentException("Amount must be positive"); account.balance += amount; }
        int count() { return accounts.size(); }
        void withdraw(Account account, long amount) { if (amount > account.balance) throw new IllegalStateException("Insufficient funds"); account.balance -= amount; }
    }
    static void check(boolean condition, String message) { if (!condition) throw new AssertionError(message); }
    public static void main(String[] args) {
        BankService service = new BankService(); Account account = new Account("Riya", 1000); service.add(account);
        service.deposit(account, 500); check(account.balance == 1500, "Deposit failed"); check(service.count() == 1, "Count failed");
        try { service.withdraw(account, 5000); throw new AssertionError("Expected exception"); } catch (IllegalStateException expected) { }
        System.out.println("Layered service tests passed");
    }
}
