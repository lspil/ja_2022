package main;

import beans.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        while (true) {
           productList.add(new Product(r.nextInt()));
           Thread.sleep(100);
        }
    }
}
