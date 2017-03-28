package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) {
		/**
		 * 1.获取完整的包名和类名
		 */
//		 Person demo = new Person();
//		 System.out.println(demo.getClass().getName());
		/**
		 * 2.实例化Class类对象
		 */
//		Class<?> model1 = null;
//		Class<?> model2 = null;
//		Class<?> model3 = null;
//		try {
//			model1 = Class.forName("reflect.Model");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		model2 = new Model().getClass();
//		model3 = Model.class;
//		System.out.println("类名称	"+model1.getName());
//		System.out.println("类名称	"+model2.getName());
//		System.out.println("类名称	"+model3.getName());
		/**
		 * 3.
		 * 通过Class实例化其他类对象
		 * 通过无参构造实例化对象(如果没有无参构造方法会出现异常)
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Person person = null;
//		try {
//			person = (Person) demo.newInstance();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		person.setName("SongHua");
//		person.setAge(12);
//		System.out.println(person);
		/**
		 * 4.通过Class调用构造函数/通过Class创建类的对象
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Person person1 = null;
//		Person person2 = null;
//		Person person3 = null;
//		Person person4 = null;
//		//获取全部的构造函数
//		Constructor<?> cons[]= demo.getConstructors();
//		try{
////			int a1 = cons[0].getParameterTypes().length;
////			int a2 = cons[1].getParameterTypes().length;
////			int a3 = cons[2].getParameterTypes().length;
////			int a4 = cons[3].getParameterTypes().length;
////			System.out.println(a1+","+a2+","+a3+","+a4);
//			person1 = (Person) cons[0].newInstance("SongHua",20);
//			person2 = (Person) cons[1].newInstance(12);
//			person3 = (Person) cons[2].newInstance("SongHua");
//			person4 = (Person) cons[3].newInstance();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println(person1);
//		System.out.println(person2);
//		System.out.println(person3);
//		System.out.println(person4);
		/**
		 * 5.返回类实现的接口
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Chinese");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		//所有的接口
//		Class<?> interfaces[] = demo.getInterfaces();
//		for(int i = 0 ; i< interfaces.length ; i++){
//			System.out.println("实现的接口 " + interfaces[i].getName());
//		}
		/**
		 * 6.获取父类
		 */
//		Class<?> demo = null ;
//		try {
//			demo = Class.forName("reflect.Chinese");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Class<?> temp = demo.getSuperclass();
//		System.out.println("Chinese的父类为"+ temp.getName());
		/**
		 * 7.获取全部构造函数
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Constructor<?> cons[] = demo.getConstructors();
//		for(int i = 0 ; i < cons.length ; i++){
//			System.out.println("构造方法： "+cons[i]);
//		}
		/**
		 * 8.获取构造方法的修饰符
		 */
//		Class<?> demo = null ;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Constructor<?> cons[] = demo.getConstructors();
//		for(int i = 0 ; i< cons.length; i++ ){
//			Class<?> paramType[] = cons[i].getParameterTypes();
//			System.out.print("构造方法：      ");
//			int mo = cons[i].getModifiers();
//			System.out.print(Modifier.toString(mo)+" ");
//			System.out.print(cons[i].getName());
//			System.out.print("(");
//			for(int j =0 ; j < paramType.length; j ++){
//				System.out.print(paramType[j].getName()+" arg"+i);
//				if(j<paramType.length-1){
//					System.out.print(" , ");
//				}
//			}
//			System.out.println("){}");
//		}
		/***
		 * 9.获取所有的方法
		 * 注意：获取所有方法（包括私有）的需要用XXDeclaredMethod
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Method[]  method = demo.getMethods();
//		for(int i = 0 ; i < method.length ; i ++){
//			Class<?> returnType = method[i].getReturnType();
//			Class<?> paraTypes[] = method[i].getParameterTypes();
//			int modifier = method[i].getModifiers();
//			System.out.print(Modifier.toString(modifier)+" ");
//			System.out.print(returnType.getName()+" ");
//			System.out.print(method[i].getName()+" ");
//			System.out.print("(");
//			for(int j = 0 ;j < paraTypes.length ; j++){
//				System.out.print(paraTypes[j].getName()+" arg"+j);
//				if(j<paraTypes.length-1){
//					System.out.print(" , ");
//				}
//			}
//			Class<?>[] exceptions = method[i].getExceptionTypes();
//			if(exceptions.length>0){
//				System.out.print(" ) throws ");
//				for(int k = 0 ; k < exceptions.length; k++){
//					System.out.print(exceptions[k].getName()+" ");
//					if(k<exceptions.length-1){
//						System.out.print(" , ");
//					}
//				}
//			}else{
//				System.out.print(" )");
//			}
//			System.out.println();
//		}
		/**
		 * 10.获取全部属性
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println("==============本类属性=============");
//		Field[] fieldSelf = demo.getDeclaredFields();
//		for(int i = 0 ; i < fieldSelf.length ; i++){
//			int modInt = fieldSelf[i].getModifiers();
//			String modifier = Modifier.toString(modInt);
//			Class<?> type = fieldSelf[i].getType();
//			System.out.println(modifier + " " + type.getName()+ " "+fieldSelf[i].getName()+";");
//		}
//		System.out.println("===============父类、接口的属性");
//		Field[] fieldAll = demo.getFields();
//		for(int j = 0 ; j < fieldAll.length ; j ++){
//			int modInt = fieldAll[j].getModifiers();
//			String modifier = Modifier.toString(modInt);
//			Class<?> type = fieldAll[j].getType();
//			System.out.println(modifier+" " + type.getName()+" "+fieldAll[j].getName()+";");
//		}
		/**
		 * 11.调用方法
		 * 注意：调用私有方法需要在方法调用之前加上setAccessible(true)
		 */
//		Class<?> demo = null ;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			Method method = demo.getDeclaredMethod("sayHello");
//			method.setAccessible(true);
//			method.invoke(demo.newInstance());
//
//			method = demo.getMethod("sayNameAge", String.class, int.class);
//			method.invoke(demo.newInstance(),"SongHua",20);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		/**
		 * 12调用get set方法
		 */
//		Class<?> demo = null ;
//		Object obj = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			obj = demo.newInstance();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		setter(obj,"Sex","男",String.class);
//		getter(obj, "Sex");
		/**
		 * 13.修改属性
		 */
//		Class<?> demo = null ;
//		Object object = null ;
//		try {
//			demo = Class.forName("reflect.Person");
//			object = demo.newInstance();
//			Field field = demo.getDeclaredField("sex");
//			field.setAccessible(true);
//			field.set(object, "男");
//			System.out.println(field.get(object));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		/**
		 * 14.修改数组的值
		 */
//		int[] temp = {1,2,3,4,5};
//		Class<?> demo = temp.getClass().getComponentType();
//		System.out.println("数组类型: "+demo.getName());
//		System.out.println("数组长度: "+Array.getLength(temp));
//		System.out.println("数组的第一个元素："+Array.get(temp, 0));
//		Array.set(temp, 0, 100);
//		System.out.println("修改之后第一个元素为："+Array.get(temp,0));
		/**
		 * 15.修改数组大小
		 */
//		int[] temp = {1,2,3,4,5,6,7,8,9};
//		int[] newTemp =(int[])arrayInc(temp,15);
//		print(newTemp);
//		System.out.println("================");
//		String[] atr = {"a","b","c"};
//		String[] str1 = (String[])arrayInc(atr,8);
//		print(str1);
		/**
		 * 16.获取类加载器
		 */
//		class test{}
//		test t = new test();
//		Person p = new Person();
//		System.out.println("类加载器    "+p.getClass().getClassLoader().getClass().getName());
				
	}
	
	/**
	 * 调用get方法
	 * @param obj
	 * @param att
	 */
	public static void getter(Object obj ,String att){
		try {
			Method method = obj.getClass().getMethod("get"+ att);
			System.out.println(method.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 调用set方法
	 * @param obj
	 * @param att
	 * @param value
	 * @param type
	 */
	public static void setter(Object obj , String att , Object value , Class<?> type ){
		try {
			Method method = obj.getClass().getMethod("set"+att,type);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 修改数组大小
	 */
	public static Object arrayInc(Object obj , int len){
		Class<?> arr = obj.getClass().getComponentType();
		Object newArray =Array.newInstance(arr, len);
		int co = Array.getLength(obj);
		System.arraycopy(obj, 0, newArray, 0, co);
		return newArray;
	}
	
	/**
	 * 打印数组
	 */
	public static void print(Object obj){
		Class<?> c = obj.getClass();
		if(!c.isArray()){
			return;
		}
		System.out.println("数组长度为： "+Array.getLength(obj));
		for(int i = 0 ; i < Array.getLength(obj);i++){
			System.out.print(Array.get(obj, i)+" ");
		}
	}
}


















