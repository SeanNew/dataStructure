package com.structure.array;

/**
 * 有序数组
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

        TestArray2 t2 = new TestArray2();
        t2.insert("aa");
        t2.insert("bb");
        t2.insert("cc");
        t2.insert("dd");
        t2.insert("ee");
        t2.insert("ff");
        t2.display();
        System.out.println(t2.search("aa"));
        System.out.println(t2.get(2));
        t2.delete(3);
        t2.display();
        t2.update(4,"newff");
        t2.display();

        TestOrderArray to = new TestOrderArray();
        to.insert(23);
        to.insert(1);
        to.insert(29);
        to.insert(26);
        to.insert(13);
        to.insert(19);
        to.insert(9);
        to.insert(16);
        to.display();
        System.out.println(to.binarySearch(13));
    }
}
