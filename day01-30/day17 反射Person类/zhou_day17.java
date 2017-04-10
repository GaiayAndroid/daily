package com.zc.constrainttest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射调用打印方法
 * 获取所有属性classz.getDeclaredFields()；
 * 获取修饰符：Modifier.toString(classz.getModifiers()
 * <p>
 * <p>
 * Created by zc on 2017/3/15.
 */

public class Test3_15 {

    private void newInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //反射机制获取类有三种方法
        Class c = Class.forName("com.zc.constrainttest.Person");
        //
        Class c2 = Person.class;
        //
        Person person = new Person(0);
        Class c3 = person.getClass();

        //创建对象：获取类以后我们来创建它的对象，利用newInstance
        //创建此Class 对象所表示的类的一个新实例
        Object o = c.newInstance(); //调用了Person的无参数构造方法.

    }

    @Test
    public void reflect() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Person foot = new Person();

        Class classz = foot.getClass();

//        Class c = Class.forName("java.lang.Integer");

// 1. 获取所有的属性---------------------------

        Field[] fs = classz.getDeclaredFields();

        //定义可变长的字符串，用来存储属性
        StringBuffer sb = new StringBuffer();
        sb.append(Modifier.toString(classz.getModifiers()) + " class " + classz.getSimpleName() + "{\n");//获取修饰符，类名
        System.out.println("类的所有的属性--------------");
        //里边的每一个属性
        for (Field field : fs) {
            sb.append("\t");//空格
            sb.append(Modifier.toString(field.getModifiers()) + " ");//获得属性的修饰符，例如public，static等等
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
            sb.append(field.getName() + ";\n");//属性的名字+回车
        }
        System.out.println(sb);



         System.out.println("类的方法-------------");
//3.打印方法
        Method[] methods = classz.getDeclaredMethods();
        StringBuffer sbMethod = new StringBuffer();
//        Method[] methods =  classz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            sbMethod.append("\t");//空格
            sbMethod.append(Modifier.toString(methods[i].getModifiers()) + " ");
            sbMethod.append(methods[i].getReturnType().getSimpleName() + " ");//返回类型
            sbMethod.append(methods[i].getName() + " (");//方法的名字

            //方法参数
            Class paramerTypes[] = methods[i].getParameterTypes();

            for (int t = 0; t < paramerTypes.length; t++) {
                String name = paramerTypes[t].getSimpleName();

                if (t == paramerTypes.length - 1) {
                    sbMethod.append(name + " arg" + t);
                } else {
                    sbMethod.append(name + " arg" + t + ", ");
                }
            }
            sbMethod.append("){}\n");

        }

        System.out.println(sbMethod);
//4.构造方法关键字
        System.out.println("构造方法-------------");

        StringBuffer constr = new StringBuffer();
//        Constructor [] ct = classz.getConstructors();//得到公共的构造方法
        Constructor[] ct = classz.getDeclaredConstructors();//获取构造方法
        for (int c = 0; c < ct.length; c++) {
            constr.append("\t");//空格

            constr.append(Modifier.toString(ct[c].getModifiers()) + " ");//修饰符

            constr.append(ct[c].getDeclaringClass().getSimpleName() + "(");
            Class[] pct = ct[c].getParameterTypes();//参数类型
            for(int p= 0; p< pct.length ; p ++){
                String name = pct[p].getSimpleName();
                if (p == pct.length - 1) {
                    constr.append(name + " arg" + p);
                } else {
                    constr.append(name + " arg" + p + ", ");
                }
            }
            constr.append("){}\n");
        }
        constr.append("}");
        System.out.println(constr);

//5.属性赋值------------------------------------------------
        System.out.println("赋值---------------------");
        //获取name属性
        Field idF = classz.getDeclaredField("name");
        //实例化这个类赋给o
        Object o = classz.newInstance();
        //打破封装
        idF.setAccessible(true); //使用反射机制可以打破封装性，导致了java对象的属性不安全。
        //给o对象的name属性赋值"110"
        idF.set(o, "110"); //set
        //get
        System.out.println("\t" + idF.get(o));
        Field idF2 = classz.getDeclaredField("age");
        idF2.setAccessible(true);
        idF2.set(o,125);
        System.out.println("\t" + idF2.get(o));
//6.调用方法
        System.out.println("调用方法---------------------");
        Method method = classz.getDeclaredMethod("sayHello",new Class[]{});
        method.setAccessible(true);
        method.invoke(o,new Class[]{});

        Method method2 = classz.getDeclaredMethod("sayNameAge",new Class[]{String.class, int.class});
        method2.setAccessible(true);
        method2.invoke(o,new Object[]{"nihao", 120});

    }


}
