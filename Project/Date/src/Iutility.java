
import java.util.Date;
import java.util.Scanner;

public interface Iutility
{
    int getInt(Scanner sc, String msg, int min, int max);
    String getString(Scanner sc, String msg, boolean isempty, String pattern);
    Date getDate(Scanner sc, String msg);    
}