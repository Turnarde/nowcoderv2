package com.drturner.nowcoderv2.problem49;

public class MulArray {
    public int[] multiply(int[] A) {
        if (A==null||A.length==0) return A;
        int[] B1=new int[A.length];
        int[] B2=new int[A.length];
        int[] B=new int[A.length];
        B1[0]=1;
        for (int i=1;i<A.length;i++){
            B1[i]=A[i-1]*B1[i-1];
        }
        B2[A.length-1]=1;
        for (int i=A.length-2;i>=0;i--){
            B2[i]=A[i+1]*B2[i+1];
        }
        for (int i=0;i<B.length;i++){
            B[i]=B1[i]*B2[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A={};
        int[] multiply = new MulArray().multiply(A);
        for (int e:multiply
             ) {
            System.out.println(e);
        }
    }
}
