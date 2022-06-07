package main;

public class Consumer extends Thread {

    public Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.m) {
                    if (!Main.list.isEmpty()) {
                        int x = Main.list.get(0);
                        Main.list.remove(0);
                        System.out.println("Consumer " + Thread.currentThread().getName() + " removed value " + x);
                        Main.m.notifyAll();
                    } else {
                        Main.m.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
