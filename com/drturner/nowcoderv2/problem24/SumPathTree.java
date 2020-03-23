package com.drturner.nowcoderv2.problem24;

import com.drturner.nowcoderv2.treeNode.TreeNode;

import java.util.ArrayList;

public class SumPathTree {
    private ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    private void FindPath(TreeNode root, int target,ArrayList<Integer> list){
        ArrayList<Integer> list1=new ArrayList<>(list);
        list1.add(root.val);
        if (root.left==null&&root.right==null&&root.val==target){
            result.add(list1);
        }
        if (root.left!=null)
            FindPath(root.left,target-root.val,list1);
        if (root.right!=null)
            FindPath(root.right,target-root.val,list1);
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        ArrayList<Integer> list=new ArrayList<>();
        if (root==null) return null;
        FindPath(root,target,list);
        return  result;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(10);
        treeNode.left=new TreeNode(5);
        treeNode.right=new TreeNode(12);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(7);
    //    treeNode.right.left=new TreeNode(7);
   //     treeNode.right.right=new TreeNode(9);
        SumPathTree sumPathTree = new SumPathTree();
        ArrayList<ArrayList<Integer>> arrayLists = sumPathTree.FindPath(null, 22);
        System.out.println(arrayLists);
    }
}
