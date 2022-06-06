package main;

public class Main {

    public static void main(String[] args) {
        SourceAThread a = new SourceAThread();
        SourceBThread b = new SourceBThread();

        a.start();
        b.start();

        try {
            a.join();
            b.join();

            System.out.println("PROCESSING");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
