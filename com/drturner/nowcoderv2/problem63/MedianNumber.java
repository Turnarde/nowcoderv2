package com.drturner.nowcoderv2.problem63;

import java.util.PriorityQueue;
import java.util.Random;

public class MedianNumber {
    private static PriorityQueue<Integer> right=new PriorityQueue<>((o1,o2)->{return o1-o2;});
    private static PriorityQueue<Integer> left=new PriorityQueue<>((o1,o2)->{return o2-o1;});
    private boolean isOdds=true;

    public void Insert(Integer num) {
        if (isOdds){
            if (!left.isEmpty()&&num>left.peek())  {
                right.offer(num);
                left.offer(right.poll());
            }
            else {
                left.offer(num);
            }
        }
        else {
            if (!left.isEmpty()&&num>left.peek()){
                right.offer(num);
            }
            else {
                left.offer(num);
                right.offer(left.poll());
            }

        }
        isOdds=!isOdds;
    }

    public Double GetMedian() {
        if (!isOdds){
            return left.peek()*1.0;
        }
        else {
            return (left.peek()+right.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        MedianNumber medianNumber = new MedianNumber();
        medianNumber.Insert(1);
        medianNumber.Insert(2);
        medianNumber.Insert(3);
        medianNumber.Insert(4);
        medianNumber.Insert(5);
        medianNumber.Insert(6);
        Double aDouble = medianNumber.GetMedian();
        System.out.println(aDouble);
    }
}
