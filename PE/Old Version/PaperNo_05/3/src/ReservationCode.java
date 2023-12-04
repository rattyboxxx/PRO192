
public class ReservationCode {

    String code;
    String customerName;

    public ReservationCode(String code, String customerName) {
        this.code = code;
        this.customerName = customerName;
    }

    String getCode() {
        String result = "";
        for (int i = 0; i < code.length(); i++) {
            if (i % 3 == 2 && i < code.length()-1) result += code.charAt(i) + "-";
            else result += code.charAt(i);
        }
        return result;
    }

    @Override
    public String toString() {
        return customerName + "\t" + code;
    }

}
