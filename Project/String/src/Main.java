
import java.util.Scanner;

public class Main
{   
    public static void main(String[] args)
    {
//        Scanner sc = new Scanner(System.in);
//        Utility ul = new Utility();
//        System.out.print("Enter a string: ");
//        String line = sc.nextLine();
//        System.out.println("--------------------");
//        System.out.println("1. Frequency of a string");
//        System.out.println("2. Uppercase the first char of each word");
//        System.out.println("3. Lowercase the first char, upper case the last char of each word");
//        System.out.println("4. Split words and sort them");
//        System.out.println("5. Remove the first char found in the string");
//        System.out.println("6. Count words in string");
//        System.out.println("7. Only prints letters");
//        System.out.println("8. Reverse string");
//        System.out.println("9. Replace all 'a' to 'A' and 'b' to 'B'");
//        System.out.println("10. Count the upper letters");
//        System.out.println("--------------------");
//        System.out.print("Choose what you want to do: ");
//        int lc = sc.nextInt();
//        switch (lc)
//        {
//            case 1:
//                ul.freq(line);
//                break;
//            case 2:
//                ul.upper(line);
//                break;
//            case 3:
//                ul.mixed_ul(line);
//                break;
//            case 4:
//                ul.sortStr(line);
//                break;
//            case 5:
//                ul.removeChar(line);
//                break;
//            case 6:
//                ul.count(line);
//                break;
//            case 7:
//                ul.isalpha(line);
//                break;
//            case 8:
//                ul.rev(line);
//                break;
//            case 9:
//                ul.rep_ab(line);
//                break;
//            case 10:
//                ul.upp(line);
//                break;
//        }    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char line = sc.nextLine().charAt(0);
        System.out.println("Is Alphabet? " + Character.isAlphabetic(line));
        System.out.println("Is Letter? " + Character.isLetter(line));
    }   
}
