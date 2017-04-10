package entrust;

import java.lang.reflect.Method;

public class Event {
	   private String methodName;//委托的方法名称
	    private Object targetObj;//委托者
	    private Class[] paramsType;//方法参数
	    private Object[] params;//参数类型

	    public Event(String methodName,Object targetObj,Object[] params){
	        this.methodName = methodName;
	        this.targetObj = targetObj;
	        this.params = params;
	        if(null!=params)
	            createParamsByClass();
	    }
	    /**
	     * 获取方法参数的类型
	     */
	    public void createParamsByClass(){
	        this.paramsType = new Class[this.params.length];
	        for(int i = 0; i < this.params.length; i++){
	            this.paramsType[i] = this.params[i].getClass();
	        }
	    }
	    /**
	     * 执行方法
	     * @throws Exception
	     * @throws SecurityException
	     */
	    public void invoke() throws Exception, SecurityException{
	        Method method = targetObj.getClass().getMethod(this.methodName, this.paramsType);
	        if(method!=null)
	            method.invoke(targetObj, this.params);
	    }
}
