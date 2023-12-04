
import java.util.Scanner;


public class Utility {
    
    public String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
    
    public double getDouble(Scanner sc, String obj, double min, double max)
    {
        String line;
        double res;
        do
        {
            System.out.format("Enter %s (%s - %s): ", obj, fmt(min), fmt(max));
            line = sc.nextLine();
            if (line.isEmpty()) line = "0";
            int count = 0;
            try
            {
                for (int i = 0; i < line.length(); i++)
                {
                    if (Character.isAlphabetic(line.charAt(i))) count = 1;
                }
                if (count == 0)
                {
                    res = Double.parseDouble(line);
                    if (res >= min && res <= max) break;
                    else;
                }               
                else;
            }
            catch (Exception ex) {}
        }
        while (true);
        return res;
    }
    
    public String getString(Scanner sc, String obj, String pattern, boolean isEmpty)
    {
        String line;
        do
        {
            System.out.print("Enter " + obj + (isEmpty ? ": " : " (not empty): "));
            line = sc.nextLine();
            if (line.isEmpty() && !isEmpty);
            else
            {
                if (pattern.isEmpty()) break;
                else if (line.matches(pattern)) break;
                else;
            }
        }
        while (true);
        return line;
    }
}
