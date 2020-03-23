package com.drturner.nowcoderv2.problem5;

import java.util.Stack;

public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int res;
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        res=stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue=new TwoStackQueue();
        twoStackQueue.push(1);
        twoStackQueue.push(2);
        System.out.println(twoStackQueue.pop());
    }
}
