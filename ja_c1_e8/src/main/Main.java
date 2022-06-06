package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService r =
                //Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
                Executors.newCachedThreadPool();

        r.execute(new OddNumberRunnable());
        r.execute(new OddNumberRunnable());
        r.execute(new OddNumberRunnable()); // multe

        r.shutdown();
    }
}
