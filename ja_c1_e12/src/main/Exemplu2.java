package main;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exemplu2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Map<String, Integer>> f1 = executor.submit(new FileReaderCallable("A.txt"));
        Future<Map<String, Integer>> f2 = executor.submit(new FileReaderCallable("B.txt"));

        try {
            var res1 = f1.get();
            var res2 = f2.get();

            Set<String> keys = new HashSet<>();
            keys.addAll(res1.keySet());
            keys.addAll(res2.keySet());

            for (String k: keys) {
                int x = res1.get(k) != null ? res1.get(k) : 0;
                int y = res2.get(k) != null ? res2.get(k) : 0;
                System.out.println(k + " " + (x + y));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
