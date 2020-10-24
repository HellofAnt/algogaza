import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    private String name;
    private Integer score;

	public Student(String name, Integer score) {
        this.name = name;
        this.score = score;

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 899));
        students.add(new Student("Bob", 982));
        students.add(new Student("Chloe", 1090));
        students.add(new Student("Dale", 982));
        students.add(new Student("Eric", 1018));
    }

	@Override
    public int compareTo(Student o) {
        return o.getScore() - getScore();
    }

    private int getScore() {
        return score;
    }

}
