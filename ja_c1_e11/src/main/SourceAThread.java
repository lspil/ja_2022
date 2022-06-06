package main;

public class SourceAThread extends Thread {

    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("Source A data collected.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
