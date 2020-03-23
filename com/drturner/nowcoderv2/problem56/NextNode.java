package com.drturner.nowcoderv2.problem56;
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode==null) return pNode;
        if (pNode.right!=null){
            TreeLinkNode right=pNode.right;
            while (right.left!=null) right=right.left;
            return right;
        }
        else {
            while ((pNode.next!=null&&(pNode!=pNode.next.left))) pNode=pNode.next;
            return pNode.next;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode1=new TreeLinkNode(12);
        TreeLinkNode treeLinkNode2=new TreeLinkNode(9);
        TreeLinkNode treeLinkNode3=new TreeLinkNode(13);
        TreeLinkNode treeLinkNode4=new TreeLinkNode(10);
        TreeLinkNode treeLinkNode5=new TreeLinkNode(11);
        TreeLinkNode treeLinkNode6=new TreeLinkNode(1);
        treeLinkNode1.left=treeLinkNode2;
        treeLinkNode1.right=treeLinkNode3;
        treeLinkNode2.left=treeLinkNode4;
        treeLinkNode2.right=treeLinkNode5;
        treeLinkNode2.next=treeLinkNode1;
        treeLinkNode3.next=treeLinkNode1;
        treeLinkNode4.next=treeLinkNode2;
        treeLinkNode5.left=treeLinkNode6;
        treeLinkNode5.next=treeLinkNode2;
        treeLinkNode6.next=treeLinkNode5;
        TreeLinkNode treeLinkNode = new NextNode().GetNext(treeLinkNode5);
        System.out.println(treeLinkNode.val);
    }
}
