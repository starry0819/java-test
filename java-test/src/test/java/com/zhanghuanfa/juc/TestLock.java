package com.zhanghuanfa.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁实现线程安全
 * @author zhanghuanfa 2019-04-24 17:39
 */
public class TestLock {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }

}

class Ticket implements Runnable {

    private int ticketCount = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                Thread.sleep(200);
                if (ticketCount > 0) {
                    System.out.println(Thread.currentThread().getName() + "完成售票, 剩余票数为" + --ticketCount);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}