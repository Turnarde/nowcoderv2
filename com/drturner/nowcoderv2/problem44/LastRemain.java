package com.drturner.nowcoderv2.problem44;

import java.util.LinkedList;
import java.util.Queue;

public class LastRemain {
    int num;
    int[] array=new int[num];
    public int LastRemaining_Solution(int n, int m) {
        num=n;
        if (n<=1) return -1;
        for (int i=0;i<num;i++){
            array[i]=1;
        }
        int tmpM=m;
        int i=0;
        while (n!=1){
            if (i==array.length) i=0;
            else if (tmpM==1){
                array[i]=0;
                i++;
            }
            else if (array[i]!=0){
                i++;
                tmpM--;
            }
        }
        return 0;
    }
    public int LastRemaining_Solution2(int n, int m) {
        Queue<Integer> queue=new LinkedList<>();
        if (n<1) return -1;
        for (int i=0;i<n;i++) queue.offer(i);
        int count=m;

        while (queue.size()!=1){
            count--;
            if (count==0){
                queue.poll();
                count=m;
            }
            else queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int i = new LastRemain().LastRemaining_Solution2(1, 1);

        System.out.println(i);
    }
}
