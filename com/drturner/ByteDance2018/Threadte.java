package com.drturner.ByteDance2018;

import java.util.concurrent.TimeUnit;

class PrintTask{
    private int number=1;
    private boolean flag=true;
    public synchronized void printNumber() throws InterruptedException {
        while (!flag){
            Thread.yield();
            TimeUnit.MILLISECONDS.sleep(200);
        }
        for (int i=1;i<number;i++){
            System.out.print(i);
            System.out.print(i+1);
            flag=!flag;
            this.wait();
        }
    }
    public synchronized void printAlphabet() throws InterruptedException {
        while (flag){
            Thread.yield();
            TimeUnit.MILLISECONDS.sleep(200);
        }
        for (int i=1;i<number/2;i++){
            char c= (char) ('A'+(i-1));
            System.out.print(c);
            flag=!flag;
            this.wait();
        }
    }
}

public class Threadte {

    public static void main(String[] args) {
        PrintTask task=new PrintTask();
        Thread t1=new Thread(()->{
            try {
                task.printAlphabet();
            } catch (InterruptedException e) {

            }
        });
        Thread t2=new Thread(()->{
            try {
                task.printNumber();
            } catch (InterruptedException e) {

            }
        });
        t1.start();;
        t2.start();
    }
}
