package com.structure.tree;

/**
 * Created by hadoop on 2018/12/29.
 * 普通的树节点
 */
public class TreeNode<T> {
    T value;

    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode() {
    }

    /*增加左子节点*/
    public void addLeft(T value){
        TreeNode<T> leftChid = new TreeNode<T>(value);
        this.leftChild = leftChid;
    }
    /*增加右子节点*/
    public void addRight(T value){
        TreeNode<T> rightChild = new TreeNode<T>(value);
        this.rightChild = rightChild;
    }
    /**重载equals方法
    *
    * instanceof关键字的作用是判断一个对象是否是一个具体类的实例，
    * 我们在重写equals方法中要先判断是否是同一对象，之后再判断一个对象是否是另一个的实例，
    * 如果是判断各个属性值以判断是否是同一对象，不是一定不是同一对象。
    * */
    public boolean equals(Object object){
        if(! (object instanceof TreeNode)){
            return false;
        }
        if(this.value.equals(((TreeNode) object).value)){
            return true;
        }else{
            return false;
        }
    }
    /*重载hashCode方法*/
    public int hashCode(){
        return this.value.hashCode();
    }
    /*重写toString方法*/
    public String toString(){
        return this.value==null ? "" :this.value.toString();
    }
}
