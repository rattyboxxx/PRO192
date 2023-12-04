import java.util.Scanner;

public class Menu
{
    String[] hints;
    int n = 0;
    
    public Menu(int size)
    {
        if (size < 1) size = 10;
        hints = new String[size];
    }
    
    public void add(String aHint)
    {
        if (n < hints.length) hints[n++] = aHint;
    }
    
    public int getChoice()
    {
        int result = 0;
        if (n > 0)
        {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < n; i++) System.out.println((i+1) + ": " + hints[i]);
            result = Utility.getInt(sc, "Please enter", 1, 5);
        }
        return result;
    }
}
