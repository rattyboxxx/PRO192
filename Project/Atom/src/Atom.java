import java.util.Scanner;

public class Atom
{
    private int number;
    private String symbol;
    private String fullname;
    private double weight;
    private Atom[] list = new Atom[10];
    private int count;

    public Atom()
    {
    }
    
    public String getFullname()
    {
        return fullname;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public int getNumber()
    {
        return number;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }
   
    public Atom(int number, String symbol, String fullname, double weight)
    {
        this.number = number;
        this.symbol = symbol;
        this.fullname = fullname;
        this.weight = weight;
    }
    
    public void add()
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++)
        {
            System.out.print("Enter atomic number : ");
            number = sc.nextInt();
            if (!accept(number))
            {
                count = i;
                break;
            }
            System.out.print("Enter symbol : ");
            symbol = sc.next();
            System.out.print("Enter full name : ");
            fullname = sc.next();
            System.out.print("Enter atomic weight : ");
            weight = sc.nextDouble();
            list[i] = new Atom(number, symbol, fullname, weight);
            System.out.println();
        }
    }
    
    public void display()
    {
        System.out.println("\n\n");
        if (count == 0) return;
        for (int i = 0; i < count; i++)
        System.out.format("%-3d%-4s%-9s%.3f\n", list[i].getNumber(), list[i].getSymbol(), list[i].getFullname(), list[i].getWeight());
    }
    
    public boolean accept(int check)
    {
        if (check == 0) return false;
        return true;
    }
}
