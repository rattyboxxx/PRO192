
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter reservation code: ");
        String code = sc.nextLine();
        ReservationCode r = new ReservationCode(name, code);
        
        System.out.print("Enter TC: ");
        int tc = sc.nextInt();
        System.out.println("OUTPUT:");
        switch (tc)
        {
            case 1:
                System.out.println(r);
                break;
            case 2:
                System.out.println(r.getName());                
                break;
        }       
    }
}
