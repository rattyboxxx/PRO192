public class ReservationCode {
    
    private final String code, customerName;
    
    public ReservationCode(String code, String customerName) {
        this.code = code;
        this.customerName = customerName;
    }

    public String getCode() {
        String str = "";
        for (int i = 0; i < code.length(); i++)
        {
            if (i % 3 == 2 && i != code.length()-1) str += code.charAt(i) + "-";
            else str += code.charAt(i);
        }
        return str;
    }
    
    @Override
    public String toString() {
        return customerName + "\t" + code;
    }
}
