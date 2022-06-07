package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static List<Integer> list = new ArrayList<>();
    public static Semaphore s = new Semaphore(1);

    public static void main(String[] args) {
        new Producer("_P1").start();
        new Producer("_P2").start();
        new Consumer("_C1").start();
        new Consumer("_C2").start();
    }
}
