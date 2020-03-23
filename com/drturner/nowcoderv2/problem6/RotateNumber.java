package com.drturner.nowcoderv2.problem6;

public class RotateNumber {
 /*
 *    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    */
     public int minNumberInRotateArray(int [] array) {
        return array[minNumberInRotateArray(array,0,array.length-1)];
     }
    private int minNumberInRotateArray(int [] array,int start,int end) {
         int mid=start+((end-start)>>1);
         if (start==end) return start;
         if (array[mid]>array[end]){
             return minNumberInRotateArray(array,mid+1,end);
         }
         else {
             return minNumberInRotateArray(array,start,mid);
         }
    }

    public static void main(String[] args) {
        int[] array={};
        System.out.println(new RotateNumber().minNumberInRotateArray(array));
    }
}
