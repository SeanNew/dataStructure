package com.structure.stack;

/**
 * Created by hadoop on 2019/2/26.
 * 数组方式实现栈
 */
public class ArrayStack<T> {
    private Object[] data = null;
    //栈容量
    private int maxSize = 0;
    //栈顶指针
    private int top = -1;

    ArrayStack() {
       this(10);
    }

    ArrayStack(int initialSize){
        if(initialSize >=0){
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        }else{
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    //判断栈为空
    public boolean empty(){
        return top == -1 ? true : false;
    }

    //元素进栈，
    public boolean push (T t){
        if(top == maxSize -1){
            throw new RuntimeException("栈已满，无法将元素入栈！");
        }else {
            data[++top] = t;
            return true;
        }
    }

    //元素出栈
    public T pop(){
        if(top == -1){
            throw new RuntimeException("栈为空");
        }else{
            return (T) data[top--];
        }
    }

    //查看栈顶元素（不移除）
    public T peek(){
        if(top == -1 ){
            throw new RuntimeException("statck is empry");
        }else{
            return (T) data[top];
        }
    }


    //返回对象在栈中的位置
    public int search(T t){
        int i=top;
        while(top != -1){
            if(peek() != t){
                top --;
            }else{
                break;
            }
        }
        int result = top+1;
        top = i;
        return result;
    }

    public static void main(String[] args){
        ArrayStack as = new ArrayStack();
        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        as.push(7);
        as.push(28);
        System.out.println(as.maxSize);
        System.out.println("--------------");
        System.out.println(as.peek());
        System.out.println(as.search(7));


    }
}
