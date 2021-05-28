package cn.itcast.n6;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestExercise")
public class TestExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("洗水壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("烧开水");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(()->{
            log.debug("洗茶壶，拿茶叶");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t1.join();
                log.debug("泡茶");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");


        t1.start();
        t2.start();
//        t1.join();
//        t2.join();

    }

}
