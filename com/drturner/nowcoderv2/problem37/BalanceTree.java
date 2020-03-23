package com.drturner.nowcoderv2.problem37;

import com.drturner.nowcoderv2.treeNode.TreeNode;

public class BalanceTree {
    class Result{
        boolean isBalance;
        int heoght;

        public Result(boolean isBalance, int heoght) {
            this.isBalance = isBalance;
            this.heoght = heoght;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return IsBalancedSub(root).isBalance;
    }
    public Result IsBalancedSub(TreeNode root) {
        Result left=new Result(true,0);
        Result right=new Result(true,0);
        if (root==null) return new Result(true,0);
        if (root.left!=null){
            left = IsBalancedSub(root.left);
        }
        if (root.right!=null){
            right = IsBalancedSub(root.right);
        }
        if (!left.isBalance||!right.isBalance||Math.abs(left.heoght-right.heoght)>1) return new Result(false,-1);
        return new Result(true,Math.max(left.heoght,right.heoght)+1);
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
    //    treeNode.right=new TreeNode(6);
        treeNode.left.left=new TreeNode(1);
        boolean b = new BalanceTree().IsBalanced_Solution(treeNode);
        System.out.println(b);
    }
}
