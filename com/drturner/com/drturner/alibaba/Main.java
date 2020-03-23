package com.drturner.com.drturner.alibaba;

import java.math.BigInteger;
import java.util.*;

public class Main {
    private static BigInteger A(int n,int m){
        BigInteger result=BigInteger.ONE;
        for (long i=n;i>=n-m+1;i--){
            result=result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    private static BigInteger N(int m){
        if (m==1) return BigInteger.ONE;
        return BigInteger.valueOf(m).multiply(N(m-1));
    }
    private static BigInteger Cop(int n,int i){

        return A(n,i).divide(N(i));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger res=BigInteger.ZERO;
        for (int i=1;i<=n;i++){
            res=res.add(Cop(n,i).multiply(Cop(i,1)));
          //  res+=Cop(n,i)*Cop(i,1);
        }
        System.out.println(res.mod(BigInteger.valueOf(1000000009)));
    }
}
