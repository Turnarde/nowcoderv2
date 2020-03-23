package com.drturner.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {
    public void quickSort(int[] array,int start,int end){
        if (start>=end) return;
        int par = partition(array, start, end);
        quickSort(array,start,par-1);
        quickSort(array,par+1,end);
    }
    public void quickSortHighLev(int[] array,int start,int end){
        if (start>=end) return;
        int[] par = highLevPartition(array, start, end);
        quickSortHighLev(array,start,par[0]-1);
        quickSortHighLev(array,par[1]+1,end);
    }
    public int[] highLevPartition(int[] array,int start,int end){
        int less=start,more=end,curr=start;
        int num=array[end];

        while (curr!=more){
            if (array[curr]<num){
                int tmp=array[curr];
                array[curr]=array[less];
                array[less]=tmp;
                less++;curr++;
            }
            else if (array[curr]==num){
                curr++;
            }
            else {
                int tmp=array[curr];
                array[curr]=array[--more];
                array[more]=tmp;
            }
        }
        int tmp=array[more];
        array[more]=num;
        array[end]=tmp;
        return new int[]{less,more};
    }
    public int partition(int[] array,int start,int end){
        //4,3,5,2,8,6   {6}
        int j=start,i=start;
        int num=array[end];
        while (j<end){
            if (array[j]<=num){
                int tmp=array[j];
                array[j]=array[i];
                array[i]=tmp;
                i++;j++;
            }
            else {
                j++;
            }
        }
        int tmp=array[i];
        array[i]=array[end];
        array[end]=tmp;

  //      System.out.println("I:  "+i);
        return i;
    }
    public static void main(String[] args) {
         int[] array={0,5,4,3,6,7,5,4};
         int [] arr=new int[1024*1024];
         for (int i=0;i<arr.length;i++){
             arr[i]=new Random().nextInt();
         }
         int [] myarr_ord=new int[10*1024*1024];
         int [] myarr_lst=new int[10*1024*1024];
         int [] myarr_hlv=new int[10*1024*1024];
      //  int []array={2};
    //    int[] ints = new QuickSort().highLevPartition(array, 0, array.length - 1);
     //   System.out.println("0:  "+ints[0]+"1:  "+ints[1]);
     //   new QuickSort().partition(array,0,6);
   //     new  QuickSort().quickSort(array,0,array.length-1);

    //    new QuickSort().quickSortHighLev(arr,0,arr.length-1);
         new Thread(()->{
             long start = System.currentTimeMillis();
             int [] arra=new int[10*1024*1024];
             for (int i=0;i<arra.length;i++){
                 arra[i]=new Random().nextInt();
             }
             new QuickSort().quickSortHighLev(arra,0,arra.length-1);
             long endt = System.currentTimeMillis();
             for (int i=0;i<arra.length;i++){
                 myarr_hlv[i]=arra[i];
             }
             System.out.println("Highlev total time:"+(endt-start));
         }).start();
         new Thread(()->{
             int [] arra_ord=new int[10*1024*1024];
             long start = System.currentTimeMillis();
             for (int i=0;i<arra_ord.length;i++){
                 arra_ord[i]=new Random().nextInt();
             }
             new QuickSort().quickSort(arra_ord,0,arra_ord.length-1);
             long endt = System.currentTimeMillis();
             System.out.println("ordinary total time:"+(endt-start));
             for (int i=0;i<arra_ord.length;i++){
                 myarr_ord[i]=arra_ord[i];
             }
         }).start();
        new Thread(()->{
            long start = System.currentTimeMillis();
            ArrayList<Integer> arra=new ArrayList<>();
            for (int i=0;i<10*1024*1024;i++){
                arra.add(new Random().nextInt());
            }
            arra.sort((o1,o2)->o1.compareTo(o2));
            long endt = System.currentTimeMillis();
            System.out.println("List total time:"+(endt-start));
            for (int i=0;i<arra.size();i++){
                myarr_lst[i]=arra.get(i);
            }
        }).start();
      //  for (int e:arr
    //         ) {
  //          System.out.println(e);
   //     }

    }
}
