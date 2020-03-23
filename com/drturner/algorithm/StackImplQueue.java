package com.drturner.algorithm;

import java.util.Stack;

public class StackImplQueue {
    private static Stack<Integer> data=new Stack<>();
    private static Stack<Integer> help=new Stack<>();
    public void push(Integer e){
        data.push(e);
    }
    public boolean isEmpty(){
        return data.isEmpty()&&help.isEmpty();
    }
    public Integer pop(){
        if (!help.isEmpty()){
            return help.pop();
        }

        while (!data.isEmpty()){
            help.push(data.pop());
        }
        return help.pop();
  //      int res=data.pop();
  //      while (!help.isEmpty()){
  //          data.push(help.pop());
  //      }
    //    Stack<Integer> tmp=help;
    //    help=data;
    //    data=tmp;
       // return res;
    }
    public static void main(String[] args) {
        StackImplQueue stack=new StackImplQueue();
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
