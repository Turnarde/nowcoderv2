package com.drturner.nowcoderv2.problem35;

import java.util.ArrayList;
import java.util.List;

public class NumberOfK {
    //统计一个数字在排序数组中出现的次数。
    private static List<Integer> res=new ArrayList<>();
    private int binarySearch(int[] array,int k,int start,int end){
        if (start>end) return -1;
        if (start==end) return k==array[start]?start:-1;
        int mid=(end-start)/2+start;

      //  if (array[mid]==k) return mid;
        if (array[mid]>=k)  return binarySearch(array,k,start,mid);
        else return binarySearch(array,k,mid+1,end);
    }
    private void binaryRightSearch(int[] array,int k,int start,int end){
        if (start>end) return;
        if (start==end) {
            if (array[start]==k){
                res.add(start);
            }
            return;
        }
        int mid=(end+1+start)/2;
        if (array[mid]<=k)  binaryRightSearch(array,k,mid,end);
        else binaryRightSearch(array,k,start,mid-1);
    }
    private void binaryLeftSearch(int[] array,int k,int start,int end){
        if (start>end) return;
        if (start==end) {
            if (array[start]==k){
                res.add(start);
            }
            return;
        }
        int mid=(end-start)/2+start;
        if (array[mid]>=k)  binaryLeftSearch(array,k,start,mid);
        else binaryLeftSearch(array,k,mid+1,end);
    }
    public int GetNumberOfK(int [] array , int k) {
        if (array==null||array.length==0) return 0;
        binaryLeftSearch(array,k,0,array.length-1);
        binaryRightSearch(array,k,0,array.length-1);
        if (res.size()>0)
            return res.get(1)-res.get(0)+1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int[] array={1,3,3,3,3,4,5};
        int k=2;
    //    new NumberOfK().binaryLeftSearch(array, k, 0, array.length - 1);
    //    new NumberOfK().binaryRightSearch(array,k,0,array.length-1);
        int i = new NumberOfK().GetNumberOfK(array, k);
        System.out.println(i);
        System.out.println(res);
    }
}
