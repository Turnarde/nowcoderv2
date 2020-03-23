package com.drturner.nowcoderv2.problem31;

public class CountOne {
    /*
    *
    * */
    public int NumberOf1Between1AndN_Solution(int n) {
        int division=10;
        int modd=0;
        int count=0;
        while (n/division>0){
            if (n%division>=2*division/10){
                count+=n/division*(division/10)+division/10;
                division*=10;
            }
            else if (n%division>=division/10){
                count+=n/division*(division/10)+n%division-division/10+1;
                division*=10;
            }
            else{
                count+=n/division*(division/10);
                division*=10;
            }
        }
        if (n%division>=2*division/10){
            count+=division/10;
        }
        else if ((n%division>=division/10)){
            count+=n%division-division/10+1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new CountOne().NumberOf1Between1AndN_Solution(0);
        System.out.println(i);
    }
}
