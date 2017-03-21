package entrust;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	 private List<Event> observers = new ArrayList();

	    public void addObserver(String method,Object obj,Object[] params){
	        this.observers.add(new Event(method,obj,params));
	    }
	    //֪ͨ
	    public void notifyObserver(){
	        for(Event event : observers){
	            try {
	                event.invoke();
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
}
