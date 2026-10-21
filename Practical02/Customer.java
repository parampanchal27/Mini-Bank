public class Customer {
    private static long customerCounter = 101;
    private final String customerId;
    private final String name;
    private final String email;
    private final String mobile;

    public Customer(String name, String email, String mobile) {
        this.customerId = "CUST" + customerCounter++;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
}
