package com.drturner.nowcoderv2.problem17;

import com.drturner.nowcoderv2.treeNode.TreeNode;

public class SubStructure {
    public boolean HasSubtree(TreeNode root1, TreeNode root2){
        if (root2==null) return false;
        return hasSubtree(root1,root2);
    }
    private boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2!=null) return false;
        if (root2==null) return true;
        if (root1.val==root2.val)
            return (hasSubtree(root1.left,root2.left)&&hasSubtree(root1.right,root2.right))||(hasSubtree(root1.left,root2))||(hasSubtree(root1.right,root2));
        else
            return hasSubtree(root1.left,root2)||hasSubtree(root1.right,root2);
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(8);
        treeNode.left=new TreeNode(8);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(8);
        treeNode.right.left=new TreeNode(10);
        TreeNode root2=new TreeNode(8);
        root2.left=new TreeNode(4);
        root2.right=new TreeNode(8);
        System.out.println(new SubStructure().HasSubtree(treeNode, root2));
    }
}
