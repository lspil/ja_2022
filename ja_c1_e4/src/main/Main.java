package main;

import repositories.CrudRepository;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        CrudRepository c = (CrudRepository) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{CrudRepository.class},
                new CrudRepositoryInvocationHandler()
        );

        c.get();
        c.insert();

        System.out.println(c.getClass());

        CrudRepository c2 = (CrudRepository) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{CrudRepository.class},
                new CrudRepositoryInvocationHandler()
        );

        System.out.println(c2.getClass());
    }
}
