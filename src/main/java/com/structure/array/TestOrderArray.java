package com.structure.array;

/**
 * 自定义String数组封装类
 * 有序数组
 */
public class TestOrderArray {
    private long[] arr;
    //表示有效数据的长度
    private int element;
    //默认构造方法
    public TestOrderArray(){
        arr =new long[50];
    }
    public TestOrderArray(int element){
        arr = new long[element];
    }

    /**
     * 添加数据  有序数组添加元素需要进行元素大小的比较
     */
    public void insert(long value){
        int i;
        for(i = 0 ; i < element ; i ++){
            if(arr[i] > value){
                break;
            }
        }
        for(int j = element ; j > i ;j --){
            arr[j] = arr[j-1];
        }
        arr[i] = value;
        element ++ ;
    }
    /**
     * 显示数组所有元素
     */
    public void display(){
        System.out.print("[");
        for (int i = 0; i < element ;i ++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }

    /**
     * 根据值查找数据返回下标
     */
    public int search(long value){
        int i ;
        for(i =0 ; i< element ;i++){
            if(value==arr[i]){
                break;
            }
        }
        if(i == element){
            return -1;
        }
        return i;
    }
    /**
     * 二分法查找
     * 根据值查找下标
     */
    public int binarySearch(long value){
        int middle;
        int left = 0;
        int right = element;
        while (true){
            middle = (left + right) / 2;
            if(arr[middle] == value){
                return middle;
            }else if(left > right){
                return -1;
            }else{
                if(arr[middle] > value){
                    right = middle - 1;
                }else {
                    left = middle + 1;
                }
            }
        }
    }
    /**
     * 根据下标查找值 返回值
     */
    public long get(int index){
        if(index >= element || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return arr[index];
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
                arr[i] = arr[i + 1];
            }
            element -= 1;
        }
    }
    /**
     * 更新数据
     */
    public void update(int index , long newvalue){
        if(index >= element || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            arr[index] = newvalue;
        }
    }

}
