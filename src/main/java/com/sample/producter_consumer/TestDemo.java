package com.sample.producter_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        int maxsize = 5;
        Queue<String> queue  = new LinkedList<>();
        Thread threadA = new Thread(new Producter(queue,maxsize,lock,condition));
        Thread threadB =  new Thread(new Consumer(queue,maxsize,lock,condition));
        threadA.start();
        threadB.start();

    }
}
