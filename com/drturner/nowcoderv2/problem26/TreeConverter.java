package com.drturner.nowcoderv2.problem26;

import com.drturner.nowcoderv2.treeNode.TreeNode;

import java.util.ArrayList;

public class TreeConverter {
    ArrayList<TreeNode> list=new ArrayList<>();
    private void middleTrace(TreeNode treeNode){
        if (treeNode==null) return;
        middleTrace(treeNode.left);
        list.add(treeNode);
        middleTrace(treeNode.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {

        middleTrace(pRootOfTree);
        if (list.size()==1){
            list.get(0).left=null;
            list.get(0).right=null;
            return list.get(0);
        }
        for (int i=0;i<list.size();i++){
            if (i==0){
                list.get(i).left=null;
                list.get(i).right=list.get(1);
            }
            else if (i==list.size()-1){
                list.get(i).left=list.get(i-1);
                list.get(i).right=null;
            }
            else {
                list.get(i).left=list.get(i-1);
                list.get(i).right=list.get(i+1);
            }

        }
        return list.size()>0?list.get(0):null;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(6);
     //   treeNode.left=new TreeNode(3);
     //   treeNode.right=new TreeNode(8);
     //   treeNode.left.left=new TreeNode(2);
     //   treeNode.left.right=new TreeNode(4);
        //    treeNode.right.left=new TreeNode(7);
        //     treeNode.right.right=new TreeNode(9);
        TreeNode convert = new TreeConverter().Convert(treeNode);
        while (convert!=null){
            System.out.println(convert.val);
            convert=convert.right;
        }
    }
}
