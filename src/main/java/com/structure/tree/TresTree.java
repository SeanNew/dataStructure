package com.structure.tree;

/**
 * Created by hadoop on 2018/12/29.
 */
public class TresTree {
    public static void main(String[] args){
        /*创建 树*/
        TreeNode<Integer> t = new TreeNode<Integer>(1);
        t.addLeft(2);
        t.addRight(3);
        t.leftChild.addLeft(4);
        t.leftChild.addRight(5);
        t.rightChild.addLeft(6);
        t.rightChild.addRight(7);

        System.out.println("中序遍历");
        TreeTools.midOrderTravel(t);
        System.out.println("\n前序遍历测试:");
        TreeTools.preOrderTravel(t);
        System.out.println("\n后序遍历测试:");
        TreeTools.backOrderTravel(t);

    }
}
