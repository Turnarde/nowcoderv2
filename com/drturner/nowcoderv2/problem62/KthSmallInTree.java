package com.drturner.nowcoderv2.problem62;

import com.drturner.nowcoderv2.treeNode.TreeNode;

import java.util.ArrayList;

public class KthSmallInTree {
    ArrayList<TreeNode> list=new ArrayList<>();
    private void midTrace(TreeNode root){
        if (root==null) return;
        midTrace(root.left);
        list.add(root);
        midTrace(root.right);
    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        midTrace(pRoot);
        if (k<=0||k>list.size()) return null;
        return list.get(k-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(6);
        treeNode.left.left=new TreeNode(1);
        treeNode.right.right=new TreeNode(7);
        TreeNode treeNode1 = new KthSmallInTree().KthNode(treeNode, 2);
        System.out.println(treeNode1.val);
    }
}
