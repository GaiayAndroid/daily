package entrust;

import java.lang.reflect.Method;

public class Event {
	   private String methodName;//ί�еķ�������
	    private Object targetObj;//ί����
	    private Class[] paramsType;//��������
	    private Object[] params;//��������

	    public Event(String methodName,Object targetObj,Object[] params){
	        this.methodName = methodName;
	        this.targetObj = targetObj;
	        this.params = params;
	        if(null!=params)
	            createParamsByClass();
	    }
	    /**
	     * ��ȡ��������������
	     */
	    public void createParamsByClass(){
	        this.paramsType = new Class[this.params.length];
	        for(int i = 0; i < this.params.length; i++){
	            this.paramsType[i] = this.params[i].getClass();
	        }
	    }
	    /**
	     * ִ�з���
	     * @throws Exception
	     * @throws SecurityException
	     */
	    public void invoke() throws Exception, SecurityException{
	        Method method = targetObj.getClass().getMethod(this.methodName, this.paramsType);
	        if(method!=null)
	            method.invoke(targetObj, this.params);
	    }
}
