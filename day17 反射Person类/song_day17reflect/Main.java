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
		 * 1.��ȡ�����İ���������
		 */
//		 Person demo = new Person();
//		 System.out.println(demo.getClass().getName());
		/**
		 * 2.ʵ����Class�����
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
//		System.out.println("������	"+model1.getName());
//		System.out.println("������	"+model2.getName());
//		System.out.println("������	"+model3.getName());
		/**
		 * 3.
		 * ͨ��Classʵ�������������
		 * ͨ���޲ι���ʵ��������(���û���޲ι��췽��������쳣)
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
		 * 4.ͨ��Class���ù��캯��/ͨ��Class������Ķ���
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
//		//��ȡȫ���Ĺ��캯��
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
		 * 5.������ʵ�ֵĽӿ�
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Chinese");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		//���еĽӿ�
//		Class<?> interfaces[] = demo.getInterfaces();
//		for(int i = 0 ; i< interfaces.length ; i++){
//			System.out.println("ʵ�ֵĽӿ� " + interfaces[i].getName());
//		}
		/**
		 * 6.��ȡ����
		 */
//		Class<?> demo = null ;
//		try {
//			demo = Class.forName("reflect.Chinese");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Class<?> temp = demo.getSuperclass();
//		System.out.println("Chinese�ĸ���Ϊ"+ temp.getName());
		/**
		 * 7.��ȡȫ�����캯��
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		Constructor<?> cons[] = demo.getConstructors();
//		for(int i = 0 ; i < cons.length ; i++){
//			System.out.println("���췽���� "+cons[i]);
//		}
		/**
		 * 8.��ȡ���췽�������η�
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
//			System.out.print("���췽����      ");
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
		 * 9.��ȡ���еķ���
		 * ע�⣺��ȡ���з���������˽�У�����Ҫ��XXDeclaredMethod
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
		 * 10.��ȡȫ������
		 */
//		Class<?> demo = null;
//		try {
//			demo = Class.forName("reflect.Person");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println("==============��������=============");
//		Field[] fieldSelf = demo.getDeclaredFields();
//		for(int i = 0 ; i < fieldSelf.length ; i++){
//			int modInt = fieldSelf[i].getModifiers();
//			String modifier = Modifier.toString(modInt);
//			Class<?> type = fieldSelf[i].getType();
//			System.out.println(modifier + " " + type.getName()+ " "+fieldSelf[i].getName()+";");
//		}
//		System.out.println("===============���ࡢ�ӿڵ�����");
//		Field[] fieldAll = demo.getFields();
//		for(int j = 0 ; j < fieldAll.length ; j ++){
//			int modInt = fieldAll[j].getModifiers();
//			String modifier = Modifier.toString(modInt);
//			Class<?> type = fieldAll[j].getType();
//			System.out.println(modifier+" " + type.getName()+" "+fieldAll[j].getName()+";");
//		}
		/**
		 * 11.���÷���
		 * ע�⣺����˽�з�����Ҫ�ڷ�������֮ǰ����setAccessible(true)
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
		 * 12����get set����
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
//		setter(obj,"Sex","��",String.class);
//		getter(obj, "Sex");
		/**
		 * 13.�޸�����
		 */
//		Class<?> demo = null ;
//		Object object = null ;
//		try {
//			demo = Class.forName("reflect.Person");
//			object = demo.newInstance();
//			Field field = demo.getDeclaredField("sex");
//			field.setAccessible(true);
//			field.set(object, "��");
//			System.out.println(field.get(object));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		/**
		 * 14.�޸������ֵ
		 */
//		int[] temp = {1,2,3,4,5};
//		Class<?> demo = temp.getClass().getComponentType();
//		System.out.println("��������: "+demo.getName());
//		System.out.println("���鳤��: "+Array.getLength(temp));
//		System.out.println("����ĵ�һ��Ԫ�أ�"+Array.get(temp, 0));
//		Array.set(temp, 0, 100);
//		System.out.println("�޸�֮���һ��Ԫ��Ϊ��"+Array.get(temp,0));
		/**
		 * 15.�޸������С
		 */
//		int[] temp = {1,2,3,4,5,6,7,8,9};
//		int[] newTemp =(int[])arrayInc(temp,15);
//		print(newTemp);
//		System.out.println("================");
//		String[] atr = {"a","b","c"};
//		String[] str1 = (String[])arrayInc(atr,8);
//		print(str1);
		/**
		 * 16.��ȡ�������
		 */
//		class test{}
//		test t = new test();
//		Person p = new Person();
//		System.out.println("�������    "+p.getClass().getClassLoader().getClass().getName());
				
	}
	
	/**
	 * ����get����
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
	 * ����set����
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
	 * �޸������С
	 */
	public static Object arrayInc(Object obj , int len){
		Class<?> arr = obj.getClass().getComponentType();
		Object newArray =Array.newInstance(arr, len);
		int co = Array.getLength(obj);
		System.arraycopy(obj, 0, newArray, 0, co);
		return newArray;
	}
	
	/**
	 * ��ӡ����
	 */
	public static void print(Object obj){
		Class<?> c = obj.getClass();
		if(!c.isArray()){
			return;
		}
		System.out.println("���鳤��Ϊ�� "+Array.getLength(obj));
		for(int i = 0 ; i < Array.getLength(obj);i++){
			System.out.print(Array.get(obj, i)+" ");
		}
	}
}


















