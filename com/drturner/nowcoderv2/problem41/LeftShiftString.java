package com.drturner.nowcoderv2.problem41;

public class LeftShiftString {
    public String LeftRotateString(String str,int n) {
        if (str==null||str.length()==0) return str;
        if (n>str.length()) n=n%str.length();
        String s1=str.substring(0,n);
        String s2=str.substring(n,str.length());
        return s2+s1;
    }

    public static void main(String[] args) {
        String string = new LeftShiftString().LeftRotateString("", 10);
        System.out.println(string);
    }
}
