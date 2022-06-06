package main;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> f = executor.submit(new NumbersSumCallable(List.of(2,3,4,5)));   // 14

        // orice alteceva vrem noi

        try {
            Integer sum = f.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable []  t = e.getSuppressed();
        }
        executor.shutdown();
    }
}
