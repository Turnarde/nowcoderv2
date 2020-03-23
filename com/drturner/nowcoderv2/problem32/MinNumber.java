package com.drturner.nowcoderv2.problem32;

import java.util.ArrayList;

public class MinNumber {
    public String PrintMinNumber(int [] numbers) {
        String result="";
        if (numbers==null||numbers.length==0) return result;
        ArrayList<String> list=new ArrayList<>();
        for (int i=0;i<numbers.length;i++) {
            list.add(String.valueOf(numbers[i]));
        }
        list.sort((o1,o2)->(o1+o2).compareTo(o2+o1));
        for (int i=0;i<list.size();i++){
            result+=list.get(i);
        }
        return result;
    }

    private String getMin(String str1,String str2) {
        if ((str1+str2).compareTo(str2+str1)<0){
            return str1+str2;
        }
        else
            return str2+str1;
    }

    public static void main(String[] args) {
        int[] array={3,5,1,4,2};
        String s = new MinNumber().PrintMinNumber(array);
        System.out.println(s);
    }
}
