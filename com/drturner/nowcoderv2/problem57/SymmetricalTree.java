package com.drturner.nowcoderv2.problem57;

import com.drturner.nowcoderv2.treeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collection;

public class SymmetricalTree {
    ArrayList<String> list=new ArrayList<>();
    private boolean symmetricalSub(TreeNode left,TreeNode right){
        if (left==null) return right==null;
        if (right==null) return false;
        if (left.val!=right.val) return false;
        return symmetricalSub(left.left,right.right)&&symmetricalSub(left.right,right.left);
    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null) return true;
        return symmetricalSub(pRoot.left,pRoot.right);
    }
    private void MidTrace(TreeNode pRoot){
        if (pRoot==null){
            list.add("#");
        }
        MidTrace(pRoot.left);
        list.add(String.valueOf(pRoot.val));
        list.add("#");
        MidTrace(pRoot.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
    //    treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(1);
       //ArrayList
        //Collection
      //  System.arraycopy();
        boolean symmetrical = new SymmetricalTree().isSymmetrical(treeNode);
        System.out.println(symmetrical);
    }
}
