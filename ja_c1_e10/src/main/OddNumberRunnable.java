package main;

public class OddNumberRunnable implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i += 2) {
                System.out.println(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
