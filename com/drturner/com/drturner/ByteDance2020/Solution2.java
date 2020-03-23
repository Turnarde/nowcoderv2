package com.drturner.com.drturner.ByteDance2020;

import org.junit.Test;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int W = sc.nextInt();
        String pos = sc.nextLine();
        String[] split = pos.split(" ");
        int[] position=new int[split.length];
        for (int i=0;i<split.length;i++){
            position[i]=Integer.parseInt(split[i]);
        }
        String s = sc.nextLine();
        String[] split1 = s.split(" ");
        int [] sup=new int[split1.length];
        for (int i=0;i<split1.length;i++){
            sup[i]=Integer.parseInt(split1[i]);
        }
        int times = water(position, sup, 0, D, W);
        System.out.println(times);
    }

    public static int water(int[] position,int [] supply,int start,int D,int W){

        if (W>=D){
            return 1;
        }
      //  D=D-position[start];
      //  W=W-position[start];

        if (position[start]>W) return 1000;
        if (position[start]>=D) return 0;
        //start buqu
        int t1=water(position,supply,start+1,D-position[start],W);
        int t2=water(position,supply,start+1,D-position[start],W+supply[start])+1;
        return t1<t2?t1:t2;
    }
    static int DD=10;
    static int WW=4;
    @Test
    public void prin(){

        int[] position={1,4,7};
        int[] supply={6,3,5};
        int water = water(position, supply, 0, 10, 4);
        System.out.println(water);
    }
}
