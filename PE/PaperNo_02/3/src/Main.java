
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList mb = new ArrayList();
        mb.add(new Brick("FS21", 60));
        mb.add(new Brick("KS20", 68));
        mb.add(new Brick("FF12", 52));
        
        System.out.print("Add more how many Brick: ");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.print("Brick code: ");
            String code = sc.nextLine();
            System.out.print("Brick price: ");
            double price = Double.parseDouble(sc.nextLine());
            mb.add(new Brick (code, price));
        }
        
        MyBrick ar = new MyBrick();
        System.out.print("Enter test function (1-f1;2-f2;3-f3): ");
        int ch = Integer.parseInt(sc.nextLine());
        switch (ch)
        {
            case 1:
                System.out.println("OUTPUT:");
                ar.f1(mb);
                mb.stream().forEach((a) -> {
                    System.out.println(a);
                });
                break;
            case 2:
                System.out.print("Enter given Brick price: ");
                double pr = Double.parseDouble(sc.nextLine());
                System.out.println("OUTPUT:");
                System.out.println(ar.f2(mb, pr));
                break;
            case 3:
                ar.f3(mb);
                mb.stream().forEach((a) -> {
                    System.out.println(a);
                });
                break;
        }
    }
    
}
