package Utility;


import java.util.Date;
import java.util.Scanner;


public interface IUtility {
    String getString(Scanner sc, String msg, boolean isEmpty, String pattern);
    int getInt(Scanner sc, String msg, int min, int max);
    double getDouble(Scanner sc, String msg, double min, double max);
    Date getDate(Scanner sc, String msg);
}
