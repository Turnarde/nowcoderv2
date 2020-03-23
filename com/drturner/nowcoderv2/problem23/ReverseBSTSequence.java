package com.drturner.nowcoderv2.problem23;

public class ReverseBSTSequence {
    private boolean VerifySquenceOfBST(int [] sequence,int start,int end){
        if (start>=end) return true;
        //3,4   4,3
        int i=end;
        while(i>start&&sequence[i-1]>sequence[end])
            i--;
        for(int j = start;j<i-1;j++)
            if(sequence[j]>sequence[end])
                return false;;
        return VerifySquenceOfBST(sequence,start,i-1)&&VerifySquenceOfBST(sequence,i,end-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
/*5,9,7
            4,6,7,5
*               7
*             /  \
*            5    9
*          /  \  /  \
*         4   6 8    10
*
*    4 , 6 , 5 , 8 , 10 , 9 , 7
*
* */

        if(sequence.length==0)
            return false;
        if(sequence.length==1)
            return true;
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    public static void main(String[] args) {
       // int[] sequence={4,6,5,8,10,9,7};
        int[] sequence={1,2,3,4,5};
        ReverseBSTSequence reverseBSTSequence = new ReverseBSTSequence();
        boolean b = reverseBSTSequence.VerifySquenceOfBST(sequence);
        System.out.println(b);
    }
}
