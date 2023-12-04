
import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(final String args[]) throws IOException {
        
        final Scanner sc = new Scanner(System.in);
        final String name;
        final double basic_salary ;
        final double revenue ;
        
        System.out.print("Enter employee name: ");
        name = sc.nextLine();
        System.out.print("Enter employee salary: ");
        basic_salary = sc.nextDouble();
        System.out.print("Enter employee revenue: ");
        revenue = sc.nextDouble();
        
        System.out.print("Enter TC: ");
        final int TC = sc.nextInt();
        
        System.out.println("OUTPUT:");
        
        if (TC == 2) {
            final Seller s = new Seller(name, basic_salary, revenue);
            System.out.println(s.getSalary());
        }
        
        if (TC == 1) {
            final Employee emp = new Employee(name, basic_salary);
            System.out.println(emp);
            final Seller s = new Seller(name, basic_salary, revenue);
            System.out.println(s);
        }
    }
}
