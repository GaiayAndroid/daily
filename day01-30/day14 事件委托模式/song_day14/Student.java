package entrust;

public class Student {
    private String name;

    //����
    private double score;

    public Student(String name, double score) {
        super();
        this.name = name;
        this.score = score;
    }

    public void speak(){
        System.out.println(name+"���Է��� == "+score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
