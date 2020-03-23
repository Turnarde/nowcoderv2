package com.drturner.nowcoderv2.problem34;

import com.drturner.nowcoderv2.listNode.ListNode;

public class CommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int count=0;
        ListNode node1=pHead1;
        ListNode node2=pHead2;
        if (pHead1==null||pHead2==null) return null;
        while (node1!=null&&node2!=null){
            node1=node1.next;
            node2=node2.next;
        }
        while (node1!=null){
            node1=node1.next;
            count++;
        }
        while (node2!=null){
            node2=node2.next;
            count--;
        }
        node1=pHead1;
        node2=pHead2;
        if (count>0){
            while (count>0){
                node1=node1.next;
                count--;
            }
        }
        else if (count<0){
            while (count<0){
                node2=node2.next;
                count++;
            }
        }
        while (node1!=null&&node2!=null){
            if (node1==node2) return node1;
            node1=node1.next;
            node2=node2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(0);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(1);
        ListNode listNode5=new ListNode(4);
        ListNode listNode6=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode5.next=listNode6;
        listNode6.next=listNode3;
        ListNode listNode = new CommonNode().FindFirstCommonNode(listNode1, listNode2);
        System.out.println(listNode.val);
    }
}
