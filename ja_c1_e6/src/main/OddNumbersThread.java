package main;

public class OddNumbersThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i+=2) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
