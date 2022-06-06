package main;

import java.util.Random;

public class Producer extends Thread {

    public Producer(String nume) {
        super(nume);
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            synchronized (Main.list) {
                if (Main.list.size() < 100) {
                    int n = r.nextInt();
                    Main.list.add(n);
                    System.out.println("Firul " + Thread.currentThread().getName() + " a adaugat valoarea " + n);
                }
            }
        }
    }
}
