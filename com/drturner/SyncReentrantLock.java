package com.drturner;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RunTask implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Come in Run");
    }
}

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"Come in call");
        return 111;
    }
}
class PrintTask{
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private Integer number=1;
    public synchronized void print5() throws InterruptedException {

        while (number!=1){
            this.wait();
        }
        for (int i=0;i<5;i++){
            System.out.println("print5----"+i);
        }
        number=2;
        this.notifyAll();
    }
    public synchronized void print10() throws InterruptedException {

        while (number!=2){
            this.wait();
        }
        for (int i=0;i<10;i++){
            System.out.println("print10----"+i);
        }
        number=3;
        this.notifyAll();
    }
    public synchronized void print15() throws InterruptedException {

        while (number!=3){
            this.wait();
        }
        for (int i=0;i<15;i++){
            System.out.println("print15----"+i);
        }
        number=1;
        this.notifyAll();
    }
}
public class SyncReentrantLock {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 8,
                200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i=0;i<16;i++){
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"===");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}
