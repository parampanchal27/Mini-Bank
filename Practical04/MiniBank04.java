public class MiniBank04 {
    enum TransactionType { DEPOSIT, WITHDRAW, TRANSFER }
    record Command(TransactionType type, String accountNumber, long amount) {}
    static Command parse(String line) {
        String[] parts = line.split("\\s+");
        if (parts.length != 3) throw new IllegalArgumentException("Expected three parts");
        return new Command(TransactionType.valueOf(parts[0]), parts[1], Long.parseLong(parts[2]));
    }
    public static void main(String[] args) {
        System.out.println(Validator.isValidMobile("9876543210"));
        System.out.println(Validator.isValidMobile("12345"));
        System.out.println(parse("DEPOSIT AC0001 500"));
    }
}
