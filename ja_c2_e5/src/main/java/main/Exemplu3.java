package main;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class Exemplu3 {

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,4,6,7,8,3,4,5,6);

        int sum1 = list1.stream()
                .distinct()
                .reduce(0, (a,b) -> a + b);

        Optional<Integer> sum2 = list1.stream()
                .distinct()
                .reduce(Integer::sum);


        int sum3 = list1.stream()
                .distinct()
                .mapToInt(x -> x)
                .sum();
    }
}
