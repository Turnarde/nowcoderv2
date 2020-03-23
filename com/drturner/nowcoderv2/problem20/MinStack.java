package com.drturner.nowcoderv2.problem20;

import java.util.Stack;

public class MinStack {
    Stack<Integer> data=new Stack<>();
    Stack<Integer> min=new Stack<>();
    public void push(int node) {
        data.push(node);
        if (!min.isEmpty()){
            if (min.peek()>node){
                min.push(node);
            }
            else{
                min.push(min.peek());
            }
        }
        else {
            min.push(node);
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.min());

    }
}
