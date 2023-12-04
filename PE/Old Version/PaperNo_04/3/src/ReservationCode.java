
public class ReservationCode {

    String custonmerName;
    String code;

    public ReservationCode() {
    }

    public ReservationCode(String code, String customerName) {
        this.custonmerName = customerName;
        this.code = code;
    }

    String getCode() {
        String result = "";
        for (int i = 0; i < code.length(); i++) {
            if (i % 2 == 1 && i < code.length()-1) result += code.charAt(i) + "-";
            else result += code.charAt(i);
        }
        return result;
    }

    @Override
    public String toString() {
        return custonmerName + "\t" + code;
    }

}
