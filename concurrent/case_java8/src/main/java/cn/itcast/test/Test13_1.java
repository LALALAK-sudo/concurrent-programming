package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test3_1")
public class Test13_1 {
    public static void main(String[] args) throws InterruptedException {
        TwoStop twoStop = new TwoStop();
        twoStop.start();
//        twoStop.start();
        Thread.sleep(599);
        twoStop.stop();
    }
}
@Slf4j(topic = "c.TwoStop")
class TwoStop{
    private Thread monitor;

    public void start() {
        monitor = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    log.debug("我在干活");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        },"t1");
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}