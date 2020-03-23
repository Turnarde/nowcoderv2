package com.drturner.nowcoderv2.problem67;

public class RopeCutting {
   // int max=1;
   public int cutRopeDP(int target) {
       if (target==2) return 1;
       if (target==3) return 2;
       int[] dp=new int[target+1];
       dp[1]=1;
       dp[2]=2;
       dp[3]=3;
       for (int i=4;i<=target;i++){
           for (int j=1;j<=i/2;j++){
               dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
           }
       }
       return dp[target];
   }
    public int cutRope(int target) {
        return cutRope(target, 1);
    }
    private int cutRope(int target, int max) {
        int maxValue = max;
        for(int i = 1; i < target; ++i){
            maxValue = Math.max(maxValue, i*cutRope(target -i, target-i));
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int i = new RopeCutting().cutRopeDP(80);
        System.out.println(i);
    }
}
