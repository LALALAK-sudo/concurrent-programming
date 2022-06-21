package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestTargetJDK {
    public static void main(String[] args) {
        TargetJDK targetJDK = new TargetJDK();

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(targetJDK.getClass().getClassLoader(),
                targetJDK.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        System.out.println("前置增强代码...");
                        Object invoke = method.invoke(targetJDK, args);
                        System.out.println("后置增强代码...");
                        return invoke;
                    }
                });

        proxy.method();
    }
}
