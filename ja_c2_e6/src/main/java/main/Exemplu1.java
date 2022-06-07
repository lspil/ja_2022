package main;

import java.util.List;
import java.util.stream.Collectors;

public class Exemplu1 {

    public static void main(String[] args) {

    }

    public long m1(List<Ticket> tickets, String destination) {
        return tickets.stream()
                .filter(t -> t.getDestination().equals(destination))
                .count();
    }

    public void m2(List<Ticket> tickets, String email) {
        tickets.stream().filter(t -> t.getClient().getEmail().equalsIgnoreCase(email))
                .forEach(System.out::println);
    }

    public boolean m3(List<Ticket> tickets, String email) {
        return tickets.stream()
                .anyMatch(t -> t.getClient().getEmail().equalsIgnoreCase(email));
    }

    public double m4_1(List<Ticket> tickets) {
        return tickets.stream()
                .mapToDouble(t -> t.getPrice())
                .average()
                .orElse(0);
    }

    public double m4_2(List<Ticket> tickets) {
        return tickets.stream()
                .collect(Collectors.averagingDouble(t -> t.getPrice()));
    }

    public long m5(List<Ticket> tickets, String origin) {
        return tickets.stream()
                .filter(t -> t.getOrigin().equalsIgnoreCase(origin))
                .count();
    }

    public boolean m6(List<Ticket> tickets) {
        return tickets.stream()
                .allMatch(t -> t.getClient().getEmail() != null);
    }
}
