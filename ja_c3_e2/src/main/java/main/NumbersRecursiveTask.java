package main;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class NumbersRecursiveTask extends RecursiveTask<Integer> {

  private final List<Integer> input;

  public NumbersRecursiveTask(List<Integer> input) {
    this.input = input;
  }

  @Override
  protected Integer compute() {
    if (input.size() <= 3) {
      return input.stream().mapToInt(x -> x).sum();
    }

    int mid = input.size() / 2;
    List<Integer> list1 = input.subList(0, mid);
    List<Integer> list2 = input.subList(mid, input.size());

    NumbersRecursiveTask t1 = new NumbersRecursiveTask(list1);
    t1.fork(); // creeaza firul de executie
    NumbersRecursiveTask t2 = new NumbersRecursiveTask(list2);
//    t2.fork(); // creeaza firul de executie

    return t1.join() + t2.compute();
  }
}
