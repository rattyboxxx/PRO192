public class Executive extends Employee {
    
    private double bonus; 
    
    public Executive(String name, String address, String phone, String socSecNumber, double rate) {
        super(name, address, phone, socSecNumber, rate);
        bonus = 0;
    
    }
    public void awardBonus(double execBonus) {
      bonus = execBonus;
    }

    @Override 
    public double pay() {
      double payment = super.pay() + bonus;
      bonus = 0;
      return payment;
    }    
}

