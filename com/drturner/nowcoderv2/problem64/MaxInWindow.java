package com.drturner.nowcoderv2.problem64;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxInWindow {
    //{2,3,4,2,6,2,5,1}
    // 2 3 4 4 6 6 6 5
    // 0 1 2 2 4 4 4 6
    public ArrayList<Integer> maxInWindowsNaive(int [] num, int size) {
        ArrayList<Integer> list=new ArrayList<>();
        if (size<=0||size>num.length) return list;
        for (int i=0;i<=num.length-size;i++){
           int max=num[i];
           for (int j=i;j<i+size;j++){
               max=max>num[j]?max:num[j];
           }
           list.add(max);
       }
        return list;
    }
    //Copy from blog
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        /*
        思路：用双端队列实现
        */
        ArrayList<Integer> res=new ArrayList<>();
        if(num==null || num.length<1 || size<=0 || size>num.length)
            return res;
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<num.length;i++){
            if(!queue.isEmpty() && queue.peek()==i-size) //超出范围的去掉
                queue.poll();
            //当前值大于之前的值，之前的不可能是最大值，可以删掉
            while(!queue.isEmpty() && num[i]>=num[queue.getLast()])
                queue.removeLast();
            queue.offer(i);
            if(i>=size-1){ //此时开始是第一个滑动窗口
                res.add(num[queue.peek()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array={2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = new MaxInWindow().maxInWindows(array, 3);
        for (int e:list
             ) {
            System.out.println(e);
        }
    }
}
