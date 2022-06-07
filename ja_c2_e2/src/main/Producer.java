package main;

import java.util.Random;

public class Producer extends Thread {

    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random r = new Random();


        while (true) {
            try {
                Main.s.acquire();
                if (Main.list.size() < 100) {
                    int x = r.nextInt();
                    Main.list.add(x);
                    System.out.println("Producer " + Thread.currentThread().getName() + " added value " + x);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Main.s.release();
            }
        }
    }

    public synchronized void m1a() { // this

    }

    public void m1b() {
        synchronized (this) {
            //
        }
    }


    // =========================================

    public synchronized static void m2a() { // Producer.class

    }

    public static void m2b() { // Producer.class
        synchronized (Producer.class) {

        }
    }
}
