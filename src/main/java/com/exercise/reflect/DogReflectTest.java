package com.exercise.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 2019/3/28.
 * 测试反射代码
 */
public class DogReflectTest {
    public static void main(String[] args) {
        //正常调用
        Dog dog = new Dog();
        dog.setName("shanshan");
        System.out.println("---dog name---" + dog.getName());

        //使用反射
        try {
            //1,获取类的 Class 对象实例
            Class cla = Class.forName(Dog.class.getName());
            //2,根据 Class 对象实例获取 Constructor 对象
            Constructor constructor = cla.getConstructor();
            //3,使用 Constructor 对象的 newInstance 方法获取反射类对象
            Object obj = null;
            try {
                obj =constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //4,而如果要调用某一个方法，则需要经过下面的步骤：
            //4.1 获取方法的 Method 对象
            Method setAgeMethod = cla.getMethod("setAge", int.class);

            //4.2 利用 invoke 方法调用方法
            try {
                setAgeMethod.invoke(obj,12);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //4.3 获取结果
            Method getAgeMethod = cla.getMethod("getAge");
            try {
                System.out.println("---dog age---"+getAgeMethod.invoke(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
