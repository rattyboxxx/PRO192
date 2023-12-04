
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;


public class CallList {
    ArrayList<Call> calls = new ArrayList<>();

    public CallList() {
    }
    
    public boolean isEmpty() {
        return calls.isEmpty();
    }
    
    // Doc file
    public void ReadDataFromFile(String filename, PhoneList phoneList) {
        File f = new File(filename);
        try
        (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] tokens = line.split("\\|");
                String phoneFrom = tokens[0], phoneTo = tokens[1];
                String cusFrom = null, cusTo = null;
                int duration = Integer.parseInt(tokens[2]);
                for (Phone p: phoneList.phones) {
                    if (p.phoneNumber.equalsIgnoreCase(phoneFrom)) {
                        cusFrom = p.customer;
                    }
                    if (p.phoneNumber.equalsIgnoreCase(phoneTo)) {
                        cusTo = p.customer;
                    }
                }
                calls.add(new Call(new Phone(phoneFrom, cusFrom), new Phone(phoneTo, cusTo), duration));
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        } 
    }
    
    // Tinh tong so tien voi so goi di cho truoc
    public int getTotalAmount(Phone phone) {
        int sum = 0;
        for (Call c: calls) {
            if (c.from.phoneNumber.equals(phone.phoneNumber)) {
                sum += c.getTotalAmount();
            }
        }
        return sum;
    }
    
    
    // Tim cac so goi den tu so goi di cho truoc
    public CallList findCallLisyByPhone(Phone phone) {
        CallList lst = new CallList();
        for (Call c: calls) {
            if (c.from.phoneNumber.equals(phone.phoneNumber)) {
                lst.calls.add(c);
            }
        }
        return lst;
    }
    
    // Sap xep list roi in ra
    @Override
    public String toString() {
        Collections.sort(calls);
        String str = "";
        for (Call c: calls) str += c + "\n";
        return str.substring(0, str.length()-1);
    }
    
    // Tinh tong gia tien cho moi so dien thoai goi di
    public void printAllAmount(PhoneList phones) {
        for (Phone p: phones.phones) {
            System.out.println("Phone number: " + p.phoneNumber);
            System.out.println("Total: " + getTotalAmount(p) + " VND");
        }
    }
    
    // Tinh gia tien voi moi cuoc goi voi so goi di cho truoc
    public void printAmount(Phone p) {
        for (Call c: calls) {
            if (c.from.phoneNumber.equals(p.phoneNumber)) {
                System.out.println(c.to.phoneNumber + ": " + c.getTotalAmount() + " VND");
            }
        }
    }
}
