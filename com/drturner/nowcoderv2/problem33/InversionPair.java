package com.drturner.nowcoderv2.problem33;

public class InversionPair {
    private void mergeSort(int[] array,int k){
        process(array,0,array.length-1);
    }
    private int process(int[] array,int start,int end){
        if (start==end) return 0;
        int mid=(start+end)/2;
        int l=process(array,start,mid);
        int r=process(array,mid+1,end);
        return (l+r+merge(array,start,mid,end))%1000000007;
    }
    private int merge(int[] array,int start,int mid,int end){
        int result=0;
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
                result+=mid-st+1;
                result=result%1000000007;
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
        return result;
    }
    public int InversePairs(int [] array) {
        if (array==null||array.length==0) return 0;
        return process(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,1,2};
        int i = new InversionPair().InversePairs(array);
        System.out.println(i);
    }
}
