package cn.itcast.n6;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Number")
public class Number {
    public static void main(String[] args) {
        NumberTest n1 = new NumberTest();
        new Thread(()->{n1.a();}).start();
        new Thread(()->{n1.b();}).start();
    }
}
@Slf4j(topic = "c.NumberTest")
class NumberTest{
    public synchronized static void a() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public synchronized static void b() {
        log.debug("b");
    }
}
