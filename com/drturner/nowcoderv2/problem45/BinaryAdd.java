package com.drturner.nowcoderv2.problem45;

public class BinaryAdd {
    public int Add(int num1,int num2) {
        while (num2!=0){
            int res=num1^num2;
            num2=(num1&num2)<<1;
            num1=res;
        }
        return num1;
    }

    public static void main(String[] args) {
        int add = new BinaryAdd().Add(5, 7);
        System.out.println(add);
    }
}
