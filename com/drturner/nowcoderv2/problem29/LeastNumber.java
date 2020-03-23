package com.drturner.nowcoderv2.problem29;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class LeastNumber {
    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
      //  ReentrantLock
        ArrayList<Integer> list=new ArrayList<>();
        if (input==null||k>input.length||input.length<=0) return list ;
        for (Integer e:input){
            list.add(e);
        }
        list.sort((o1,o2)->o1-o2);
        ArrayList<Integer> result=new ArrayList<>();
        for (int i=0;i<k;i++){
            result.add(list.get(i));
        }
        return result;
    }
    public void mergeSort(int[] array,int k){
        process(array,0,array.length-1);
    }
    public void process(int[] array,int start,int end){
        if (start==end) return;
        int mid=(start+end)/2;

        process(array,start,mid);
        process(array,mid+1,end);
        merge(array,start,mid,end);
    }
    public void merge(int[] array,int start,int mid,int end){
        int st=start;
        int index=mid+1;
        int[] tmp=new int[end-start+1];
        int count=0;
        while (st<=mid&&index<=end){
            if (array[st]<=array[index]){
                tmp[count]=array[st];
                st++;
                count++;
            }
            else {
                tmp[count]=array[index];
                index++;
                count++;
            }
        }
        while (st<=mid){
            tmp[count]=array[st];
            st++;
            count++;
        }
        while (index<=end){
            tmp[count]=array[index];
            index++;
            count++;
        }
        count=0;
        for (int i=start;i<=end;i++){
            array[i]=tmp[count++];
        }
    }

    public static void main(String[] args) {
        int[] array={4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = new LeastNumber().GetLeastNumbers_Solution(null, 7);
        for (int e:list
             ) {
            System.out.println(e);
        }
    }
}
