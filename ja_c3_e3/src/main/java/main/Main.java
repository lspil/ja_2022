package main;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> list = List.of(1,3,4,5,6,7,8,9,4,6,8,4,5,6,7);

    list.parallelStream()
        .peek(x -> System.out.println(Thread.currentThread().getName() + " " + x))
        .forEach(System.out::println);
  }
}
