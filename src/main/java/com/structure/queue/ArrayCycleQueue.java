package com.structure.queue;

/**
 * Created by hadoop on 2019/3/1.
 * 最简单的 单向队列  使用数组实现
 */
public class ArrayCycleQueue {
    //底层使用数组实现
    private long[] arr;
    //有效数据大小
    private int elements;
    //队头
    private int front;
    //队尾
    private int end;

    /**
     * 默认构造方法
     * 初始化队列大小、队头队尾
     */
    public ArrayCycleQueue() {
        arr = new long[20];
        elements = 0;
        front = 0;
        end = -1;
    }

    /**
     * 带参数的构造方法
     */
    public ArrayCycleQueue(int maxSize){
        arr = new long[maxSize];
        elements = 0;
        front = 0;
        end = -1;
    }

    /**
     *插入数据，队尾插入
     */
    public void insert(long value){
        if (end == arr.length - 1){
            end = -1;
        }
        arr[++end] = value;
        elements ++;
    }

    /**
     * 删除数据，队头删除
     */

    public long remove(){
        elements -- ;
        if(front == arr.length ){
            front = 0;
        }
        return arr[front ++];
    }

    /**
     * 查看数据，但不删除
     */
    public long peek(){
        return arr[front];
    }

    /**
     * 判断队列是否为空
     */
    public boolean empty(){
        return elements == 0 ;
    }

    /**
     * 判断队列是否为满
     */
    public boolean full(){
        return elements == arr.length;
    }

    /**
     * 查看队列所有元素
     */
    public String toStrings(){
        String result = "[";
        for(long lon:arr){
            result += lon+ " ";
        }
        return result+"]";
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        ArrayCycleQueue aq = new ArrayCycleQueue(5);
        aq.insert(13);
        aq.insert(1);
        aq.insert(34);
        aq.insert(22);
        aq.insert(29);
        System.out.println(aq.remove());
        aq.insert(19);
        System.out.println(aq.remove());
        aq.insert(18);
        System.out.println(aq.remove());
        aq.insert(8);
        System.out.println(aq.remove());
        aq.insert(5);
        System.out.println(aq.remove());
        aq.insert(25);
        System.out.println(aq.remove());
        aq.insert(35);
        System.out.println(aq.peek());
        System.out.println(aq.toStrings());
        System.out.println(aq.full());
        System.out.println(aq.empty());
    }

}
