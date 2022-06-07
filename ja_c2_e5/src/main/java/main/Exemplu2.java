package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exemplu2 {

    public static void main(String[] args) {
        // avand o lista de String, afisam toate sirurile de lungime para
        List<String> list1 = List.of("AB", "AAA", "BBB", "ABCD", "V"); // AB, ABCD

        list1.stream()
             .filter(s -> s.length() % 2 == 0)
             .forEach(s -> System.out.println(s));   //  s -> System.out.println(s)  ==> System.out::println

        // ==================================================
        List<String> res1 = new ArrayList<>();
        list1.stream()
                .filter(s -> s.length() % 2 == 0)
                .forEach(s -> res1.add(s));    // GRESIT! NERECOMANDAT!

        List<String> res2 = list1.stream()
                .filter(s -> s.length() % 2 == 0)
                .collect(Collectors.toList());  // CORECT!

        // ==================================================

        List<String> list2 = List.of("AB", "AAA", "BBB", "ABCD", "V");
        // {2 => ["AB"], 3 => ["AAA", "BBB"], 4 => ["ABCD"], 1 => ["V"]}

        Map<Integer, List<String>> res3 =
                list2.stream()
                        .collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(res3);

        // ===================================================

        List<String> list3 = List.of("AB", "AAA", "BBB", "ABCD", "V");
        // {2 => ["AB"], 3 => ["AAA", "BBB"], 4 => ["ABCD"], 1 => ["V"]}

        Map<Integer, String> res4 =
                list3.stream()
                        .collect(Collectors.groupingBy(s -> s.length(),
                                        Collectors.joining()));

        System.out.println(res4);

        // ===================================================

        List<String> list4 = List.of("AB", "AAA", "BBB", "ABCD", "V");
        // {2 => ["AB"], 3 => ["AAA", "BBB"], 4 => ["ABCD"], 1 => ["V"]}

        Map<Integer, Long> res5 =
                list4.stream()
                        .collect(Collectors.groupingBy(s -> s.length(),
                                Collectors.counting()));

        System.out.println(res5);
    }


}
