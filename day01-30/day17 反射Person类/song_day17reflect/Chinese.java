package reflect;

public class Chinese extends MySuperClass implements China  {

	private String sex;
	public Chinese(){
		
	}
	public Chinese(String sex){
		this.sex = sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	
	@Override
	public void sayChina() {
	System.out.println("hello,china");	
	}

	@Override
	public void sayHello(String name, int age) {
		System.out.println(name+"	"+age);
	}

}
