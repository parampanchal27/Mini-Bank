import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface Id { }
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD) @interface Positive { String message() default "must be > 0"; }
class AnnotatedAccount {
    @Id private final String number = "AC0001";
    @Positive private final long balance;
    AnnotatedAccount(long balance) { this.balance = balance; }
}
public class MiniBank07 {
    static String[] validate(Object object) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Positive.class) && field.getLong(object) <= 0) errors.add(field.getName() + ": must be > 0");
        }
        return errors.toArray(String[]::new);
    }
    public static void main(String[] args) throws Exception { System.out.println(Arrays.toString(validate(new AnnotatedAccount(-100)))); }
}
