
package Interface;

import java.util.Scanner;

public class Utility {
    public int getInt(Scanner sc, String msg, int min, int max) {
        int result;
        String line;
        do
        {
            System.out.print(msg);
            line = sc.nextLine();
            try
            {
                result = Integer.parseInt(line);
                if (result >= min && result <= max) break;
                else;
            }
            catch (Exception ex) {}
        }
        while (true);
        return result;
    }

    public String getString(Scanner sc, String msg, boolean isEmpty, String pattern) {
        String line;
        do
        {
            System.out.print(msg + (isEmpty ? ": " : " (not empty): "));
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
