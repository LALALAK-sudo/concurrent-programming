package cn.itcast.CreateThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.ImplRunnable")
public class ImplRunnable {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Thread t1 = new Thread(threadTest, "t1");
        Thread t2 = new Thread(threadTest, "t2");
        new Thread(()->{
            log.debug("hello");
        },"t3").start();
        t1.start();
        t2.start();
        log.debug("running");
    }
}
@Slf4j(topic = "c.ThreadTest")
class ThreadTest implements Runnable{

    @Override
    public void run() {
        log.debug("running");
    }
}