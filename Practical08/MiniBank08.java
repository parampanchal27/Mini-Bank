class BankException extends Exception { BankException(String message) { super(message); } }
class InsufficientFundsException extends BankException { final long shortfall; InsufficientFundsException(long shortfall) { super("Short by " + shortfall); this.shortfall = shortfall; } }
class InvalidAmountException extends BankException { InvalidAmountException() { super("Amount must be positive"); } }
class ExceptionAccount {
    long balance;
    ExceptionAccount(long balance) { this.balance = balance; }
    void deposit(long amount) throws InvalidAmountException { if (amount <= 0) throw new InvalidAmountException(); balance += amount; }
    void withdraw(long amount) throws BankException { if (amount <= 0) throw new InvalidAmountException(); if (amount > balance) throw new InsufficientFundsException(amount - balance); balance -= amount; }
}
public class MiniBank08 {
    public static void main(String[] args) {
        ExceptionAccount account = new ExceptionAccount(1000);
        try { account.withdraw(5000); }
        catch (InsufficientFundsException exception) { System.out.println("Withdrawal failed: " + exception.getMessage()); }
        catch (BankException exception) { System.out.println(exception.getMessage()); }
        finally { System.out.println("Balance: " + account.balance); }
        try (AutoCloseable resource = () -> System.out.println("Resource closed")) { System.out.println("Resource used"); }
        catch (Exception exception) { System.out.println(exception.getMessage()); }
    }
}
