
public class Course implements Comparable<Course> {

    double fee;
    String name;

    public Course() {
    }

    public Course(String name, double fee) {
        this.fee = fee;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Course o) {
        return Double.compare(fee, o.fee);
    }
}
