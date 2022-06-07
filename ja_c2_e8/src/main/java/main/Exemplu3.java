package main;

public class Exemplu3 {

    public static void main(String[] args) {
        int x = 10;

        switch (x) {
            case 1:
            case 3:
                System.out.println("A");
                break;
            case 10:
                System.out.println("B");
                break;
            default:
                System.out.println("C");
        }


        switch (x) {
            case 1,3:
                System.out.println("A");
                break;
        }

        int y1 = switch (x) {
            case 1,3 -> 100;
            case 100 -> 200;
            default -> 300;
        };

        int y2 = switch (x) {
            case 1,3 -> 100;
            case 100 -> 200;
            default -> throw new RuntimeException();
        };

        switch (x) {
            case 1,3 -> m1();
            case 100 -> m2();
        }
    }

    public static void m1() {

    }

    public static void m2() {

    }
}
