package com.drturner.nowcoderv2.problem19;

import java.util.ArrayList;

public class PrintMatrix {
    private static ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row=matrix.length;
        if (row==0) return list;
        int col=matrix[0].length;
        int startC=0;
        int startR=0;
        int endC=col-1;
        int endR=row-1;
        while (startC<=endC&&startR<=endR){
            printMatrix(matrix,startR,startC,endR,endC);
            startC++;
            startR++;
            endC--;
            endR--;
        }
        return list;
    }
    private void printMatrix(int [][] matrix,int startR,int startC,int endR,int endC) {
        if (startR==endR&&startC==endC){
            list.add(matrix[startR][endR]);
            return;
        }
        else if (startR==endR){
            for (int i=startC;i<=endC;i++){
                list.add(matrix[startR][i]);
            }
            return;
        }
        else if (startC==endC){
            for (int i=startR;i<=endR;i++){
                list.add(matrix[i][endC]);
            }
            return;
        }
        for (int i=startC;i<=endC-1;i++){
            list.add(matrix[startR][i]);
        }
        for (int i=startR;i<=endR-1;i++){
            list.add(matrix[i][endC]);
        }
        for (int i=endC;i>=startC+1;i--){
            list.add(matrix[endR][i]);
        }
        for (int i=endR;i>=startR+1;i--){
            list.add(matrix[i][startC]);
        }
    //    printMatrix(matrix,startR,startC,startR,endC-1);
    //    printMatrix(matrix,startR,endC,endR-1,endC);
    //    printMatrix(matrix,endR,endC,endR,startC+1);
    //    printMatrix(matrix,endR,startC,startR-1,startC);
    }

    public static void main(String[] args) {
        int[][] array={
                {1},{2},{3},{4},
            //    {5,6,7,8},
            //    {9,10,11,12},
         //       {13,14,15,16}
        };
    //    new PrintMatrix().printMatrix(array,0,0,3,3);
        new PrintMatrix().printMatrix(array);
        for (Integer e:list
             ) {
            System.out.println(e);
        }
    }
}
