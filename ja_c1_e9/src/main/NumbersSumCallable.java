package main;

import java.util.List;
import java.util.concurrent.Callable;

public class NumbersSumCallable implements Callable<Integer> {

    private final List<Integer> numbers;

    public NumbersSumCallable(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (Integer x : numbers) {
            sum += x;
        }
        return sum;
    }
}
