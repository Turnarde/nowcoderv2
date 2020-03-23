package com.drturner.algorithm;

public class MergeSort {
    public void mergeSort(int [] array){
        if (array.length==0) return;
        process(array,0,array.length-1);
    }
    private void process(int[] arr,int start,int end){
        int mid=(start+end)/2;
        if (start==end) return;
        process(arr,start,mid);
        process(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    private void merge(int[] arr1,int start,int par,int end){
        int [] tmp=new int[end-start+1];
        int count=0;
        int count2=0;
        while (start+count<=par&&par+count2+1<=end){
            if (arr1[start+count]>arr1[par+count2+1]){
                tmp[count+count2]=arr1[par+count2+1];
                count2++;
            }
            else {
                tmp[count+count2]=arr1[start+count];
                count++;
            }
        }
        if (count+start<=par){
            for (int i=count+start;i<=par;i++){
                tmp[count+count2]=arr1[i];
                count++;
            }
        }
        else{//(count2+par+1<=end)
            for (int i=count2+par+1;i<=end;i++){
                tmp[count2+count]=arr1[i];
                count2++;
            }
        }
        for (int i=0;i<tmp.length;i++){
            arr1[start+i]=tmp[i];
        }
    }

    public static void main(String[] args) {
       // int[] array={5,4,3,6,7,2,1};
        int []array={2};
        new MergeSort().mergeSort(array);
        for (int e:array){
            System.out.println(e);
        }
    }
}
