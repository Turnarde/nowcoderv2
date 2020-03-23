package com.drturner.algorithm;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class KMPStringMatch {
    private int[] next(char[] array){
        if (array.length==1) return new int[]{-1};
        int [] nxt=new int[array.length];
        nxt[0]=-1;
        nxt[1]=0;
        int cn=0;
        int i=2;

        while (i<array.length){
            if (array[i-1]==array[cn]){
                nxt[i]=++cn;
                i++;
            }
            else if (cn>0){
                cn=nxt[cn];
            }
            else {
                nxt[i]=0;
                i++;
            }
        }
        return nxt;
    }
    public int getIndexOf(String str1,String str2){
        if (str1==null||str2==null||str1.length()==0||str2.length()==0||str1.length()<str2.length()) return -1;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i1=0;
        int i2=0;
        int[] nxt = next(s2);
        while (i2<s2.length&&i1<s1.length){
            if (s1[i1]==s2[i2]){
                i1++;
                i2++;
            }
            else if (nxt[i2]==-1){
                i1++;
            }
            else {
                i2=nxt[i2];
            }
        }
        return i2==s2.length?i1-i2:-1;
    }

    public static void main(String[] args) {
        String str1="abcdcbac";
        String str2="fcbac";
        int index = new KMPStringMatch().getIndexOf(str1, str2);
        System.out.println(index);
    }
}
