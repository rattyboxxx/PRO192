import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        // Tao CSDL ban dau thong qua ArrayList
        ArrayList<Course> list = new ArrayList<>();
        list.add(new Course("PRJ311", 110));
        list.add(new Course("DBI202", 150));
        list.add(new Course("PRF192", 120));
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Add more how many course: ");
        int course = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < course; i++) {
            System.out.print("Course name: ");
            String name = sc.nextLine();
            System.out.print("Course fee: ");
            double fee = Double.parseDouble(sc.nextLine());
            list.add(new Course(name, fee));
        }
        
        System.out.print("Enter test function (1-f1;2-f2): ");
        int choice = sc.nextInt();
        MyCourse m = new MyCourse();
        switch (choice)
        {
            case 1:
                System.out.print("Enter st: ");
                int st = sc.nextInt();
                m.f1(list, st);
                System.out.println("OUTPUT:");
                for (Course c: list)
                    System.out.println(c.getName());
                break;
            case 2:
                System.out.print("Enter course fee: ");
                double fee1 = sc.nextDouble();
                System.out.println("OUTPUT:");
                System.out.println(m.f2(list, fee1));
        }

    }
}
