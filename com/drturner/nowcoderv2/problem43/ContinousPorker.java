package com.drturner.nowcoderv2.problem43;

public class ContinousPorker {
    //0 1 2 3 4 5 6 ...13
    public boolean isContinuous(int [] numbers) {
        int zeros=0;
        if (numbers==null||numbers.length==0) return false;
        for (int i=0;i<numbers.length;i++){
         //   if (numbers[i]==0) zeros++;
            for (int j=i+1;j<numbers.length;j++){
                if (numbers[j]<numbers[i]){
                    int tmp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=tmp;
                }
            }
        }
        for (int i=0;i<numbers.length;i++)
            if (numbers[i]==0) zeros++;
        int num=numbers[zeros];
        for (int i=zeros+1;i<numbers.length;i++){
            if ((numbers[i]!=num+1)&&(zeros>0)){
                num++;
                zeros--;
                i--;
            }
            else if (numbers[i]!=num+1){
                return false;
            }
            else num++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array={6,5,13,3,2};
        boolean continuous = new ContinousPorker().isContinuous(array);
        System.out.println(continuous);
    }
}
