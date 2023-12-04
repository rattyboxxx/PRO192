
import java.util.Scanner;

public class Fraction {
    private int check = 0;
    private int tu;
    private int mau;
    private int tukq;
    private int maukq;

    public Fraction() {
    }
    
    private int gcd(int a, int b)
    {
        if (a < 0) return gcd(-a, b);
        if (b < 0) return gcd(a, -b);
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public void print()
    {
        if (tukq % maukq == 0) System.out.println("Ket qua la " + (tukq/maukq));
        else
        {
            int ucln = gcd(tukq, maukq);
            tukq /= ucln;
            maukq /= ucln;
            System.out.println("Ket qua la " + tukq + "/" + maukq);
        }
    }
    
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu so: ");
        tu = sc.nextInt();
        System.out.print("Nhap mau so: ");
        do
        {
            mau = sc.nextInt();
            if (mau == 0)
            {
                System.out.print("Nhap mau so: ");
            }
            else break;
        }
        while (true);
        if (check == 0)
        {
            int ucln = gcd(tu, mau);
            tukq = tu / ucln;
            maukq = mau / ucln;
            check++;
        }
    }
    
    public void add()
    {
        if (check == 0)
        {
            System.out.println("lol");
            input();
        }
        else
        {
            input();
            tukq = tu * maukq + mau * tukq;
            maukq = maukq * mau;
        }      
    }
    
    public void subtract()
    {
        if (check == 0)
        {
            System.out.println("lol");
            input();
        }
        else
        {
            input();
            tukq = mau * tukq - tu * maukq;
            maukq = maukq * mau;
        } 
    }
    
    public void multiple()
    {
        if (check == 0)
        {
            System.out.println("lol");
            input();
        }
        else
        {
            input();
            tukq *= tu;
            maukq *= mau;
        }       
    }
    
    public void divide()
    {
        if (check == 0)
        {
            System.out.println("lol");
            input();
        }
        else
        {
            input();
            if (tu == 0) System.out.println("Cannot divide 'cause you gay!");
            else
            {
                tukq *= mau;
                maukq *= tu;
            }            
        }
    }
}
