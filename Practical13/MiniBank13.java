import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

public class MiniBank13 {
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface Id { }
    static class Account { @Id final String number; final long balance; Account(String number, long balance) { this.number = number; this.balance = balance; } public String toString() { return number + "=" + balance; } }
    static class Repository<T> {
        private final Map<String, T> values = new HashMap<>();
        T save(T entity) { values.put(id(entity), entity); return entity; }
        @SafeVarargs final void saveAll(T... entities) { for (T entity : entities) save(entity); }
        T findById(String id) { return values.get(id); }
        ArrayList<T> findAll() { return new ArrayList<>(values.values()); }
        private String id(T entity) { try { for (Field field : entity.getClass().getDeclaredFields()) if (field.isAnnotationPresent(Id.class)) { field.setAccessible(true); return String.valueOf(field.get(entity)); } } catch (ReflectiveOperationException e) { throw new IllegalStateException(e); } throw new IllegalArgumentException("Missing @Id"); }
    }
    static <N extends Number> double average(N[] values) { double total = 0; for (N value : values) total += value.doubleValue(); return total / values.length; }
    public static void main(String[] args) { Repository<Account> repository = new Repository<>(); repository.saveAll(new Account("AC0001", 5000), new Account("AC0002", 2000)); System.out.println(repository.findById("AC0001")); System.out.println(repository.findAll()); System.out.println(average(new Integer[]{2, 4, 6})); }
}
