package com.drturner.nowcoderv2.problem27;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class StringPermution {
    ArrayList<String> list=new ArrayList<>();
    Set<String> set=new TreeSet<>();
    public ArrayList<String> Permutation(String str) {
        if (str==null||str.length()==0) return list;
        PermutationSub(str.toCharArray(),0,str.length()-1);
        for (String s:set){
            list.add(s);
        }
        return list;
    }
    private void PermutationSub(char[] str,int start,int end) {

        if (start==end){
            StringBuilder res=new StringBuilder();
            for (int i=0;i<=end;i++){
                res.append(str[i]);
            }
            set.add(res.toString());
        //    list.add(res.toString());
            return;
        }
        for (int i=start;i<=end;i++){
            swap(str,start,i);
            PermutationSub(str,start+1,end);
            swap(str,start,i);
        }
    }
    private void swap(char[] arr,int i1,int i2){
        char tmp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=tmp;
    }

    public static void main(String[] args) {
        ArrayList<String> abc = new StringPermution().Permutation("baac");
        System.out.println(abc);
    }
}
