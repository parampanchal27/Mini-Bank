public class MiniBank03 {
    public static void main(String[] args) {
        Account first = new Account("AC0001", "Riya", 4000);
        Account second = new Account("AC0001", "Riya", 4000);
        Customer customer = new Customer("Riya", new Customer.Address("1 Main Road", "Pune", "411001"));
        System.out.println(first);
        System.out.println("Equal: " + first.equals(second));
        System.out.println("Account object: " + (first instanceof Account));
        System.out.println(customer.getAddress().getCity());
    }
}
