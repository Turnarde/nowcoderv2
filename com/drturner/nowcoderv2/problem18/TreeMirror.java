package com.drturner.nowcoderv2.problem18;

import com.drturner.nowcoderv2.treeNode.TreeNode;

public class TreeMirror {
    public void Mirror(TreeNode root) {
        if (root==null) return;
        TreeNode treeNode=root.left;
        root.left=root.right;
        root.right=treeNode;
        Mirror(root.left);
        Mirror(root.right);
    }
    private TreeNode mirror(TreeNode root){
        if (root==null) return null;
        TreeNode treeNode=new TreeNode(root.val);
        treeNode.left=mirror(root.right);
        treeNode.right=mirror(root.left);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(7);
        treeNode.left=new TreeNode(8);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(8);
        treeNode.right.left=new TreeNode(10);
   //    TreeNode mirror = new TreeMirror().mirror(treeNode);
        new TreeMirror().Mirror(treeNode);
        TreeNode.print(treeNode);
    }
}
