package main;

import java.util.concurrent.CompletableFuture;

public class ReverseStringThread extends Thread {

  private final CompletableFuture<String> future;
  private final String input;

  public ReverseStringThread(String input, CompletableFuture<String> future) {
    this.future = future;
    this.input = input;
  }

  public void run() {
    String reversed = new StringBuilder(input).reverse().toString();

    future.complete(reversed);
  }
}
