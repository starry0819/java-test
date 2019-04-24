package com.zhanghuanfa.juc;

/**
 * @author zhanghuanfa 2019-04-24 19:14
 */
public class ProducerAndConsumerBaseSyn {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer, "生产者1").start();
        new Thread(consumer, "消费者1").start();
    }

}

class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 20) {
            clerk.purchase();
            count++;
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 20) {
            clerk.sell();
            count++;
        }
    }
}

class Clerk {

    private int productCount;

    public synchronized void purchase() {
        while (productCount >= 5) {
            System.out.println("产品已足够了");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "生产一个产品, 还剩: " + ++productCount);
        this.notifyAll();
    }

    public synchronized void sell() {
        while (productCount <= 0) {
            System.out.println("产品没货了");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "卖出一个产品, 还剩: " + --productCount);
        this.notifyAll();
    }
}
