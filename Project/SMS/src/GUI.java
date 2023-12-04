
import java.io.IOException;
import java.util.Scanner;

public class GUI {
    
    public static void f1(StudentList va, StudentList sl) throws IOException
    {
        // Setup
        Scanner sc = new Scanner(System.in);
        Utility ul = new Utility();
        
        // In subjects.txt
        String file = "subjects.txt";
        System.out.println("\nList of subjects:");
        System.out.println("ID\t\tName");
        va.loadfromfile(file, sl, "");
        System.out.print("\n");
        
        // Nhap subject ID va kiem tra
        String a;
        do
        {
            a = ul.getString(sc, "subject ID", "^[A-Z]{3}[0-9]{3}", true);
        }
        while (!va.find(a, file, sl, "", ""));
        
        // In exercise.txt + total. Can phai khoi tao lai bien sl thi thay file
        file = "exercises.txt";
        sl = new StudentList();
        System.out.println("\nList of exercises of subject " + a + ":");
        System.out.println("Name\t\tPercentage");
        va.loadfromfile(file, sl, a);
        System.out.println("====================");
        System.out.format("Total\t\t%.2f\n\n", va.total(sl, a));
        
        // Nhap exercise name va kiem tra
        String b = ul.getString(sc, "exercise name", "", false);
        
        // Nhap percentage va kiem tra
        double c;
        do
        {
            c = ul.getDouble(sc, "percentage", 1, va.maxi(sl, a));
        }
        while (c > va.maxi(sl, a));
        
        // Them vao exercises.txt
        Student st = new Student(a, b, c);
        if (va.find(b, file, sl, a, ""))
            sl.add(st);
        else
        {
            for (int i = 0; i < sl.size(); i++)
                if (sl.get(i).getEx_name().equals(b))
                    sl.set(i, st);
        }
        va.saveToFile(file, sl);
        
        // In New exercise.txt + total. Bang 1 cach nao do ma chung ta can chia doi total
        System.out.println("\nList of exercises of subject PRF192" + ":");
        System.out.println("Name\t\tPercentage");
        va.loadfromfile(file, sl, a);
        System.out.println("====================");
        System.out.format("Total\t\t%.2f\n\n", va.total(sl, a)/2);
        
        // End function
        System.out.print("Press enter key to continue");
        sc.nextLine();
        System.out.println();
    }
    
    public static void f2(StudentList va, StudentList sl) throws IOException
    {
        //Setup
        Scanner sc = new Scanner(System.in);
        Utility ul = new Utility();
        
        // In students.txt
        String file = "students.txt";
        System.out.println("\nList of students:");
        System.out.println("ID\t\tName");
        va.loadfromfile(file, sl, "");
        System.out.print("\n");
        
        // Nhap studentID va kiem tra
        String id;
        do
        {
            id = ul.getString(sc, "student ID", "^[H][E][0-9]{6}", true);
        }
        while (!va.find(id, file, sl, "", ""));
        
        // In subjects.txt. Can phai khoi tao lai bien sl thi thay file
        file = "subjects.txt";
        sl = new StudentList();
        System.out.println("\nList of subjects:");
        System.out.println("ID\t\tName");
        va.loadfromfile(file, sl, "");
        System.out.print("\n");
        
        // Nhap subject ID va kiem tra
        String a;
        do
        {
            a = ul.getString(sc, "subject ID", "^[A-Z]{3}[0-9]{3}", true);
        }
        while (!va.find(a, file, sl, "", ""));
        
        // In marks.txt. Can phai khoi tao lai bien sl khi thay file
        file = "marks.txt";
        sl = new StudentList();
        System.out.println("\nList of marks of " + a + " for " + id + ":");
        System.out.println("Exercise\tPercentage\tMarks");
        va.loadfromfile(file, sl, id);
        System.out.println("=====================================");
        System.out.format("TOTAL\t\t\t\t%.2f\n", va.totalmark(sl, id));
        
        // Kiem tra mon hoc do co trong khong, neu khong thi ket thuc chuong trinh
        if (va.checkblank(sl, id, a))
        {
            System.out.println("No exercises available.");
            return;
        }
        System.out.println();
        
        // Chon exercise name
        String lab;
        do
        {
            lab = ul.getString(sc, "exercise in the list", "", false);
        }
        while(!va.find(lab, file, sl, a, id));
        
        // Sua diem
        double mak = ul.getDouble(sc, "marks", 0, 10);
        
        // Sue diem trong ArrayList
        Student student = new Student(id, a, lab, mak);
        for (int i = 0; i < sl.size(); i++)
        {
            if (sl.get(i).getId().equals(student.getId()) && sl.get(i).getEx_name().equals(student.getEx_name()))
            {
                sl.set(i, student);
                break;
            }
        }
        
        // In lai exercises.txt. Bang 1 cach nao do ma chung ta can chia doi total
        System.out.println("\nList of marks of " + a + " for " + id + ":");
        System.out.println("Exercise\tPercentage\tMarks");
        va.saveToFile(file, sl);
        va.loadfromfile(file, sl, id);
        System.out.println("=====================================");
        System.out.format("TOTAL\t\t\t\t%.2f\n", va.totalmark(sl, id)/2); 
        
        // End function
        System.out.print("Press enter key to continue!");
        sc.nextLine();
        System.out.println();
    }
}
