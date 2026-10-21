import java.util.*;
import java.util.concurrent.*;

public class MiniBank10 {
    static class Buffer {
        private final Queue<String> queue = new ArrayDeque<>();
        synchronized void put(String value) throws InterruptedException { while (queue.size() == 3) wait(); queue.add(value); notifyAll(); }
        synchronized String take() throws InterruptedException { while (queue.isEmpty()) wait(); String value = queue.remove(); notifyAll(); return value; }
    }
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 1; i <= 10; i++) { int id = i; pool.submit(() -> System.out.println("Transaction " + id + " on " + Thread.currentThread().getName())); }
        pool.shutdown(); pool.awaitTermination(5, TimeUnit.SECONDS);
        Buffer buffer = new Buffer();
        Thread producer = new Thread(() -> { try { for (int i = 1; i <= 5; i++) buffer.put("T" + i); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread consumer = new Thread(() -> { try { for (int i = 1; i <= 5; i++) System.out.println("Processed " + buffer.take()); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        producer.start(); consumer.start(); producer.join(); consumer.join();
    }
}
