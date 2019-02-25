package com.structure.sort;

/**
 * Created by hadoop on 2019/2/22.
 * 冒泡排序
 *冒泡排序的基本思想为：
 一趟冒泡排序的过程为：
 首先将第一个记录的关键字和第二个记录的关键字进行比较，若为逆序，则将两个记录交换之，
 然后比较第二个记录的关键字和第三个记录的关键字，依次类推，
 直至第n-1个记录和第n个记录的关键字进行过比较为止；

 在冒泡排序的过程中，关键字较小的记录好比水中气泡逐趟向上漂浮，而关键字较大的记录好比石头往下沉，
 每一趟有一块“最大”的石头沉到水底。

 例如：
 待排序列：12,3,15,6,2,11,3
 第一趟： 3,12,6,2,11,3,15
 第一趟： 3,6,2,11,3,12,15
 第二趟： 3,2,6,3,11,12,15
 第三趟： 2,3,3,6,11,12,15

 冒泡排序的时间复杂度为：O(n^2)，空间复杂度为O(1)
 冒泡排序是稳定的；

 */
public class BubbleSort {
    public static void main(String[] args){
        long[] aaa = new long[]{12,3,15,6,2,11,3};

        sort(aaa);
    }

    public static long[] sort(long[] arr){
        long temp;
        for(int i = 0 ; i < arr.length -1  ; i ++){//外层循环控制排序趟数
            for(int j = 0 ; j < arr.length -1 - i ; j ++){//内层循环控制每一趟排序多少次
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(long a:arr){
            System.out.print(a+" ");
        }
        return arr;
    }
}
