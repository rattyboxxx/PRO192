import java.util.Scanner;

public class PersonList
{
    private Person[] list = null;
    private int count = 0;
    
    public PersonList(int size)
    {
        if (size < 10) size = 10;
        list = new Person[size];
    }
    
    int find(String aCode)
    {
        for (int i = 0; i < count; i++)
            if (aCode.equals(list[i].getCode())) return i;
        return -1;
    }
    
    public void add()
    {
        if (count == list.length) System.out.println("List is full!");
        else
        {
            String newCode, newName;
            int newAge;
            
            Scanner sc = new Scanner(System.in);
            int pos;
            do
            {
                // System.out.print("Enter the person's code: ");
                // newCode = sc.nextLine().toUpperCase();
                newCode = Utility.getStrCode(sc, false, "[hH][eE][\\d]{6}");
                pos = find(newCode);
                if (pos >= 1) System.out.println("\tThis code existed");
            }
            while (pos >= 0);
            //System.out.print("Enter name: ");
            //newName = sc.nextLine().toUpperCase();
            newName = Utility.getStrName(sc, false);
            
            // System.out.print("Enter age: ");
            // newAge = Integer.parseInt(sc.nextLine());
            newAge = Utility.getInt(sc, "Enter age", 18, 25); //Input age ưith Utility
            
            list[count++] = new Person(newCode, newName, newAge);
            System.out.println("Added successfully!");
        }
    }
    
    public void remove()
    {
        if (count == 0)
        {
            System.out.println("Empty list.");
            return;
        }
        
        String removedCode;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code: ");
        removedCode = sc.nextLine().toUpperCase();
        int pos = find(removedCode);
        if (pos < 0) System.out.println("Invalid code!");
        else
        {
            for (int i = pos; i < count; i++) list[i] = list[i+1];
            count--;
            System.out.println("ID " + removedCode + " has been removed");
        }
    }
    
    public void update()
    {
        if (count == 0)
        {
            System.out.println("Empty list");
            return;
        }
        
        String code;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code: ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if (pos < 0) System.out.println("Invalid code!");
        else
        {
            String newName;
            int newAge;
            System.out.print("Enter the person's name: ");
            newName = sc.nextLine().toUpperCase();
            System.out.print("Enter the person's age: ");
            newAge = Integer.parseInt(sc.nextLine());
            list[pos].setName(newName);
            list[pos].setAge(newAge);
            System.out.println("Updated successfully ID " + code + "!");
        }
    }
    
    public void print()
    {
        if (count == 0)
        {
            System.out.println("Empty list.");
            return;
        }
        System.out.println("LIST OF PERSON\n");
        for (int i = 0; i < count; i++)
            System.out.println(" " + list[i].toString());
    }
    
    void sort()
    {
        if (count == 0) return;
        for (int i = 0; i < count - 1; i++)
            for (int j = i+1; j < count; j++)
                if (list[j].getAge() > list[i].getAge())
                {
                    Person p = list[i];
                    list[i] = list[j];
                    list[j] = p;
                }
    }
}
