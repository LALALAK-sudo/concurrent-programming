package cn.itcast.proxy;

// 目标类
public class TargetJDK implements TargetInterface{
    @Override
    public void method() {
        System.out.println("targetJDK running...");
    }
}
