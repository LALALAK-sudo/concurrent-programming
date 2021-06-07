package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.Test45")
public class Test45 {
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    static ReentrantLock ROOM = new ReentrantLock();
    // 等抽烟的休息室
    static Condition waitCigarette = ROOM.newCondition();
    // 等外卖的休息室
    static Condition waitTakeout = ROOM.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            ROOM.lock();
            try {
                while(!hasCigarette) {
                    log.debug("没有香烟，不干活");
                    try {
                        waitCigarette.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("有香烟了，fight！");
            }finally {
                ROOM.unlock();
            }
        }, "老烟枪").start();

        new Thread(()-> {
            ROOM.lock();
            try{
                while(!hasTakeout) {
                    try {
                        log.debug("食堂等饭...");
                        waitTakeout.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("干饭，fight");
            }finally {
                ROOM.unlock();
            }
        }, "饿死鬼").start();

        Thread.sleep(1000);

        new Thread(()->{
            ROOM.lock();
            try {
                hasCigarette = true;
                waitCigarette.signal();
            }finally {
                ROOM.unlock();
            }
        }, "送香烟").start();

        new Thread(()->{
            ROOM.lock();
            try {
                hasTakeout = true;
                waitTakeout.signal();
            }finally {
                ROOM.unlock();
            }
        }, "送外卖").start();
    }
}
