package com.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的操作类
 * Created by hadoop on 2018/12/29.
 */
public class TreeTools {
    /*判断树中的节点个数*/
    public static <T> int getTreeNnm(TreeNode<T> root){
        if(root == null){
            return 0;
        }
        return getTreeNnm(root.leftChild)+getTreeNnm(root.rightChild)+1;
    }
    /*判断树的深度*/
    public static <T> int getTreeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = getTreeDepth(root.leftChild) + 1;
        int rightDepth = getTreeDepth(root.rightChild) + 1;
        return Math.max(leftDepth,rightDepth);
    }
    /*访问node节点*/
    private static <T> void visitNode(TreeNode node){
        System.out.println(node.value + "\t");

    }
    /*前序遍历*/
    public static <T> void preOrderTravel(TreeNode root){
        if(root == null) return;
        visitNode(root);
        preOrderTravel(root.leftChild);
        preOrderTravel(root.rightChild);
    }
    /*中序遍历*/
    public static <T> void midOrderTravel(TreeNode root){
        if(root == null) return;
        midOrderTravel(root.leftChild);
        visitNode(root);
        midOrderTravel(root.rightChild);
    }
    /*后序遍历*/
    public static <T> void backOrderTravel(TreeNode root){
        if (root == null) return;
        backOrderTravel(root.leftChild);
        backOrderTravel(root.rightChild);
        visitNode(root);
    }
    /*分层遍历*/
    public static <T> void levelTravel(TreeNode root){
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode<T> temp = queue.poll();
            visitNode(temp);
            if (temp.leftChild != null){
                queue.offer(temp.leftChild);
            }
            if(temp.rightChild != null){
                queue.offer(temp.rightChild);
            }
        }
    }
    /*求第K层节点个数*/
    public static <T> int getNumForKlevel(TreeNode<T> root,int k){
        if (root == null || k <1){
            return 0;
        }
        if (k == 1 ) return 1;
        int leftNum = getNumForKlevel(root.leftChild,k-1);
        int rightNum = getNumForKlevel(root.rightChild,k - 1);
        return leftNum + rightNum;
    }
    /*求二叉树中叶子节点的个数*/

    /*交换根节点的左右子树*/

    /*查看node是否是root的子节点*/

    /*返回两个节点lnode和rnode的以root为根节点的公共父节点 */

    /*根据前序和中序构建二叉树*/

    /*查看node1和node2两棵树是否相等(两棵树所有节点都相等)*/
}
