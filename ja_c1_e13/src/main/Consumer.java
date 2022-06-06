package main;

public class Consumer extends Thread {

    public Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Main.list) {
                if (!Main.list.isEmpty()) {
                    int n = Main.list.get(0);
                    Main.list.remove(0);
                    System.out.println("Firul " + Thread.currentThread().getName() + " a consumat valoarea " + n);
                }
            }
        }
    }
}
