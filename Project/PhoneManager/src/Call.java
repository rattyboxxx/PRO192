
public class Call implements Comparable {
    Phone from;
    Phone to;
    int duration;

    public Call() {
    }

    public Call(Phone from, Phone to, int duration) {
        this.from = from;
        this.to = to;
        this.duration = duration;
    }
    
    public int getTotalAmount() {
        if (duration < 10) return duration * 1500;
        else if (duration < 60) return 15000 + (duration - 10) * 1300;
        return 15000 + 50 * 1300 + (duration - 60) * 1000;
    }
    
    @Override
    public String toString() {
        return from.phoneNumber + "|" + to.phoneNumber + "|" + duration;
    }

    @Override
    public int compareTo(Object o) {
        if (from.customer.equals(((Call)o).from.customer) && duration == (((Call)o).duration)) return to.customer.compareTo(((Call)o).to.customer);
        else if (from.customer.equals(((Call)o).from.customer)) return Integer.compare(duration, ((Call)o).duration);
        return from.customer.compareTo(((Call)o).from.customer);
    }
}
