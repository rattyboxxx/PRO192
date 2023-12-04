
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String ch;
        do
        {
            System.out.println("Assignment: A1601, Group 3");
            System.out.println(" MENU");
            System.out.println("1. Register an exercise for the given subject.");
            System.out.println("2. Enter an exercise’s marks of the given subject for a student.");
            System.out.println("3. Exit");
            do
            {
                System.out.print("Please enter 1, 2, or 3: ");               
                ch = sc.nextLine();
            }
            while (!ch.equals("1") && !ch.equals("2") && !ch.equals("3"));                       
            StudentList va = new StudentList();
            StudentList sl = new StudentList();
            switch (ch)
            {
                case "1":
                    GUI.f1(va, sl);
                    break;
                case "2":
                    GUI.f2(va, sl);
                    break;
                case "3":
                    System.out.println("Program completed. Thank you for using it!");
                    break;
            }
        }
        while (!ch.equals("3")); 
    }   
}
