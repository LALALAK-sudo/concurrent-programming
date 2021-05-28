package cn.itcast.n4;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j(topic = "c.ExerciseTransfer")
public class ExerciseTransfer {
    public static void main(String[] args) throws InterruptedException {
        TicketWindow ticketWindow = new TicketWindow(800);
        // 所有线程集合
        List<Thread> threadList = new ArrayList<>();
        List<Integer> amountList = new ArrayList<>();
        Object object = new Object();
        for (int i = 0; i < 200; i++) {
            Thread thread = new Thread(() -> {
                int amount = ticketWindow.sell(randomAmount());
                synchronized (object) {
                    amountList.add(amount);
                }
            });
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        for (Integer integer : amountList) {
            log.debug("{}", integer);
        }

        log.debug("余票{}",ticketWindow.getCount());
        log.debug("卖出{}",amountList.stream().mapToInt(i->i).sum());
    }

    // Random 为线程安全
    static Random random = new Random();

    public static int randomAmount() {
        return random.nextInt(5)+1;
    }
}

//售票窗口
class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    // 售票
    public synchronized int sell(int amount) {
        if(this.count >= amount) {
            this.count -= amount;
            return amount;
        }else {
            return 0;
        }
    }
}