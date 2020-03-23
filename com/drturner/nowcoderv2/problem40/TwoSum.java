package com.drturner.nowcoderv2.problem40;

import java.util.ArrayList;

public class TwoSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        //1,2,3,4,5  6
        ArrayList<Integer> list=new ArrayList<>();
        if (array==null||array.length==0) return list;
        int mul=Integer.MAX_VALUE;
        int[] res=new int[2];
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (sum-array[i]==array[j]){
                    if (array[i]*array[j]<mul){
                        mul=array[i]*array[j];
                        res[0]=array[i];
                        res[1]=array[j];
                    }
                }
            }
        }
        if (mul!=Integer.MAX_VALUE){
            list.add(res[0]);
            list.add(res[1]);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] array={1,2,4,7,11,16};
        ArrayList<Integer> list = new TwoSum().FindNumbersWithSum(array, 10);
        System.out.println(list);
        String s="abcXYZdef";
        System.out.println(s.substring(0,s.length()));
    }
}
