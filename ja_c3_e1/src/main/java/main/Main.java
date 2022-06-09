package main;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

  public static void main(String[] args) {
    CompletableFuture<String> future = new CompletableFuture<>();
    ReverseStringThread t1 = new ReverseStringThread("Hello", future);
    t1.start();

    try {
      int x = future
                .thenApply(s -> s.length())
                .get();

      System.out.println(x);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }


}
