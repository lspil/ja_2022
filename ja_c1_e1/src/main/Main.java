package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        Class klassCat = Class.forName("beans.Cat");
        Constructor c = klassCat.getDeclaredConstructor();
        c.setAccessible(true);
        Object o = c.newInstance();

        Field fieldName = klassCat.getDeclaredField("name");
        fieldName.setAccessible(true);
        fieldName.set(o, "Tom");

        Method m = klassCat.getDeclaredMethod("sayMeow");
        m.setAccessible(true);
        m.invoke(o);

        System.out.println(o.getClass());
    }
}
