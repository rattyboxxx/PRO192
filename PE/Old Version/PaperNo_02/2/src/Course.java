public class Course {
    private double fee;
    private String name;
    
    public Course(){}

    public Course(String name, double fee) {
        this.fee = fee;
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
