
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utility implements Iutility
{   
    @Override
    public int getInt(Scanner sc, String msg, int min, int max) {
        String line;
        int result;
        do
        {
            System.out.print(msg);
            line = sc.nextLine();
            try
            {
                result = Integer.parseInt(line);
                if (result <= max && result >= min) break;
                else;
            }
            catch (Exception ex) {}
        }
        while(true);
    return result;
    }

    @Override
    public String getString(Scanner sc, String msg, boolean isempty, String pattern) {
        String line;
        do
        {
            System.out.print(msg);
            line = sc.nextLine();
            if (line.isEmpty() && !isempty);
            else
            {
                if (pattern.isEmpty()) break;
                else if (line.matches(pattern)) break;
                else;
            }
        }
        while(true);
        return line;
    }

    @Override
    public Date getDate(Scanner sc, String msg) {
        Date date;
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        dateformat.setLenient(false);
        String line;
        Date date1;
        
        try {
            date1 = dateformat.parse("31/12/999");
        } catch (ParseException ex) {
            date1 = null;
        }
        
        do
        {
            System.out.print(msg);
            line = sc.nextLine();
            try
            {
                date = dateformat.parse(line);
                if (date.after(date1)) break;
                break;
            }
            catch(Exception ex) {}
        }
        while (true);
        return date;
    }    
}
