package com.drturner.nowcoderv2.problem14;

import com.drturner.nowcoderv2.listNode.ListNode;

public class TailKth {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p1=head;
        ListNode p2=head;
        if (p1==null||k<=0) return null;
        while (k>1){
            p1=p1.next;
            k--;
            if (p1==null)
                return null;
        }
        while (p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(3);
        ListNode listNode3=new ListNode(4);
        ListNode listNode4=new ListNode(5);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        ListNode listNode5 = new TailKth().FindKthToTail(listNode2, 0);
        System.out.println(listNode5.val);
    }
}
