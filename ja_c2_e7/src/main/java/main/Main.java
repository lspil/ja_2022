package main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public long m1(List<BankAccount> bankAccountList, String email) {
        return bankAccountList.stream()
                .filter(a -> a.getClient().getEmail().equalsIgnoreCase(email))
                .count();
    }

    public void m2(List<BankAccount> bankAccountList) {
        bankAccountList.stream()
                .map(a -> a.getClient())
                .distinct()
                .forEach(c -> System.out.println(c.getName() + " " + c.getEmail()));
    }

    public void m3(List<BankAccount> bankAccountList) {
//        Comparator<BankAccount> bankAccountComparator = (a1, a2) -> {
//            if (a1.getBalance() < a2.getBalance()) {
//                return -1;
//            }
//
//            if (a2.getBalance() < a1.getBalance()) {
//                return 1;
//            }
//            return 0;
//        };
        bankAccountList.stream()
                .filter(a -> a instanceof SavingsBankAccount)
                //.sorted(bankAccountComparator)
                .sorted(Comparator.comparingDouble(a -> -a.getBalance()))
                .forEach(System.out::println);
    }

    public Map<Client, Long> m4(List<BankAccount> bankAccountList) {
        return bankAccountList.stream()
                .collect(Collectors.groupingBy(a -> a.getClient(),
                        Collectors.counting()));

    }

    public void m5(List<BankAccount> bankAccountList) {
        bankAccountList.stream()
                .map(a -> a.getClient())
                .distinct()
                .sorted(Comparator.comparing(c -> c.getName()))
                .forEach(System.out::println);
    }
}
