package com.drturner.nowcoderv2.problem66;

public class RobotMove {
    /*
    * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
    * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
    * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
    * */
    public int movingCountv2(int threshold, int rows, int cols) {
        int count=0;
        //  la:
        for (int i=rows-1;i>=0;i--){
            for (int j=cols-1;j>=0;j--){
                if (reachable(i,j,threshold)){
                    System.out.println("i: "+i+"j: "+j);
                    count=count+1;
                }
                else if (rows==1){
                    break;
                }
                else if (cols==1){
                    return count;
                }
                //    count=reachable(i,j,threshold)?count+1:count;
            }
        }
        return count;
    }
    public int movingCount(int threshold, int rows, int cols) {
        int count=0;
      //  la:
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (reachable(i,j,threshold)){
                    System.out.println("i: "+i+"j: "+j);
                    count=count+1;
                }
                else if (rows==1){
                    break;
                }
                else if (cols==1){
                    return count;
                }
            //    count=reachable(i,j,threshold)?count+1:count;
            }
        }
        return count;
    }
    private boolean reachable(int row,int col,int k){
        int num=0;
        while (row!=0){
            num+=(row%10);
            row/=10;
        }
        while (col!=0){
            num+=(col%10);
            col/=10;
        }
        return num<=k;
    }

    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
        boolean reachable = robotMove.reachable(15, 100, 6);
        int i = robotMove.movingCount(10,100,1);
        System.out.println(i);
    }
}
