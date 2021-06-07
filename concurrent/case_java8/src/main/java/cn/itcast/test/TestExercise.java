package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestExercise")
public class TestExercise {
    private static int flag;
    private static int loopNumber;

    public static void main(String[] args) {
        flag = 0;
        Object lock = new Object();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while(flag != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    log.debug("a");
                    flag = 1;
                    lock.notifyAll();
                }
            }
        }, "t1");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while(flag != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    log.debug("b");
                    flag = 2;
                    lock.notifyAll();
                }
            }
        }, "t2");
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    while(flag != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    log.debug("c");
                    flag = 0;
                    lock.notifyAll();
                }
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
