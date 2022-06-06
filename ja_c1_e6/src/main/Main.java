package main;

public class Main {

    public static void main(String[] args) {
        OddNumbersThread t1 = new OddNumbersThread();
        OddNumbersThread t2 = new OddNumbersThread();

        t1.start();
        System.out.println(Thread.currentThread().getName() + " " + "END");
    }
}
