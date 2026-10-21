public class MiniBank02 {
    public static void main(String[] args) {
        Account account = new Account("Riya", 5000);
        account.deposit(2000);
        System.out.println(account.getBalance());
        account.withdraw(3000);
        System.out.println(account.getBalance());
        System.out.println("Successful withdrawal: " + account.withdraw(10000));
        System.out.println(account.getBalance());
        System.out.println(new Customer("Riya", "riya@mail.com", "9876543210").getCustomerId());
    }
}
