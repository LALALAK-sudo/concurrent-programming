package cn.itcast.CreateThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.ExtendThread")
public class ExtendThread{
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> log.debug("runing"),"t1");
        t1.start();
        log.debug("runing");
    }
}



