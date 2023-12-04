import java.util.Scanner;

public class Utility
{
    public static boolean check(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ') continue;
            if ((Character.isLetter(s.charAt(i)) == false)) return false;
        }
        return true;
    }
    
    public static int getInt(Scanner sc, String msg, int min, int max)
    {
        int result;
        String line;
        do
        {
            System.out.format("%s (from %d to %d): ", msg, min, max);
            line = sc.nextLine();
            try
            {
                result = Integer.parseInt(line);
                if (result >= min && result <= max) break;
                else System.out.println("Invalid number. Please try again");
            }
            catch (Exception ex)
            {
                System.out.println("Invalid character. Please try again");
            }
        }
        while (true);
        return result;
    }
    
    public static String getStrCode(Scanner sc, boolean IsEmpty, String pattern)
    {
        String line = "";
        do
        {
            System.out.format("Enter code" + (IsEmpty ? ": " : " (Not empty): "));
            line = sc.nextLine();
            if (line.isEmpty() && !IsEmpty);
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
    
    public static String getStrName(Scanner sc, boolean IsEmpty)
    {
        String line = "";
        do
        {
            System.out.format("Enter name" + (IsEmpty ? ": " : " (Not empty): "));
            line = sc.nextLine();
            if (line.isEmpty() && !IsEmpty);
            else if (!check(line));
            else break;
        }
        while (true);
        return line;
    }
}
