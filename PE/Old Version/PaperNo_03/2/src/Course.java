
public class Course {   
     
    private String name;
    private double fee;
    
    public Course() {
        
    }

    public Course(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }
 
    public String getName() {
        return name;
    }
 
    //add and complete you other methods (if needed) here   

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

     
}
