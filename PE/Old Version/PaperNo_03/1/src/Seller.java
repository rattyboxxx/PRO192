
public class Seller extends Employee {  
   
    private double revenue;
    
    public Seller() {
       
    }

    public Seller(String name, double revenue, double salary) {
        super(name, salary);
        this.revenue = revenue;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    
     /*Complete the below function for second test case*/
    @Override
    public double getSalary() {
        if (revenue < 30000) return super.getSalary() + revenue * 0.05;
        return super.getSalary() + revenue * 0.1;
    }  
    
    // add and complete your other methods here (if needed)
    @Override
    public String toString() {
        return  super.toString() + "\t" + revenue;
    }
}
