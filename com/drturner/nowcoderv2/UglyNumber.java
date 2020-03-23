package com.drturner.nowcoderv2;

import java.util.ArrayList;
import java.util.HashSet;

public class UglyNumber {
    //方法爆炸
    public int GetUglyNumber_Solution(int index) {
        if (index==1)
            return 1;
        if (index==2)
            return 2;
        if (index==3)
            return 3;
        if (index==4)
            return 4;
        if (index==5)
            return 5;
        int count=5;
        HashSet<Integer> list=new HashSet<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int n=6;
        while (count<index){
            if ((list.contains(n/2)&&n%2==0)||(list.contains(n/3)&&n%3==0)||(list.contains(n/5)&&n%5==0)){
                count++;
                n++;
            }
            else{
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        String s;

        int i = new UglyNumber().GetUglyNumber_Solution(13);
        System.out.println(i);
    }
}
