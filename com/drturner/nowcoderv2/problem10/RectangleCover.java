package com.drturner.nowcoderv2.problem10;

public class RectangleCover {
    public int RectCover(int target) {
        return myRectCover(target);
    }
    private int myRectCoverCommit(int target){
        if (target==0){
            return 1;
        }
        if (target==1){
            return 1;
        }
        if (target==2){
            return 2;
        }
        if (target%2==0){
            int val1 = myRectCover(target / 2);
            int val2 = myRectCover(target / 2 - 1);
            return val1*val1+val2*val2;
        }
        else {
            int val1 = myRectCover((target+1) / 2);
            int val2 = myRectCover((target-1) / 2 );
            int val3 = myRectCover((target - 1) / 2 - 1);
            return val1*val2+val2*val3;
        }
    }

    private int myRectCover(int target){
        int mid=target/2;
        if (target<0) return 0;
        if (target==0)
            return 1;
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        int num=myRectCover(mid-1)*myRectCover(target-mid)+myRectCover(mid-2)*myRectCover(target-mid)+myRectCover(mid-1)*myRectCover(target-mid-1);
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new RectangleCover().RectCover(3));
        for (int i=-5;i<12;i++){
            System.out.println(new RectangleCover().myRectCover(i) +"======="+ new RectangleCover().myRectCoverCommit(i));
        }
    }
}
