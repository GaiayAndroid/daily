package singleton;

public class SingleTon {
	public static SingleTon singleton = new SingleTon();
	public  static int count1 ;
	public  static int count2 = 0 ;
	public SingleTon() {
		count1 ++;
		count2 ++;
	}
	public static SingleTon newInstance(){
		return singleton ;
	}
	
	public static void main(String[] args) {
		SingleTon sin = SingleTon.newInstance();
		System.out.println("count 1 = " +  sin.count1);
		System.out.println("count 2 = " +  sin.count2);
	}
	/***
	 * �ж��⣺A.count1=1��count2=1; 
	 * B .count1=1��count2=0; 
	 * C.count1=2��count2=1;
	 * D..count1=0��count2=0
	 * 
	 * ��ΪB �� ִ�в��裺
	 * new SingleTon --> count1 ++; count2 ++; --> public static int count2 =0  
	 */
	
}
