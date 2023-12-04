
public class Student {
    private String name;
    private String id;
    private int age;
    private String sbj_id;
    private String sbj_name;
    private String ex_name;
    private double per;
    private double mark;

    public Student() {
    }
    
    // for students.txt
    public Student(String id, String name, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    // for subjects.txt
    public Student(String sbj_id, String sbj_name) {
        this.sbj_id = sbj_id;
        this.sbj_name = sbj_name;
    }

    // for exercises.txt
    public Student(String sbj_id, String ex_name, double per) {
        this.sbj_id = sbj_id;
        this.ex_name = ex_name;
        this.per = per;
    }

    // for marks.txt
    public Student(String id, String sbj_id, String ex_name, double mark) {
        this.id = id;
        this.sbj_id = sbj_id;
        this.ex_name = ex_name;
        this.mark = mark;
    }
    
    // Only need getter
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getSbj_id() {
        return sbj_id;
    }

    public String getSbj_name() {
        return sbj_name;
    }

    public String getEx_name() {
        return ex_name;
    }

    public double getPer() {
        return per;
    }

    public double getMark() {
        return mark;
    }
}
