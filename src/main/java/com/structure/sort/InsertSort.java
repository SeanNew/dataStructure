package com.structure.sort;

/**
 * 插入排序
 * Created by hadoop on 2019/2/26.
 *
 * 待排序列：12,3,15,6,2,11,3
 第1趟： 3,12,15,6,2,11,3
 第2趟： 3,6,12,15,2,11,3
 第3趟： 2,3,6,12,15,11,3
 第4趟： 2,3,6,11,12,15,3
 第5趟： 2,3,3,6,11,12,15
 */
public class InsertSort {

    public static void sort(long[] array){
        long temp = 0;
        for(int i = 1 ; i < array.length ; i ++){
            temp = array[i];
            int j = i;
            while (j > 0 && array[j-1] >=temp){
                array[j] = array[j - 1];
                j -- ;
            }
            array[j] = temp;
        }
        for (long lo : array){
            System.out.print(lo+" ");
        }
    }
    public static void main(String[] args){
        long[] arr = new long[]{12,3,15,6,2,11,3};
        sort(arr);
    }
}
