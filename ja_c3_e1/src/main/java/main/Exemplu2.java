package main;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exemplu2 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    CompletableFuture.runAsync(() -> {   // task pe fir separat de executie care nu returneaza o valoare
      System.out.println(":)");
    }).get();

    var res = CompletableFuture.supplyAsync(() -> {  // task pe fir separat de executie care returneaza o valoare
      return 10;
    }).thenApply(s -> s * 2).get();
  }
}
