package main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CrudRepositoryInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("get")) {
            System.out.println(":))");
        } else {
            System.out.println(":((");
        }
        return null;
    }
}
