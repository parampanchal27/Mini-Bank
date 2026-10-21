interface Transactable { void deposit(long amount); boolean withdraw(long amount); }
interface InterestBearing { double interestRate(); default double yearlyInterest(long balance) { return balance * interestRate() / 100; } }
@FunctionalInterface interface WithdrawRule { boolean allow(long balance, long amount); }
interface Premium { }
class PackageAccount implements Transactable, InterestBearing, Premium {
    private long balance;
    PackageAccount(long balance) { this.balance = balance; }
    public void deposit(long amount) { if (amount > 0) balance += amount; }
    public boolean withdraw(long amount) { if (amount > 0 && amount <= balance) { balance -= amount; return true; } return false; }
    public double interestRate() { return 4.0; }
    long balance() { return balance; }
}
public class MiniBank06 {
    public static void main(String[] args) {
        PackageAccount account = new PackageAccount(1000);
        WithdrawRule anonymous = new WithdrawRule() { public boolean allow(long balance, long amount) { return amount <= balance; } };
        WithdrawRule lambda = (balance, amount) -> amount <= balance;
        System.out.println("Anonymous: " + anonymous.allow(account.balance(), 500));
        System.out.println("Lambda: " + lambda.allow(account.balance(), 500));
        System.out.println("Yearly interest: " + account.yearlyInterest(account.balance()));
    }
}
