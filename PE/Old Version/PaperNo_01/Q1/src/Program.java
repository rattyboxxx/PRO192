
import java.util.Scanner;


public class Program {
    static Scanner sc = new Scanner(System.in);
    
    public static int getRange(int min, int max, String msg) {
        int res = 0; String line;
        do {
            System.out.print(msg);
            line = sc.nextLine();
            try {
                res = Integer.parseInt(line);
                if (res >= min && res <= max) break;
            }
            catch (Exception e) {}
        }
        while (true);
        return res;
    }
    
    public static String getString(String msg) {
        String line = "";
        do {
            System.out.print(msg);
            line = sc.nextLine();
            if (!line.isEmpty()) break;
        }
        while (true);
        return line;
    }
    
    public static int getInteger(String msg) {
        String line;
        int res = 0;
        
        do {
            System.out.print(msg);
            line = sc.nextLine();
            try {
                res = Integer.parseInt(line);
                break;
            }
            catch (Exception e) {}
        }
        while (true);
        return res;
    }
    
    public static void main(String[] args) {
        CarManagement cm = new CarManagement();
        cm.listCar.add(new Car(01, "Alpha", "red"));
        cm.listCar.add(new Car(02, "Romeo", "blue"));
        cm.listCar.add(new Car(03, "Audi", "green"));
        cm.listCar.add(new Car(04, "Honda", "black"));
        cm.listCar.add(new Car(05, "Toyota", "gray"));
        
        do {
            System.out.println("1. Print car list");
            System.out.println("2. Update a car");
            System.out.println("3. Exit");
            int ch = getRange(1, 3, "> ");
            if (ch == 3) break;
            switch (ch) {
                case 1:
                    cm.printCarList();
                    break;
                case 2:
                    int id = getInteger("Enter current carId: ");
                    boolean check = true;
                    for (Car c: cm.listCar) {
                        if (c.getCarId() == id) {
                            check = false;
                            System.out.println("Car found: " + c);
                            String name = getString("Enter new name: ");
                            cm.updatePhone(new Car(id, name, c.getColor()));
                        }
                    }
                    if (check) System.out.println("No CarID " + id);
                    break;
            }
        }
        while (true);
    }
}
