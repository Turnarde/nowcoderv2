package com.drturner.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplStack {
    Queue<Integer> queue1=new LinkedList();
    Queue<Integer> queue2=new LinkedList();
    public void push(Integer e){
        queue1.offer(e);
    }
    public boolean isEmpty(){
        return queue1.isEmpty();
    }
    public Integer pop() {
        if (queue1.isEmpty()) throw new ArrayIndexOutOfBoundsException("栈空");
        while (queue1.size()>1){
            queue2.offer(queue1.poll());
        }
        int res=queue1.poll();
        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        QueueImplStack stack=new QueueImplStack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
