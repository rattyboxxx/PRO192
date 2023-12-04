
import java.util.Arrays;
import java.util.Scanner;

public class Utility {
    
    Scanner sc = new Scanner(System.in);
    
    public void freq(String line)
    {
        System.out.println("Enter the word: ");
        String msg = sc.nextLine();
        
        if (!line.contains(msg)) 
        {
            System.out.print("String not found!");
            return;
        }
        
        String[] words = new String[80];
        Scanner scText = new Scanner(line);
        scText.useDelimiter("[\\s]+");
        int count = 0;        
        while (scText.hasNext()) words[count++] = scText.next();
        
        int result = 0;
        for (int i = 0; i < count; i++)
            if (words[i].contains(msg)) ++result;
        
        System.out.print("This string \"" + msg + "\" appears " + result + (result < 2 ? " time." : " times."));
        System.out.println();
    }
    
    public void upper(String line)
    {
        String[] words = new String[80];
        Scanner scText = new Scanner(line);
        scText.useDelimiter("[\\s]+");
        int count = 0;
        while (scText.hasNext()) words[count++] = scText.next();
        System.out.println("After changing:");
        for (int i = 0; i < count; i++)
        {
            words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            System.out.print(words[i] + " ");
        }    
        System.out.println();
    }
    
    public void mixed_ul(String line)
    {
        String[] words = new String[80];
        Scanner scText = new Scanner(line);
        scText.useDelimiter("[\\s]+");
        int count = 0;
        while (scText.hasNext()) words[count++] = scText.next();
        System.out.println("After changing:");
        for (int i = 0; i < count; i++)
        {
            int n = words[i].length();
            words[i] = Character.toLowerCase(words[i].charAt(0)) + words[i].substring(1,n-1) + Character.toUpperCase(words[i].charAt(n-1));
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }
    
    public void sortStr(String line)
    {
        String[] words = new String[80];
        Scanner scText = new Scanner(line);
        scText.useDelimiter("[\\s]+");
        int count = 0;
        while (scText.hasNext()) words[count++] = scText.next();
        Arrays.sort(words);
        System.out.println("After changing:");
        for (int i = 0; i < count; i++) System.out.print(words[i] + " ");
        System.out.println();
    }
    
    public void removeChar(String line)
    {
        System.out.print("Enter a character: ");
        char c = sc.nextLine().charAt(0);
        System.out.println("After changing:");
        System.out.print(line.replaceFirst(c + "", ""));
        System.out.println();
    }
    
    public void count(String line)
    {
        Scanner scText = new Scanner(line);
        System.out.println(line);
        scText.useDelimiter("[\\s]+");
        int count = 0;
        while (scText.hasNext())
        {
            count++;
            scText.next();
        }
        System.out.print(count == 0 ? "Empty string" : "Total: " + count + (count == 1 ? " word" : " words"));
        System.out.println();
    }
    
    public void isalpha(String line)
    {
        for (int i = 0; i < line.length(); i++)
        {
            if (Character.isLetter(line.charAt(i)))
                System.out.format("%c", line.charAt(i));
        }
        System.out.println();
    }
    
    public void rev(String line)
    {
        String result = "";
        int n = line.length();
        for (int i = n-1; i >= 0; i--)
            result += line.charAt(i);
        System.out.print(result);
        System.out.println();
    }
    
    public void rep_ab(String line)
    {
        System.out.print(line.replaceAll("a", "A").replaceAll("b", "B"));
        System.out.println();
    }
    
    public void upp(String line)
    {
        int n = line.length();
        int count = 0;
        for (int i = 0; i < n; i++)
            if (Character.isUpperCase(line.charAt(i))) ++count;
        System.out.print(count + " " + (count < 2 ? "upper letter" : "upper letters"));
        System.out.println();
    }
}
