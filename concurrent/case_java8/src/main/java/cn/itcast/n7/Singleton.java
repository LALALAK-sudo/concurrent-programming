package cn.itcast.n7;



public class Singleton {
    private static volatile Singleton singleton;

    public Singleton() {

    }

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized(Singleton.class) {
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}
