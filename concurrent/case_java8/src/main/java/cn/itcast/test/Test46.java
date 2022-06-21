package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test46")
public class Test46 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("123");
        });
        t1.start();
        t1.start();
    }
}
