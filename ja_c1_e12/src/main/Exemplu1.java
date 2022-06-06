package main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exemplu1 {

    public static void main(String[] args) throws IOException {
        FileReaderRunnable r1 = new FileReaderRunnable("A.txt");
        FileReaderRunnable r2 = new FileReaderRunnable("B.txt");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            Map<String, Integer> res1 = r1.getResult();
            Map<String, Integer> res2 = r2.getResult();

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
        }
    }
}
