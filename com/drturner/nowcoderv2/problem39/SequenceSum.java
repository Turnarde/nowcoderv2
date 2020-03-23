package com.drturner.nowcoderv2.problem39;

import java.util.ArrayList;

public class SequenceSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int l=1;
        int r=2;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        while (l<r){
            int tmp=(l+r)*(r-l+1)/2;
            if (tmp==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for (int i=l;i<=r;i++){
                    list.add(i);
                }
                result.add(list);
                l++;
            }
            else if (tmp<sum){
                r++;
            }
            else {
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new SequenceSum().FindContinuousSequence(2);
        System.out.println(arrayLists);
    }
}
