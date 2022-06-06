package main;

import annotations.Aleator;
import beans.Numar;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

        Class klassNumar = Class.forName("beans.Numar");
        Constructor c = klassNumar.getDeclaredConstructor();
        Numar  o = (Numar) c.newInstance();

        Field [] fields = klassNumar.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(Aleator.class)) {
                f.set(o, new Random().nextInt());
            }
        }

        System.out.println(o.getX());
        System.out.println(o.getY());
    }
}
