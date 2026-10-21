import java.util.Objects;

public class Account {
    private final String accountNumber;
    private final String ownerName;
    private final long balance;
    public Account(String accountNumber, String ownerName, long balance) {
        this.accountNumber = accountNumber; this.ownerName = ownerName; this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    @Override public String toString() { return accountNumber + " | " + ownerName + " | " + balance; }
    @Override public boolean equals(Object object) {
        return object instanceof Account other && accountNumber.equals(other.accountNumber);
    }
    @Override public int hashCode() { return Objects.hash(accountNumber); }
}
