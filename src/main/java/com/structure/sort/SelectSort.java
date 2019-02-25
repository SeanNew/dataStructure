package com.structure.sort;

/**
 * Created by hadoop on 2019/2/25.
 * 选择排序
 * 选择排序的基本思想：
 每一趟在n-i+1（i=1,2,3…,n-1）个记录中选取关键字最小的记录与第i个记录交换，并作为有序序列中的第i个记录。

 例如：
 待排序列： 4,12,3,26,19,8,21
 第一趟： 3,12,4,26,19,8,21  下标2 换 下标 0
 第二趟： 3,4,12,26,19,8,21  下标2 换 下标 1
 第三趟： 3,4,8,26,19,12,21  下标5 换 下标 2
 第四趟： 3,4,8,12,19,26,21  下标5 换 下标 3
 第五趟： 3,4,8,12,19,26,21  下标4 换 下标 4  下标不动
 第六趟： 3,4,8,12,19,21,26  下标6 换 下标 5


 选择排序的时间复杂度为：O(n^2)，空间复杂度：O(1)
 选择排序是不稳定的；

 */
public class SelectSort {

    public static long[] sort(long[] arr){

        int min ;
        long temp;
        for(int i = 0 ; i < arr.length -1 ; i ++){//每次循环数组，找出最小的元素，放在前面，这样前面就是排序好的
            min = i;//假设最小元素下标
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //若数组中有比假设的元素还小则交换
            if(i != min){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args){
        long[] aaa = new long[]{4,12,3,26,19,8,21};
        sort(aaa);
        for (long lo:aaa){
            System.out.print(lo+" ");
        }
    }
}
