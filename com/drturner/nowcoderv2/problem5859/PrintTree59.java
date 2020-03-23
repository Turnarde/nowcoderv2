package com.drturner.nowcoderv2.problem5859;

import com.drturner.nowcoderv2.treeNode.TreeNode;

import java.util.*;

public class PrintTree59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue=new LinkedList<>();
        Map<TreeNode,Integer> map=new HashMap<>();
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        if (pRoot==null) return lists;
        queue.offer(pRoot);
        map.put(pRoot,0);
        ArrayList<TreeNode> listtr=new ArrayList<>();
        while (!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            TreeNode node = queue.poll();
            listtr.add(node);
            if (node.left!=null) {
                queue.offer(node.left);
                map.put(node.left,map.get(node)+1);
            }
            if (node.right!=null) {
                queue.offer(node.right);
                map.put(node.right,map.get(node)+1);
            }
        }
        for (int i=0,j=0;i<=map.get(listtr.get(listtr.size()-1));i++){
            ArrayList<Integer> list=new ArrayList<>();
            while (j<listtr.size()&&map.get(listtr.get(j))==i){
                list.add(listtr.get(j++).val);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(6);
        treeNode.left.left=new TreeNode(1);
        treeNode.right.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>> print = new PrintTree59().Print(treeNode);
        System.out.println(print);
    }
}
