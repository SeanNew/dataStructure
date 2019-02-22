package com.structure.array;

/**
 * 自定义String数组封装类
 */
public class TestArray2 {
    private String[] strarr;
    //表示有效数据的长度
    private int element;
    //默认构造方法
    public TestArray2(){
        strarr =new String[50];
    }
    public TestArray2(int element){
        strarr = new String[element];
    }

    /**
     * 添加数据
     */
    public void insert(String value){
        strarr[element] = value;
        element ++ ;
    }
    /**
     * 显示数组所有元素
     */
    public void display(){
        System.out.print("[");
        for (int i = 0; i < element ;i ++){
            System.out.print(strarr[i]+" ");
        }
        System.out.println("]");
    }

    /**
     * 根据值查找数据返回下标
     */
    public int search(String value){
        int i ;
        for(i =0 ; i< element ;i++){
            if(value.equals(strarr[i])){
                break;
            }
        }
        if(i == element){
            return -1;
        }
        return i;
    }
    /**
     * 根据下标查找值 返回值
     */
    public String get(int index){
        if(index >= element || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return strarr[index];
        }
    }
    /**
     * 删除元素
     */
    public void delete(int index){
        if(index >= element || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            for(int i = index ; i< element ; i ++){
                strarr[i] = strarr[i + 1];
            }
            element -= 1;
        }
    }
    /**
     * 更新数据
     */
    public void update(int index , String newvalue){
        if(index >= element || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            strarr[index] = newvalue;
        }
    }

}
