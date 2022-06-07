package main;

public class Consumer extends Thread {

    public Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Main.s.acquire();
                if (!Main.list.isEmpty()) {
                    int x = Main.list.get(0);
                    Main.list.remove(0);
                    System.out.println("Consumer " + Thread.currentThread().getName() + " removed value " + x);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Main.s.release();
            }
        }

    }
}
