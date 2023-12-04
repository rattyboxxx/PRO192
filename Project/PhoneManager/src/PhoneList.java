
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;


public class PhoneList {
    ArrayList<Phone> phones = new ArrayList<>();

    public PhoneList() {
    }
    
    public boolean isEmpty() {
        return phones.isEmpty();
    }
    
    // Doc file
    public void ReadDataFromFile(String filename) {
        File f = new File(filename);
        try
        (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] tokens = line.split("\\|");
                phones.add(new Phone(tokens[0], tokens[1]));
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }       
    }
    
    // Tra ve doi tuong Phone voi String so dien thoai cho truoc
    public Phone getPhone(String phoneNumber) {
        for (Phone p: phones) {
            if (p.phoneNumber.equalsIgnoreCase(phoneNumber)) {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        Collections.sort(phones);
        String str = "";
        for (Phone p: phones) str += p.toString() + "\n";
        return str.substring(0, str.length()-1);
    }
}
