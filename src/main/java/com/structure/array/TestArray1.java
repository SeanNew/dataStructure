package com.structure.array;

/**
 * Created by hadoop on 2019/2/22.
 */
public class TestArray1 {
    public static void main(String[] args){

        //创建数组
        int[] arr1 = new int[5];
        String[] sarr1 = new String[3];
        int[] arr2 = new int[]{1,2,3};

        //int数组只指定数组长度  不指定元素  则数组中的元素为0
        System.out.println(arr1.length);
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        //String数组只指定数组长度  不指定元素  则数组中的元素为null
        System.out.println(sarr1[0]);
        System.out.println(sarr1[1]);

        System.out.println(arr2[1]);
        arr2[1] = 12;
        System.out.println(arr2[1]);

    }
}
