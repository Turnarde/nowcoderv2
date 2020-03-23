package com.drturner.algorithm;

import java.util.Scanner;

public class ParlindrSubSeq {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
      //  String s="aaa";
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        int num=0;
        for (int i=0;i<sb.length();i++){
            int count=1;
            while (i-count>=0&&i+count<sb.length()){
                if ((sb.charAt(i-count)==sb.charAt(i+count))&&(sb.charAt(i-count)!='#')){ num++;count++;}
                else if (sb.charAt(i-count)==sb.charAt(i+count)){
                    count++;
                }
                else
                    break;
            }
        }
        System.out.println(num+s.length());
    }
}
