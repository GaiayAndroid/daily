package entrust;

public class Test {
	public static void main(String[] args) {
		Teacher teacher = new Teacher("����ʦ");
		Student liq = new Student("����",28.1);
		Student dem = new Student("����",66.1);
		Parents parents = new Parents();
		teacher.addObserver("speak", liq, null);
		teacher.addObserver("speak", dem, null);
		teacher.addObserver("phoneNotice", parents, new Object[]{liq});
		teacher.notifyObserver();
	}
}
