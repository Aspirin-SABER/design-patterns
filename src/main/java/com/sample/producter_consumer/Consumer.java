package com.sample.producter_consumer;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    private Queue<String> msg;
    private int maxsize;
    private Lock lock;
    private Condition condition;

    public Consumer(Queue<String> msg, int maxsize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxsize = maxsize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        {
            int i=0;
            while (true){
                i++;
                lock.lock();
                while (msg.isEmpty()){
                    try {
                        System.out.println("队列为空");
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费的内容是"+msg.remove());
                condition.signal();

                lock.unlock();
            }
        }
    }
}
