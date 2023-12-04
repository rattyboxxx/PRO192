
public class Phone implements Comparable {
    String phoneNumber;
    String customer;

    public Phone() {
    }

    public Phone(String phoneNumber, String customer) {
        this.phoneNumber = phoneNumber;
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        return phoneNumber + "|" + customer;
    }

    @Override
    public int compareTo(Object o) {
        if (customer.equalsIgnoreCase(((Phone)(o)).customer)) return phoneNumber.compareToIgnoreCase(((Phone)(o)).phoneNumber);
        return customer.compareToIgnoreCase(((Phone)(o)).customer);
    }
}
