package com.drturner.nowcoderv2.problem9;

public class JumpFlog {
    public int JumpFloorII(int target) {
        if (target==1)
            return 1;
        return 2*JumpFloorII(target-1);
    }
    public int JumpFloorIINotRec(int target) {
        if (target==1)
            return 1;
        return 2*JumpFloorIINotRec(target-1);
    }
    public static void main(String[] args) {
        for (int i=1;i<26;i++){
            int num = new JumpFlog().JumpFloorII(i);
            System.out.println(num);
        }

    }
}
