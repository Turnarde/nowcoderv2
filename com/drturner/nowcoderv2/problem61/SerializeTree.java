package com.drturner.nowcoderv2.problem61;

import com.drturner.nowcoderv2.treeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class SerializeTree {
    String Serialize(TreeNode root) {
        if (root==null) return "#!";
        String s1="";
        String s2="";

        s1 = Serialize(root.left);
        s2 = Serialize(root.right);

        return root.val+"!"+s1+s2;
    }
    TreeNode Deserialize(String str) {
        String[] split = str.split("!");
        Queue<String> queue=new LinkedList<>();
        for (String s:split){
            queue.offer(s);
        }
        return preTrack(queue);
    }
    TreeNode preTrack(Queue<String> queue){
        if (queue.isEmpty()) return null;
        if ("#".equals(queue.peek())){
            queue.poll();
            return null;
        }
        TreeNode treeNode=new TreeNode(Integer.parseInt(queue.poll()));
        treeNode.left=preTrack(queue);
        treeNode.right=preTrack(queue);
        return treeNode;
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(6);
        treeNode.left.left=new TreeNode(1);
        treeNode.right.right=new TreeNode(7);
        String serialize = new SerializeTree().Serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = new SerializeTree().Deserialize(serialize);
        TreeNode.print(deserialize);
    }
}
