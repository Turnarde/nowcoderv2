package com.drturner.nowcoderv2.problem54;

import com.drturner.nowcoderv2.listNode.ListNode;

public class ListLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null||pHead.next==null||pHead.next.next==null) return null;
        ListNode p1=pHead.next;
        ListNode p2=pHead.next.next;
        while (p2!=null&&p1!=p2){
            p1=p1.next;
            p2=p2.next.next;
        }
        if (p2==null) return null;
        p2=pHead;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
