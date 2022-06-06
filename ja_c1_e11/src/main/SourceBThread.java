package main;

public class SourceBThread extends Thread {

    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Source A data collected.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
