package com.sample.producter_consumer;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producter implements Runnable {

    private Queue<String> msg;
    private int maxsize;
    private Lock lock;
    private Condition condition;

    public Producter(Queue<String> msg, int maxsize, Lock lock, Condition condition) {
        this.msg = msg;
        this.maxsize = maxsize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            i++;
            lock.lock();
            while (msg.size()==maxsize){
                try {
                    System.out.println("队列已满");
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
            System.out.println("生产消息："+i);
            msg.add("生产的消息内容是："+i);
            condition.signal();
            lock.unlock();
        }
    }
}
