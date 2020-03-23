package com.drturner.nowcoderv2.problem13;

import java.util.ArrayList;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> odd=new ArrayList<>();
        ArrayList<Integer> even=new ArrayList<>();

        for (int i=0;i<array.length;i++){
            if (array[i]%2==1){
                odd.add(array[i]);
            }
            else even.add(array[i]);
        }
        for (Integer e:even
             ) {
            odd.add(e);
        }
        for (int i=0;i<array.length;i++){
            array[i]=odd.get(i);
        }
    }

    public static void main(String[] args) {
        int[] array={};
        new ReOrderArray().reOrderArray(array);
        for (int e:array
             ) {
            System.out.println(e);
        }
    }
}
