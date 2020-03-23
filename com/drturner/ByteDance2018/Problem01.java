package com.drturner.ByteDance2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
* 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：
* 我们对用户按照它们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，
* 我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，有多少用户对这类文章喜好值为k。
* 因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。

5
1 2 3 3 5
3
1 2 1
2 3 5
3 5 3

输入描述:
输入：  第1行为n代表用户的个数
        第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度
        第3行为一个正整数q代表查询的组数
        第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型

输出描述:
输出：一共q行，每行一个整数代表喜好值为k的用户的个数
* */
public class Problem01 {
    private static int like(int[] array,int l,int r,int k){
        int count=0;
        for (int i=l;i<=r;i++){
            if (array[i]==k) count++;
        }
        return count;
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        int totalNum=Integer.parseInt(sc.nextLine());
        int [] arrays=new int[totalNum];
        String [] arrs=sc.nextLine().split(" ");
        for(int i=0;i<totalNum;i++){
            arrays[i]=Integer.parseInt(arrs[i]);
            if (!map.containsKey(arrays[i])){
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(arrays[i],list);
            }
            else {
                map.get(arrays[i]).add(i);
            }
        }
        int srNum=Integer.parseInt(sc.nextLine());
        int[][] srArr=new int[srNum][3];
        for(int i=0;i<srNum;i++){
            String [] tmp=sc.nextLine().split(" ");
            for(int j=0;j<3;j++){
                srArr[i][j]=Integer.parseInt(tmp[j]);
            }
        }
        int [] res=new int[srNum];
        for (int i=0;i<srNum;i++){
            //  res[i]=like(arrays,srArr[i][0]-1,srArr[i][1]-1,srArr[i][2]);
            if (map.containsKey(srArr[i][2])){
                for (Integer index:map.get(srArr[i][2])) {
                    if (index>=srArr[i][0]-1&&index<=srArr[i][1]-1){
                        res[i]++;
                    }
                }
            }
        }
        for (int e:res
             ) {
            System.out.println(e);
        }
        /*
        int srNum=Integer.parseInt(sc.nextLine());
        int[][] srArr=new int[srNum][3];
        for(int i=0;i<srNum;i++){
            String [] tmp=sc.nextLine().split(" ");
            for(int j=0;j<3;j++){
                srArr[i][j]=Integer.parseInt(tmp[j]);
            }
        }
        int [] res=new int[srNum];
        int [][] count=new int[srNum][srNum];
        for (int i=0;i<srNum;i++){
          //  res[i]=like(arrays,srArr[i][0]-1,srArr[i][1]-1,srArr[i][2]);
            for (int j=srArr[i][0]-1;j<=srArr[i][1]-1;j++){

                if (arrays[j]==srArr[i][2]) res[i]++;
            }
        } */

    }
}
