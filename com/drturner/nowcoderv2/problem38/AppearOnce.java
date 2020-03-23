package com.drturner.nowcoderv2.problem38;

import java.util.ArrayList;

public class AppearOnce {
    //  3 1 2 1 5 3
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int res=array[0];
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for (int i=1;i<=array.length-1;i++){
            res=res^array[i];
        }
        int index=-1;
        for (int i=0;i<32;i++){
            int tmp=res&(1<<i);
            if (tmp!=0){
                index=i;
                break;
            }
        }
        int tmp=(1<<index);
        for (int i =0;i<array.length;i++){
            if ((array[i]&tmp)==0) list1.add(array[i]);
            else list2.add(array[i]);
        }
        num1[0]=list1.get(0);
        for (int i=1;i<list1.size();i++){
            num1[0]=num1[0]^list1.get(i);
        }
        num2[0]=list2.get(0);
        for (int i=1;i<list2.size();i++){
            num2[0]=num2[0]^list2.get(i);
        }
    }
//0010
//0101
    public static void main(String[] args) {
        int[] array={3,2,2,5};
        //2^5
        int[] num1=new int[1];
        int[] num2=new int[1];
        new AppearOnce().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+"  "+num2[0]);
    }
}
