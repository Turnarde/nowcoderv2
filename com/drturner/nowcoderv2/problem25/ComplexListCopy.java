package com.drturner.nowcoderv2.problem25;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class ComplexListCopy {
    Map<RandomListNode,RandomListNode> map=new HashMap<>();
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode node=pHead;
        if (pHead==null) return null;
        while (pHead!=null){
            map.put(pHead,new RandomListNode(pHead.label));
            pHead=pHead.next;
        }
        pHead=node;
        while (pHead!=null){
            if (pHead.next!=null)
                map.get(pHead).next=map.get(pHead.next);
            else
                map.get(pHead).next=null;
            if (pHead.random!=null)
                map.get(pHead).random=map.get(pHead.random);
            else
                map.get(pHead).random=null;
            pHead=pHead.next;
        }
        return map.get(node);
    }
}
