package com.exercise.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 2019/3/28.
 * 测试反射代码
 */
public class DogReflectTest {
    public static void main(String[] args) {
        /**
         * 正常调用
         */
        Dog dog = new Dog();
        dog.setName("shanshan");
        System.out.println("---dog name---" + dog.getName());

        /**
         * 使用反射
         */
        try {
            //1,获取类的 Class 对象实例
            Class cla = Class.forName(Dog.class.getName());
            //2,根据 Class 对象实例获取 Constructor 对象
            Constructor constructor = cla.getConstructor();
            //3,使用 Constructor 对象的 newInstance 方法获取反射类对象
            Object obj = null;
            try {
                obj = constructor.newInstance();
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
                setAgeMethod.invoke(obj, 12);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //4.3 获取结果
            Method getAgeMethod = cla.getMethod("getAge");
            try {
                System.out.println("---dog age---" + getAgeMethod.invoke(obj));
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

        getAllclassUseDeclared();
    }


    /**
     * 反射常用API
     */
    /**
     * 1,获取反射中的class对象
     在反射中，要获取一个类或调用一个类的方法，我们首先需要获取到该类的 Class 对象。
     在 Java API 中，获取 Class 类对象有三种方法：
     */
    public static void getClassUseReflect() throws ClassNotFoundException {
        //第一种，使用 Class.forName 静态方法。当你知道该类的全路径名时，你可以使用该方法获取 Class 类对象。
        Class class1 = Class.forName("com.exercise.reflect.Dog");
        //第二种，使用 .class 方法。 这种方法只适合在编译前就知道操作的 Class。
        Class class2 = Dog.class;
        //第三种，使用类对象的 getClass() 方法。
        String string = new String("Dog");
        Class class3 =string.getClass();
    }

    /**
     * 通过反射创建类对象
     通过反射创建类对象主要有两种方式：
     通过 Class 对象的 newInstance() 方法、
     通过 Constructor 对象的 newInstance() 方法。
     */
    public static void getObj() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //第一种：通过 Class 对象的 newInstance() 方法。
        Class cla = Dog.class;
        Dog dog1 = (Dog) cla.newInstance();

        //第二种：通过 Constructor 对象的 newInstance() 方法
        Constructor constructor = cla.getConstructor();
        Dog dog2 = (Dog) constructor.newInstance();
        //通过 Constructor 对象创建类对象可以选择特定构造方法，
        //而通过 Class 对象则只能使用默认的无参数构造方法。
        //下面的代码就调用了一个有参数的构造方法进行了类对象的初始化。
        Constructor constructor2 = cla.getConstructor(String.class,int.class);
        Dog dog3 = (Dog) constructor2.newInstance("xiaoming",11);
    }

    /**
     * 通过反射获取类属性、方法、构造器
     */
    public static void getAllclassUseDeclared(){
        //我们通过 Class 对象的 getFields() 方法可以获取 Class 类的属性，但无法获取私有属性。
        Class clz = Dog.class;
        Field[] fields = clz.getFields();
        for (Field field : fields) {
            System.out.println("--1--"+field.getName());
        }

        //而如果使用 Class 对象的 getDeclaredFields() 方法则可以获取包括私有属性在内的所有属性：
        //与获取类属性一样，当我们去获取类方法、类构造器时，如果要获取私有方法或私有构造器，
        //则必须使用有 declared 关键字的方法。
        Field[] fields2 = clz.getDeclaredFields();
        for (Field field2 : fields2) {
            System.out.println("--2--"+field2.getName());
        }
    }
}
