
public abstract class Student {
   public static final int NUM_OF_TESTS = 3;
   private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
   protected int[] test;
   protected String courseGrade;

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    abstract public void computeCourseGrade();
    public Student() {
        test = new int[NUM_OF_TESTS];
        courseGrade = "****";
    }
      
    public int getTestScore(int testNumber) {
        return test[testNumber];
    }
   
    public void setTestScore(int testNumber, int testScore) {
        test[testNumber] = testScore;
    }

}
