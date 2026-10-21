public class MiniBank09 {
    static class Account {
        private long balance;
        synchronized void deposit(long amount) { balance += amount; }
        synchronized long balance() { return balance; }
    }
    static class AccountWorker implements Runnable {
        private final Account account; private final int times; private final long amount;
        AccountWorker(Account account, int times, long amount) { this.account = account; this.times = times; this.amount = amount; }
        public void run() { for (int i = 0; i < times; i++) account.deposit(amount); }
    }
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(); Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) { threads[i] = new Thread(new AccountWorker(account, 1000, 1), "Worker-" + i); threads[i].start(); }
        for (Thread thread : threads) thread.join();
        System.out.println("Final balance: " + account.balance());
    }
}
