package com.drturner.nowcoderv2.problem48;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumbers {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Map<Integer,Integer> map=new HashMap<>();
        if (numbers==null||numbers.length==0) return false;
        for (int e:numbers) {
            if (map.containsKey(e)){
                duplication[0]=e;
                return true;
            }
            else{
                map.put(e,1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] duplication={0};
        int[] number={2,3,1,0,2,5,3};
        boolean duplicate = new DuplicateNumbers().duplicate(number, number.length, duplication);
        System.out.println(duplication[0]);
    }
}
