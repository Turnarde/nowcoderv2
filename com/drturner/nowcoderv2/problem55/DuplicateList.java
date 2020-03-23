package com.drturner.nowcoderv2.problem55;

import com.drturner.nowcoderv2.listNode.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DuplicateList {
    LinkedList<ListNode> stack=new LinkedList<>();
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null) return pHead;
     //   stack.offerLast(pHead);
     //   pHead=pHead.next;
        int last=Integer.MAX_VALUE;
        while (pHead!=null){
            if (!stack.isEmpty()&&pHead.val==stack.peekLast().val||pHead.val==last){
                if (!stack.isEmpty()&&pHead.val==stack.peekLast().val) last=stack.pollLast().val;
            }
            else
                stack.offerLast(pHead);
            pHead=pHead.next;
        }
        if (stack.isEmpty()) return null;
        ListNode head=stack.pollFirst();
        head.next=null;
        ListNode tmp=head;
        while (!stack.isEmpty()){
            tmp.next=stack.pollFirst();
            tmp=tmp.next;
            tmp.next=null;
        }
     //   while (!stack.isEmpty()){
     //       System.out.println(stack.pollFirst().val);
     //   }
        return head;
    }

    public static void main(String[] args) {
        ListNode pHead=new ListNode(2);
        pHead.next=new ListNode(2);
        pHead.next.next=new ListNode(3);
        pHead.next.next.next=new ListNode(3);
        ListNode listNode = new DuplicateList().deleteDuplication(pHead);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
