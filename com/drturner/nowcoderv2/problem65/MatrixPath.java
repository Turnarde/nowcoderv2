package com.drturner.nowcoderv2.problem65;

import java.util.Collections;
import java.util.HashMap;

public class MatrixPath {
    boolean[][] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char [][] m=new char[rows][cols];
        visited=new boolean[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                m[i][j]=matrix[j+i*cols];
                visited[i][j]=false;
            }
        }
        boolean res=false;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (m[i][j]==str[0]){
                    res=res||hasPathSub2(m,i,j,str,0);
                }
            }
        }
        return res;
    }
    private boolean hasPathSub2(char[][] matrix,int startR,int startC, char[] str,int index) {
        if (index==str.length) return true;
        if (startR<0||startC<0||startR>=matrix.length||startC>=matrix[0].length||visited[startR][startC]||matrix[startR][startC]!=str[index]) return false;
        visited[startR][startC]=true;
        if (hasPathSub2(matrix,startR+1,startC,str,index+1)||
                hasPathSub2(matrix,startR-1,startC,str,index+1)||
                hasPathSub2(matrix,startR,startC+1,str,index+1)||
                hasPathSub2(matrix,startR,startC-1,str,index+1)){
            return true;
        }
        else {
            visited[startR][startC]=false;
            return false;
        }
    }

    public boolean hasPathSub(char[][] matrix,int startR,int startC, char[] str,int index) {
        if (index==str.length) return true;
        if (startR<0||startC<0||startR>=matrix.length||startC>=matrix[0].length||visited[startR][startC]) return false;
        visited[startR][startC]=true;
        if (matrix[startR][startC]==str[index]){
            return hasPathSub(matrix,startR+1,startC,str,index+1)||
                    hasPathSub(matrix,startR-1,startC,str,index+1)||
                    hasPathSub(matrix,startR,startC+1,str,index+1)||
                    hasPathSub(matrix,startR,startC-1,str,index+1)||
                    hasPathSub(matrix,startR+1,startC,str,index)||
                    hasPathSub(matrix,startR-1,startC,str,index)||
                    hasPathSub(matrix,startR,startC+1,str,index)||
                    hasPathSub(matrix,startR,startC-1,str,index);
        }
        else {
            return hasPathSub(matrix,startR+1,startC,str,index)||
                    hasPathSub(matrix,startR-1,startC,str,index)||
                    hasPathSub(matrix,startR,startC+1,str,index)||
                    hasPathSub(matrix,startR,startC-1,str,index);
        }
    }

    public static void main(String[] args) {
        MatrixPath matrixPath = new MatrixPath();
        String s="abcesfcsadee";
        char[] chars = s.toCharArray();

        String str="abcb";
        boolean b = matrixPath.hasPath(chars, 3, 4, str.toCharArray());
        System.out.println(b);
    }

}
