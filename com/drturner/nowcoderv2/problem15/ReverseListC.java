package com.drturner.nowcoderv2.problem15;

import com.drturner.nowcoderv2.listNode.ListNode;

public class ReverseListC {
    /*
        1->2->3->4
    * */
    public ListNode ReverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        ListNode current=head;
        while (current!=null){
            next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        return pre;
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
        ListNode listNode5 = new ReverseListC().ReverseList(listNode);

        while (listNode5!=null){
            System.out.println(listNode5.val);
            listNode5=listNode5.next;
        }
    }
}
