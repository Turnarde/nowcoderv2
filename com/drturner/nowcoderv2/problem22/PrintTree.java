package com.drturner.nowcoderv2.problem22;

import com.drturner.nowcoderv2.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList();
        if (root==null) return list;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left!=null)
                queue.offer(poll.left);
            if (poll.right!=null)
                queue.offer(poll.right);
        }
        return list;
    }
}
