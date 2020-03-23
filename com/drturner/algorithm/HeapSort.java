package com.drturner.algorithm;

public class HeapSort {
    public void heapSort(int[] array){
        if (array.length==0) return;
        int heapSize=array.length-1;
        for (int i=0;i<array.length;i++){
            insertHeap(array,i);
        }
        while (heapSize>0){
            int tmp=array[0];
            array[0]=array[heapSize];
            array[heapSize]=tmp;
            heapify(array,0,heapSize--);
        }
    }
    public void heapify(int[] array,int index,int heapSize){
        int left=2*index+1;
        while (left<heapSize){
            int largest=(2*index+2<heapSize)&&(array[2*index+2]>array[left])?left+1:left;
            largest=array[index]>array[largest]?index:largest;
            if (largest==index) return;
            int tmp=array[largest];
            array[largest]=array[index];
            array[index]=tmp;
            index=largest;
            left=2*index+1;
        }
    }
    public void insertHeap(int[] array,int index){
        while (array[(index-1)/2]<array[index]){
            int tmp=array[(index-1)/2];
            array[(index-1)/2]=array[index];
            array[index]=tmp;
            index=(index-1)/2;
        }
    }
    public static void main(String[] args) {
      //  int[] array={4,5,3,6,7,2,1};
        int []array={2,1,3};
        new HeapSort().heapSort(array);
   //     new HeapSort().heapify(array,0,3);
        for (int e:array){
            System.out.println(e);
        }
    }
}
