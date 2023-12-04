
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Fraction play = new Fraction();
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        do
        {
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiple");
            System.out.println("4. Divide");
            System.out.println("5. Show answer");
            System.out.println("6. Exit");
            System.out.print("Type what you need: ");
            choose = sc.nextInt();
            switch (choose)
            {
                case 1:
                    play.add();
                    break;
                case 2:
                    play.subtract();
                    break;
                case 3:
                    play.multiple();
                    break;
                case 4:
                    play.divide();
                    break;
                case 5:
                    play.print();
                    break;
                case 6:
                    System.out.println("Good bye and fuck you.");
                    break;
            }
        }
        while (choose != 6);
    }
}
