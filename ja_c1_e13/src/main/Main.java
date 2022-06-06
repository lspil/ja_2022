package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String [] args) {
        Producer p1 = new Producer("P1");
        Consumer c1 = new Consumer("C1");

        p1.start();
        c1.start();
    }
}
