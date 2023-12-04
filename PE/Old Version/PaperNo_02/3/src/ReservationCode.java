
public class ReservationCode {

    private String name;
    private String code;

    public ReservationCode() {
    }

    public ReservationCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        String str = "";
        for (int i = 0; i < name.length(); i++)
        {
            char ch = name.charAt(i);
            if (ch == 'z') str += 'a';
            else if (ch == 'Z') str += 'A';
            else if (Character.isAlphabetic(ch)) str += (char)((int)ch + 1);
            else str += ch;
        }
        return str;
    }

    @Override
    public String toString() {
        return name + " " + code;
    }
}
