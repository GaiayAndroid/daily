package reflect;

import java.lang.reflect.Method;

/** 
 * <p> 
 * Title: ˽�з������ù����� 
 * </p> 
 *  
 * <p> 
 * Description:����java���������ĵ�˽�з��� 
 * </p> 
 * */
public class PrivateUtil {
	 /** 
     * ���õݹ���һ�����ָ������������Ҳ�����ȥ����������ֱ�����ϲ�Object����Ϊֹ�� 
     *  
     * @param clazz 
     *            Ŀ���� 
     * @param methodName 
     *            ������ 
     * @param classes 
     *            ���������������� 
     * @return �������� 
     * @throws Exception 
     */  
    public static Method getMethod(Class clazz, String methodName,  
            final Class[] classes) throws Exception {  
        Method method = null;  
        try {  
            method = clazz.getDeclaredMethod(methodName, classes);  
        } catch (NoSuchMethodException e) {  
            try {  
                method = clazz.getMethod(methodName, classes);  
            } catch (NoSuchMethodException ex) {  
                if (clazz.getSuperclass() == null) {  
                    return method;  
                } else {  
                    method = getMethod(clazz.getSuperclass(), methodName,  
                            classes);  
                }  
            }  
        }  
        return method;  
    }  
  
    /** 
     *  
     * @param obj 
     *            ���������Ķ��� 
     * @param methodName 
     *            ������ 
     * @param classes 
     *            ������������ 
     * @param objects 
     *            �������� 
     * @return �����ķ���ֵ 
     */  
    public static Object invoke(final Object obj, final String methodName,  
            final Class[] classes, final Object[] objects) {  
        try {  
            Method method = getMethod(obj.getClass(), methodName, classes);  
            method.setAccessible(true);// ����private�����Ĺؼ�һ�仰  
            return method.invoke(obj, objects);  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    public static Object invoke(final Object obj, final String methodName,  
            final Class[] classes) {  
        return invoke(obj, methodName, classes, new Object[] {});  
    }  
  
    public static Object invoke(final Object obj, final String methodName) {  
        return invoke(obj, methodName, new Class[] {}, new Object[] {});  
    }  
  
    /** 
     * ���Է������ 
     *  
     * @param args 
     */  
    public static void main(String[] args) {  
        PrivateUtil.invoke(new B(), "printlnA", new Class[] { String.class },  
                new Object[] { "test" });  
        PrivateUtil.invoke(new B(), "printlnB");  
    }  
}  
  
class A {  
    private void printlnA(String s) {  
        System.out.println(s);  
    }  
}  
  
class B extends A {  
    private void printlnB() {  
        System.out.println("b");  
    }  
}
