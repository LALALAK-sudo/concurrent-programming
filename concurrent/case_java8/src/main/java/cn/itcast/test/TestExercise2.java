package cn.itcast.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestExercise2 {
    private static int flag;

    public static void main(String[] args) {
        ReentrantLock lcok = new ReentrantLock();
        Condition c0 = lcok.newCondition(); // 0
        Condition c1 = lcok.newCondition(); // 1
        Condition c2 = lcok.newCondition(); // 2
        flag = 0;
        new Thread(()->{
            lcok.lock();
            for (int i = 0; i < 5; i++) {
                while (flag != 0) {
                    try {
                        c0.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("a");
                flag = 1;
                c1.signal();
            }
            lcok.unlock();
        }, "t1").start();

        new Thread(()->{
            lcok.lock();
            for (int i = 0; i < 5; i++) {
                while (flag != 1) {
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("b");
                flag = 2;
                c2.signal();
            }
            lcok.unlock();
        }, "t2").start();

        new Thread(()->{
            lcok.lock();
            for (int i = 0; i < 5; i++) {
                while (flag != 2) {
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("c");
                flag = 0;
                c0.signal();
            }
            lcok.unlock();
        }, "t3").start();


    }


}
