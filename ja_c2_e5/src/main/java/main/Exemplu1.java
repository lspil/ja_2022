package main;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Exemplu1 {

    public static void main(String[] args) {
        // Sursa, operatii intermediare (0), operatie terminala

        List<String> list1 = List.of("ABC", "DE", "QWERTY");
        long r1 = list1.stream().count();

        long r2 = Stream.of("ABC", "DE", "QWERTY").count();
        Stream.empty();  // preferam sa returnam un stream gol decat sa returnam null.
        Stream.generate(() -> new Random().nextInt())
                .limit(10)
                .forEach(System.out::println);

        // Optional  -> o folosim pentru a marca o valoare optionala

        Optional<String> o1 = Optional.of("HELLO");

        if(o1.isPresent()) {  // procedurala
            String string = o1.get(); // != null
        }

        o1.ifPresent(v -> System.out.println(v));
        o1.ifPresentOrElse(v -> System.out.println(v),
                () -> {});

        String s1 = o1.map(v -> "OLLEH")
                        .orElse(":))");  // nu returnam null

        String s2 = o1.map(v -> "OLLEH")
                .orElseThrow();

    }

    public String m1() {
        return null;
    }

    public Optional<String> m2() {
        return Optional.empty();
    }
}
