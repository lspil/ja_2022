package beans;

public class Cat {

    private String name;

    private Cat() {
    }

    private void sayMeow() {
        System.out.println("Meow! " + name);
    }
}
