
import java.util.Scanner;

public class Main
{   
    static int find(Student[] students, int count, String id)
    {
        for (int i = 0; i < count; i++)
            if (students[i].getId().equals(id)) return i;
        return -1;
    }
    
    public static void main(String[] args)
    {
        Utility util = new Utility();
        Scanner sc = new Scanner(System.in);
        int numOfStu;
        numOfStu = util.getInt(sc, "Enter numbers of students (1 to 10): ", 1, 10);        
        Student[] students = new Student[numOfStu];
        for (int i = 0; i < numOfStu; i++)
        {
            Student s = new Student();
            s.setName(util.getString(sc, "Enter name: ", false, ""));
            int pos;
            do
            {
                s.setId(util.getString(sc, "Enter ID (HE012345): ", false, "[hH][eE][\\d]{6}").toUpperCase());
                pos = find(students, i, s.getId());
                if (pos != -1) System.out.println("Invalid!");
            }
            while (pos != -1);
            s.setBirthDate(util.getDate(sc, "Enter DOB (dd/MM/yyyy): "));
            students[i] = s;
        }
        for (Student s : students)
            System.out.println(s);
    }
}
