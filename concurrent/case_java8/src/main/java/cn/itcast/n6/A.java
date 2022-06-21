package cn.itcast.n6;

public class A {
    private static int i;
    static {
        i = 1;
        System.out.println("static: i =" + i);
    }
    public A () {
        i++;
        System.out.println("构造 i =" + i);
    }
}
