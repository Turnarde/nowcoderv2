package com.drturner.nowcoderv2.problem21;

import java.util.Stack;

public class PopPreOrder {
    //1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int count=0;
        int i=0;
        for (;i<popA.length;i++){
            if (!stack.isEmpty()&&popA[i]==stack.peek()){
                stack.pop();
                continue;
            }
            while (count<pushA.length&&pushA[count]!=popA[i]){
                stack.push(pushA[count++]);
            }
            count++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        PopPreOrder popPreOrder = new PopPreOrder();
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,1,2};
        boolean b = popPreOrder.IsPopOrder(pushA, popA);
        System.out.println(b);
    }
}
