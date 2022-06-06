package main;

public class Main {

    public static void main(String[] args) {
        Runnable r = new OddNumberRunnable(); // face firul de executie

        Thread t1 = new Thread(r); // mecanismul de fir de executie
        t1.start();
    }
}
