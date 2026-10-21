import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MiniBank11 {
    static class Account implements Serializable {
        private static final long serialVersionUID = 1L;
        final String number; long balance; transient String sessionToken;
        Account(String number, long balance) { this.number = number; this.balance = balance; this.sessionToken = "temporary"; }
        public String toString() { return number + "=" + balance + ", token=" + sessionToken; }
    }
    public static void main(String[] args) throws Exception {
        Path file = Files.createTempFile("accounts", ".dat");
        Account[] accounts = { new Account("AC0001", 5000), new Account("AC0002", 2000) };
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(file))) { output.writeObject(accounts); }
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(file))) { System.out.println(Arrays.toString((Account[]) input.readObject())); }
        Path log = Files.createTempFile("transactions", ".log");
        Files.writeString(log, "DEPOSIT AC0001 500\nWITHDRAW AC0002 200\n");
        System.out.println("Log lines: " + Files.readAllLines(log).size());
        Files.deleteIfExists(file); Files.deleteIfExists(log);
    }
}
