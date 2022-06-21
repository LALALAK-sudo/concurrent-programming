package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

public class TwoPhaseTest {
    public static void main(String[] args) {
        TwoPhase twoPhase = new TwoPhase();
        twoPhase.start();
        twoPhase.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        twoPhase.stop();


    }
}

@Slf4j(topic = "c.TwoPhase")
class TwoPhase{
    private volatile boolean stop = false;
    private Thread monitorThread;
    private boolean strating = false;

    public void start() {
        synchronized (this) {
            if(strating) {
                return;
            }
            strating = true;
        }
        monitorThread = new Thread(()->{
            while (true) {
                Thread current = Thread.currentThread();
                // 是否被打断
                if(stop) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("执行监控记录");
                } catch (InterruptedException e) {

                }
            }
        });
        monitorThread.start();
    }

    public void stop() {
        strating = false;
        stop = true;
        monitorThread.interrupt();
    }
}
