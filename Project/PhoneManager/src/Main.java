
import java.util.Scanner;


public class Main {
    
    static Scanner sc = new Scanner(System.in);
    
    // Ep gia tri tra ve nam trong khoang from den to
    public static int getSelection(String msg, int from, int to) {
        int res = 0;
        do {
            System.out.print(msg);
            String str = sc.nextLine();
            try {
                res = Integer.parseInt(str);
                if (res >= from && res <= to) {
                    return res;
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        while (true);
    }
    
    public static void main(String[] args) {
        PhoneList plist = new PhoneList();
        CallList clist = new CallList();
        String phone;
        do {
            System.out.println("1. Read PhoneList, CallList from file");
            System.out.println("2. Get Amount for each calling from a phone number");
            System.out.println("3. Sort PhoneList by customer name");
            System.out.println("4. Sort CallList by PhoneFrom customer name or duration");
            System.out.println("5. Find calling from a phone number");
            System.out.println("6. Find all TotalAmount of all phone numbers");
            System.out.println("7. Exit");
            int ch = getSelection("> Choose: ", 1, 7);
            switch (ch) {
                case 1:
                    plist.ReadDataFromFile("Phones.txt");
                    clist.ReadDataFromFile("Calls.txt", plist);
                    break;
                case 2:
                    System.out.print("Enter a phone number: ");
                    phone = sc.nextLine();
                    clist.printAmount(plist.getPhone(phone));
                    break;
                case 3:
                    System.out.println(plist);
                    break;
                case 4:
                    System.out.println(clist);
                    break;
                case 5:
                    System.out.print("Enter a phone number: ");
                    phone = sc.nextLine();
                    System.out.println(clist.findCallLisyByPhone(plist.getPhone(phone)));
                    break;
                case 6:
                    clist.printAllAmount(plist);
                    break;
                case 7:
                    break;
            }
            if (ch == 7) break;
        }
        while (true);
    }
}
