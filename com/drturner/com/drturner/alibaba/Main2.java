package com.drturner.com.drturner.alibaba;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        char[][] matrix=new char[n1][n2];
        for (int i=0;i<n1;i++){
            String s=sc.nextLine();
            matrix[i]=s.toCharArray();
        }

    }
}
