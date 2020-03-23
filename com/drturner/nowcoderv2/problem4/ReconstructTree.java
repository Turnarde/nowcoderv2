package com.drturner.nowcoderv2.problem4;

import com.drturner.nowcoderv2.treeNode.TreeNode;

public class ReconstructTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int preStart,int preEnd, int [] in,int inStart,int inEnd) {
        int part=-1;
        if (preStart<0||inEnd<0) return null;
        if (preStart>preEnd||inStart>inEnd){
            return null;
        }
        for (int i=inStart;i<=inEnd;i++){
            if (in[i]==pre[preStart]){
                part=i;
                break;
            }
        }
        TreeNode treeNode=new TreeNode(pre[preStart]);
        treeNode.left=reConstructBinaryTree(pre,preStart+1,preStart+part-inStart,in,inStart,part-1);
        treeNode.right=reConstructBinaryTree(pre,preStart+part-inStart+1,preEnd,in,part+1,inEnd);
        return treeNode;
    }

    public static void main(String[] args) {
        int []pre={1,2,4,7,3,5,6,8};
        int [] in={4,7,2,1,5,3,8,6};
        TreeNode treeNode = new ReconstructTree().reConstructBinaryTree(pre, in);
        TreeNode.print(treeNode);
    }
}
