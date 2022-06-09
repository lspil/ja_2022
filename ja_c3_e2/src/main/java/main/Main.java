package main;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

  public static void main(String[] args) {
    // [a1,a2,a3.....,an]
    // [a1, a2, a3] + [a4, a5, a6] +...

    List<Integer> list = List.of(1,3,4,5,6,7,8,9,4,6,8,4,5,6,7);
    ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    var res = pool.invoke(new NumbersRecursiveTask(list));
    System.out.println(res);

    // ForkJoinTask  -> RecursiveAction, RecursiveTask<T>
  }
}
