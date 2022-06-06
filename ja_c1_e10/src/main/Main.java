package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor();

        e.submit(new OddNumberRunnable());

        e.shutdown();
    }
}
