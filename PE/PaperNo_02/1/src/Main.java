
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Brick code: ");
        String code = sc.nextLine();
        System.out.print("Enter Brick price: ");
        double price = sc.nextDouble();
        Brick br = new Brick(code, price);
        System.out.println("1. TC = 1 - test getCode()");
        System.out.println("2. TC = 2 - test setPrice()");
        System.out.print("Enter TC: ");
        int tc = sc.nextInt();
        switch (tc)
        {
            case 1:
                System.out.println("OUTPUT:");
                System.out.println(br.getCode());
                break;
            case 2:
                System.out.print("Enter new Brick price: ");
                price = sc.nextDouble();
                System.out.println("OUTPUT:");
                br.setPrice(price);
                System.out.println(br.getPrice());
        }
    }
    
}
