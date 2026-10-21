abstract class Account {
    private final String owner;
    protected long balance;
    Account(String owner, long balance) { this.owner = owner; this.balance = balance; }
    abstract double interestRate();
    abstract boolean canWithdraw(long amount);
    String owner() { return owner; }
}
class SavingsAccount extends Account {
    private final long minimumBalance;
    SavingsAccount(String owner, long balance, long minimumBalance) { super(owner, balance); this.minimumBalance = minimumBalance; }
    @Override double interestRate() { return 4.0; }
    @Override boolean canWithdraw(long amount) { return balance - amount >= minimumBalance; }
}
class CurrentAccount extends Account {
    private final long overdraftLimit;
    CurrentAccount(String owner, long balance, long overdraftLimit) { super(owner, balance); this.overdraftLimit = overdraftLimit; }
    @Override double interestRate() { return 0.0; }
    @Override boolean canWithdraw(long amount) { return balance - amount >= -overdraftLimit; }
}
class FixedDepositAccount extends Account {
    FixedDepositAccount(String owner, long balance) { super(owner, balance); }
    @Override double interestRate() { return 7.0; }
    @Override boolean canWithdraw(long amount) { return false; }
}
public class MiniBank05 {
    public static void main(String[] args) {
        Account[] accounts = { new SavingsAccount("Riya", 5000, 1000), new CurrentAccount("Aman", 1000, 500), new FixedDepositAccount("Neha", 7000) };
        for (Account account : accounts) {
            System.out.println(account.owner() + " rate=" + account.interestRate() + " withdraw=" + account.canWithdraw(500));
            if (account instanceof SavingsAccount) System.out.println("Savings account minimum balance applies");
        }
    }
}
