package com.drturner.nowcoderv2.problem30;

public class GreatSumSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max=array[0];
        int[] sum=new int[array.length];
        sum[0]=array[0];
        //计算以i结尾的子数组最大和，存储在sum数组中
        for (int i=1;i<array.length;i++){
            sum[i]=(sum[i-1]+array[i]>array[i])?sum[i-1]+array[i]:array[i];
            if (sum[i]>max) max=sum[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array={6,-3,-2,7,-15,1,2,2};
        int i = new GreatSumSubArray().FindGreatestSumOfSubArray(array);
        System.out.println(i);
    }
}
