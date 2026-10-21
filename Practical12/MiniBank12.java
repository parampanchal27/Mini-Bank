import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MiniBank12 {
    static class Account implements Comparable<Account> {
        final String number; final long balance;
        Account(String number, long balance) { this.number = number; this.balance = balance; }
        public int compareTo(Account other) { return number.compareTo(other.number); }
        public String toString() { return number + "=" + balance; }
    }
    static class AccountStore {
        private final ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
        private final ArrayList<String> history = new ArrayList<>();
        void add(Account account) { accounts.put(account.number, account); }
        Account get(String number) { return accounts.get(number); }
        ArrayList<Account> sortedByBalance() { ArrayList<Account> result = new ArrayList<>(accounts.values()); result.sort(Comparator.comparingLong(a -> -a.balance)); return result; }
        void addHistory(String item) { history.add(item); }
    }
    public static void main(String[] args) { AccountStore store = new AccountStore(); store.add(new Account("AC0001", 5000)); store.add(new Account("AC0002", 2000)); store.add(new Account("AC0003", 9000)); store.addHistory("DEPOSIT AC0001 500"); System.out.println(store.get("AC0002")); System.out.println(store.sortedByBalance()); }
}
