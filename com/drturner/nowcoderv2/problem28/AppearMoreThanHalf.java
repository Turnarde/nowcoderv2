package com.drturner.nowcoderv2.problem28;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
* 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
* */
public class AppearMoreThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int e:array) {
            if (!map.containsKey(e)){
                map.put(e,1);
            }
            else if (map.get(e)>array.length/2){
                return e;
            }
            else {
                map.put(e,map.get(e)+1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer e:keySet
             ) {
            if (map.get(e)>array.length/2){
                result=e;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array={};
        int i = new AppearMoreThanHalf().MoreThanHalfNum_Solution(array);
        System.out.println(i);
    }
}
