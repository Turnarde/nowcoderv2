package com.drturner.nowcoderv2.problem11;

public class OneInBinary {
    public int NumberOf1(int n) {
        String string = Integer.toBinaryString(n);
        System.out.println(string+"======="+string.length());
        int res=0;
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)=='1') res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OneInBinary().NumberOf1(-2));
    }
}
