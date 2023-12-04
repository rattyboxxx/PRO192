
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Brick code: ");
        String code = sc.nextLine();
        System.out.print("Enter Brick price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Brick maker: ");
        String maker = sc.nextLine();
        Brick br = new ColorBrick(code, price, maker);
        System.out.println("1. TC = 1 - test toString()");
        System.out.println("2. TC = 2 - test getPrice()");
        System.out.print("Enter TC: ");
        int tc = sc.nextInt();
        switch (tc)
        {
            case 1:
                System.out.println("OUTPUT:");
                System.out.println(br);
                break;
            case 2:
                System.out.println("OUTPUT:");
                System.out.println(br.getPrice());
        }
    }
    
}
