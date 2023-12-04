
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. TC = 1 - test sum()");
        System.out.println("2. TC = 2 - testgetCode()");
        System.out.print("Enter TC: ");
        int tc = sc.nextInt();
        sc.nextLine();
        MyString ms = new MyString();
        String str;
        switch (tc)
        {
            case 1:
                System.out.print("Enter a value in a string: ");
                str = sc.nextLine();
                System.out.println("OUTPUT:");
                System.out.println(ms.sum(str));
                break;
            case 2:
                System.out.print("Enter a value of rc: ");
                str = sc.nextLine();
                System.out.println("OUTPUT:");
                System.out.println(ms.getCode(str));
                break;
        }
    }
    
}
