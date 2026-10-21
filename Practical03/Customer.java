public class Customer implements Cloneable {
    private final String name;
    private final Address address;
    public Customer(String name, Address address) { this.name = name; this.address = address; }
    public Address getAddress() { return address; }
    @Override public Customer clone() {
        try { return (Customer) super.clone(); }
        catch (CloneNotSupportedException exception) { throw new AssertionError(exception); }
    }
    public static class Address {
        private final String line, city, pincode;
        public Address(String line, String city, String pincode) { this.line = line; this.city = city; this.pincode = pincode; }
        public String getLine() { return line; }
        public String getCity() { return city; }
        public String getPincode() { return pincode; }
    }
}
