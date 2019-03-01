package com.structure.linkList;

/**
 * Created by hadoop on 2019/3/1.
 * 单向链表
 */
public class SingleLinkedList {

    /**
     * 定义链表节点
     */
    public class Node{
        //数据域
        private long data;
        //指针域
        private Node next;

        public Node(long data){
            this.data = data;
        }
    }

    //头节点
    private Node firstNode;

    /**
     * 插入节点，在头节点插入
     *
     */
    public void addHead(long data){
        Node newnode = new Node(data);
        if(firstNode == null){
            firstNode = newnode;
        }else{
            newnode.next = firstNode;
            firstNode = newnode;
        }
    }

    /**
     * 删除节点，删除头节点
     * 如果链表为空 则无法删除  抛出异常
     */
    public long deleteHead(){
        long l = firstNode.data;
        firstNode = firstNode.next;
        return l;
    }

    /**
     * 判断列表是否为空
     */
    public boolean empty(){
        return firstNode == null;
    }

    /**
     * 查找指定节点，找到返回node，找不到返回null
     * 若有多个，这里只返回的是第一个node
     */
    public Node find(long data){
        Node node = firstNode;
        if(firstNode == null){
            return null;
        }else {
            while (node != null){
                if(node.data == data){
                    return node;
                }else{
                    node = node.next;
                }
            }
        }
        return null;
    }

    /**
     * 删除指定元素，删除成功返回ture，否则返回false
     * 查找到指定元素 将指定元素的上一个节点的next指向指定元素的下一个节点
     */
    public boolean delete(long data) {
        if (firstNode == null) {
            return false;
        }else {
            Node currentNode = firstNode;
            Node preNode = firstNode;
            boolean result = false;
            while (currentNode != null) {
                if (currentNode.data == data) {
                    preNode.next = currentNode.next;
                    currentNode = currentNode.next;
                    result = true;
                } else {
                    preNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
            if(firstNode.data == data){
                deleteHead();
                result = true;
            }
            return result;
        }
    }

    /**
     * 显示节点信息。
     */
    public void display(){
        Node node = firstNode;
        while (node != null){
            System.out.print(node.data+" ->");
            node = node.next;
        }
    }

    public static void main(String[] args){
        SingleLinkedList sll = new SingleLinkedList();
        System.out.println(sll.delete(1));
        sll.addHead(10);
        System.out.println(sll.delete(12));
        sll.addHead(12);
        System.out.println(sll.delete(12));
        sll.addHead(1);
        sll.addHead(20);
        sll.addHead(14);
        sll.addHead(8);
        sll.addHead(12);
        System.out.println(sll.delete(12));
        sll.display();



        /*sll.display();

        System.out.println(sll.find(12).data);

        sll.deleteHead();
        System.out.println();
        sll.display();*/
    }
}
