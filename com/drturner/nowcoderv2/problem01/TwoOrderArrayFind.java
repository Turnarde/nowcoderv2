package com.drturner.nowcoderv2.problem01;

public class TwoOrderArrayFind {
    public boolean Find(int target, int [][] array) {
        int row=array.length-1;
        int col=0;
        while (row>=0&&col<array[0].length){
            if (array[row][col]==target) return true;
            else if (array[row][col]<target) col++;
            else row--;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] array={
                {2,3,4,5},
                {3,4,5,7},
                {6,7,9,11},
                {9,10,11,12}
        };
        for (int i=-3;i<20;i++){
            boolean find = new TwoOrderArrayFind().Find(i, array);
            System.out.println(find+"======"+i);
        }

    }
}
